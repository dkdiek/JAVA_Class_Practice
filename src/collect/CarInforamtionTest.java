package collect;

import java.util.List;
import java.util.Map;

public class CarInforamtionTest {

	public static void main(String[] args) {
		CarInformation ci = new CarInformation();
		ci.setGM();
		ci.setHyundai();
		ci.setKia();

		List list = ci.searchCar("gm");

		for (int i = 0; i < list.size(); i++) {
			Map map = (Map) list.get(i);
			System.out.println("모델명:" + map.get("name"));
			System.out.println("세그먼트:" + map.get("segment"));
			System.out.println("가격:" + map.get("price"));
			System.out.println("---------------------------");
			
			
		}
	}
}
