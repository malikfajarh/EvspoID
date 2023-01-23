package strategyPattern;

public class Delivery {
	private DeliveryMethod deliveryMethod;

	public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	
	public double executeDeliveryMethod(int weight, int distance) {
		return deliveryMethod.execute(weight, distance);
	}
	
	public String checkDeliveryType() {
		String result = null;
		if(deliveryMethod instanceof SameDayDelivery) {
			result = "Same day services";
		}else if(deliveryMethod instanceof ThreeDaysDelivery) {
			result = "Three days services";
		}
		return result;
	}
	
	public String getInfo() {
		return "info";	
	}
}
