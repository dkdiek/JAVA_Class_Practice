package board3;

import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Database db;
	
	public Menu() {
		db = new Database();
	}
	
	public void showMenu() {
		
		boolean retry = false;
		int mainMenuInput;
		
		do {
			System.out.println();
			System.out.println("** 메인 메뉴 **");
			System.out.println("1. 게시판 쓰기");
			System.out.println("2. 게시판 보기");
			System.out.println("3. 게시판 상세 보기");
			System.out.println("4. 게시판 수정");
			System.out.println("5. 게시판 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.printf("> 메뉴 번호를 입력하세요 :");
			mainMenuInput = sc.nextInt();
			sc.nextLine();
			
			if(1 == mainMenuInput) {
				db.writeContent();
				retry = true;
			} else if(2 == mainMenuInput) {
				db.showBoard();
				retry = true;
			} else if(3 == mainMenuInput) {
				//게시판 상세보기
				retry = true;
			} else if(4 == mainMenuInput) {
				//게시판 수정
				retry = true;
			} else if(5 == mainMenuInput) {
				//게시판 삭제
				retry = true;
			} else if(0 == mainMenuInput) {
				System.out.println("프로그램을 종료합니다");
				retry = false;
			}
			
		}while(retry);
		
			
		
		
	}
	

}
