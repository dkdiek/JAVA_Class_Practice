
public class Calculator {

	private static int SUM;
	
	int price;
	String brand;
	
	Calculator(){ //생성자
		
	}
	
	Calculator(int price){//생성자 오버로딩
		this("일산");
		this.price = price; // 들어온 값을 글로벌 변수에 넣고싶은데 철자가 같아서
	}
	
	Calculator(String brand){//생성자 오버로딩
		this.brand = brand; // 들어온 값을 글로벌 변수에 넣고싶은데 철자가 같아서
	}
	
	int getSum() {
		return SUM;
	}
	
	int add(int a, int b) {
		SUM = a+b;
		return SUM;
	}
	
	int add(int a, int b, int c) { //동일한 이름 메소드 추가
		SUM = a+b+c;
		return SUM;		
	}
	
	int del(int a, int b) {
		SUM = a-b;
		return SUM;
	}
}
