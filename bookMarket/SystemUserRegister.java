package bookMarket;

import bookMarketSystem.UserManager;

public interface SystemUserRegister {
	public boolean regUser(String name,String password, String address, Integer phoneNum);
}
