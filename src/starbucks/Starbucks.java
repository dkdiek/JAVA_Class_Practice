package starbucks;

public class Starbucks {
	
	//<Singletone 패턴>
	// 상대방이 스타벅스 sb에 접근 못하게 private, 메모리에는 올려야하니까 static
	private static Starbucks sb;
	// 상대방이 new를 못하게 생성자를 private로 막는다
	private Starbucks() {	
	}
	// sb가 비공개지만 메소드를 통해 전달할 수 있다
	public static Starbucks getInstance() {
		if(null == sb) { 
			sb = new Starbucks();
		}
		return sb;//sb도 static이어야 함, 두번째는 있는 값을 전달해
		//같은 주소 값을 공유함
	}
	
	//----------------------------------------------------
	Coffee sell (Money money) {
		return new Coffee();
	}
	public static void main(String[] args) {
		Starbucks sb1 = Starbucks.getInstance();
		Starbucks sb2 = Starbucks.getInstance();
		System.out.println(sb1==sb2);
	
	}
}
