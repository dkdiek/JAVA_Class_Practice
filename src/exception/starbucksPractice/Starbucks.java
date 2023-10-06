package exception.starbucksPractice;

public class Starbucks {
	
	private int amount;
	
	public Starbucks( int amount ) {
		this.amount = amount;
	}
	
	public void sell( Guest guest ) throws CoffeeSoldOutException {
				
		--amount;
		System.out.println("잔여 커피 : " + amount);
		
		if(1 > amount) {
			throw new CoffeeSoldOutException("[품절]");
		}
		
	}
	
	

}
