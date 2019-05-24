package app.helper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import org.apache.poi.ss.formula.functions.*;

public class Loan {
	private ArrayList<Payment> paymentList = new ArrayList<Payment>();
	private double loanAmount;
	private double interestRate;
	private int lengthOfLoan;
	private double additionalPayment;
	private double currentValue;
	
	public Loan(double loanAmount, double interestRate, int lengthOfLoan, double additionalPayment) {
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.lengthOfLoan = lengthOfLoan;
		this.additionalPayment = additionalPayment;
		
		currentValue = this.loanAmount;
		int payPeriod = 1;
		do {
			double pmt = round(Finance.pmt(this.interestRate/12, this.lengthOfLoan, this.lengthOfLoan*12, -this.loanAmount) + this.additionalPayment, 4);
			double ppmt = round(Finance.ppmt(this.interestRate/12, payPeriod, this.lengthOfLoan*12, -this.loanAmount) + this.additionalPayment, 4);
			double ipmt = round(Finance.ipmt(this.interestRate/12, payPeriod, this.lengthOfLoan*12, ithis.loanAmount), 4);
			Payment payment = new Payment(pmt, ppmt, ipmt);
			
			System.out.println("Period: " + payPeriod);
			System.out.println("Present Value" + round(currentValue(),2);
			System.out.println("Payment" + round(payment.getiPayment(), 2));
			System.out.println("Interest Payment: " + round(payment.getPayment(), 2));
			System.out.println("Principle Payment: " + round(payment.getpPayment(), 2));
			paymentList.add(payment);
			if (currentValue - payment.getpPayment() <= 0.001) {
				payment.setPayment(currentValue);
				currentValue = 0;
				break;
			}
			else {
				currentValue -= ppmt;
			}
			payPeriod++;
		} while(currentValue > 0);
	}
	
	public double addPayments() {
		double total = 0;
		for (Payment p : paymentList) {
			total+=p.getPayment();
		}
		return total;
	}
	
	public double totalInterestPayed() {
		return this.sumPayments() - this.loanAmount;
	}
	
}
