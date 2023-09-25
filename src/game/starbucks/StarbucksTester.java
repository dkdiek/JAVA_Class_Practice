package game.starbucks;

import java.util.Scanner;

public class StarbucksTester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("아메리카노 한잔 가격을 입력하세요: ");
		int priceOfAme = sc.nextInt();

		System.out.println("아메리카노 수량을 입력하세요: ");
		int qty = sc.nextInt();

		Starbucks sb = new Starbucks(priceOfAme);

		int total = sb.getTotal(qty);
		System.out.println("총 금액은 " + total + "입니다");

	}

}
