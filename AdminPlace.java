package bookMarketSystem;

import java.util.ArrayList;

import bookMarket.SystemForAdmin;

public class AdminPlace extends Place implements SystemForAdmin{

	Human currentUser;
	BookManager bookManager =  new BookManager();
	ArrayList<Book> bookSearchList = new ArrayList<>();
	
	public AdminPlace(Human admin) {
		super(admin);
		currentUser = admin;
	}
	
	public boolean deleteBook(int bookNum) {
		return bookManager.deleteBook(bookNum);
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
	
	//override method
	public String buyBook(int num) {
		return null;
	}


	@Override
	public ArrayList<String> listUserBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean enterBook(String name, Integer ISBN, String author, String publisher, Integer state, Integer price,
			Integer year) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyBook(int bookNum, String name, Integer ISBN, String author, String publisher, Integer state,
			Integer price, Integer year) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
