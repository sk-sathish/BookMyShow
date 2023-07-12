package entity;

import constants.PaymentStatus;

public class Payment {
	double amount;
	PaymentStatus status;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	public void setStatus(PaymentStatus paymentStatus) {
		this.status = paymentStatus;
	}
	
}
