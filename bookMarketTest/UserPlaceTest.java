package bookMarketTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import bookMarketSystem.Book;
import bookMarketSystem.BookManager;
import bookMarketSystem.Human;
import bookMarketSystem.User;
import bookMarketSystem.UserPlace;
import junit.framework.TestCase;

class UserPlaceTest extends TestCase {

	Human user = new User("ex","ex","ex",1);
	UserPlace p = new UserPlace(user);
	//use wrapper class because of if can be null 
	Integer ISBN = 97199999;
	Integer price = 20000;
	Integer year = 2020;
	Book book = new Book("name",ISBN,"author","publisher",1,price ,year,user);
	BookManager tester = new BookManager();
			
	
	@Test
	void testFindBook() {
		//set
		User user = new User("test","test","test",2222);
		Book book = new Book("tester",1,"tester","tester",1,1,1,user);
		assertFalse(p.deleteBook(1));
		tester.enterBook(book);
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add(book.toString());
			//enter sample to book list to test
		
		
		//test
		assertEquals(arrayList,p.findBook("tester",1));
		assertTrue(p.findBook("test",1).isEmpty());	
		
		assertEquals(arrayList,p.findBook(Integer.toString(1),2));
		assertTrue(p.findBook(Integer.toString(1111),2).isEmpty());
		
		assertEquals(arrayList,p.findBook("tester",3));
		assertTrue(p.findBook("test",3).isEmpty());
		
		assertEquals(arrayList,p.findBook("tester",4));
		assertTrue(p.findBook("test",4).isEmpty());
		
		assertEquals(arrayList,p.findBook(Integer.toString(1),5));
		assertTrue(p.findBook(Integer.toString(1111),5).isEmpty());
		
		assertEquals(arrayList,p.findBook(user.getName(),6));
		assertTrue(p.findBook("ssss",6).isEmpty());
	}

	@Test
	void testListUserBook() {
		tester.enterBook(book);
		ArrayList<String> array = new ArrayList<>();
		array.add(book.toString());
		assertEquals(array,p.listUserBook());
	}


	@Test
	void testDeleteBook() {
		//set
		tester.enterBook(book);
		//test
		assertFalse(p.deleteBook(111));
		assertTrue(p.deleteBook(book.getNum()));
	}

	@Test
	void testBuyBook() {
		//set
		tester.enterBook(book);
		Human seller = new User("sell","sell","sell",11111);
		Book book2 = new Book("name",ISBN,"author","publisher",1111,price ,year,seller);
		tester.enterBook(book2);
		
		//test
		
		 //seller can't be equal with buyer.
		assertEquals("You can't buy your book yourself.\n",p.buyBook(book.getNum()));
		//incorrect book number 
		assertEquals("There is not correct book\n",p.buyBook(1111));
		//purchase success
		assertEquals(String.format("Success. Send e-mail to '%s'\n",seller.getAddress()),p.buyBook(book2.getNum()));
		
	}

	@Test
	void testModifyBook() {
		//set
		Human stranger = new User("x","x","x",11);
		Book book2 = new Book("name",ISBN,"author","publisher",1111,price ,year,stranger);
		tester.enterBook(book);
		tester.enterBook(book2);
		
		//test
		//User can't modify other's book info
		assertTrue(p.modifyBook(book.getNum(), "name2", 1111, "author2", "publisher2", 1111, price, year));
		assertFalse(p.modifyBook(book2.getNum(),"name2",2222,"author2","publisher2",2222,2222,2222));
	}

}
