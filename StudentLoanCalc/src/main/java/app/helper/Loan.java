package app.helper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.poi.ss.formula.functions.*;

public class Loan {
	private LinkedList<Payment> paymentList = new LinkedList<Payment>();
	private double loanAmount;
	private double interestRate;
	private int lengthOfLoan;
	private double additionalPayment;
	private double amountDue;
	
	public Loan(double loanAmount, double interestRate, int lengthOfLoan, double additionalPayment) {
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.lengthOfLoan = lengthOfLoan;
		this.additionalPayment = additionalPayment;
		
		amountDue = this.loanAmount;
		int payPeriod = 1;
		do {
			double pmt = Finance.pmt(this.interestRate/12, this.lengthOfLoan*12, -this.loanAmount) + this.additionalPayment;
			double ppmt = Finance.ppmt(this.interestRate/12, payPeriod, this.lengthOfLoan*12, -this.loanAmount);
			double ipmt = Finance.ipmt(this.interestRate/12, payPeriod, this.lengthOfLoan*12, -this.loanAmount);
			Payment payment = new Payment(pmt, ppmt, ipmt, additionalPayment);
			
			System.out.println("Period: " + payPeriod);
			System.out.println("Amount Due: " + round(amountDue,2));
			System.out.println("Payment: " + round(payment.getIpmt(), 2));
			System.out.println("Principle Payment: " + round(payment.getPpmt(), 2));
			System.out.println("Interest Payment: " + round(payment.getIpmt(), 2));
			System.out.println();
			
			paymentList.add(payment);
			
			if (amountDue - payment.getPmt() - payment.getApmt() <= 0) {
				if (amountDue - payment.getPmt() <= 0) {
					payment.setPmt(amountDue);
					payment.setApmt(0);
					amountDue = 0;
				}
				else {
					payment.setApmt(amountDue - payment.getPmt());
					amountDue = 0;
				}
				break;
			}
			else {
				amountDue -= (ppmt + additionalPayment);
			}
			payPeriod++;
		} while(amountDue > 0);
		
		System.out.println("Total Payments: " + addPayments());
		System.out.println("Total Principal Payments: " + addPrincipal());
		System.out.println("Total Interest: " + addInterest());
	}
	
	// Sum all of the payments in PaymentList
	public double addPayments() {
		double total = 0;
		for (Payment p : paymentList) {
			total+=p.getPmt();
		}
		return round(total,2);
	}
	
	// Sum all of the principal payments in PaymentList
	public double addPrincipal() {
		double total = 0;
		for (Payment p : paymentList) {
			total+=p.getPpmt();
		}
		return round(total,2);
	}
	
	// Sum all of the interest payments in PaymentList
	public double addInterest() {
		double total = 0;
		for (Payment p : paymentList) {
			total+=p.getIpmt();
		}
		return round(total,2);
	}
	
	// Print Payment Information
	public void printPayments() {
		System.out.println("Number of Payments: " + paymentList.size());
		for ( Payment p:paymentList) {
			System.out.println("Principle Payment: " + p.getPpmt());
			System.out.println("Interest Payment: " + p.getIpmt());
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
