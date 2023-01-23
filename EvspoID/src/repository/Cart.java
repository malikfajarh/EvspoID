package repository;

import java.util.ArrayList;
import model.Transaction;

public class Cart {
	
	Transaction transaction;
	
	private ArrayList<Transaction> transactionList;

	private static Cart cart;

	private Cart() {
		transactionList = new ArrayList<>();
	}

//	Singleton design pattern
	public static Cart getCartRepository() {
		if (cart == null) {
			cart = new Cart();
		}
		return cart;
	}

	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}
	
	public void addTransactionList(Transaction transaction) {
		transactionList.add(transaction);
	}
}
