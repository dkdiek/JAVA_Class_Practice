
public class Restaurant {

	
	String mainDish;//메모리에 mainDish를 잡는다
	int price; //메모리에 price를 잡는다
	
	//메인 메뉴, 가격 입력 받기
	//생성자 this
	Restaurant(String mainDish, int price){
		this.mainDish = mainDish; // 들어온 값에 넣으면 의미가 없어서 같은 데이터에 또 들어가는 것을 방지하고 위에 mainDish에 값을 넣기위해 this를 붙여준다.
		this.price = price; // 같은 철자가 아니면 this 안붙여도 됨
	}
	
	//메인 메뉴 뭔지 답변
	String askMainDish() {
		return this.mainDish;
	}
	
	// 총 금액 계산 전달
	int askPrice(int amount){
		return price * amount;
	}
}
