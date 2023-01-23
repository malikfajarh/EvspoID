package strategyPattern;

public interface DeliveryMethod {
	double execute(float weight , int distance);
	String info();
}
