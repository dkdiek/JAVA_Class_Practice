package game.everLand;

import java.util.List;
import java.util.ArrayList;

public class EverlandTicketGangTest {

	public static void main(String[] args) {

		List ticketList = new ArrayList();
		
		int total = 0;
		
		for ( int i = 1 ; i < 1001 ; i++ ) {
			EverlandTicketGang et = new EverlandTicketGang(i);
						
			total += et.price;
						
			System.out.println("티켓번호: " + et.no + ", 종류: " + et.type + ", 입장료: "
			+ et.price + ", 누적: " + total);
						
			ticketList.add(et);
		}
		
		System.out.println("");
	}

}
