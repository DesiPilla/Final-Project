package app.helper;

public class Payment {
	private double pmt;		// Payment
	private double ppmt;	// Principal Payment
	private double ipmt;	// Interest Payment
	private double apmt;	// Additional Payment
	
	// Payment Constructor
	public Payment(double payment, double ppayment, double ipayment, double apayment) {
		this.pmt = payment;
		this.ppmt = ppayment;
		this.ipmt = ipayment;
		this.apmt = apayment;
	}
	
	// Get Payment Value
	public double getPmt() {
		return this.pmt;
	}
	
	// Set Payment Value
	public void setPmt(double ppt) {
		this.pmt = ppt;
	}
	
	// Get Principal Payment Value
	public double getPpmt() {
		return this.ppmt;
	}
	
	// Set Principal Payment Value
	public void setPpmt(double ppmt) {
		this.ppmt = ppmt;
	}
	
	// Get Interest Payment Value
	public double getIpmt() {
		return this.ipmt;
	}
	
	// Set Interest Payment Value
	public void setIpmt(double ipmt) {
		this.ipmt = ipmt;
	}
	
	// Get Additional Payment Value
	public double getApmt()  {
		return this.apmt;
	}
	
	// Set Additional Payment Value
	public double setApmt(double apmt) {
		return this.apmt = apmt;
	}
}
