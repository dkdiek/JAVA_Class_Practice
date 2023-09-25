package game.oddEven;

import java.util.Scanner;

public class OddEvenGame {
	
	Scanner sc = new Scanner(System.in);
	
	int computer;
	int guestValue;
	int computerValue;
	
	// 컴퓨터 숫자 생성 & 홀/짝 구분
	OddEvenGame(){ 
		computer = (int) (Math.random()*9) ;
		if(computer % 2 == 0 || computer == 0) {
			computerValue = 2;
		}else {
			computerValue = 1;
		}
	}
	
	// 손님 홀짝 선택
	void guest() {
		System.out.println("홀수 짝수를 선택하세요 1 = 홀수, 2 = 짝수");
		guestValue = sc.nextInt();
		if(guestValue == 1) {
			System.out.println("홀수를 선택하셨습니다.");
		}else if (guestValue == 3){
			System.out.println("작수를 선택하셨습니다.");
		}
	}
	
	// 컴퓨터 홀짝 문자로 리턴
	String checkOddEven(){ 
		String checkOddEven;

		if(computerValue == 2) {
			checkOddEven = "짝수"; 
		}else {
			checkOddEven = "홀수"; 
		}
		return checkOddEven;			
	}
	
	// 실행 및 결과 확인
	void getResult() { 
		guest();
		System.out.println("히든 숫자는 " + checkOddEven() +", "+ computer + "입니다.");
		if(guestValue == computerValue) {
			System.out.println("정답입니다");
		}else {
			System.out.println("오답입니다");
		}
	}
	
	
	


}
