package electronics.houseElectronics;
import electronics.*;

public class Oven extends electronics.houseElectornics {
	
	String name = "oven";
	
	public String turnOn() {
		return name + " 작동합니다";
	}
	
	public String turnOff() {
		return name + " 종료합니다";
	}

}
