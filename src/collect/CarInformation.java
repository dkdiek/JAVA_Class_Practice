package collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CarInformation {

	List carBrandList;

	public CarInformation() {
		carBrandList = new ArrayList();
	}

	void setHyundai() {
		List carList = new ArrayList();

		Map avante = new HashMap();
		avante.put("name", "아반떼");
		avante.put("segment", "준중형");
		avante.put("price", 16000000);
		carList.add(avante);

		Map sonata = new HashMap();
		sonata.put("name", "소나타");
		sonata.put("segment", "중형");
		sonata.put("price", 20000000);
		carList.add(sonata);

		Map grandeur = new HashMap();
		grandeur.put("name", "그랜저");
		grandeur.put("segment", "대형");
		grandeur.put("price", 30000000);
		carList.add(grandeur);

		Map brand = new HashMap();
		brand.put("hyundai", carList);

		carBrandList.add(brand);

	}

	void setKia() {
		List carList = new ArrayList();

		Map k3 = new HashMap();
		k3.put("name", "k3");
		k3.put("segment", "준중형");
		k3.put("price", 16000000);
		carList.add(k3);

		Map k5 = new HashMap();
		k5.put("name", "k5");
		k5.put("segment", "중형");
		k5.put("price", 20000000);
		carList.add(k5);

		Map k7 = new HashMap();
		k7.put("name", "k7");
		k7.put("segment", "대형");
		k7.put("price", 30000000);
		carList.add(k7);

		Map brand = new HashMap();
		brand.put("kia", carList);

		carBrandList.add(brand);

	}

	void setGM() {
		List carList = new ArrayList();

		Map cruze = new HashMap();
		cruze.put("name", "크루즈");
		cruze.put("segment", "준중형");
		cruze.put("price", 16000000);
		carList.add(cruze);

		Map malibu = new HashMap();
		malibu.put("name", "말리부");
		malibu.put("segment", "중형");
		malibu.put("price", 20000000);
		carList.add(malibu);

		Map impala = new HashMap();
		impala.put("name", "임팔라");
		impala.put("segment", "대형");
		impala.put("price", 30000000);
		carList.add(impala);

		Map brand = new HashMap();
		brand.put("gm", carList);

		carBrandList.add(brand);

	}
	
	List searchCar(String brand) {
		List resultList = null;
		outter : for ( int i = 0 ; i < carBrandList.size() ; i++ ) {
			Map map = (Map)carBrandList.get(i);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
			Set set = map.keySet();
			Iterator ite = set.iterator();
			while ( ite.hasNext() ) {
				String name = (String)ite.next();
				if ( brand.equals(name) ) {
					resultList = (List)map.get(name);
					break outter;
				}
			}
		}
		return resultList;
	}

}
