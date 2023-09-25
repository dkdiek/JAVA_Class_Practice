package ifc;

public class CTest {
	public static void main(String[] args) {

//		A a = new C(); //원래 C타입을 A타입으로 바꾸고 a에 저장한다
//		B b = new C(); //원래 C타입을 B타입으로 바꾸고 b에 저장한다
//		D d = new C(); //원래 C타입을 B타입으로 바꾸고 b에 저장한다
		
//		C c_a = (C)a; //C로 변경한 a를 다시 c타입으로 바꿔 c_a에 저장한다
//		C c_b = (C)b; //C로 변경한 b를 다시 c타입으로 바꿔 c_b에 저장한다
		
		ct1(new C()); //방법1 ct1이 STATIC이라서 () 바로 쓸 수 있음
		
		C c = new C(); //방법2 객체를 생성후 c에 담아야 쓸 수 있다
		ct1(c);
	}
	
	 static void ct1 (B b) { 
		System.out.println("Hello World!");
	}
}
