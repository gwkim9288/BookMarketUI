package bookMarketSystem;

import java.util.ArrayList;

public class BookManager {
	
	// the book list that entered in book market system.
	private static ArrayList<Book> bookList = new ArrayList<>();
	

	//delete the book in the list. true is done.
	boolean deleteBook(int bookNum){
		for(Book i : bookList)
		{
			if(i.getNum() == bookNum) {
				bookList.remove(i);
				i.getUser().deleteBook(bookNum);
				return true;
			}
		}
		return false;
	}

	public boolean enterBook(Book book) {
		book.getUser().addBook(book);
		bookList.add(book);
		return true;
	}
	
	//user make a decision:1, search by name
	public ArrayList<Book> getBookInfoByName(String bookName) {
		ArrayList<Book> result = new ArrayList<>();
		for(Book i : bookList) {
			if(i.getName().equals(bookName))
				result.add(i);
		}
		return result;
	}
	
	//user make a decision:2, search by ISBN
	public ArrayList<Book> getBookInfoByISBN(Integer ISBN) {
		ArrayList<Book> result = new ArrayList<>();
		for(Book i : bookList) {
			if(i.getISBN().equals(ISBN))
				result.add(i);
		}
		return result;
	}
	
	//user make a decision:3, search by author
	public ArrayList<Book> getBookInfoByAuthor(String author) {
		ArrayList<Book> result = new ArrayList<>();
		for(Book i : bookList) {
			if(i.getAuthor().equals(author))
				result.add(i);
		}
		return result;
	}
	
	//user make a decision:4, search by publisher
	public ArrayList<Book> getBookInfoByPublisher(String publisher) {
		ArrayList<Book> result = new ArrayList<>();
		for(Book i : bookList) {
			if(i.getPublisher().equals(publisher))
				result.add(i);
		}
		return result;
	}
	
	//user make a decision:5, search by publishing year
	public ArrayList<Book> getBookInfoByYear(Integer year) {
		ArrayList<Book> result = new ArrayList<>();
		for(Book i : bookList) {
			if(i.getYear().equals(year))
				result.add(i);
		}
		return result;
	}
	
	//user make a decision:6, search by seller's name
	public ArrayList<Book> getBookInfoByUserName(String userName) {
		ArrayList<Book> result = new ArrayList<>();
		for(Book i : bookList) {
			if(i.getUser().getName().equals(userName))
				result.add(i);
		}
		return result;
	}
	
	
	public boolean modifyBookInfo(int bookNum, Book newBook) {
		int num =0 ;
		for(Book i : bookList) {
			if(i.getNum() == bookNum) {
				i.getUser().modifyBookInfo(bookNum, newBook);
				bookList.set(num, newBook);
				return true;
			}
			num++;
		}
		return false;
	}
	
	public Book matchBook(int num) {
		for(Book i : bookList) {
			if(i.getNum() == num)
				return i;
		}
		return null;
	}
}
