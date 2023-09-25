package animal;

public class Animal {
	
	String name = "Animal";
	void soundFeed(Animal a) {
		System.out.println(a.getName()
				+"Animal Feed");
	}
	public String getName() {
		return this.name;}
	
	public void soundFeed() {
		System.out.println("Animal Feed");
	}
	
}
