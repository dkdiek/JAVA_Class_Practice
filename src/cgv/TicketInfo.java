package cgv;

public class TicketInfo {
	
	static String CINEMA_NAME = "CGV 일산"; //극장명
	int ticketNo; //티켓번호
	String movieTitle; //영화제목
	String movieDate; //상영일시
	int movieRoom; //상영관
	
	//-------------------생성자--------------------//
	public TicketInfo(String movieTitle){ //생성자
		this(1); // 영화제목이 들어오면 아래 들어가 1관이 되도록 설정
		this.movieTitle = movieTitle;
	}
	public TicketInfo(int movieRoom){ //생성자 오버로딩
		this.movieRoom = movieRoom;
	}
	//-------------------메소드--------------------//
	int getTicketNo() { //메소드
		return ++ticketNo;
	}
	int getTicketNo(int ticketNo) { //메소드 오버로딩
		return ++ticketNo;
	}
	

}
