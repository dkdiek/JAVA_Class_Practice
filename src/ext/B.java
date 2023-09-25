package ext;

public class B extends C { // 클래스 C를 상속한다

	int b;
	
	public B() { //생성자
		System.out.println("b 생성자");
	}
	public B(int i) { //생성자2
		System.out.println("b-int i 생성자");
	}
	
	public void b() { //메소드
		System.out.println("b()");
	}
	
}
