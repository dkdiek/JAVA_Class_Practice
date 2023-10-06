package boardPractice;

import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Database db = new Database();
	
	int mainMenuInput;
	
	public void showMainMenu() {
	
		while( true ) {
			System.out.println();
			System.out.println("** 메인 메뉴 **");
			System.out.println("1. 게시물 쓰기");
			System.out.println("2. 게시물 보기");
			System.out.println("0. 프로그램 종료");
			System.out.println("> 실행 번호를 입력하시오 :");
			
			mainMenuInput = sc.nextInt();
			sc.nextLine();
			
			if ( 1 == mainMenuInput ) {
				db.writeBoard();
			} else if ( 2 == mainMenuInput ) {
				db.readBoard();
			} else if ( 0 == mainMenuInput ) {
				System.out.println("-- 프로그램을 종료합니다");
				break;
			}
			
		}
	}

}
