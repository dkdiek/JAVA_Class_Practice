package exception;

/**
 * 1. 스타벅스에서 일일 총 커피 수량이 제한되어 있다. 2. 200잔을 넘어서면 더 이상 커피를 팔 수 없다. 재고 200잔 보유
 * 201명째 손님이 스타벅스에서 커피를 주문하는 순간 [재고 없음] 이라는 예외가 발생하도록 만들기
 * 
 * class Starbucks, Guest, Test, CoffeeSoldOutException
 */

public class Starbucks {
	private int amount;

	public Starbucks(int amount) {
		this.amount = amount;

	}

	void sell(Guest guest) throws CoffeeSoldOutException {
		--this.amount;
		System.out.println("남은 수량 :" + this.amount);
		if (1 > this.amount) {
			throw new CoffeeSoldOutException("[재고 없음]");
		}
	}

}
