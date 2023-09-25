package game.starbucks2;

import java.util.Scanner;

/*
 * (int perPrice, int money)
 */
public class Starbucks {

	int companyMoney = 1000000000;
	int exchange;
	int perPrice;
	int qty;
	int customerMoney;
	int giveMoney;
	int sales;

	Starbucks() {
		Scanner sc = new Scanner(System.in);
		System.out.println("커피 한잔 가격을 입력하세요: ");
		this.perPrice = sc.nextInt();
		sc.close();
	}

	int calOrderPrice() {
		int qty;
		Scanner sc = new Scanner(System.in);
		System.out.println("손님, 주문 수량을 입력하세요: ");
		qty = sc.nextInt();
		System.out.println("아메리카노" + qty + "잔, 총 금액은 " + qty * perPrice + "입니다.");
		sc.close();
		this.qty = qty;
		this.companyMoney = companyMoney + qty*perPrice; 
		this.sales = qty * perPrice;
		return this.sales;
	}

	int giveMoney(int customerMoney) {
		this.customerMoney = customerMoney;
		int giveMoney = customerMoney - sales;

		if (giveMoney > 0) {
			this.companyMoney = companyMoney + sales;
			System.out.println("\n거스름돈은 " + giveMoney + "입니다.");
			;
		} else if (giveMoney == 0) {
			giveMoney = 0;
			System.out.println("\n거스름돈은 없습니다");
		} else {
			giveMoney = 0;
			this.companyMoney = companyMoney - sales;
			System.out.println("\n결제 비용이 부족합니다");
		}
		return customerMoney;		
	}
	
	void checkSales() {
		System.out.println("현재 보유금은 "+ companyMoney + "입니다");
	}

}
