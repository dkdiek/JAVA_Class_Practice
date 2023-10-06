package exception;

public class Test {

	public static void main(String[] args) {
		Starbucks starbucks = new Starbucks(200);
		
//		for (int i = 1 ; i < 202 ; i++) {
//			try {
//				starbucks.sell(new Guest());
//			} catch (CoffeeSoldOutException e) {
//				e.printStackTrace();
//			}
//			
//		}
//		
		while (true) {
			try {
				starbucks.sell(new Guest());
				System.out.println();
			} catch (CoffeeSoldOutException e) {
//				System.out.println(e.getMessage()); // 메세지만 별도로
				e.printStackTrace();
				break; // 무한 박복문 탈출 예외 만나면
			}
		}
		System.out.println("스타벅스 Closed");

	}

}
