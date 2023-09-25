package game.starbucks2;
/*
 * 총액, 손님이 가진 돈, 스벅이 가진 돈 
 */
public class StarbucksTester {

	public static void main(String[] args) {
		

		Starbucks sb = new Starbucks();//한 잔당 가격 설정
		sb.calOrderPrice(); //주문 수량 입력, 결제 비용
		
		Guest guest = new Guest();
		guest.getMoney(); //고객 비용 지불
		
		sb.giveMoney(guest.getMoney()); //거스름돈 안내
		
		sb.checkSales(); //스타벅스 매출 확인
			
		
	}

}
