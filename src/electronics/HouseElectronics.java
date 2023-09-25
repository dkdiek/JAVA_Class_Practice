package electronics;

public class HouseElectronics {
	
	String name = "HouseElectronics";
	public void turnOn(HouseElectronics h) {
		System.out.println(h.getName()
				+" 작동합니다");
	}
	public String getName() {
		return this.name;}
	
//	public void turnOn() {
//		System.out.println("Animal Feed");
//	}

}
