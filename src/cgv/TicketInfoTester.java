package cgv;

public class TicketInfoTester {

	public static void main(String[] args) {
		TicketInfo ti = new TicketInfo("아바타");

		// int ticketNo; // 로컬 변수
		
		//ti.ticketNo = (ticketNo = ti.getTicketNo(7));
		
		//System.out.println(ticketNo); //로컬 변수 값 확인
		//System.out.println(ti.ticketNo); // 생성 객체 변수 값 확인
		
		//추천 방법 - 로컬에 저장X
		ti.ticketNo = ti.getTicketNo(7);
		
		ti.movieDate = "2023년9월13일 12시 50분";
		
		System.out.println("극장명은: "+TicketInfo.CINEMA_NAME);
		System.out.println("티켓번호는: "+ti.ticketNo);
		System.out.println("영화제목: "+ti.movieTitle);
		System.out.println("상영일시: "+ti.movieDate);
		System.out.println("상영관: "+ti.movieRoom);
//		
	}
}
