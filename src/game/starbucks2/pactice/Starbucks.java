package game.starbucks2.pactice;

import java.util.Scanner;

public class Starbucks {

	Scanner sc = new Scanner(System.in);

	int money;
	int perPrice;
	int qty;
	int total;

	Starbucks() {
		System.out.println("커피 한 잔 가격을 설정하세요: ");
		perPrice = sc.nextInt();
		System.out.println("매장 보유 금액을 설정하세요: ");
		money = sc.nextInt();
	}
	
	void getTotal() {
		System.out.println("손님, 커피 몇 잔 주문하시겠어요?: ");
		qty = sc.nextInt();
		total = qty*perPrice;
	}
	
	void orderCoffee(Guest guest) {
		getTotal();
		System.out.println("손님, 커피" + qty + "잔 금액은 " + total + "입니다.");
		
		money = money + total;
		guest.money = guest.money - total;
		
		System.out.println("스타벅스 매장 보유금은 "+ money);
		System.out.println("손님 보유금은 "+ guest.money);
	}
	
	

}
