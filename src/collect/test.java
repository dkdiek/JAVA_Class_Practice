package collect;

import java.util.List;

public class test {

	public static void main(String[] args) {
		HangzhouAsianGame hag = new HangzhouAsianGame();
		hag.setESports();
		hag.setCycle();
		System.out.println();
		List list = hag.searchEvent("eSports");
		System.out.println();
	}

}
