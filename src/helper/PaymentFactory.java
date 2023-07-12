package helper;

import abstraction.IPaymentStrategy;
import constants.PaymentType;
import service.BankTransferPaymentStrategy;
import service.CreditCardPaymentStrategy;

public class PaymentFactory {
	public static IPaymentStrategy getPaymentStrategy(PaymentType paymentType) {
		if(paymentType.equals(PaymentType.CREDIT_CARD)) {
			return new CreditCardPaymentStrategy();
		}
		else if(paymentType.equals(PaymentType.BANK_TRANSFER)) {
			return new BankTransferPaymentStrategy();
		}
		return null;
	}
}
