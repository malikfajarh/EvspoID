package client;

import java.util.Scanner;

import facade.MainFacade;

public class Main {
	Scanner scan = new Scanner(System.in);
	MainFacade mainFacade = new MainFacade();
	
	public Main() {
		mainFacade.initialize();
		menu();
	}
	
	public void menu() {
		Integer input = 0;
		do {
			System.out.println("\nWelcome to EvspoID");
			System.out.println("==================");
			System.out.println("1. Sign Up");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print(">> ");
			input = scan.nextInt();
			scan.nextLine();
			
			if (input == 1) {
				signUp();
			} else if (input == 2) {
				login();
			}else if(input >= 3) {
				break;
			}
			
		}while (input!=3 );
		System.out.println("Goodbye...");		
	}

	public void signUp() {
		String username, password, address;
		boolean result = false;
		
		System.out.println("\nSignUp Page");
		System.out.println("==========");
		
		do {
			System.out.print("Username: ");
			username = scan.nextLine();
			result = mainFacade.checkUsername(username);
			if (result == true) {
				System.out.println("Username not available!");
			}
		}while(result == true);
	
		System.out.print("Password: ");
		password = scan.nextLine();
		
		System.out.print("Address: ");
		address = scan.nextLine();
		
		mainFacade.createUser(username, password, address);
		System.out.println("Account has been created...");
	}
	
	public void login() {
		String username, password;
		boolean result = false, isAdmin = false;
		
		System.out.println("\nLogin Page");
		System.out.println("==========");
			
		System.out.print("Username: ");
		username = scan.nextLine();
		
		System.out.print("Password: ");
		password = scan.nextLine();
		
		result = mainFacade.checkUserAvailable(username, password);
		isAdmin = mainFacade.checkAdmin(username, password);
		if (result == true && isAdmin == false) {
			System.out.print("Login successfull...");
			scan.nextLine();
			home(username);
		}else if (isAdmin == true) {
			System.out.print("Admin login successfull...");
			scan.nextLine();
			adminMenu(username);
		}else {
			System.out.print("Wrong username or password");
			scan.nextLine();
		}
	}
	
	
	
	public void home(String username) {
		Integer input = 0;
		
		do {
			System.out.printf("\nHome Page EvspoID. Hi "+username+"\n");
			System.out.println("===============================");
			System.out.println("1. Basketball");
			System.out.println("2. Football");
			System.out.println("3. Badminton");
			System.out.println("4. Cart");
			System.out.println("5. My transaction");
			System.out.println("6. Sign out");
			System.out.print(">> ");
			input = scan.nextInt();
			scan.nextLine();

			if (input == 1) {
				mainFacade.viewProductBySport("basketball");
			} else if (input == 2) {
				mainFacade.viewProductBySport("football");
			} else if (input == 3) {
				mainFacade.viewProductBySport("badminton");
			}else if(input == 4) {
				mainFacade.viewCart();
			}else if(input == 5) {
				mainFacade.viewTransaction(); ;
			}else if(input == 6) {
				break;
			}
			
		}while (input!=6);
		System.out.print("Signing out...");
		scan.nextLine();
	}
	
	public void adminMenu(String username) {
		Integer input = 0;
		
		do {
			System.out.printf("\nHome Page EvspoID. Hi "+username+"\n");
			System.out.println("===============================");
			System.out.println("1. Insert product");
			System.out.println("2. Update product");
			System.out.println("3. Delete product");
			System.out.println("4. All transaction");
			System.out.println("5. Sign out");
			System.out.print(">> ");
			input = scan.nextInt();
			scan.nextLine();

			if (input == 1) {
				mainFacade.adminInsertProduct();
			} else if (input == 2) {
				mainFacade.adminUpdateProduct();
			} else if (input == 3) {
				mainFacade.adminDeleteProduct();;
			}else if(input == 4) {
				mainFacade.adminAllTransaction();
			}else if(input == 5) {
				break;
			}
			
		}while (input!=6);
		System.out.print("Signing out...");
		scan.nextLine();
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

}
