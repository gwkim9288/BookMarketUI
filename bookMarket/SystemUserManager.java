package bookMarket;

import bookMarketSystem.Human;
import bookMarketSystem.User;

public interface SystemUserManager {
	
	boolean deleteUser(String name);
	
	void changeActive(String name);
}
