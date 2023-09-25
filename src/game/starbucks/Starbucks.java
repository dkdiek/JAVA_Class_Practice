package game.starbucks;

public class Starbucks {
	// 필드
	int priceOfAme;

	// 생성자
	Starbucks(int priceOfAme) {
		this.priceOfAme = priceOfAme;

	}

	// 메소드
	int getTotal(int qty) {
		return +priceOfAme * qty;
	}
}
