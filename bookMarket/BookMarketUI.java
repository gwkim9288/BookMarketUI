package bookMarket;

import java.util.Scanner;

import bookMarketSystem.UserRegister;

public class BookMarketUI {
	
	SystemUserRegister userReg = new UserRegister();
	
	public void initialize() {
		System.out.println("Hello Welcome To My BOOK Market");
		System.out.println("If you want to create new ID: (1) , If you already have a ID and log in : (2)");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if(input == 1)
			registerUser();
		else if(input == 2)
			marketIn();
		
	}
	
	public void registerUser() {
		System.out.println("__________________________________________________________");
		System.out.println("<New Register>");
		System.out.println("ID:");
		Scanner sc = new Scanner(System.in);
		String inputName = sc.nextLine();
		System.out.println("Password:");
		String inputPW = sc.nextLine();
		System.out.println("Phone Number(without '-'):");
		Integer inputPhoneNum = sc.nextInt();
		System.out.println("ID:");
		String inputAddress = sc.nextLine();
		userReg.regUser(inputName, inputPW, inputAddress, inputPhoneNum);
	}
}
