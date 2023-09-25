package game.odd;

import java.util.Scanner;

public class OddEven {

	int comNumber;
	int guestNumber;

	public OddEven() {
		comNumber = (int) (Math.random() * 9);
	}

	void setGuestNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("홀/짝을 선택하시오. 1:홀 2:짝");
		guestNumber = sc.nextInt();
	}

	void printNumber() {
		System.out.println("히든 숫자는: " + comNumber);
		if (0 == guestNumber % 2) {
			System.out.println("손님: 짝");
		} else {
			System.out.println("손님: 홀");
		}
	}

	void checkWin() {
		String result = "";
		if (1 == comNumber % 2) {
			if (1 == guestNumber) {
				result = "빙고";
			} else {
				//처리 없음
			}
		}
		if (0 == comNumber % 2) {
			if (2 == guestNumber) {
				result = "빙고";
			} else {
				//처리없음
			}
		if ( "".equals(result)) {
			System.out.println("결과: 다음기회에");
		} else {
			System.out.println("결과:"+result);
		}
		}
	}

}
