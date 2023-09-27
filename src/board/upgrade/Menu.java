package board.upgrade;

import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);

	void display() {

		DataBase db = new DataBase();
		while (true) {

			System.out.println("1. 게시글 보기");
			System.out.println("2. 게시글 작성");
			System.out.println("3. 프로그램 종료");
			System.out.println(">메뉴를 선택하시오.");
			int choice = sc.nextInt();

			if (1 == choice) {
				db.showList();
				System.out.println("1. 게시글 상세 보기");				
				System.out.println("2. 메뉴 돌아가기");
				System.out.println(">메뉴를 선택하시오.");
				int detailView = sc.nextInt();
				
				if(1 == detailView) {
					System.out.println(">조회할 게시글 번호를 입력하시오.");
					int articleNo = sc.nextInt();
					db.showList(articleNo - 1);
				}else if(2 == detailView) {
					continue;
				}
			}
			if (2 == choice) {
				db.writeBoard();
			}
			if (3 == choice) {
				break;
			}

		}
		System.out.println("프로그램을 종료합니다.");

	}

}
