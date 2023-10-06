package exception.gsn;

import java.util.Scanner;

public class Guest {
	
	int orderQty;
	
	public void orderCoffee() {
		Scanner sc = new Scanner(System.in);
		orderQty = sc.nextInt();
		sc.nextLine();
	}
	

}
