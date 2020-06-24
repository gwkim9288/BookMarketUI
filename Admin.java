package bookMarketSystem;

import java.util.ArrayList;

public class Admin extends Human {

	Admin() {
		super("admin", "sssss");
	}

	@Override
	boolean changeActive() {
		return false;
	}

	@Override
	boolean getActivation() {
		return true;
	}

	@Override
	ArrayList<String> listUserBook() {
		return null;
	}


	@Override
	void addBook(Book book) {
		
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyBookInfo(int bookNum, Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteBook(int bookNum) {
		// TODO Auto-generated method stub
		return false;
	}

}
