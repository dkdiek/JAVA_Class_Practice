package game.lotto;

import java.util.Scanner;

public class Lotto {
	
	int[] lotto = new int[6];
	int[] guest = new int[6];
	int count;
	
	public Lotto() {
		int number = 0;
		for ( int i = 0 ; i < 6 ; i++ ) {
			number = (int)(Math.random()*45)+1;
			lotto[i] = number;
		}
	}
	
	void setGuestNumber() {
		Scanner scanner = new Scanner(System.in);
		int number = 0;
		for ( int i = 0 ; i < 6 ; i++ ) {
			System.out.println((i+1) +" 번째 숫자를 입력하시오.");
			number = scanner.nextInt();
			guest[i] = number;
		}
	}

	void getBing() {
		int guestNumber = 0;
		int lottoNumber = 0;
		for ( int i = 0 ; i < 6 ; i++ ) {
			guestNumber = guest[i];
			for ( int j = 0 ; j < 6 ; j++ ) {
				lottoNumber = lotto[j];
				if ( guestNumber == lottoNumber ) {
					count++;
					break;
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
