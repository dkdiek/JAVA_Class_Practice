package game.findNumber;

import java.util.Scanner;

public class BingTester {

	public static void main(String[] args) {
		Bingo bingo = new Bingo();
		
		Scanner sc = new Scanner(System.in);
		int guestNumber = 0;
		while( true ) {
			System.out.println("1~100의 숫자 중 하나를 입력하시오.");
			guestNumber = sc.nextInt();
			
			if(bingo.number == guestNumber) {
				System.out.println("빙고");
				break;
			}
			bingo.getHint(guestNumber);
		}
	
	}
}
