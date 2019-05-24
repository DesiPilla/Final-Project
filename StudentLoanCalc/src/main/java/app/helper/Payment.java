package app.helper;

public class Payment {
	private double pmt;
	private double ppmt;
	private double ipmt;
	
	public Payment(double payment, double ppayment, double ipayment) {
		this.pmt = payment;		// Payment
		this.ppmt = ppayment;	// Principal Payment
		this.ipmt = ipayment;	// Interest Payment
	}
	
	public double getPmt() {
		return this.pmt;
	}
	
	public void setPmt(double ppt) {
		this.pmt = ppt;
	}
	
	public double getPpmt() {
		return this.ppmt;
	}
	
	public void setPpmt(double ppmt) {
		this.ppmt = ppmt;
	}
	
	public double getIpmt() {
		return this.ipmt;
	}
	
	public void setIpmt(double ipmt) {
		this.ipmt = ipmt;
	}
}
