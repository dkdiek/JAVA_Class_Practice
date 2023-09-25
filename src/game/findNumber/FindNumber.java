package game.findNumber;

import java.util.Iterator;
import java.util.Scanner;

public class FindNumber {

	int computer; // 컴퓨터 랜덤 숫자
	int user; // 플레이어 입력 숫자
	int trial = 1; // 시도 횟수
	boolean continueTrial = true; // 추가 진행 여부

	Scanner sc = new Scanner(System.in);

	// 생성자 - 컴퓨터 1~100 랜덤 번호 생성 후 computer 변수에 저장
	public FindNumber() {
		computer = (int) (Math.random() * 100) + 1;
	}
	// 메소드1 - 입력 값 받기
	public void valueUser() {
		System.out.println(trial + "번째 시도, 숫자를 입력하세요 :");
		user = sc.nextInt();
	}
	// 메소드2 - 게임 실행
	public void playGame() {
		valueUser();
		while (continueTrial) {
			if (computer > user) {
				++trial;
				System.out.println(user + " 보다 큰 숫자입니다.");
				valueUser();
			} else if (computer < user) {
				++trial;
				System.out.println(user + " 보다 작은 숫자입니다.");
				valueUser();
			} else if (computer == user) {
				System.out.println("컴퓨터 : " + computer + " // 플레이어 : " + user + "\n 정답입니다! 시도 횟수: " + trial);
				continueTrial = false;
			}
		}
	}
}
