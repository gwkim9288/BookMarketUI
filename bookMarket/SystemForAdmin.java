package bookMarket;

import java.util.ArrayList;

import bookMarketSystem.Book;
import bookMarketSystem.Human;

public interface SystemForAdmin {
	
	public boolean deleteBook(int bookNum);
	
	public ArrayList<String> findBook(String bookName);
}
