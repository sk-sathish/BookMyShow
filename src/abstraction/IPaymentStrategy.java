package abstraction;

import entity.Payment;

public interface IPaymentStrategy {
	public Payment processPayment();
}
