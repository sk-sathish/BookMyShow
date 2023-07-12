package service;

import abstraction.IPaymentStrategy;
import constants.PaymentStatus;
import entity.Payment;

public class BankTransferPaymentStrategy implements IPaymentStrategy{

	@Override
	public Payment processPayment() {
		Payment payment = new Payment();
		payment.setStatus(PaymentStatus.SUCCESSFUL);
		return payment;
	}

}
