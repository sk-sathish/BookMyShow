package service;

import abstraction.IPaymentStrategy;
import constants.PaymentStatus;
import entity.Payment;

public class CreditCardPaymentStrategy implements IPaymentStrategy{

	@Override
	public Payment processPayment() {
		// TODO Auto-generated method stub
		Payment payment = new Payment();
		payment.setStatus(PaymentStatus.SUCCESSFUL);
		return payment;
	}

}
