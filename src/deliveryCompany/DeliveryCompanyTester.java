package deliveryCompany;

public class DeliveryCompanyTester {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DeliveryCompany deliverycompany = new DeliveryCompany(); //생성자2
		int price = deliverycompany.showPrice(1);
		System.out.println(price);
		
		DeliveryCompany deliverycompany2 = new DeliveryCompany(1); //생성자1
		int price2 = deliverycompany2.showPrice("더조은컴퓨터학원");
		System.out.println(price2);
		
	}
 }
