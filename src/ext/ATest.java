package ext;

public class ATest {

	public static void main(String[] args) {
//		C c = new A(); // A는 조상 클래스인 C로 자동 형변환
//		B b = (B) c; // C를 다시 A로 형변환

		 A a = (A)new B();
		 a.a();
		
	}

}
