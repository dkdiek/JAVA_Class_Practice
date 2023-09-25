package game.lottoGame;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 1~45중 6개 배열에 저장
 * 고객으로부터 숫자 6개를 입력받는다
 * 고객 숫자가 랜덤 숫자 몇개나 일치하는지 검사
*/
public class Lotto {

	Scanner sc = new Scanner(System.in);
	int lotto[] = new int[6];
	int guest[] = new int[6];
	int count;

	public Lotto() {
		int number = 0;
		for (int i = 0; i < lotto.length; i++) {

			number = (int) (Math.random() * 45) + 1;

			for (int j = 0; j < i; j++) {
				if (lotto[j] == number) {
					continue;
				} else {
					lotto[i] = number;

				}
			}

		}
	}

	public void setGuestNumber() {
		int number = 0;

		for (int i = 0; i < guest.length; i++) {
			System.out.println(i + 1 + "번째 숫자를 입력하세요: ");
			number = sc.nextInt();
			
			for(int j = 0 ; j < i ; j++) {
				if (guest[j] == number) {
					System.out.println(i + 1 + "번째 숫자를 입력하세요 중복 불가: ");
					number = sc.nextInt();
				} else {
					guest[j] = number;
				}
			}
		}
					
	}

	public void getBingo() {
		int guestNumber;
		int lottoNumber;

		for (int i = 0; i < guest.length; i++) {
			guestNumber = guest[i];
			for (int j = 0; j < lotto.length; j++) {
				lottoNumber = lotto[j];

				if (guestNumber == lottoNumber) {
					count++;
					break;
				}
			}

		}
	}

}
