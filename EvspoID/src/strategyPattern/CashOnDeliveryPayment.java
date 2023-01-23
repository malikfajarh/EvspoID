package strategyPattern;

public class CashOnDeliveryPayment implements PaymentMethod {

	@Override
	public double execute(int total, int amount) {
		double discount = 0;
		if (amount >= 3 && amount <= 5) {
			discount = 0.03 * total;
		} else if (amount >= 6) {
			discount = 0.1 * total;
		}
//		System.out.println(total+" "+discount);
		return discount;
	}

	@Override
	public String info() {
		return "Cash on delivery";
	}

}
