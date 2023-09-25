package game.everLand;

import java.awt.List;
import java.util.ArrayList;

public class EverLandTest {

	public static void main(String[] args) {
		
		//for문용 변수
		int i;
		//에버랜드 매출 총합 변수
		int everLandSales=0;
				
		for ( i = 1 ; i < 1001 ; i++ ) {
			
			EverLandTicket el = new EverLandTicket();
			ArrayList<EverLandTicket> ticketList = new ArrayList<EverLandTicket>();

			String customerType = el.ticketInfo(i);
			int ticketPrice = el.calTicket(customerType);
			
			everLandSales += ticketPrice;

			System.out.println( "티켓번호: " + i + "// 고객타입: " + customerType
					+ "// 티켓금액: " + ticketPrice + "원" + "// 누적:" + everLandSales );
						
				
			ticketList.add( el );
			
		}
		System.out.println( "\n에버랜드 매출은 " + everLandSales + "원입니다." );
	}

}
