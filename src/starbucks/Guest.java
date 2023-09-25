package starbucks;

public class Guest {
	
	Money money; //has-a 관계 한 객체가 다른 객체를 가진다
	Coffee coffee;
	
	Guest(Money money){ // 생성자
		this.money = money;
	}
	
	void order(Starbucks starbucks) {
		coffee = starbucks.sell(money);
	}

}
