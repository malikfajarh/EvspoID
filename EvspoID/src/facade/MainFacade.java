package facade;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import factory.BadmintonFactory;
import factory.BasketballFactory;
import factory.FootballFactory;
import factory.SportFactory;
import factory.UserFactory;
import model.Clothes;
import model.Gear;
import model.Shoe;
import model.Transaction;
import model.User;
import repository.Cart;
import repository.SportShop;
import repository.UsersRepository;
import strategyPattern.CashOnDeliveryPayment;
import strategyPattern.DebitPayment;
import strategyPattern.Delivery;
import strategyPattern.Payment;
import strategyPattern.SameDayDelivery;
import strategyPattern.ThreeDaysDelivery;

public class MainFacade {
	int input = 0, prevIndex = 0;
	Scanner scan = new Scanner(System.in);
	UserFactory userFactory = new UserFactory();
	UsersRepository userRepository = UsersRepository.getUsersRepository();
	Cart cartRepository = Cart.getCartRepository();
	SportFactory sf; SportShop basketballDepartement  = new SportShop(new BasketballFactory()); 
	SportShop footballDepartement = new SportShop(new FootballFactory());
	SportShop badmintonDepartement = new SportShop(new BadmintonFactory());
	Clothes clothes; Shoe shoe; Gear gear; Clothes dummyClothes;
	User user;
	User currentUser; Clothes currentClothes; Shoe currentShoe; Gear currentGear;
//	Payment paymentType = new Payment(); Delivery deliveryServices = new Delivery();
	DecimalFormat df = new DecimalFormat("Rp#,###.##");
	String tempPayment, tempDelivery; int qty;
	ArrayList<Integer>arrIndex = new ArrayList<>();
	
