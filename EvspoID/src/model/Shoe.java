package model;

public abstract class Shoe {
	
	protected String name;
	protected int price;
	protected String brand;
	protected String supplier;
	protected String supplierAddress;
	protected int stock;
	protected String sportCategory;
	protected String category;
	
	public Shoe(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category) {
		super();
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.supplier = supplier;
		this.supplierAddress = supplierAddress;
		this.stock = stock;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getSportCategory() {
		return sportCategory;
	}

	public void setSportCategory(String sportCategory) {
		this.sportCategory = sportCategory;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
