package app.controller;

import app.StudentCalc;
import app.helper.Loan;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField NbrOfYears;
	
	@FXML
	private Label lblTotalInterest;
	
	@FXML
	private TextField AdditionalPayment;
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {

		double loanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Amount: " + loanAmount);
		
		LocalDate localDate = PaymentStartDate.getValue();
		System.out.println(localDate);
		
		double interestRate = Double.parseDouble(InterestRate.getText());
		System.out.println(interestRate);
		
		int numYears = Integer.parseInt(NbrOfYears.getText());
		System.out.println(numYears);
		
		double additionalPayment = Double.parseDouble(AdditionalPayment.getText());
		System.out.println(additionalPayment);
		
		Loan loan = new Loan(loanAmount, interestRate, numYear, additionalPayment);
		lblTotalPayments.setText(Double.toString(Math.round(loan.sumPayments())));
		lblTotalInterest.setText(Double.toString(Math.round(loan.totalInterestPayed())));
		
		
		/*
		System.out.println("Amount: " + LoanAmount.getText());
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Amount: " + dLoanAmount);	
		
		lblTotalPayemnts.setText("123");
		
		LocalDate localDate = PaymentStartDate.getValue();
	 
		System.out.println(localDate);
		*/
	}
}
