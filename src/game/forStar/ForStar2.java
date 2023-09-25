package game.forStar;

public class ForStar2 {

	public void printStar() {
		
		int i = 0;
		int j = 0;
		
		for( i=5; i >= 1; i-- ) { // 5바퀴
			
			for( j=1; j <= i; j++) {
			System.out.print("*");	
			}
			
		System.out.println();
		}
		
	}

}
