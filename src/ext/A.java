package ext;

public class A extends B { //클래스 B를 상속한다
	//변수의 선언과 초기화 //final 최종값 변경 불가 static 모두가 쓸 수 있도록
	//필드 변수, 글로벌 변수, 살아있는한 존재
	final static int a = 100;
	
	public A() { //생성자
		super(3);
		System.out.println("a 생성자");	
	}
	
	public void a() { //메소드
		b();
		//원래 super로 갔는데 오버라이딩하여 아래 메소드로 이동
		//super.b(); 오버라이딩 전처럼 상위로가기
	}
	
	public void a(int a) { //메소드
		c();
		//원래 super로 갔는데 오버라이딩하여 아래 메소드로 이동
		//super.b(); 오버라이딩 전처럼 상위로가기
	}
	
	
	public void b() { //클래스 B의 B메소드 오버라이딩
		System.out.println("b()오버라이딩");
		super.b();
		this.c();
	}

}
