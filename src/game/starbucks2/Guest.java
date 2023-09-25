package game.starbucks2;

import java.util.Scanner;

/*
 * Guest(int money)
 */
public class Guest {
	
	int paidMoney;
	
	Guest(){
		Scanner sc = new Scanner(System.in);
		System.out.println("\n지불할 비용을 입력하세요: ");
		paidMoney = sc.nextInt();
	}
	
	int getMoney() {
		return paidMoney;
	}
	

}
