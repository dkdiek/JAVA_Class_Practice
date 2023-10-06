package exception.gsn;

public class Test {

	public static void main(String[] args) {
		
		Starbucks starbucks = new Starbucks();
		try {
			starbucks.takeOrder();
		} catch (CoffeeSoldOutException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

}
