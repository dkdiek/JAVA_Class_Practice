package starbucks;

/*
 * cgv 티켓 정보 프로그램을 만드려고 합니다.
 * 티켓에는 극장명, 티켓번호, 영화제목, 상영일시, 상영관이 있습니다.
 * 조건) 생성자/메소드 오버로딩을 하시오.
 * 극장명은 static으로 하시오.
 */

public class CGV_Ticket {

	static String theater;
	
	String ticketNumberSTR; int ticketNumber;
	String movieName;
	int movieTime; int moviePlace;
	//-------------------- 생성자 ------------------------//
	CGV_Ticket(String ticketNumberSTR) { // 오버로딩1
		this(74);
		this.ticketNumberSTR = ticketNumberSTR;
	}
	CGV_Ticket(int ticketNumber){ // 오버로딩2
		this.ticketNumber = ticketNumber;
	}
	//-------------------- 메소드 ------------------------//
	public int informTicket(int ticketNumber) { // 메소드1
		this.informTicket("0003332222222");
		return ticketNumber;
	}
	public String informTicket(String ticketNumberSTR) { // 메소드2
		this.ticketNumberSTR=ticketNumberSTR;
		return ticketNumberSTR;
	}
	
	
}
