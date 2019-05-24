package app.helper;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoanTests {

	// Expected values come from the Excel sheet
	
	// Run tests without an additional payment
	/*
	@Test
	public void TestLoan1() {
		double loanAmount = 100000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 0;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		double expectedValue = 158580;
		assertEquals(loan.addPayments() , expectedValue, 15);
	}
	*/
	
	@Test
	public void TestPrincipal1() {
		double loanAmount = 100000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 0;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		assertEquals(loan.addPrincipal() , loanAmount, .1);
	}
	/*
	@Test
	public void TestInterest1() {
		double loanAmount = 100000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 0;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		double expectedValue = 58580;
		assertEquals(loan.addInterest() , expectedValue, 15);
	}
	*/
	/*
	// Run tests with an additional payment
	@Test
	public void TestLoan2() {
		double loanAmount = 100000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 200;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		double expectedValue = 145667;
		assertEquals(loan.addPayments() , expectedValue, 15);
	}
	
	@Test
	public void TestPrincipal2() {
		double loanAmount = 100000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 200;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		assertEquals(loan.addPrincipal() , loanAmount, .1);
	}

	@Test
	public void TestInterest2() {
		double loanAmount = 100000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 200;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		double expectedValue = 45667;
		assertEquals(loan.addInterest() , expectedValue, 15);
	}
	*/
}
