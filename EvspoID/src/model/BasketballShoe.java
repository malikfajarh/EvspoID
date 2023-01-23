package model;

public class BasketballShoe extends Shoe {

	public BasketballShoe(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category) {
		super(name, price, brand, supplier, supplierAddress, stock, category);
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.supplier = supplier;
		this.supplierAddress = supplierAddress;
		this.stock = stock;
		this.category = category;
		setSportCategory("Basketball");
	}

}
