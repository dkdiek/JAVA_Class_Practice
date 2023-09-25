
public class CalculatorTester {

	void test() {
	}
	
	
	public static void main(String[] args) {
		Calculator cal2 = new Calculator();
		cal2.add(1,2);
		Calculator cal3 = new Calculator();
		cal3.add(2,3);
		Calculator cal4 = new Calculator();
		cal3.add(2,3,4);
		
		System.out.println(cal2.getSum());//브레이크 포인트 용
		System.out.println(cal3.getSum());
		System.out.println(cal4.getSum());
		//SUM 값이 PRIVATE로 바로 불러올 수 없어서 getsum으로 가져오기
		
		
	}


}
