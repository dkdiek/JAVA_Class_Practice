package game.everLand;

public class EverlandTicketGang {

	int no;
	String type;
	int price;

	public EverlandTicketGang(int no) {
		this.no = no;


		if (no % 28 == 0) { // 이벤트
			type = "이벤트";
			price = 0;
		} else if (no % 4 == 0) { // 청소년
			type = "청소년";
			price = 35000;
		} else if (no % 7 == 0) { // 영유아
			type = "미취학 아동";
			price = 18000;
		} else {
			type =  "성인";
			price = 50000;
		}

	}

}
