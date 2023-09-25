package game.forStar;

public class ForStar3 {

	public void printStar() {

		for (int i = 1; i < 6; i++) {
			for (int j = 5; j > i; j--) { // 위쪽 삼각형
				System.out.print(" ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 4; i > 0; i--) { // 아래쪽 삼각형
			for (int j = 5; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
