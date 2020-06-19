package bookMarket;

import java.util.ArrayList;

import bookMarketSystem.Human;
import bookMarketSystem.User;

public interface SystemUserManager {
	
	int deleteUser(String name);
	
	boolean changeActive(String name);
	
	public ArrayList<String> listUser();
}
