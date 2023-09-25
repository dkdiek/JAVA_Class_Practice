package game.everLand;
/*
 * 티켓 종류에는 성인, 청소년, 미취학이 있습니다.
 * 티켓 사려고 줄 1000명이 서있음
 * (성인)
 * 청소년, 미취학을 제외하고 모두 성인입니다.
 * 입장료는 5만원입니다.
 * 
 * (청소년)
 * 4의 배수마다 서있음
 * 입장료는 3만5천원입니다.
 * 
 * (영유아)
 * 7의 배수마다 서있음
 * 입장료는 1만8천원입니다.
 * 
 * 종류가 교차되는 경우에는 무료입장 이벤트로 합니다.
 * 
 * 에버랜드 매출액을 구하시오.
 * 티켓번호: 1, 성인, ㅇ
 *  
 */
public class EverLandTicket {
	
	int ticketPrice;
	
	//고객 타입 구분 - 티켓 번호가 들어오면 고객 타입을 스트링으로 리턴
	public String ticketInfo(int ticketNo) {
		if(ticketNo % 28 == 0) { // 이벤트
			return "이벤트";			
		} else if(ticketNo % 4 == 0 ) { // 청소년
			return "청소년";
		} else if(ticketNo % 7 == 0) { // 영유아
			return "미취학 아동";
		} else {
			return "성인";
		}
	}
	
	//티켓 요금 결정 - 고객 타입 스트링이 들어오면 티켓 비용을 인트로 리턴
	public int calTicket(String ticketInfo) {
		
		if(ticketInfo == "성인") {
			ticketPrice = 50000;
		} else if(ticketInfo == "청소년") {
			ticketPrice = 35000;
		} else if(ticketInfo == "미취학 아동") {
			ticketPrice = 18000; 
		} else if(ticketInfo == "이벤트") {
			ticketPrice = 0;
		}
		return ticketPrice;
	}

}
