package clothAnswer;

public class Designer {
	public static void main(String[] args) {
		Clothes top = new Clothes(true,105,"Jacket",10000000);
		top.setColor("Black");
		
		Clothes bottom = new Clothes(false,31,"Trouser",7000000);
		bottom.setColor("Red");
		
		System.out.println(top.getClothesInfo());
		System.out.println(bottom.getClothesInfo());
	}
}