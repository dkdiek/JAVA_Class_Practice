package airplane;

public class SingleToneTester {

	public static void main(String[] args) {
		SingleTone st = SingleTone.getInstance();
		SingleTone st2 = SingleTone.getInstance();
		
		st.flyAirplane();
		System.out.println(st.airplaneModel);
		
		st2.flyAirplane();
		System.out.println(st2.airplaneModel);
		System.out.println(st.airplaneModel);
		
		String airplaneModel = SingleTone.getInstance().airplaneModel;
		System.out.println(airplaneModel);
		airplaneModel = "st";
		System.out.println(airplaneModel);
		
		
		
	}

}
