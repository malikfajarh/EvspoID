package strategyPattern;

public class ThreeDaysDelivery implements DeliveryMethod {

	@Override
	public double execute(float amount, int distance) {
		int deliveryFee = 0;
		if (amount <= 3) {
			deliveryFee = 14000;
		} else {
			deliveryFee = 30000;
		}
		return deliveryFee;
	}

	public String info() {
		return "Three days delivery";
	}
}
