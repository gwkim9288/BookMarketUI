package bookMarketSystem;

import java.util.ArrayList;

import bookMarket.SystemForUser;

public class UserPlace extends Place implements SystemForUser{
	
	Human currentUser;
	BookManager bookManager = new BookManager();
	
	public UserPlace(Human cur) {
		super(cur);
		currentUser = cur;
	}
		
	public boolean enterBook(String name, Integer ISBN, String author, String publisher,Integer state, Integer price, Integer year) {
		Book book = new Book(name,ISBN,author,publisher,state,price,year,currentUser);
		return bookManager.enterBook(book);
	}

	public boolean deleteBook(int bookNum) {
		if(bookManager.matchBook(bookNum) == null)
			return false;
		if(bookManager.matchBook(bookNum).getUser().equals(currentUser))
			return bookManager.deleteBook(bookNum);
		else
			return false;
	}
	
	public String buyBook(int num) {
		Purchase pur = new Purchase(currentUser,num);
		return pur.doPurchase();
	}
	
	// throws NumberFormatException to UI. show error message and repeat search process
		public ArrayList<String> findBook (String term, int decision)  throws NumberFormatException {
			ArrayList<Book> bookSearchList = null;
			switch(decision)
			{
			case 1:
				bookSearchList = bookManager.getBookInfoByName(term);
				break;
			case 2:
				bookSearchList = bookManager.getBookInfoByISBN(Integer.parseInt(term));
				break;
			case 3:
				bookSearchList = bookManager.getBookInfoByAuthor(term);
				break;
			case 4:
				bookSearchList = bookManager.getBookInfoByPublisher(term);
				break;
			case 5:
				bookSearchList = bookManager.getBookInfoByYear(Integer.parseInt(term));
				break;
			case 6:
				bookSearchList = bookManager.getBookInfoByUserName(term);
				break;
			}
			ArrayList<String> searchResult = new ArrayList<>();
			for(Book i : bookSearchList)
				searchResult.add(i.toString());
			return searchResult;
		}
	
	public boolean modifyBook(int bookNum,String name,Integer ISBN, String author,String publisher, Integer state, Integer price , Integer year) {
		Book book = new Book(name,ISBN,author,publisher,state,price,year,currentUser);
		if(bookManager.matchBook(bookNum).getUser() == currentUser) {
			currentUser.modifyBookInfo(bookNum,book);
			return 	bookManager.modifyBookInfo(bookNum, book);
		}
		else
			return false;
	}

	public ArrayList<String> listUserBook(){
		return currentUser.listUserBook();
	}



}
