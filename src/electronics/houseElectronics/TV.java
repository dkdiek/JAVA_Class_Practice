package electronics.houseElectronics;

public class TV extends electronics.houseElectornics {

	String name = "TV";
	
	public String turnOn() {
		return name + " 작동합니다";
	}
	
	public String turnOff() {
		return name + " 종료합니다";
	}

}
