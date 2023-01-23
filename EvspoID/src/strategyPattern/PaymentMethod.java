package strategyPattern;

public interface PaymentMethod {
	double execute(int total, int amount);
	String info();
}
