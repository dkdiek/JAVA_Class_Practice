package cloth;
/**
 * 디자이너가 되어 옷을 만든다
 * 옷의 정보 상/하의 구분, 사이즈, 색상, 스타일
 * 조건)
 * 상/하의 옷 한 벌로 만들어서 출력하시오
 */
public class ClothInfo {
	
	static String BRAND_NAME = "nike";
	
	String topOrBottom;
	String size;
	String color;
	String style ="Casual";//하드코딩
	int price;
	 //생성자1----------------------------------
	ClothInfo(String topOrBottom){
		this(40000, topOrBottom);
		this.topOrBottom = topOrBottom;
	}
	//생성자2----------------------------------	
	ClothInfo(int price, String topOrBottom){
		this.price = price;
		this.topOrBottom = topOrBottom;
	}
	//메소드1----------------------------------	
	String getInfo(String topOrBottom) {
		if("top".equals(topOrBottom)) {
			size="95,100,105";
		} else if("bottom".equals(topOrBottom) ) {
			size="30,32,34";
		} else {
			size="잘못된 정보입력입니다";
		} 	
		return size;
	}
}
