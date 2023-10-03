package board2;

import java.util.Scanner;

public class Menu {

	private Board board;
	Scanner sc = new Scanner(System.in);
	
	// 생성자
	public Menu() {
		board = new Board();
	}

	// 메인 메뉴 보여주기
	public void showMainMenu() {

		System.out.println();
		System.out.println("** 메인 메뉴 **");
		System.out.println("1. 게시글 보기");
		System.out.println("2. 게시글 작성");
		System.out.println("3. 관리자 모드");
		System.out.println("0. 프로그램 종료");
		System.out.printf("> 실행 번호를 입력하시오 : ");

	}
	
	// 메인 메뉴 선택 입력 받기
	public void selectMenu() {

		int mainMenuInput;

		mainMenuInput = sc.nextInt();
		sc.nextLine();
		System.out.println();

		if (1 == mainMenuInput) {
			board.showBoardList();
		} else if (2 == mainMenuInput) {
			board.writeBoard();
		} else if (3 == mainMenuInput) {
			board.adminMode();
		} else if (0 == mainMenuInput) {
			System.out.println("--- 프로그램을 종료합니다.");
			System.exit(0);
		} else {
			System.out.println("Note : 잘못된 실행 번호입니다.");
		}
	}
}
