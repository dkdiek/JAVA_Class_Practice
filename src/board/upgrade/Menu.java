package board.upgrade;
/*
 * 삭제, 수정 추가
 */
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

				if (0 < db.getListSize()) {
					System.out.println(">게시물 번호를 선택하시오.");
					int bNumber = sc.nextInt();
					db.showContent(bNumber);
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
