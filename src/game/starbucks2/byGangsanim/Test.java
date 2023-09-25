package game.starbucks2.byGangsanim;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("아메리카노 한 잔당 가격을 입력하세요: ");
		int priceOfAme = sc.nextInt();

		Starbucks sb = new Starbucks(priceOfAme, 0);
		Guest guest = new Guest(100000000);		
		
		sb.order(guest);
		
		System.out.println("스타벅스 매출: " +sb.money +"원");
		System.out.println("손님 지갑: " +guest.money +"원");
	
	}
	
}
