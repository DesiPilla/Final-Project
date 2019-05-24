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
			double ipmt = round(Finance.ipmt(this.interestRate/12, payPeriod, this.lengthOfLoan*12, -this.loanAmount), 4);
			Payment payment = new Payment(pmt, ppmt, ipmt);
			
			System.out.println("Period: " + payPeriod);
			System.out.println("Present Value: " + round(currentValue,2));
			System.out.println("Payment: " + round(payment.getIpmt(), 2));
			System.out.println("Interest Payment: " + round(payment.getPmt(), 2));
			System.out.println("Principle Payment: " + round(payment.getPpmt(), 2));
			System.out.println();
			
			paymentList.add(payment);
			if (currentValue - payment.getPpmt() <= 0.001) {
				payment.setPmt(currentValue);
				currentValue = 0;
				break;
			}
			else {
				currentValue -= ppmt;
			}
			payPeriod++;
		} while(currentValue > 0);
	}
	
	// Sum all of the payments in PaymentList
	public double addPayments() {
		double total = 0;
		for (Payment p : paymentList) {
			total+=p.getPmt();
		}
		return total;
	}
	
	// Sum all of the principal payments in PaymentList
	public double addPrincipal() {
		double total = 0;
		for (Payment p : paymentList) {
			total+=p.getPpmt();
		}
		return total;
	}
	
	// Sum all of the interest payments in PaymentList
	public double addInterest() {
		double total = 0;
		for (Payment p : paymentList) {
			total+=p.getIpmt();
		}
		return total;
	}
	
	// Interest Payed = Total Payments - Original Loan Amount
	public double totalInterestPayed() {
		return this.addPayments() - this.loanAmount;
	}
	
	// Print Payment Information
	public void printPayments() {
		System.out.println("Number of Payments: " + paymentList.size());
		for ( Payment p:paymentList) {
			System.out.println("Interest Payment: " + p.getIpmt());
			System.out.println("Principle Payment: " + p.getIpmt());
			System.out.println();
		}
	}
	
	// Helper function to round Loan Information
	public static double round(double unrounded, int numDecimals) {
		BigDecimal bigDecimal = new BigDecimal(Double.toString(unrounded));
		bigDecimal = bigDecimal.setScale(numDecimals, RoundingMode.HALF_UP);
		return bigDecimal.doubleValue();
	}
	
}
