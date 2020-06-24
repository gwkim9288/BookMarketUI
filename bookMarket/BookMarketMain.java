package bookMarket;

public class BookMarketMain {
	public static void main(String[] args) {
		try {
			System.out.println("Hello Welcome To My BOOK Market\n");
			BookMarketUI start = new BookMarketUI();
			start.initialize();
		}catch(Exception e) {
			
		}
	}
}
