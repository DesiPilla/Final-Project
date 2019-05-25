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
	
	public Loan(double loanAmount, double interestRate, int lengthOfLoan, double apmt) {
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.lengthOfLoan = lengthOfLoan;
		this.additionalPayment = apmt;
		
		amountDue = this.loanAmount;
		int payPeriod = 1;
		do {
			double pmt = Finance.pmt(this.interestRate/12, this.lengthOfLoan*12, -this.loanAmount);
			double ipmt = amountDue*interestRate/12;
			double ppmt = pmt - ipmt;
			
			/*
			double ppmt = Finance.ppmt(this.interestRate/12, payPeriod, this.lengthOfLoan*12, -this.loanAmount-addAdditional());
			double ipmt = Finance.ipmt(this.interestRate/12, payPeriod, this.lengthOfLoan*12, -this.loanAmount-addAdditional());
			*/
			Payment payment = new Payment(pmt, ppmt, ipmt, apmt);
			
			System.out.println("Period: " + payPeriod);
			System.out.println("Amount Due: " + round(amountDue,2));
			System.out.println("Payment: " + round(payment.getPmt(), 2));
			System.out.println("Principle Payment: " + round(payment.getPpmt() + payment.getApmt(), 2));
			System.out.println("Interest Payment: " + round(payment.getIpmt(), 2));
			System.out.println("Additional Payment: " + round(payment.getApmt(), 2));
			System.out.println();
			
			if (amountDue - ppmt - apmt <= 0) {
				if (amountDue - ppmt <= 0) {
					payment.setPmt(amountDue);
					payment.setApmt(0);
					amountDue = 0;
				}
				else {
					payment.setApmt(amountDue - pmt);
					amountDue = 0;
					paymentList.add(payment);
					break;
				}
			}
			else {
				amountDue -= (ppmt + apmt);
			}
			
			paymentList.add(payment);
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
			total+= (p.getPmt() + p.getApmt());
		}
		return round(total,2);
	}
	
	// Sum all of the principal payments in PaymentList
	public double addPrincipal() {
		double total = 0;
		for (Payment p : paymentList) {
			total+= (p.getPpmt() + p.getApmt());
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
	
	// Sum all of the additional payments in PaymentList
	public double addAdditional() {
		double total = 0;
		for (Payment p : paymentList) {
			total+=p.getApmt();
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
