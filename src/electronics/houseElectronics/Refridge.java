package electronics.houseElectronics;

public class Refridge extends electronics.houseElectornics {
	
	String name = "Refridge";
	
	public String turnOn() {
		return name + " 작동합니다";
	}
	
	public String turnOff() {
		return name + " 종료합니다";
	}

}
