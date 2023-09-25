package game.starbucks2.pactice;

import java.util.Scanner;

public class Guest {
	
	Scanner sc = new Scanner(System.in);

	int money;
	
	Guest() {
	 System.out.println("손님이 보유한 금액을 설정하세요: ");
	 money = sc.nextInt();
 
	}

}