	public void initialize() {
		basketballDepartement.setDetailProduct("Zion 2 Black - 42", 2059000, "Nike", "GoodsDept", "Jl. Pertukangan jaya, Jakarta", 2, "Shoe");
		basketballDepartement.setDetailProduct("Air Force 1 Mid 07 high White - 40", 1689000, "Nike", "HoopStation", "Jl. Kota raya, Bandung", 3, "Shoe");
		basketballDepartement.setDetailProduct("Kyrie Infinity EP Blue - 43", 1979000, "Nike", "HoopStation", "Jl. Kota raya, Bandung", 3, "Shoe");
		basketballDepartement.setDetailProduct("Dame 8 Black - 45", 2000000, "Adidas", "GoodsDept", "Jl. Pertukangan jaya, Jakarta", 1, "Shoe");
		
		basketballDepartement.setDetailProduct("HARDEN VOL. 6 T-SHIRT Red - XL", 500000, "Adidas", "GoodsDept", "Jl. Pertukangan jaya, Jakarta", 2, "Clothes");
		basketballDepartement.setDetailProduct("DAME TEE White - L", 400000, "Adidas", "GoodsDept", "Jl. Pertukangan jaya, Jakarta", 3, "Clothes");
		basketballDepartement.setDetailProduct("Lebron James Lakers Yellow - L", 1528000, "Nike", "HoopStation", "Jl. Kota raya, Bandung", 3, "Clothes");
		
		basketballDepartement.setDetailProduct("LIL' STRIPE MINI BASKETBALL - 5", 250000, "Adidas", "GoodsDept", "Jl. Pertukangan jaya, Jakarta", 3, "Gear");
		basketballDepartement.setDetailProduct("Jordan Everyday Ankle Socks White - L", 290000, "Nike", "HoopStation", "Jl. Kota raya, Bandung", 3, "Gear");
		basketballDepartement.setDetailProduct("AEROREADY PRIMEGREEN TRAXION CREW SOCKS Green - M", 350000, "Adidas", "GoodsDept", "Jl. Pertukangan jaya, Jakarta", 3, "Gear");
	
		footballDepartement.setDetailProduct("PREDATOR EDGE.4 FXG Black - 44", 900000, "Adidas", "GoodsDept", "Jl. Pertukangan jaya, Jakarta", 2, "Shoe");
		footballDepartement.setDetailProduct("Nike Lunar Gato II IC White - 42", 1649000, "Nike", "HoopStation", "Jl. Kota raya, Bandung", 3, "Shoe");
		footballDepartement.setDetailProduct("Nike Zoom Mercurial Vapor 15 Elite FG	Chopper - 41", 3559000, "Nike", "HoopStation", "Jl. Kota raya, Bandung", 1, "Shoe");
		
		footballDepartement.setDetailProduct("FC BAYERN PRE-MATCH JERSEY Red - L", 900000, "Adidas", "GoodsDept", "Jl. Pertukangan jaya, Jakarta", 3, "Clothes");
		footballDepartement.setDetailProduct("ARSENAL PRE-MATCH JERSEY White - M", 900000, "Adidas", "GoodsDept", "Jl. Pertukangan jaya, Jakarta", 3, "Clothes");
		footballDepartement.setDetailProduct("Liverpool F.C. Red - XL", 799000, "Nike", "HoopStation", "Jl. Kota raya, Bandung", 3, "Clothes");
		
		footballDepartement.setDetailProduct("UCL LEAGUE VOID FOOTBALL - 5", 550000, "Adidas", "GoodsDept", "Jl. Pertukangan jaya, Jakarta", 2, "Gear");
		footballDepartement.setDetailProduct("ARGENTINA 22 HOME SOCKS White - XL", 330000, "Adidas", "GoodsDept", "Jl. Pertukangan jaya, Jakarta", 1, "Gear");
		footballDepartement.setDetailProduct("Arsenal Bottle", 200000, "Adidas", "GoodsDept", "Jl. Pertukangan jaya, Jakarta", 3, "Gear");

		badmintonDepartement.setDetailProduct("YONEX AERUS Z 2 MEN Blue - 40 ", 2250000, "Yonex", "Smash", "Jl. Pelipir, Medan", 2, "Shoe");
		badmintonDepartement.setDetailProduct("YONEX Power Cushion Aerus X Black - 42", 2090000, "Yonex", "Smash", "Jl. Pelipir, Medan", 2, "Shoe");
		badmintonDepartement.setDetailProduct("Li-Ning Energy 10 White - 38", 580000, "Li-Ning", "Shuttle cock", "Jl. Kebangsaan, Aceh", 3, "Shoe");
		
		badmintonDepartement.setDetailProduct("YONEX MENS BADMINTON TOURNAMENT SLEEVELESS TOP White - L", 1087000, "Yonex", "Smash", "Jl. Pelipir, Medan", 2, "Clothes");
		badmintonDepartement.setDetailProduct("Li-Ning Badminton T-Shirt ATSSA03-2 Royal Blue - M", 268000, "Li-Ning", "Shuttle cock", "Jl. Kebangsaan, Aceh", 3, "Clothes");
		badmintonDepartement.setDetailProduct("YONEX MEN'S RN T-SHIRT 16372EX - FIRE RED, L", 331170, "Yonex", "Smash", "Jl. Pelipir, Medan", 2, "Clothes");

		badmintonDepartement.setDetailProduct("YONEX BADMINTON FRAME NANORAY Z SPEED - HIGH ORANGE, 3U/G5", 2152910, "Yonex", "Smash", "Jl. Pelipir, Medan", 2, "Gear");
		badmintonDepartement.setDetailProduct("Li-Ning Badminton Racket Bladex 73 Super Light - 6U Blue AYPS059-1", 920000, "Li-Ning", "Shuttle cock", "Jl. Kebangsaan, Aceh", 3, "Gear");
		badmintonDepartement.setDetailProduct("YONEX BADMINTON STRING BG AEROBITE BOOST - GREY/RED",133000, "Yonex", "Smash", "Jl. Pelipir, Medan", 2, "Gear");	

		user = userFactory.makeUser("joko", "1234", "Jl. Batu");
//		user = userFactory.makeUser("admin", "1234", "Jl. Toko pusat");
		userRepository.addUserList(user);
	}
	
	public void createUser(String username, String password, String address) {
		user = userFactory.makeUser(username, password, address);
		userRepository.addUserList(user);
	}
	
