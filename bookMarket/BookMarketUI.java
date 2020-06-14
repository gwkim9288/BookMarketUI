package bookMarket;

import java.util.ArrayList;
import java.util.Scanner;

import bookMarketSystem.Market;
import bookMarketSystem.UserRegister;

public class BookMarketUI {
	
	SystemUserRegister userReg = new UserRegister();
	SystemForLogin logIn; 
	SystemForUser userPlace;
	SystemForAdmin adminPlace;
	SystemUserManager userManager;
	
	
	public void initialize() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello Welcome To My BOOK Market");
		System.out.println("If you want to create new ID: (1) , If you already have a ID and log in : (2)");
		int input = sc.nextInt();
		sc.nextLine();
		if(input == 1)
			registerUser();
		else if(input == 2)
			logIn();
		
	}
	
	public void registerUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("__________________________________________________________");
		System.out.println("<New Register>");
		System.out.println("ID:");
		String inputName = sc.nextLine();
		System.out.println("Password:");
		String inputPW = sc.nextLine();
		System.out.println("Phone Number(without '-'):");
		Integer inputPhoneNum = sc.nextInt();
		sc.nextLine();
		System.out.println("ID:");
		String inputAddress = sc.nextLine();
		userReg.regUser(inputName, inputPW, inputAddress, inputPhoneNum);
	}
	
	public void logIn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("__________________________________________________________");
		System.out.println("<LogIn>");
		System.out.println("ID:");
		String inputName = sc.nextLine();
		System.out.println("Password:");
		String inputPassword = sc.nextLine();
		logIn = new Market(inputName,inputPassword);
		if(logIn.isAdmin()) {
			adminPlace = logIn.getPlace();
			marketInUser();
		}
		else
		{
			userPlace = logIn.getPlace();
			userManager = logIn.getManager();
			marketInAdmin();
		}
	}
	
	public void marketInUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("__________________________________________________________");
		System.out.println("1.Search Book , 2.Register Book, 3.List up books you registered");
		System.out.println("Please input what you want to do:");
		int choice = sc.nextInt();
		sc.nextLine();
		if(choice == 1) {
			findBookUser();
		}
		else if(choice == 2) {
			
		}
		else if(choice == 3) {
			
		}
	}
	
	public void marketInAdmin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("__________________________________________________________");
		System.out.println("1.Search Book , 2.UserManage");
		System.out.println("Please input what you want to do:");
		int choice = sc.nextInt();
		sc.nextLine();
		if(choice == 1)
			findBookAdmin();
		else if(choice == 2)
			userManage();
	}
	
	public void findBookUser() {
		Scanner sc = new Scanner(System.in);
		int num =0;
		System.out.println("__________________________________________________________");
		System.out.println("Enter book name(if you return: '!'):");
		String bookName = sc.nextLine();
		if(bookName == "back")
		{
			marketInUser();
		}
		ArrayList<String> result = userPlace.findBook(bookName);
		for(String i : result)
		{
			num++;
			System.out.println(num+")"+i.toString());
		}
		System.out.println("If you want to buy, enter the book number(no purchase:0):");
		int choice = sc.nextInt();
		sc.nextLine();
		if(choice == 0)
			marketInUser();
		//purchase part, write after
	}
	
	public void findBookAdmin() {
		Scanner sc = new Scanner(System.in);
		int num =0;
		System.out.println("__________________________________________________________");
		System.out.println("Enter book name(if you want to return: '!'):");
		String bookName = sc.nextLine();
		if(bookName == "back")
		{
			marketInAdmin();
		}
		ArrayList<String> result = userPlace.findBook(bookName);
		for(String i : result)
		{
			num++;
			System.out.println(num+")"+i.toString());
		}
		System.out.println("If you want to delete, enter the book number(no delete:0):");
		int choice = sc.nextInt();
		sc.nextLine();
		if(choice == 0)
			marketInAdmin();
		//delete part, write after
	}
	
	public void userManage() {
		Scanner sc = new Scanner(System.in);
		System.out.println("__________________________________________________________");
		ArrayList<String> userList= userManager.listUser();
		for(String i :userList)
		{
			System.out.println(i.toString());
		}
		while(true) {
			System.out.println("1.delete , 2.change active");
			System.out.println("Please input what you want to do(if you want to return: '0'):");
			int choice = sc.nextInt();
			if(choice == 0)
				marketInAdmin();
			else if(choice == 1)
				deleteUser();
			else if(choice == 2)
				changeActivation();
			else
				System.out.println("you input wrong number");
		}
	}
	
	public void deleteUser() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("<Delete User>\n");
			System.out.println("Enter the user name(if you want to return: '!'):");
			String input = sc.nextLine();
			if(input == "!")
				break;
			else
			{
				if(userManager.deleteUser(input)) {
					System.out.println("Delete complete.\n");
					userManage(); //after delete user go back to usermanage mode;
					break;
				}
				else
					System.out.println("There is no user match your input.\n");
			}
		}
	}
	
	public void changeActivation() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("<Change User Activation>\n");
			System.out.println("Enter the user name(if you want to return: '!'):");
			String input = sc.nextLine();
			if(input == "!")
				break;
			else
			{
				if(userManager.changeActive(input)) {
					System.out.println("Change complete.\n");
					userManage(); //after delete user go back to usermanage mode;
					break;
				}
				else
					System.out.println("There is no user match your input.\n");
			}
		}
	}
}
///책 살때, 유저쪽 기능 UI 추가하기(등록한 책 리스트업 , 책 삭제, 책 수정하기)