package factory;

import model.Clothes;
import model.Shoe;
import model.Gear;

public interface SportFactory {
	abstract Clothes createClothes(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category);
	abstract Shoe createShoe(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category);
	abstract Gear createGear(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String category);
}
