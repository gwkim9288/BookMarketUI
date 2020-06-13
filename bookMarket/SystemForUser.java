package bookMarket;

import java.util.ArrayList;

import bookMarketSystem.AdminPlace;
import bookMarketSystem.Book;
import bookMarketSystem.Place;
import bookMarketSystem.Purchase;
import bookMarketSystem.UserPlace;

public interface SystemForUser {
	public boolean enterBook();

	public boolean deleteBook();
	
	public Purchase buyBook(int num);
	
	public ArrayList<String> findBook(String bookName);
	
	public boolean modifyBook(Book book,String name, String author, String state, Integer price , Integer year);
}
