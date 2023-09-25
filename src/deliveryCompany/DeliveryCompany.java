package deliveryCompany;

public class DeliveryCompany {

	String deliveryManName;
	String senderAddress;
	String customerAddress;
	int deliveryCode;
	int deliveryPrice;
	
	DeliveryCompany(){ //생성자1
		this(0);
	}
	DeliveryCompany(int deliveryCode){ //생성자2
		this.deliveryCode = deliveryCode;			
	}
	int showPrice(int delvieryCode) { //메소드1
		if(deliveryCode == 1) {
			deliveryPrice = 4000;
		} else {
			deliveryPrice = 0;
		}
		return deliveryPrice;
	}
	int showPrice(String customerAddress) { //메소드2
		return 0;
	}	
}
