package app.controller;

import app.StudentCalc;
import app.helper.*;
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
	private TextField InterestRate;
	@FXML
	private TextField NbrOfYears;
	@FXML
	private TextField AdditionalPayment;
	@FXML
	private Label lblTotalPayemnts;
	@FXML
	private Label lblTotalInterest;
	@FXML
	private DatePicker PaymentStartDate;
	
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
		
		Loan loan = new Loan(loanAmount, interestRate, numYears, additionalPayment);
		lblTotalPayemnts.setText(Double.toString(Math.round(loan.addPayments())));
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
