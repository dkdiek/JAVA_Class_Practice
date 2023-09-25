package game.rps;

import java.util.Scanner;

public class Rcp {

	static void runRcp() {

		String computerEng = null;
		String userEng = null;

		Scanner sc = new Scanner(System.in);

		int computer = (int) (Math.random() * 3) + 1;

		System.out.println("입력하세요 1=가위, 2=바위, 3=보 :");
		int user = sc.nextInt();

		if (computer == 1) {
			computerEng = "가위";
		} else if (computer == 2) {
			computerEng = "바위";
		} else if (computer == 3) {
			computerEng = "보";
		}

		if (user == 1) {
			userEng = "가위";
		} else if (user == 2) {
			userEng = "바위";
		} else if (user == 3) {
			userEng = "보";
		}

		System.out.println("컴퓨터 : " + computerEng + "  VS  유저 : " + userEng);
		if (computer == user) {
			System.out.println("비겼습니다");
		} else if (computer == 1) {
			if (user == 2) {
				System.out.println("이겼습니다");
			} else if (user == 3) {
				System.out.println("졌습니다");
			}
		} else if (computer == 2) {
			if (user == 1) {
				System.out.println("졌습니다");
			} else if (user == 3) {
				System.out.println("이겼습니다");
			}
		} else if (computer == 3) {
			if (user == 1) {
				System.out.println("이겼습니다");
			} else if (user == 2) {
				System.out.println("졌습니다");
			}
		} else {
			System.out.println("잘못된 입력값입니다");
		}
	}

	public static void main(String[] args) {
		runRcp();
	}
}
