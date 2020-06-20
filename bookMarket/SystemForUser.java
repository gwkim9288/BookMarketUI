package bookMarket;

import java.util.ArrayList;

import bookMarketSystem.AdminPlace;
import bookMarketSystem.Book;
import bookMarketSystem.Place;
import bookMarketSystem.Purchase;
import bookMarketSystem.UserPlace;

public interface SystemForUser {
	public boolean enterBook(String name,Integer ISBN, String author,String publisher, Integer state, Integer price , Integer year);

	public boolean deleteBook(int bookNum);
	
	public String buyBook(int num);
	
	public ArrayList<String> findBook(String bookName, int option);
	
	public boolean modifyBook(int bookNum,String name,Integer ISBN, String author,String publisher, Integer state, Integer price , Integer year);

	public ArrayList<String> listUserBook();

}
