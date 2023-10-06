package exception.gsn;

/**
 * 1. 스타벅스에서 일일 총 커피 수량이 제한되어 있다. 2. 200잔을 넘어서면 더 이상 커피를 팔 수 없다. 재고 200잔 보유
 * 201명째 손님이 스타벅스에서 커피를 주문하는 순간 [재고 없음] 이라는 예외가 발생하도록 만들기
 * 
 * class Starbucks, Guest, Test, CoffeeSoldOutException
 */

public class Starbucks {
	
	
	int coffeeStock = 200;
	
	
	public void takeOrder() throws CoffeeSoldOutException {
		
		boolean hasCoffee;
		
		Guest guest = new Guest();

		do {
			System.out.println();
			System.out.println("안녕하세요 커피 몇 잔 주문하시겠어요?");
			System.out.println("주문 가능한 커피 수량은 " + coffeeStock + "잔 입니다.");
			guest.orderCoffee();
			if (coffeeStock >= guest.orderQty) {
				System.out.println("주문이 완료되었습니다.");
				coffeeStock -= guest.orderQty;
				System.out.println("주문 가능한 커피 수량 : " + coffeeStock);
			} else {
				throw new CoffeeSoldOutException("[재고 부족] : 주문한 수량이 재고보다 많습니다");
				//System.out.println("주문 수량이 너무 많습니다");
			}
			if (0 < coffeeStock) {
				hasCoffee = true;
				} else {
				throw new CoffeeSoldOutException("[재고 없음] : 모든 수량을 판매하였습니다");
//				hasCoffee = false;
//				System.out.println("재고 소진으로 금일 판매를 마감합니다.");
//				break;
			}

		} while (hasCoffee);

	}

}
