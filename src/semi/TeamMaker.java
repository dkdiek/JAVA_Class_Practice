package semi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeamMaker {

	public static void main(String[] args) {

		List<HashSet> teamList = new ArrayList<HashSet>();

		Set<Integer> seletcedNumberSet = new HashSet<Integer>();

		boolean newSetFlag = true; // 초기에는 항상 새로운 Set을 생성
		HashSet<Integer> teamSet = new HashSet<>(); // 초기화

		while (true) {

			int number = (int) (Math.random() * 17) + 1;

			if (seletcedNumberSet.contains(number)) {
				continue;
			}
			if (newSetFlag) {

				teamSet = new HashSet<Integer>();
				newSetFlag = false;
			}

			if (3 > teamSet.size()) {
				teamSet.add(number);
			}

			if (5 > teamList.size()) {
				if (3 == teamSet.size()) {

					teamList.add(teamSet);
					newSetFlag = true;
				}
			} else {
				if (2 == teamSet.size()) {

					teamList.add(teamSet);
					newSetFlag = true;
				}
			}

			seletcedNumberSet.add(number);

			if (17 == seletcedNumberSet.size()) {
				break;
			}

		}
		System.out.println(teamList);
	}

}
