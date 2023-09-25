/*저는 여행 예약 사이트를 만들고 싶어요
여행지를 선택하고 항공/숙박비를 계산해주세요.
*/
public class Travel {

	
	  int arrivalCode;
	  int airPlanePrice;
	  int hotelPrice;
	  
	  void costOfarrival(int arrivalCode) {
		  this.arrivalCode = arrivalCode;
		  }
	  
	  int travelAmountCalc(int arrivalCode){
		  
		  int totalPrice=0;
		  
		  if(arrivalCode==1) {
			  totalPrice = (hotelPrice + airPlanePrice)*4;
		  } else if(arrivalCode==2) {
			  totalPrice =  (hotelPrice + airPlanePrice)*2;
		  } else if(arrivalCode==3) {
			  totalPrice =  (hotelPrice + airPlanePrice)*3;
		  }
		  return totalPrice;
	 }
	 

	int airlinePrice;
	int hotelPricee;

	int askLAPrice(int laPrice) {
		return laPrice + airlinePrice + hotelPricee;
	}

	int askGBPrice() {
		return airlinePrice + hotelPricee;
	}

}
