package strategyPattern;

public class Payment {
	private PaymentMethod paymentMehtod;

	public void setPaymentMehtod(PaymentMethod paymentMehtod) {
		this.paymentMehtod = paymentMehtod;
	}
	
	public double executePaymentMethod(int total, int amount) {
		return paymentMehtod.execute(total, amount);
	}
	
	public String checkPaymentType() {
		String result = null;
		if(paymentMehtod instanceof CashOnDeliveryPayment) {
			result = "Cash on delivery";
		}else if(paymentMehtod instanceof DebitPayment) {
			result = "Debit";
		}
		return result;
	}
}
