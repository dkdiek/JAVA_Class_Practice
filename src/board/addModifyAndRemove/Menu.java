package board.addModifyAndRemove;

/*
 * 삭제, 수정 추가
 */
import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);

	void display() {

		DataBase db = new DataBase();
		while (true) {

			System.out.println();
			System.out.println("** 메인 메뉴 **");
			System.out.println("1. 게시글 보기");
			System.out.println("2. 게시글 작성");
			System.out.println("0. 프로그램 종료");
			System.out.println("> 메뉴 번호를 입력하시오.");
			int choice = sc.nextInt();

			// 1. 게시글 보기---------------------------------------------------
			if (1 == choice) {
				int showMenuChoice = 0;

				do {
					db.showList();

					if (0 < db.getListSize()) {

						System.out.println();
						System.out.println("** 게시글 보기 메뉴 **");
						System.out.println("1. 게시글 상세 보기");
						System.out.println("2. 게시글 수정");
						System.out.println("3. 게시글 삭제");
						System.out.println("0. 메인 메뉴 돌아가기");
						System.out.println("> 메뉴 번호를 입력하시오.");

						showMenuChoice = sc.nextInt();

						if (0 == showMenuChoice) {
							break; // 메인 메뉴로 돌아갑니다.
						}

						if (1 == showMenuChoice) {
							System.out.println();
							System.out.println("> 상세 보기할 게시물 번호를 입력하시오.");
							int bNumber = sc.nextInt();
							db.showContent(bNumber);

							System.out.println();
							System.out.println("** 상세 게시글 작성 메뉴 **");
							System.out.println("1. 게시글 수정");
							System.out.println("2. 게시글 삭제");
							System.out.println("0. 메인 메뉴 돌아가기");
							System.out.println("> 메뉴 번호를 입력하시오.");

							int showContentNumber;

							while (true) {
								showContentNumber = sc.nextInt();

								if (0 == showContentNumber) {
									break; // 상세 보기 메뉴에서 뒤로 가기
								}

								if (1 == showContentNumber) {
									db.modifyBoard(bNumber);

									showMenuChoice = 1;
									break;

								} else if (2 == showContentNumber) {
									db.deleteBoard(bNumber);

									showMenuChoice = 1;
									break;
								}
							}
							break;

						} else if (2 == showMenuChoice) {
							System.out.println();
							System.out.println("> 수정할 게시물 번호를 입력하시오.");
							int modifyNumber = sc.nextInt();
							db.modifyBoard(modifyNumber);
						} else if (3 == showMenuChoice) {
							System.out.println();
							System.out.println("> 삭제할 게시물 번호를 입력하시오.");
							int deleteNumber = sc.nextInt();
							db.deleteBoard(deleteNumber);

						}
					}
				} while (0 != showMenuChoice);

			}

			// 2. 게시글 작성---------------------------------------------------
			if (2 == choice) {
				int writeMenuChoice = 0;

				do {
					db.writeBoard();
					System.out.println();
					System.out.println("** 게시글 작성 메뉴 **");
					System.out.println("1. 게시글 추가 작성");
					System.out.println("0. 메인 메뉴 돌아가기");
					System.out.println("> 메뉴 번호를 입력하시오.");

					writeMenuChoice = sc.nextInt();
				} while (0 != writeMenuChoice);

			}

			// 0. 프로그램 종료---------------------------------------------------
			if (0 == choice) {
				System.out.println("---프로그램을 종료합니다.");
				break;
			}

		}

	}

}
