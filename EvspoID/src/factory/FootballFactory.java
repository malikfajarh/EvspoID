package factory;

import model.Clothes;
import model.Shoe;
import model.Gear;
import model.FootballClothes;
import model.FootballGear;
import model.FootballShoe;

public class FootballFactory implements SportFactory {

	public FootballFactory() { }
	
	@Override
	public Clothes createClothes(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category) {
		return new FootballClothes(name, price, brand, supplier, supplierAddress, stock, category);
	}
	
	@Override
	public Shoe createShoe(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category) {
		return new FootballShoe(name, price, brand, supplier, supplierAddress, stock, category);
	}
	
	@Override
	public Gear createGear(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category) {
		return new FootballGear(name, price, brand, supplier, supplierAddress, stock, category);
	}

}
