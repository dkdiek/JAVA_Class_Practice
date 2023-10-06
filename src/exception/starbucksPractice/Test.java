package exception.starbucksPractice;

public class Test {
public static void main(String[] args) {
	
	Starbucks starbucks = new Starbucks(200);
	
	System.out.println("스타벅스에 오신걸 환영합니다.");

	while (true) {
		try {
			starbucks.sell( new Guest() );
		} catch (CoffeeSoldOutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			break;
		}
		
		
	}
}
	
	
}