	public boolean checkAdmin(String username, String password) {
		boolean result = false;
		if (username.equals("admin") && password.equals("1234")) {
			result = true;
		}
		return result;
	}
	
	public boolean checkUsername(String username) {
		boolean result = false;
		for (User user : userRepository.getUserList()) {
			if(username.equals(user.getUsername())) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	public boolean checkUserAvailable(String username, String password) {
		boolean result = false;
		for (User user : userRepository.getUserList()) {
			if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
				result = true;
				currentUser = user;
				break;
			}
		}
		return result;
	}
	
	public void viewProductBySport(String sport) {
		if(sport.equals("basketball")) {
			basketballDepartement.viewProduct();
			chooseProduct();
		}else if(sport.equals("football")) {
			footballDepartement.viewProduct();
			chooseProduct();
		}else if(sport.equals("badminton")) {
			badmintonDepartement.viewProduct();
			chooseProduct();
		}
	}
	
	public void chooseProduct() {
		qty = 0; boolean result = false;
		String productName;
		
		do{
			
			System.out.print("Choose product name[0 to exit]: ");
			productName = scan.nextLine();
//			System.out.println(productName);
			if(productName.equals("0")) {
				System.out.println("Exit..."); scan.nextLine();
				break;
			}
			System.out.print("Input quantity: ");
			qty = scan.nextInt(); scan.nextLine();
			result = checkProductAvailable(productName, qty);
			
			if (result == false) System.out.println("Product not available...");
			else if(result == true) System.out.println("Added to cart!");scan.nextLine();
		}while(result == false);
		
		cartRepository.addTransactionList(new Transaction(currentUser, currentClothes, currentGear, currentShoe, null, null, "waiting to be paid", qty));
		
	}
	
	public boolean checkProductAvailable(String productName, int qty) {
		boolean result = false; int availableStock = 0;
		for (Clothes clothes: footballDepartement.getClothesList()) {
			if(productName.equalsIgnoreCase(clothes.getName()) && qty <= clothes.getStock()) {
				result = true;
				availableStock = clothes.getStock() - qty;
				clothes.setStock(availableStock);
				currentClothes = clothes;
				currentGear = footballDepartement.makeDummyGear();
				currentShoe = footballDepartement.makeDummyShoe();
				break;
			}
		}
		
		for (Gear gear: footballDepartement.getGearList()) {
			if(productName.equalsIgnoreCase(gear.getName()) && qty <= gear.getStock()) {
				result = true;
				availableStock = gear.getStock() - qty;
				gear.setStock(availableStock);
				currentGear = gear;
				currentClothes = footballDepartement.makeDummyClothes();
				currentShoe = footballDepartement.makeDummyShoe();
				break;
			}
		}
		
		for (Shoe shoe: footballDepartement.getShoesList()) {
			if(productName.equalsIgnoreCase(shoe.getName()) && qty <= shoe.getStock()) {
				result = true;
				availableStock = shoe.getStock() - qty;
				shoe.setStock(availableStock);
				currentShoe = shoe;
				currentClothes = footballDepartement.makeDummyClothes();
				currentGear = footballDepartement.makeDummyGear();
				break;
			}
		}
		
		for (Clothes clothes: basketballDepartement.getClothesList()) {
			if(productName.equalsIgnoreCase(clothes.getName()) && qty <= clothes.getStock()) {
				result = true;
				availableStock = clothes.getStock() - qty;
				clothes.setStock(availableStock);
				currentClothes = clothes;
				currentGear = basketballDepartement.makeDummyGear();
				currentShoe = basketballDepartement.makeDummyShoe();
				break;
			}
		}
		
		for (Gear gear: basketballDepartement.getGearList()) {
			if(productName.equalsIgnoreCase(gear.getName()) && qty <= gear.getStock()) {
				result = true;
				availableStock = gear.getStock() - qty;
				gear.setStock(availableStock);
				currentGear = gear;
				currentClothes = basketballDepartement.makeDummyClothes();
				currentShoe = basketballDepartement.makeDummyShoe();
				break;
			}
		}
		
		for (Shoe shoe: basketballDepartement.getShoesList()) {
			if(productName.equalsIgnoreCase(shoe.getName()) && qty <= shoe.getStock()) {
				result = true;
				availableStock = shoe.getStock() - qty;
				shoe.setStock(availableStock);
				currentShoe = shoe;
				currentClothes = basketballDepartement.makeDummyClothes();
				currentGear = basketballDepartement.makeDummyGear();
				break;
			}
		}
		
		for (Clothes clothes: badmintonDepartement.getClothesList()) {
			if(productName.equalsIgnoreCase(clothes.getName()) && qty <= clothes.getStock()) {
				result = true;
				availableStock = clothes.getStock() - qty;
				clothes.setStock(availableStock);
				currentClothes = clothes;
				currentGear = badmintonDepartement.makeDummyGear();
				currentShoe = badmintonDepartement.makeDummyShoe();
				break;
			}
		}
		
		for (Gear gear: badmintonDepartement.getGearList()) {
			if(productName.equalsIgnoreCase(gear.getName()) && qty <= gear.getStock()) {
				result = true;
				availableStock = gear.getStock() - qty;
				gear.setStock(availableStock);
				currentGear = gear;
				currentClothes = badmintonDepartement.makeDummyClothes();
				currentShoe = badmintonDepartement.makeDummyShoe();
				break;
			}
		}
		
		for (Shoe shoe: badmintonDepartement.getShoesList()) {
			if(productName.equalsIgnoreCase(shoe.getName()) && qty <= shoe.getStock()) {
				result = true;
				availableStock = shoe.getStock() - qty;
				shoe.setStock(availableStock);
				currentShoe = shoe;
				currentClothes = badmintonDepartement.makeDummyClothes();
				currentGear = badmintonDepartement.makeDummyGear();
				break;
			}
		}
		
		return result;
	}
	
	public void insertProduct(String name, int price, String brand, String supplier, String supplierAddress, int stock,
			String sportCategory, String category) {
		initialize();
		footballDepartement.setDetailProduct(name, price, brand, supplier, supplierAddress, stock, category);
		
	}
	
	public void viewCart() {
 		int i = 1, totalPrice = 0, temp;
 		double discount = 0, deliveryFee = 0;
 		boolean empty = true;
 		String payment, delivery;
 		
		System.out.printf("\n%s transaction\n-----------------\n",currentUser.getUsername());

		for (Transaction transaction : cartRepository.getTransactionList()) {	
			
			if(transaction.getUser().getUsername().equals(currentUser.getUsername()) && transaction.getStatus().equals("waiting to be paid")) {
				temp = cartRepository.getTransactionList().indexOf(transaction);
				arrIndex.add(temp);
				
				System.out.printf("[%d]\n",i);
				 empty = false;
				if (!transaction.getClothes().getName().equals("Dummy")) {
					System.out.printf("Product: %s | %s qty: %d\n",transaction.getClothes().getName(),df.format(transaction.getClothes().getPrice()), transaction.getQty());
					totalPrice += transaction.getClothes().getPrice() * transaction.getQty();
				}else if(!transaction.getShoe().getName().equals("Dummy")) {
					System.out.printf("Product: %s | %s qty: %d\n",transaction.getShoe().getName(),df.format(transaction.getShoe().getPrice()),transaction.getQty());
					totalPrice += transaction.getShoe().getPrice() * transaction.getQty();
				}else if(!transaction.getGear().getName().equals("Dummy")) {
					System.out.printf("Product: %s | %s qty: %d\n",transaction.getGear().getName(),df.format(transaction.getGear().getPrice()),transaction.getQty());
					totalPrice += transaction.getGear().getPrice()* transaction.getQty();
				}else {
					System.out.println("Error");
				}
				
				System.out.printf("Delivery service: %s\n",transaction.getDelivery());
				System.out.printf("Payment mehtod: %s\n",transaction.getPayment());
				System.out.printf("Status: %s\n",transaction.getStatus());
				i++;
				transaction.setStatus("Paid");
			}
			
		}
		if (empty == false) {
			do {
				System.out.print("\nChoose Delivery services[Same day services | 3 days services]: ");
				delivery = scan.nextLine(); tempDelivery = delivery;
			}while(!delivery.equalsIgnoreCase("Same day services" ) && !delivery.equalsIgnoreCase("3 days services"));
			
			do {
				System.out.print("Choose Payment method[Debit | Cash on delivery]: ");
				payment = scan.nextLine(); tempPayment = payment;
			}while(!payment.equalsIgnoreCase("Debit" ) && !payment.equalsIgnoreCase("Cash on delivery"));
				
			for (Transaction transaction : cartRepository.getTransactionList()) {
				for (Integer integer : arrIndex) {
					if (cartRepository.getTransactionList().indexOf(transaction) == arrIndex.indexOf(prevIndex)) {
//						System.out.println("qty: "+qty);
						Payment paymentType = new Payment(); Delivery deliveryServices = new Delivery();
						if (payment.equalsIgnoreCase("Debit")) {
							paymentType.setPaymentMehtod(new DebitPayment());
							discount = paymentType.executePaymentMethod(totalPrice, qty); 
							transaction.setPayment(paymentType);
						}else if(payment.equalsIgnoreCase("Cash on delivery")) {
							paymentType.setPaymentMehtod(new CashOnDeliveryPayment());
							discount = paymentType.executePaymentMethod(totalPrice, qty);
							transaction.setPayment(paymentType);
						}

						if (delivery.equalsIgnoreCase("Same day services")) {
							deliveryServices.setDeliveryMethod(new SameDayDelivery());
							deliveryFee = deliveryServices.executeDeliveryMethod(qty, 0);
							transaction.setDelivery(deliveryServices);
							
						}else if (delivery.equalsIgnoreCase("3 days services")) {
							deliveryServices.setDeliveryMethod(new ThreeDaysDelivery());
							deliveryFee = deliveryServices.executeDeliveryMethod(qty, 0);
							transaction.setDelivery(deliveryServices);
						}
						
					}
				}
			
			}
			
			System.out.println("\nTotal : "+df.format(totalPrice));
			System.out.println("Discount: -"+df.format(discount));
			System.out.println("Delivery fee: +"+df.format(deliveryFee));
			System.out.println("-------------------------");
			System.out.println("Total Price : "+df.format(totalPrice-discount+deliveryFee));
			scan.nextLine();
			prevIndex++;
		}else {
			System.out.println("Your Cart empty..."); scan.nextLine();
		}
		
	}
	
	public void viewTransaction() {
		int i = 1;
 		
		System.out.printf("\n%s All transaction\n---------------------\n",currentUser.getUsername());
		if (cartRepository.getTransactionList().isEmpty() == true) {
			System.out.println("No transaction recorded..."); scan.nextLine();
		}else {
			for (Transaction transaction : cartRepository.getTransactionList()) {	
				if(transaction.getUser().getUsername().equals(currentUser.getUsername())) {
					System.out.printf("[%d]\n",i);
					 
					if (!transaction.getClothes().getName().equals("Dummy")) {
						System.out.printf("Product: %s | %s qty: %d\n",transaction.getClothes().getName(),df.format(transaction.getClothes().getPrice()), transaction.getQty());
					}else if(!transaction.getShoe().getName().equals("Dummy")) {
						System.out.printf("Product: %s | %s qty: %d\n",transaction.getShoe().getName(),df.format(transaction.getShoe().getPrice()),transaction.getQty());
					}else if(!transaction.getGear().getName().equals("Dummy")) {
						System.out.printf("Product: %s | %s qty: %d\n",transaction.getGear().getName(),df.format(transaction.getGear().getPrice()),transaction.getQty());
					}else {
						System.out.println("Error");
					}
				
					System.out.println("Delivery service: "+transaction.getDelivery().checkDeliveryType());
					System.out.println("Payment method: "+transaction.getPayment().checkPaymentType());
					System.out.printf("Status: %s\n\n",transaction.getStatus());
					i++;
				}
				
			}
			System.out.println("Press enter to continue...");
			scan.nextLine();
		}
		
	}
	public void adminInsertProduct() {
		String name, category, brand, supplier, supplierAddress, sport;
		int stock, price; 
		
		System.out.print("Insert product name: ");
		name = scan.nextLine();
		
		System.out.print("Insert product price: ");
		price = scan.nextInt(); scan.nextLine();
		
		System.out.print("Insert product stock: ");
		stock = scan.nextInt(); scan.nextLine();
		
		System.out.print("Insert product category[shoe | clothes | gear]: ");
		category = scan.nextLine();
		
		System.out.print("Insert product brand: ");
		brand = scan.nextLine();
		
		System.out.print("Insert product supplier: ");
		supplier = scan.nextLine();
		
		System.out.print("Insert product supplier address: ");
		supplierAddress = scan.nextLine();
		
		System.out.print("Insert product sport category[basketball | football | badminton]: ");
		sport = scan.nextLine();
		
		if (sport.equals("basketball")) {
			basketballDepartement.setDetailProduct(name, price, brand, supplier, supplierAddress, stock, category);
		}else if (sport.equals("football")) {
			footballDepartement.setDetailProduct(name, price, brand, supplier, supplierAddress, stock, category);
		}else if (sport.equals("badminton")) {
			badmintonDepartement.setDetailProduct(name, price, brand, supplier, supplierAddress, stock, category);
		}
		System.out.println("Product has been created..."); scan.nextLine();
	}
	
	public void adminUpdateProduct() {
		input = 0;
		
		do {
			System.out.println("\nChoose sport category\n--------------");
			System.out.println("1. Basketball");
			System.out.println("2. Football");
			System.out.println("3. Badminton");
			System.out.println("4. Exit");
			System.out.print(">> ");
			input = scan.nextInt(); scan.nextLine();
			
			if(input == 1) {
				basketballDepartement.viewProduct();
//				System.out.println("masuk");
				adminUpdateProductInsert("basketball");
				
			}else if(input == 2) {
				footballDepartement.viewProduct();
				adminUpdateProductInsert("football");

			}else if (input == 3) {
				badmintonDepartement.viewProduct();
				adminUpdateProductInsert("badminton");

			}
			
		}while(input!= 4);
		
	}
	
	public void adminUpdateProductInsert(String sportCategory) {
		System.out.println("\nUpdate menu\n----------");
		String name = null, category, brand, supplier, supplierAddress, sport, sportDivision = sportCategory;
		int result = 0;
		int stock, price; 
		
		do {
			System.out.print("Select product name[0 to exit]: ");
			name= scan.nextLine();
			
			if(name.equals("0")) {
				break;
			}
			
			result = adminCheckProduct(name, sportDivision);
		}while(result < 0);
		
		if(name.equals("0")) {
			System.out.println("Exit..."); scan.nextLine();
		}else {
			System.out.print("Update product price: ");
			price = scan.nextInt(); scan.nextLine();
			
			System.out.print("Update product stock: ");
			stock = scan.nextInt(); scan.nextLine();
			
			System.out.print("Update product brand: ");
			brand = scan.nextLine();
			
			System.out.print("Update product supplier: ");
			supplier = scan.nextLine();
			
			System.out.print("Update product supplier address: ");
			supplierAddress = scan.nextLine();
			
			adminInsertUpdatedProduct(name, sportCategory, result, brand, supplier, supplierAddress, price, stock);
		}
		
		
	}
	
	public int adminCheckProduct(String productName, String sportCategory) {
		int index = -1; 
		if (sportCategory.equals("basketball")) {
			for (Clothes clothes: basketballDepartement.getClothesList()) {
				if(productName.equalsIgnoreCase(clothes.getName()) ) {
					index = basketballDepartement.getClothesList().indexOf(clothes);
					break;
				}
			}
			
			for (Gear gear: basketballDepartement.getGearList()) {
				if(productName.equalsIgnoreCase(gear.getName()) ) {
					index = basketballDepartement.getGearList().indexOf(gear);
					break;
				}
			}
			
			for (Shoe shoe: basketballDepartement.getShoesList()) {
				if(productName.equalsIgnoreCase(shoe.getName()) ) {
					index = basketballDepartement.getShoesList().indexOf(shoe);
					break;
				}
			}
		}else if(sportCategory.equals("football")) {
			for (Clothes clothes: footballDepartement.getClothesList()) {
				if(productName.equalsIgnoreCase(clothes.getName())) {
					index = footballDepartement.getClothesList().indexOf(clothes);
					break;
				}
			}
			
			for (Gear gear: footballDepartement.getGearList()) {
				if(productName.equalsIgnoreCase(gear.getName())) {
					index = footballDepartement.getGearList().indexOf(gear);
					break;
				}
			}
			
			for (Shoe shoe: footballDepartement.getShoesList()) {
				if(productName.equalsIgnoreCase(shoe.getName()) ) {
					index = footballDepartement.getShoesList().indexOf(shoe);
					break;
				}
			}
		}else if(sportCategory.equals("badminton")) {
			for (Clothes clothes: badmintonDepartement.getClothesList()) {
				if(productName.equalsIgnoreCase(clothes.getName()) ) {
					index = badmintonDepartement.getClothesList().indexOf(clothes);
					break;
				}
			}
			
			for (Gear gear: badmintonDepartement.getGearList()) {
				if(productName.equalsIgnoreCase(gear.getName()) ) {
					index = badmintonDepartement.getGearList().indexOf(gear);
					break;
				}
			}
			
			for (Shoe shoe: badmintonDepartement.getShoesList()) {
				if(productName.equalsIgnoreCase(shoe.getName()) ) {
					index = badmintonDepartement.getShoesList().indexOf(shoe);
					break;
				}
			}
		}		
		
		return index;
	}
	
	public void adminInsertUpdatedProduct(String productName, String sportCategory, int index, String brand, String supplier, String supplierAddress, int price, int qty) {
		if (sportCategory.equals("basketball")) {
			for (Clothes clothes: basketballDepartement.getClothesList()) {
				if(productName.equalsIgnoreCase(clothes.getName()) ) {
					clothes.setName(productName); clothes.setBrand(brand); clothes.setStock(qty); clothes.setPrice(price);
					clothes.setSupplier(supplier);
					clothes.setSupplierAddress(supplierAddress);
					break;
				}
			}
			
			for (Gear gear: basketballDepartement.getGearList()) {
				if(productName.equalsIgnoreCase(gear.getName()) ) {
					gear.setName(productName); gear.setBrand(brand); gear.setStock(qty); gear.setPrice(price);
					gear.setSupplier(supplier);
					gear.setSupplierAddress(supplierAddress);
					break;
				}
			}
			
			for (Shoe shoe: basketballDepartement.getShoesList()) {
				if(productName.equalsIgnoreCase(shoe.getName()) ) {
					shoe.setName(productName); shoe.setBrand(brand); shoe.setStock(qty); shoe.setPrice(price);
					shoe.setSupplier(supplier);
					shoe.setSupplierAddress(supplierAddress);
					break;
				}
			}
		}else if(sportCategory.equals("football")) {
			for (Clothes clothes: footballDepartement.getClothesList()) {
				if(productName.equalsIgnoreCase(clothes.getName())) {
					clothes.setName(productName); clothes.setBrand(brand); clothes.setStock(qty); clothes.setPrice(price);
					clothes.setSupplier(supplier);
					clothes.setSupplierAddress(supplierAddress);
					break;
				}
			}
			
			for (Gear gear: footballDepartement.getGearList()) {
				if(productName.equalsIgnoreCase(gear.getName())) {
					gear.setName(productName); gear.setBrand(brand); gear.setStock(qty); gear.setPrice(price);
					gear.setSupplier(supplier);
					gear.setSupplierAddress(supplierAddress);
					break;
				}
			}
			
			for (Shoe shoe: footballDepartement.getShoesList()) {
				if(productName.equalsIgnoreCase(shoe.getName()) ) {
					shoe.setName(productName); shoe.setBrand(brand); shoe.setStock(qty); shoe.setPrice(price);
					shoe.setSupplier(supplier);
					shoe.setSupplierAddress(supplierAddress);
					break;
				}
			}
		}else if(sportCategory.equals("badminton")) {
			for (Clothes clothes: badmintonDepartement.getClothesList()) {
				if(productName.equalsIgnoreCase(clothes.getName()) ) {
					clothes.setName(productName); clothes.setBrand(brand); clothes.setStock(qty); clothes.setPrice(price);
					clothes.setSupplier(supplier);
					clothes.setSupplierAddress(supplierAddress);
					break;
				}
			}
			
			for (Gear gear: badmintonDepartement.getGearList()) {
				if(productName.equalsIgnoreCase(gear.getName()) ) {
					gear.setName(productName); gear.setBrand(brand); gear.setStock(qty); gear.setPrice(price);
					gear.setSupplier(supplier);
					gear.setSupplierAddress(supplierAddress);
					break;
				}
			}
			
			for (Shoe shoe: badmintonDepartement.getShoesList()) {
				if(productName.equalsIgnoreCase(shoe.getName()) ) {
					shoe.setName(productName); shoe.setBrand(brand); clothes.setStock(qty); shoe.setPrice(price);
					shoe.setSupplier(supplier);
					shoe.setSupplierAddress(supplierAddress);
					break;
				}
			}
		}		
		System.out.println("Product updated..."); scan.nextLine();
	}
	
	public void adminAllTransaction() {
		int i = 1;
 		
		System.out.print("\nAll transaction\n---------------------\n");
		if (cartRepository.getTransactionList().isEmpty() == true) {
			System.out.println("No transaction recorded..."); scan.nextLine();
		}else {
			for (Transaction transaction : cartRepository.getTransactionList()) {	
					System.out.printf("[%d] %s\n",i,transaction.getUser().getUsername());

				if (!transaction.getClothes().getName().equals("Dummy")) {
					System.out.printf("Product: %s | %s qty: %d\n",transaction.getClothes().getName(),df.format(transaction.getClothes().getPrice()), transaction.getQty());
				}else if(!transaction.getShoe().getName().equals("Dummy")) {
					System.out.printf("Product: %s | %s qty: %d\n",transaction.getShoe().getName(),df.format(transaction.getShoe().getPrice()),transaction.getQty());
				}else if(!transaction.getGear().getName().equals("Dummy")) {
					System.out.printf("Product: %s | %s qty: %d\n",transaction.getGear().getName(),df.format(transaction.getGear().getPrice()),transaction.getQty());
				}else {
					System.out.println("Error");
				}
				
				System.out.println("Delivery service: "+transaction.getDelivery().checkDeliveryType());
				System.out.println("Payment mehtod: "+transaction.getPayment().checkPaymentType());
				System.out.printf("Status: %s\n",transaction.getStatus());
				i++;
			
			
			}
			System.out.println("Press enter to continue...");
			scan.nextLine();
		}
		
	}
		
	public void adminDeleteProduct() {
			
			String name, category, sport = null;
			
			System.out.print("Delete Product\n------------\n");
			
			do {
				System.out.print("Product sport category[basketball | football | badminton]: ");
				sport = scan.nextLine();
			}while(!sport.equalsIgnoreCase("basketball" ) && !sport.equalsIgnoreCase("football") && !sport.equalsIgnoreCase("badminton"));
			
			if (sport.equals("basketball")) {
				basketballDepartement.viewProduct();
			}else if (sport.equals("football")) {
				footballDepartement.viewProduct();
			}else if (sport.equals("badminton")) {
				badmintonDepartement.viewProduct();
			}
			
			System.out.print("Product name[0 to exit]: ");
			name = scan.nextLine();
			
			if(name.equals("0")) {
				System.out.println("Exit..."); scan.nextLine();
			}else {
				System.out.print("Product category[shoe | clothes | gear]: ");
				category = scan.nextLine();
				
				if (sport.equals("basketball")) {
					basketballDepartement.deleteProduct(name, category);
				}else if (sport.equals("football")) {
					footballDepartement.deleteProduct(name, category);
				}else if (sport.equals("badminton")) {
					badmintonDepartement.deleteProduct(name, category);
				}
				System.out.println("Product has been deleted..."); scan.nextLine();
			}
			
		}

}
