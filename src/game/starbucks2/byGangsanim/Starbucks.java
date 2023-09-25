package game.starbucks2.byGangsanim;

import java.util.Scanner;

public class Starbucks {

	Scanner sc = new Scanner(System.in);

	// 필드
	int priceOfAme;
	int money;

	// 생성자
	Starbucks(int priceOfAme, int money) {
		this.priceOfAme = priceOfAme;
		this.money = money;
	}

	// 메소드
	int getTotal(int qty) {
		return priceOfAme * qty;
	}

	void order(Guest guest) {
		System.out.println("아메리카노 몇 잔 드릴까요?: ");
		int qty = sc.nextInt();

		int total = getTotal(qty);
		System.out.println("손님, 총 금액은 " + total + "입니다");
		
		guest.money = guest.money - total;
		
		money = money + total;

	}
}
