package factory;

import model.Clothes;
import model.Gear;
import model.Shoe;
import model.BasketballClothes;
import model.BasketballGear;
import model.BasketballShoe;

public class BasketballFactory implements SportFactory {

	public BasketballFactory() { }
	
	@Override
	public Clothes createClothes(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category) {
		return new BasketballClothes(name, price, brand, supplier, supplierAddress, stock, category);
	}
	
	@Override
	public Shoe createShoe(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category) {
		return new BasketballShoe(name, price, brand, supplier, supplierAddress, stock, category);
	}
	
	@Override
	public Gear createGear(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category) {
		return new BasketballGear(name, price, brand, supplier, supplierAddress, stock, category);
	}

}
