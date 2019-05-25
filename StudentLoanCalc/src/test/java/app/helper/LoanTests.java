package app.helper;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoanTests {

	// Expected values come from the Excel sheet
	// Run tests without an additional payment
	@Test
	public void TestLoan1() {
		double loanAmount = 100000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 0;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		double expectedValue = 158580.53;
		assertEquals(loan.addPayments() , expectedValue, .5);
	}
	
	@Test
	public void TestPrincipal1() {
		double loanAmount = 100000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 0;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		assertEquals(loan.addPrincipal() , loanAmount, .1);
	}
	
	@Test
	public void TestInterest1() {
		double loanAmount = 100000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 0;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		double expectedValue = 58580.53;
		assertEquals(loan.addInterest() , expectedValue, .5);
	}
	
	// Run tests with an additional payment
	@Test
	public void TestLoan2() {
		double loanAmount = 100000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 200;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		double expectedValue = 145466.59;
		assertEquals(loan.addPayments() , expectedValue, .5);
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
		double expectedValue = 45466.59;
		assertEquals(loan.addInterest() , expectedValue, .5);
	}
	
	// Checks Other End Condition for an Additional Payment Model
	@Test
	public void TestLoan3() {
		double loanAmount = 100000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 300;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		double expectedValue = 140953.58;
		assertEquals(loan.addPayments() , expectedValue, .5);
	}
	
	@Test
	public void TestPrincipal3() {
		double loanAmount = 100000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 300;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		assertEquals(loan.addPrincipal() , loanAmount, .1);
	}

	@Test
	public void TestInterest3() {
		double loanAmount = 100000;
		double interestRate = 0.10;
		int lengthOfLoan = 10;
		double additionalPayment = 300;
		
		Loan loan = new Loan(loanAmount, interestRate, lengthOfLoan, additionalPayment);	
		double expectedValue = 40953.58;
		assertEquals(loan.addInterest() , expectedValue, .5);
	}
}
