package bookMarket;

import bookMarketSystem.AdminPlace;
import bookMarketSystem.Place;
import bookMarketSystem.UserManager;
import bookMarketSystem.UserPlace;

public interface SystemForLogin {
	public Place getPlace() ;
	public boolean isAdmin();
	public UserManager getManager();
}
