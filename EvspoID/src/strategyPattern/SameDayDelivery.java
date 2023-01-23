package strategyPattern;

public class SameDayDelivery implements DeliveryMethod {

	@Override
	public double execute(float amount, int distance) {
		int deliveryFee = 0;
		if (amount <= 3) {
			deliveryFee = 35000;
		} else {
			deliveryFee = 67000;
		}
		return deliveryFee;
	}

	public String info() {
		return "Same day delivery";
	}
}
