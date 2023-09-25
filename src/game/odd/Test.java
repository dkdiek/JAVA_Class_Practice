package game.odd;

public class Test {

	public static void main(String[] args) {

		System.out.println("홀짝 게임에 오신걸 환영합니다!");
		
		OddEven oe = new OddEven();
		oe.setGuestNumber();
		oe.printNumber();
		oe.checkWin();
	}

}
