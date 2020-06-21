package bookMarketTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bookMarketSystem.Admin;
import bookMarketSystem.Human;
import bookMarketSystem.User;
import bookMarketSystem.UserManager;
import junit.framework.TestCase;

class UserManagerTest extends TestCase{
	Human admin = new Admin();
	UserManager manager = new UserManager(admin);
	
	
	@Test
	void testFindUser() {
		//set
		Human user = new User("success","success","success",11111);
		UserManager.regUser("success","success","success",11111);
		
		//test
		assertSame(user.getName(),UserManager.findUser("success", "success").getName());
		assertNull(UserManager.findUser("fail", "success"));
		assertNull(UserManager.findUser("success", "fail"));

	}


	@Test
	void testDeleteUser() {
		UserManager.regUser("success","success", "success", 11111);
		
		//test, state: activation = active
		assertEquals(0,manager.deleteUser("success")); //fail, user is active
		assertEquals(2,manager.deleteUser("fail")); //fail user name is unmatched
		
		manager.changeActive("success");
		//test, state: activation = inactive
		assertEquals(1,manager.deleteUser("success")); //success, user is inactive
		assertEquals(2,manager.deleteUser("fail")); //fail user name is unmatched
		
	}

	@Test
	void testChangeActive() {
		UserManager.regUser("success","success", "success", 11111);
		
		//test
		assertTrue(manager.changeActive("success"));
		assertFalse(manager.changeActive("fail"));
		
		//change previous state
		manager.changeActive("success");
	}

}
