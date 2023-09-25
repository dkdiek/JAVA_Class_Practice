package game.sumEven;

public class SumEven {
	//방법 1
	int sum; int i;

	void calSum () {

		for( i = 1 ; i <= 100 ; i++ ){
			if ( i % 2 == 0 ) {
				sum = sum + i;
			}
			
		}
		
		System.out.println( "1 부터 " + (i-1) + "까지 짝수의 합은 : " + sum );
	}
	
	//방법 2
	void calSum2 () {
		
		int sum2=0; int i2;
		
		for( i2 = 2 ; i2 <= 100 ; i2 += 2 ){
				sum2 = sum2 + i2;
		}
		
		System.out.println( "1 부터 " + (i-1) + "까지 짝수의 합은 : " + sum );
	}
	
}
