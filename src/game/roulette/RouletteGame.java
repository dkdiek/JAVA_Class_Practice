package game.roulette;

import java.util.Scanner;

public class RouletteGame {

	int number;
	int number2;
	int number3;
	int coin;
	int startKey;
	Scanner sc = new Scanner(System.in);

	public RouletteGame() {
		System.out.println("게임 코인을 넣으세요 1게임 = 100원:");
		coin = sc.nextInt();
	} 
	
	
	void getFirstNum() {
		number = (int)(Math.random()*6)+1;
	}
	void getSecondNum() {
		number2 = (int)(Math.random()*6)+1;
	}
	void getThirdNum() {
		number3 = (int)(Math.random()*6)+1;
	}
		
	void runGame() {
		
		System.out.println("\n 시작하려면 0을 누르세요:");
		startKey = sc.nextInt();
		
		if(startKey==0) {

			if (coin >= 100) {

				getFirstNum();
				getSecondNum();
				getThirdNum();
				
				System.out.println("\n--------------------------------------------");
				System.out.println("룰렛 게임을 시작합니다. 3개의 번호가 모두 일치하면 성공입니다.\n");
				
				if(number == number2 && number2 == number3) {
					if(number == 1 && number2 == 1 && number3 == 1) {
						System.out.println("숫자:" +number+" 숫자: "+number2+" 숫자: "+number3+"축하합니다 100만원 당첨입니다.");
					}else if(number == 2 && number2 == 2 && number3 == 2) {
						System.out.println("숫자: "+number+" 숫자: "+number2+" 숫자: "+number3+"축하합니다 200만원 당첨입니다.");
					}else if(number == 3 && number3 == 3 && number3 == 3) {
						System.out.println("숫자: "+number+" 숫자: "+number2+" 숫자: "+number3+"축하합니다 300만원 당첨입니다.");
					}else if(number == 4 && number3 == 4 && number3 == 4) {
						System.out.println("숫자: "+number+" 숫자: "+number2+" 숫자: "+number3+"축하합니다 400만원 당첨입니다.");
					}else if(number == 5 && number3 == 5 && number3 == 5) {
						System.out.println("숫자: "+number+" 숫자: "+number2+" 숫자: "+number3+"축하합니다 500만원 당첨입니다.");
					}else if(number == 6 && number3 == 6 && number3 == 6) {
						System.out.println("숫자: "+number+" 숫자: "+number2+" 숫자: "+number3+"축하합니다 600만원 당첨입니다.");
					}else if(number == 7 && number3 == 7 && number3 == 7) {
						System.out.println("숫자: "+number+" 숫자: "+number2+" 숫자: "+number3+"축하합니다 700만원 당첨입니다.");
					}
				}else {
					System.out.println("숫자:"+number+" 숫자: "+number2+" 숫자: "+number3+"\n실패입니다.");
				}
				this.coin = this.coin - 100;
				runGame();
			} else {
				System.out.println("코인이 부족합니다. 게임을 시작할 수 없습니다.");
			}
			
		} else {
			//실행없음
		}
		
		
		
		
		
	}
	
	
}
