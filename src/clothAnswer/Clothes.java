package clothAnswer;

public class Clothes {
	
	static String BRAND = "NIKE";
	
	String type;	
	int size;	
	String color;	
	String style;	
	int price;	
	
	public Clothes(boolean type, int size, String style, int price){
		this.type = (type) ? "상의" : "하의";//3항 연산자
		this.size = size;
		this.style = style;
		this.price = price;
	}
	
	void setColor(String color){
		this.color = color;
	}
	
	String getBrandString() {
		return "[" + style + "made by " + BRAND +"]" ;
	}
	
	String getClothesInfo() {
		return
				getBrandString()
				+ "\n 타입: " + this.type
				+ "\n 색상: " + this.color
				+ "\n 사이즈: " + this.size
				+ "\n 가격: " + this.price;
	}

}
