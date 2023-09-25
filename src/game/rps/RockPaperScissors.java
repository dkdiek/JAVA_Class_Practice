package game.rps;

import java.util.Scanner;

import electronics.userTester;

/*
 * 0. 메타 데이터 정리(1가위, 2바위, 3보)
 * 1. 생성자에서 컴퓨터의 랜덤 번호 저장
 * 2. 메소드: 사용자로부터 입력 받음 
 * 3. 메소드: 컴퓨터, 손님 선택 표시
 * 4. 메소드: 승패 체크
 */
public class RockPaperScissors {

	int comNumber;
	int guestNumber;

	public RockPaperScissors() {
		comNumber = (int) (Math.random() * 3) + 1;
	}

	void setGuestNumber() {
		System.out.println("가위 = 1, 바위 = 2, 보 = 3 중 입력하세요 :");
		Scanner sc = new Scanner(System.in);
		guestNumber = sc.nextInt();
		if (guestNumber == 1 || guestNumber == 2 || guestNumber == 3) {
			// 처리 없음
		} else {
			System.out.println("잘못된 숫자 입력입니다.");
			guestNumber = 4;
		}
	}

	void printNumber() {
		String comNumKor = "";
		String guestNumKor = "";

		if (1 == comNumber) {
			comNumKor = "가위";
		} else if (2 == comNumber) {
			comNumKor = "바위";
		} else if (3 == comNumber) {
			comNumKor = "보";
		} else {
			// 처리 없음
		}

		if (1 == guestNumber) {
			guestNumKor = "가위";
		} else if (2 == guestNumber) {
			guestNumKor = "바위";
		} else if (3 == guestNumber) {
			guestNumKor = "보";
		} else {
			// 처리 없음
		}

		System.out.println("컴퓨터 : " + comNumKor);
		System.out.println("손님 : " + guestNumKor);
	}

	// 내가 만든 메소드
	void printResult() {
		String result = "";
		if (guestNumber == 4) {
			result = "프로그램을 종료합니다.";
		} else {

			if (comNumber == guestNumber) {
				System.out.println("비겼습니다");
			} else if (comNumber == 1) {
				if (guestNumber == 2) {
					result = "유저가 승리했습니다.";
				} else if (guestNumber == 3) {
					result = "유저가 패배했습니다.";
				}
			} else if (comNumber == 2) {
				if (guestNumber == 1) {
					result = "유저가 패배했습니다.";
				} else if (guestNumber == 3) {
					result = "유저가 승리했습니다.";
				}
			} else if (comNumber == 3) {
				if (guestNumber == 1) {
					result = "유저가 승리했습니다.";
				} else if (guestNumber == 2) {
					result = "유저가 패배했습니다.";
				}

			}
		}
		System.out.println(result);
	}

	// 강사님 스타일
	void checkWinner() {
		String result2 = "";
		if (comNumber == guestNumber) {
			result2 = "무승부";
		} else {
			if (1 == guestNumber) {
				if (2 == comNumber) {
					result2 = "컴퓨터 승리";
				} else {
					result2 = "유저 승리";
				}
			} else if (2 == guestNumber) {
				if (3 == comNumber) {
					result2 = "컴퓨터 승리";
				} else {
					result2 = "유저 승리";
				}
			} else if (3 == guestNumber) {
				if (1 == comNumber) {
					result2 = "컴퓨터 승리";
				} else {
					result2 = "유저 승리";
				}
			} else {
				// 처리 없음
			}

			System.out.println("결과 " + result2);
		}
	}
}
