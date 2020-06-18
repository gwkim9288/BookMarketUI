package bookMarket;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
		int input;
		System.out.println("Hello Welcome To My BOOK Market\n");
		
		while(true) {
			try {
				System.out.println("___________________________________________________________________________________________________________");
				System.out.println("1. create new ID , 2. LogIn.");
				System.out.print("Please input what you want to do:");
				input = sc.nextInt();
				sc.nextLine();
				if(input == 1)
					registerUser();
				else if(input == 2)
					logIn();
				else
					System.out.println("Please input correct number\n");
			}
			catch(InputMismatchException e) {
				System.out.println("Please input only integer\n");
				sc = new Scanner(System.in);
			}
		}
		
	}
	
	public void registerUser() {
		Scanner sc = new Scanner(System.in);
		Integer inputPhoneNum;
		String inputName;
		System.out.println("___________________________________________________________________________________________________________");
		System.out.println("<New Register>");
		System.out.print("ID:");
		while(true) {
			inputName = sc.nextLine();
			if(inputName == null)
				System.out.println("please input your ID");
			else
				break;
		}
		System.out.print("Password:");
		String inputPW = sc.nextLine();
		while(true) {
			try {
				System.out.print("Phone Number(without '-'):");
				inputPhoneNum = sc.nextInt();
				sc.nextLine();
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("Please input only integer(without'-')\n");
				sc = new Scanner(System.in);
			}
		}
		System.out.print("Address:");
		String inputAddress = sc.nextLine();
		userReg.regUser(inputName, inputPW, inputAddress, inputPhoneNum);
	}
	
	public void logIn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("___________________________________________________________________________________________________________");
		System.out.println("<LogIn>");
		System.out.print("ID:");
		String inputName = sc.nextLine();
		System.out.print("Password:");
		String inputPassword = sc.nextLine();
		logIn = new Market(inputName,inputPassword);
		if(logIn.isRegistered()==false) {
			System.out.println("You are not registered or You input incorrect info.\n");
			logIn();
		}
		if(logIn.isAdmin()) {
			adminPlace = logIn.getPlace();
			userManager = logIn.getManager();
			marketInAdmin();
		}
		else
		{
			userPlace = logIn.getPlace();
			marketInUser();
		}
	}
	
	public void marketInUser() {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("___________________________________________________________________________________________________________");
		while(true) {
			try {
				System.out.println("1.Search Book , 2.Register Book, 3.List up books you registered");
				System.out.print("Please input what you want to do:");
				choice = sc.nextInt();
				sc.nextLine();
				if(choice == 1) {
					findBookUser();
				}
				else if(choice == 2) {
					enterBook();
				}
				else if(choice == 3) {
					listUserBook();
				}
				else
					System.out.println("Please input valid number.\n");
			}
			catch(InputMismatchException e) {
				System.out.println("Please input only integer");
				sc = new Scanner(System.in);
			}
		}
		
	}
	
	// admin login
	public void marketInAdmin() {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("___________________________________________________________________________________________________________");
		while(true) {
			try {
				System.out.println("1.Search Book , 2.UserManage");
				System.out.print("Please input what you want to do:");
				choice = sc.nextInt();
				sc.nextLine();
				if(choice == 1)
					findBookAdmin();
				else if(choice == 2)
					userManage();
				else
					System.out.println("Please input correct number\n");
				}
			catch(InputMismatchException e) {
				System.out.println("Please input only integer\n");
				sc = new Scanner(System.in);
			}
		}
	}
	
	public void findBookUser() {
		Scanner sc = new Scanner(System.in);
		int num =0;
		ArrayList<String> result = new ArrayList<>();
		System.out.println("___________________________________________________________________________________________________________");
		while(true) {
			System.out.print("Enter book name(if you want to return: '!'):");
			String bookName = sc.nextLine();
			if(bookName.equals("!"))
			{
				marketInUser();
			}
			result = userPlace.findBook(bookName);
			if(result.isEmpty())
				System.out.println("There is no matched Book\n");
			else
				break;
		}
		System.out.println("[Search Result]");
		for(String i : result)
		{
			num++;
			System.out.println(num+")"+i.toString());
		}
		while(true) {
			try {
				System.out.print("\nIf you want to buy, enter the book number(no purchase:0):");
				int inputNum = sc.nextInt();
				sc.nextLine();
				if(inputNum == 0)
					marketInUser();
				else
					buyBook(inputNum);
			} catch(InputMismatchException e) {
				System.out.println("Please input integer\n");
				sc = new Scanner(System.in);
			}
		}
		
	}
	
	//admin select [1.find book] in marketInAdmin	
	public void findBookAdmin() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> result = new ArrayList<>();
		int num =0;
		System.out.println("___________________________________________________________________________________________________________");
		while(true) {
			System.out.print("Enter book name(if you want to return: '!'):");
			String bookName = sc.nextLine();
			if(bookName.equals("!"))
			{
				marketInAdmin();
			}
			result = adminPlace.findBook(bookName);
			if(result.isEmpty())
				System.out.println("There is no matched Book\n");
			else
				break;
		}
		
		System.out.println("[Search List]");
		for(String i : result)
		{
			num++;
			System.out.println(num+")"+i.toString());
		}
		
		while(true) {
			try {
				System.out.print("If you want to delete, enter the book number(no delete:0):");
				int inputNum = sc.nextInt();
				sc.nextLine();
				if(inputNum == 0)
					marketInAdmin();
				else
					deleteBookAdmin(inputNum);
			} catch(InputMismatchException e) {
			System.out.println("Please input integer\n");
			sc = new Scanner(System.in);
			}
		}
	}
	
	
	public void userManage() {
		Scanner sc = new Scanner(System.in);
		System.out.println("___________________________________________________________________________________________________________");
		ArrayList<String> userList= userManager.listUser();
		// no registered user, return to previous state
		if(userList.isEmpty()) {
			System.out.println("There is no registered user\n");
			marketInAdmin();
		}
		// list user
		System.out.println("[User List]");
		for(String i :userList)
		{
			System.out.println(i.toString());
		}
		
		while(true) {
			try {
				System.out.println("1.delete , 2.change active");
				System.out.print("Please input what you want to do(if you want to return: '0'):");
				int choice = sc.nextInt();
				sc.nextLine();
				if(choice == 0)
					marketInAdmin();
				else if(choice == 1)
					deleteUser();
				else if(choice == 2)
					changeActivation();
				else
					System.out.println("Please input correct number\n");
			} catch(InputMismatchException e) {
				System.out.println("Please input integer\n");
				sc = new Scanner(System.in);
			}
		}
	}
	
	public void deleteUser() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("<Delete User>\n");
			System.out.print("Enter the user name(if you want to return: '!'):");
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
	
	//in usermanage mode, select 2.change active
	public void changeActivation() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("<Change User Activation>\n");
			System.out.print("Enter the user name(if you want to return: '!'):");
			String input = sc.nextLine();
			if(input == "!")
				break;
			else
			{
				if(userManager.changeActive(input)) {
					System.out.println("Change complete.\n");
					userManage(); //after deleting user go back to usermanage mode;
					break;
				}
				else
					System.out.println("There is no user match your input.\n");
			}
		}
	}
	///책 살때, 유저쪽 기능 UI 추가하기(등록한 책 리스트업 , 책 삭제, 책 수정하기)

	
	public void listUserBook() {
		Scanner sc = new Scanner(System.in);
		int num =0;
		ArrayList<String> result = userPlace.listUserBook();
		System.out.println("___________________________________________________________________________________________________________");
		if(result == null) {
			System.out.println("There is no book you entered\n");
			marketInUser();
		}
		System.out.println("[Your Book]");
		for(String i: result) {
			num++;
			System.out.println(num+")"+i.toString());
		}	
		while(true) {
			try {
				System.out.print("1.delete book , 2.modify book info(if you want to return: '!'):");
				int choice = sc.nextInt();
				sc.nextLine();
				if(choice == 0)
					marketInUser();
				else if(choice == 1)
					deleteBookUser();
				else if(choice == 2)
					modifyBook();
				else
					System.out.println("Please input correct number\n");
			} catch(InputMismatchException e) {
				System.out.println("Please input integer\n");
				sc = new Scanner(System.in);
			}
		}
	}
	
	public void enterBook() {
		Scanner sc = new Scanner(System.in);
		int num =0;
		String temp;
		String inputName = null;
		Integer inputISBN = null;
		Integer inputYear = null;
		Integer inputPrice = null;
		
		System.out.println("___________________________________________________________________________________________________________");
		System.out.println("<Sell Your Book>");
		while(true) {
			System.out.print("Name:");
			inputName = sc.nextLine();
			if(inputName != null)
				break;
			else
				System.out.println("Please input your book name\n");
		}
		
		while (true) {
			try {
				System.out.print("ISBN(without '-'):");
				temp = sc.nextLine();
				inputISBN = Integer.parseInt(temp);
				break;
			}catch(NumberFormatException e) {
				System.out.println("Please input only integer");
				sc = new Scanner(System.in);
			}
		}
		
		System.out.print("Author:");
		String inputAuthor = sc.nextLine();
		
		System.out.print("Publisher:");
		String inputPub= sc.nextLine();
		
		while (true) {
			try {
				System.out.print("Publishing Year:");
				temp = sc.nextLine();
				inputYear = Integer.parseInt(temp);
				break;
			}catch(NumberFormatException e) {
				System.out.println("Please input only integer");
				sc = new Scanner(System.in);
			}
		}
		
		while (true) {
			try {
				System.out.print("Price:");
				temp = sc.nextLine();
				inputPrice = Integer.parseInt(temp);
				break;
			}catch(NumberFormatException e) {
				System.out.println("Please input only integer\n");
				sc = new Scanner(System.in);
			}
			
		}
		
		System.out.print("State:");
		String inputState= sc.nextLine();
		
		userPlace.enterBook(inputName,inputISBN,inputAuthor,inputPub,inputState,inputYear,inputPrice);
		System.out.println("Success!!\n");
		System.out.println("___________________________________________________________________________________________________________");
	}
	
	
	//after list up user's book list, choose to delete registered book
	public void deleteBookUser() {
		Scanner sc = new Scanner(System.in);
		int inputNum;
		System.out.println("<Delete Book>");
		while(true) {
			try {
				System.out.print("Please input book's number(if you want to return 0):");
				inputNum = sc.nextInt();
				sc.nextLine();
				if(inputNum == 0)
					listUserBook();
				if(userPlace.deleteBook(inputNum)) {
					System.out.println("Success.\n");
					listUserBook();
				}
				else
					System.out.println("You can't delete other's book. Please input valid number.\n");
			}catch(InputMismatchException e) {
				System.out.println("Please input integer only.\n");
				sc = new Scanner(System.in);
			}
		}
	}
	
	public void modifyBook() {
		Scanner sc = new Scanner(System.in);
		int inputNum;
		String temp;
		String inputName = null;
		Integer inputISBN = null;
		Integer inputYear = null;
		Integer inputPrice = null;
		System.out.println("<Modify Book>");
		while(true) {
			try {
				System.out.print("Please input book's number(if you want to return 0):");
				inputNum = sc.nextInt();
				sc.nextLine();
				if(inputNum == 0)
					listUserBook();
				break;
			}catch(InputMismatchException e) {
				System.out.println("Please input integer only.\n");
				sc = new Scanner(System.in);
			}
		}
		
		System.out.println("Please enter your Book's information.\n");
		while(true) {
			System.out.print("Name:");
			inputName = sc.nextLine();
			if(inputName != null)
				break;
			else
				System.out.println("Please input your book name\n");
		}
		
		while (true) {
			try {
				System.out.print("ISBN(without '-'):");
				temp = sc.nextLine();
				inputISBN = Integer.parseInt(temp);
				break;
			}catch(NumberFormatException e) {
				System.out.println("Please input only integer");
				sc = new Scanner(System.in);
			}
		}
		
		System.out.print("Author:");
		String inputAuthor = sc.nextLine();
		
		System.out.print("Publisher:");
		String inputPub= sc.nextLine();
		
		while (true) {
			try {
				System.out.print("Publishing Year:");
				temp = sc.nextLine();
				inputYear = Integer.parseInt(temp);
				break;
			}catch(NumberFormatException e) {
				System.out.println("Please input only integer");
				sc = new Scanner(System.in);
			}
		}
		
		while (true) {
			try {
				System.out.print("Price:");
				temp = sc.nextLine();
				inputPrice = Integer.parseInt(temp);
				break;
			}catch(NumberFormatException e) {
				System.out.println("Please input only integer\n");
				sc = new Scanner(System.in);
			}
			
		}
		
		System.out.print("State:");
		String inputState= sc.nextLine();
		
		if(userPlace.modifyBook(inputNum, inputName, inputISBN, inputAuthor, inputPub, inputState, inputPrice, inputYear))
			System.out.println("Success.");
		else
			System.out.println("Fail. You can't modify other's book.");
		listUserBook();
	}
	
	
	public void buyBook(int bookNum) {
		System.out.println(userPlace.buyBook(bookNum));
		marketInUser();
	}
	
	
	public void deleteBookAdmin(int bookNum) {
		adminPlace.deleteBook(bookNum);
		System.out.println("Success.");
		marketInAdmin();
	}
}



