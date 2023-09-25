package animal;

import animal.ext.*;

public class Zookeeper {
	
	Animal a;//필드의 다향성 상위 타입으로 저장(모든 동물 저장 가능)
	
//	//메소드 - 먹이를 줍니다.
//	void feeda(Animal a) { //매개 변수의 다형성
//		a.soundFeed();
//	}
	//메소드2 - 먹이를 줍니다.
	Animal feed(Animal a) { //Animal을 상속하는 모든 레퍼런스가 들어올 수 있다
		if (a instanceof Tiger) {
			System.out.println("Tiger feed");
		} else if (a instanceof Elephant) {
			System.out.println("Elephant feed");
		}	else if (a instanceof Horse) {
			System.out.println("Horse feed");
		}	else if (a instanceof Rabbit) {
			System.out.println("Rabbit feed");
		}	else {
			a.soundFeed(a);
		}
		return a;
	}
}
