package bookMarketSystem;

import java.util.ArrayList;
import java.util.List;

import bookMarket.SystemUserManager;

public class UserManager implements SystemUserManager {
	Human recentUser;
	private static ArrayList<Human> listUser = new ArrayList<>();

	
	static public Human findUser(String name,String password){
		if(listUser.isEmpty())
			listUser.add(new Admin());
		for(Human i: listUser)
		{
			if(i.matchInfo(name, password))
				return i;
		}
		return null;
	}

	static public void regUser(String name, String password, String address, int phoneNum) {
		if(listUser.isEmpty())
			listUser.add(new Admin());

		listUser.add(new User(name,password,address,phoneNum));
	}
	
	public int deleteUser(String name){
			for(Human i : listUser)
			{
				if(i.getName().equals(name))
				{
					if(i.getActivation())
						return 0;
					else {
						listUser.remove(i);
						return 1;
					}
				}
			}
			return 2;
	}
	
	public boolean changeActive(String name) {
		for(Human i : listUser)
		{
			if(i.getName().equals(name))
				return i.changeActive();
		}
		return false;
	}
	
	public ArrayList<String> listUser(){
		ArrayList<String> result = new ArrayList<>();
		for(Human i : listUser) {
			if(i.isAdmin() == false)
				result.add(i.toString());
		}
		return result;
	}
}
