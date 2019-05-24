package app.helper;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoanTests {

	@Test
	public void TestLoan() {
		double loanAmount = 200000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 0;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		double expectedValue = 317162.05;
		System.out.println(expectedValue);
		System.out.println(loan.addPayments());
		assertEquals(loan.addPayments(), expectedValue, 100);
	}
	
	@Test
	public void TestPrincipal() {
		double loanAmount = 50000;
		double interestRate = 0.10;
		int lengthOfLoan = 5;
		double additionalPayment = 0;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		double error = 0.001;
		assertTrue(loan.addPayments() - loan.addInterest() - loanAmount > error);
	}

	@Test
	public void TestInterest() {
		double loanAmount = 50000;
		double interestRate = 0.10;
		int lengthOfLoan = 5;
		double additionalPayment = 0;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		double error = 0.001;
		assertTrue(loan.addPayments() - loan.addInterest() - loanAmount > error);
	}
}
