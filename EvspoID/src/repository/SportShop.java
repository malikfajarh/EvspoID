package repository;

import java.util.ArrayList;
import java.text.DecimalFormat;

import factory.SportFactory;
import model.Clothes;
import model.Gear;
import model.Shoe;

public class SportShop {

	SportFactory sportFactory;
	Clothes clothes;
	Gear gear;
	Shoe shoe;

	private ArrayList<Clothes> clothesList = new ArrayList<>();;
	private ArrayList<Gear> gearList = new ArrayList<>();
	private ArrayList<Shoe> shoesList = new ArrayList<>();
	DecimalFormat df = new DecimalFormat("Rp#,###.##");

	public SportShop(SportFactory sportFactory) {
		this.sportFactory = sportFactory;
	}

	public void setDetailProduct(String name, int price, String brand, String supplier, String supplierAddress,
			int stock, String category) {
		if (category.equalsIgnoreCase("Clothes")) {
			clothes = sportFactory.createClothes(name, price, brand, supplier, supplierAddress, stock, category);
			clothesList.add(clothes);
		} else if (category.equalsIgnoreCase("Gear")) {
			gear = sportFactory.createGear(name, price, brand, supplier, supplierAddress, stock, category);
			gearList.add(gear);
		} else if (category.equalsIgnoreCase("Shoe")) {
			shoe = sportFactory.createShoe(name, price, brand, supplier, supplierAddress, stock, category);
			shoesList.add(shoe);
		}
	}
	
	public void deleteProduct(String name, String category) {
		if (category.equalsIgnoreCase("clothes")) {
			int index=0;
			int resultIndex = 0;
			for(Clothes allClothes:clothesList) {
				if(allClothes.getName().equals(name)) {
					resultIndex = index;
					break;
				}
				index++;
			}
			clothesList.remove(resultIndex);
		} else if (category.equalsIgnoreCase("gear")) {
			int index=0;
			int resultIndex = 0;
			for(Gear allGear:gearList) {
				if(allGear.getName().equals(name)) {
					resultIndex = index;
					break;
				}
				index++;
			}
			gearList.remove(resultIndex);
		} else if (category.equalsIgnoreCase("shoe")) {
			int index=0;
			int resultIndex= 0;
			for(Shoe allShoe:shoesList) {
				if(allShoe.getName().equals(name)) {
					resultIndex = index;
					break;
				}
				index++;
			}
			shoesList.remove(resultIndex);
		}
	}

	public Clothes makeDummyClothes() {
		clothes = sportFactory.createClothes("Dummy", 0, null, null, null, 0, null);
		return clothes;
	}

	public Gear makeDummyGear() {
		gear = sportFactory.createGear("Dummy", 0, null, null, null, 0, null);
		return gear;
	}

	public Shoe makeDummyShoe() {
		shoe = sportFactory.createShoe("Dummy", 0, null, null, null, 0, null);
		return shoe;
	}

	public ArrayList<Clothes> getClothesList() {
		return clothesList;
	}

	public ArrayList<Shoe> getShoesList() {
		return shoesList;
	}

	public ArrayList<Gear> getGearList() {
		return gearList;
	}

	public void addClothesList(Clothes clothes) {
		clothesList.add(clothes);
	}

	public void addShoesList(Shoe shoe) {
		shoesList.add(shoe);
	}

	public void addGearList(Gear gear) {
		gearList.add(gear);
	}

	public void viewProduct() {
		System.out.println("\nClothes\n------");
		for (Clothes clothes : clothesList) {

			System.out.println("Product : " + clothes.getName());
			System.out.println("Price : " + df.format((clothes.getPrice())));
			System.out.printf("Brand : %s, %s (%s)\n",clothes.getBrand(),clothes.getSupplier(),clothes.getSupplierAddress());
			System.out.println("Stock : " + clothes.getStock());
			System.out.println();

		}

		System.out.println("Gear\n-------");
		for (Gear gear : gearList) {
			System.out.println("Product : " + gear.getName());
			System.out.println("Price : " + df.format(gear.getPrice()));
			System.out.printf("Brand : %s, %s (%s)\n",gear.getBrand(),gear.getSupplier(),gear.getSupplierAddress());
			System.out.println("Stock : " + gear.getStock());
			System.out.println();
		}

		System.out.println("Shoe\n------");
		for (Shoe shoe : shoesList) {
			System.out.println("Product : " + shoe.getName());
			System.out.println("Price : " + df.format(shoe.getPrice()));
			System.out.printf("Brand : %s, %s (%s)\n",shoe.getBrand(),shoe.getSupplier(),shoe.getSupplierAddress());
			System.out.println("Stock : " + shoe.getStock());
			System.out.println();
		}

	}

}
