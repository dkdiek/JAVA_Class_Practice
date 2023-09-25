package game.numberReplacing;

import java.util.Iterator;

public class NumberReplacing {

	int[] arr = new int[10];
	int[] arrEven = new int[10]; // 다 짝수나올 수 있으니 넉넉하게 10개
	int max;

	public NumberReplacing() {
		int number;
		int indexOfEven = 0;

		for (int i = 0; i < arr.length; i++) {
			number = (int) (Math.random() * 100) + 1;
			arr[i] = number;

			if (0 == number % 2) {
				arrEven[indexOfEven] = number;
				indexOfEven++;
			}

		}
	}

	// 최대 값 구하는 메소드
	public void getMax() {
		int max = 0;
		int next;

		for (int i = 0; i < arr.length; i++) {
			next = arr[i];

			if (max < next) {
				max = next;
			}
		}
		System.out.println(max);

	}

	// 최대 값 구하는 강사님 메소드---------------------------------------------------------
	int maxgsn;

	public void getMaxArrGangsaNim() {
		// 두 개 먼저 뽑고
		int num1 = arr[0];
		int num2 = arr[1];
		maxgsn = getMaxNumGangsaNim(num1, num2);

		for (int i = 2; i < arr.length; i++) {
			maxgsn = getMaxNumGangsaNim(maxgsn, arr[i]);
		}
	}

	int getMaxNumGangsaNim(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}
}
