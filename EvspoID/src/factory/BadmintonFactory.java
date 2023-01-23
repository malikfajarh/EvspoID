package factory;

import model.Clothes;
import model.Gear;
import model.Shoe;
import model.BadmintonClothes;
import model.BadmintonShoe;
import model.BadmintonGear;

public class BadmintonFactory implements SportFactory {
	
	public BadmintonFactory() { }
	
	@Override
	public Clothes createClothes(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category) {
		return new BadmintonClothes(name, price, brand, supplier, supplierAddress, stock, category);
	}
	
	@Override
	public Shoe createShoe(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category) {
		return new BadmintonShoe(name, price, brand, supplier, supplierAddress, stock, category);
	}
	
	@Override
	public Gear createGear(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category) {
		return new BadmintonGear(name, price, brand, supplier, supplierAddress, stock, category);
	}

}
