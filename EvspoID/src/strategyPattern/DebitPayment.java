package strategyPattern;

public class DebitPayment implements PaymentMethod {

	@Override
	public double execute(int total, int amount) {
		double discount = 0;
		if (amount >= 2 && amount <= 4) {
			discount = 0.15 * total;
		} else if (amount >= 5) {
			discount = 0.35 * total;
		}
		return discount;
	}
	
	public String info() {
		return "Debit";
	}
}
