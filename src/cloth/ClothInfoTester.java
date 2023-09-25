package cloth;

public class ClothInfoTester {

	public static void main(String[] args) {

		//생성자1-----------------------------------------		
		ClothInfo clothinfo = new ClothInfo("top");
		clothinfo.size = clothinfo.getInfo("top");
		
		System.out.println("브랜드명은: "+ClothInfo.BRAND_NAME);
		System.out.println("상하의: "+clothinfo.topOrBottom);
		System.out.println("사이즈는: "+clothinfo.size);		
		System.out.println("가격은: "+clothinfo.price);
		System.out.println("스타일은: "+clothinfo.style);
		
		System.out.println("---------------------------");
		
		//생성자2-----------------------------------------		
		ClothInfo clothinfo2 = new ClothInfo(50000, "bottom");
		clothinfo2.size = clothinfo.getInfo("bottom");
		
		System.out.println("브랜드명은: "+ClothInfo.BRAND_NAME);
		System.out.println("상하의: "+clothinfo2.topOrBottom);
		System.out.println("사이즈는: "+clothinfo2.size);		
		System.out.println("가격은: "+clothinfo2.price);
		System.out.println("스타일은: "+clothinfo2.style);

	}

}
