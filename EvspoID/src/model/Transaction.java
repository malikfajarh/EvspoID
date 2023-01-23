package model;

import strategyPattern.Delivery;
import strategyPattern.Payment;

public class Transaction {
	private User user;
	private Clothes clothes;
	private Gear gear;
	private Shoe shoe;
	private Payment payment;
	private Delivery delivery;
	private String status;
	private int qty;

	public Transaction(User user, Clothes clothes, Gear gear, Shoe shoe, Payment payment, Delivery delivery,
			String status, int qty) {
		super();
		this.user = user;
		this.clothes = clothes;
		this.gear = gear;
		this.shoe = shoe;
		this.payment = payment;
		this.delivery = delivery;
		this.status = status;
		this.qty = qty;
	}

	public User getUser() {
		return user;
	}

	public Clothes getClothes() {
		return clothes;
	}

	public Gear getGear() {
		return gear;
	}

	public Shoe getShoe() {
		return shoe;
	}

	public Payment getPayment() {
		return payment;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public String getStatus() {
		return status;
	}

	public int getQty() {
		return qty;
	}

	public Payment setPayment(Payment payment) {
		return this.payment = payment;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
