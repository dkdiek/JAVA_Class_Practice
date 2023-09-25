package game.everLand;

import java.util.List;
import java.util.ArrayList;

public class EverlandTicketGangTest2 {

	public static void main(String[] args) {

		List ticketList = new ArrayList();

		int total = 0;
		EverlandTicketGang2 et = null;

		for (int i = 1; i < 1001; i++) {
			et = makeET(i);
			total += et.price;

			System.out.println("티켓번호: " + et.no + ", 종류: " + et.type + ", 입장료: " + et.price + ", 누적: " + total);

			ticketList.add(et);
		}

		System.out.println();
	}

	public static EverlandTicketGang2 makeET(int i) {
		if ( (0 == i % 4) && (0 == i % 7) ) {
			return new EverlandTicketGang2(i, "빅이벤트", 0);
		}
		if (0 == i % 4) {
			return new EverlandTicketGang2(i, "청소년", 35000);
		}
		if (0 == i % 7) {
			return new EverlandTicketGang2(i, "미취학", 18000);
		}
		return new EverlandTicketGang2(i, "성인", 50000);
	}
}