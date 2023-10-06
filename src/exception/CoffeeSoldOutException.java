package exception;

public class CoffeeSoldOutException extends Exception {

	public CoffeeSoldOutException(String msg) {
		super(msg); // throwable 부모 클래스에 msg를 전달
	}

}
