package airplane;

public class SingleTone {

	private static SingleTone SINGLETONE = new SingleTone();
	private String airplaneModel = "3000";
	
	private SingleTone() {
		
	}
	public static SingleTone getInstance() {
		return SINGLETONE;
	}
	
	public String flyAirplane() {
		return airplaneModel;
	}
}
