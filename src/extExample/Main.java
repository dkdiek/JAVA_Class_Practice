package extExample;

import ext.A;

public class Main extends A {
	
	String hi;
	
    public void a() {
    	hi = super.otherPackageMethod();
    	this.hi=hi;
    }
    
    public static void main(String[] args) {
        Students students = new Students("홍길동", 18, 100, 90, 80);
        students.printMyself(); //부모 메소드 호출 - Students에 People이 상속되서
        students.printScore(); //자식 메소드 호출
    }

}