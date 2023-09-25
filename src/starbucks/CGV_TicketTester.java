package starbucks;

public class CGV_TicketTester {

	public static void main(String[] args) {
		

		CGV_Ticket cgv_ticket2 = new CGV_Ticket("000332");//오버로딩1
		
		int info2 = cgv_ticket2.informTicket(11);//메소드1
		System.out.println(info2);
			
		
		CGV_Ticket cgv_ticket = new CGV_Ticket(000332);//오버로딩2

		
		String info1 = cgv_ticket.informTicket("000332");//메소드2
		System.out.println(info1);


	}

}
