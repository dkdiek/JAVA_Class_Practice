package game.collect;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * 게시판 만들기
 * 사용자로 부터의 입력 (게시글 번호, 제목, 내용, 작성자, 작성 일시 LocalDateTime.now())
 * 
 * 게시글 리스트 보기(for문)
 * 게시글 작성(작성일시는 현재 시간, 게시글 번호는 자동)
 * 
 * 메뉴
 * 게시글 보기 for문
 * 게시글 작성
 * 
 */

public class Board {

	Scanner sc = new Scanner(System.in);

	List board;

	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String formattedDateTime = now.format(formatter);

	// 생성자--------------------------------------------------
	public Board() {
		board = new ArrayList();
	}

	// 게시글 작성 메소드-----------------------------------------
	void writeBoard() {

		int no = 1;
		String title;
		String content;
		String writer;
		String dateTime = formattedDateTime;
		String quit;

		do {
			Map article = new HashMap();

			System.out.println("게시글 제목을 입력하세요: ");
			title = sc.nextLine();

			System.out.println("게시글 내용을 입력하세요: ");
			content = sc.nextLine();

			System.out.println("게시글 작성자를 입력하세요: ");
			writer = sc.nextLine();

			article.put("번호", no);
			article.put("제목", title);
			article.put("내용", content);
			article.put("작성자", writer);
			article.put("작성일시", dateTime);
			board.add(article);

			System.out.println("게시글 작성을 성공했습니다.");
			System.out.println("게시글 추가 작성 =1, 종료 = 0 입력: ");
			quit = sc.nextLine();

			no++;

		} while (!quit.equals("0"));
		runProgram();
	}

	// 게시글 확인 메소드-----------------------------------------
	public void checkBoard() {
		String quit = null;

		for (int i = 0; i < board.size(); i++) {
			Map article = (Map) board.get(i);

			System.out.println("게시글 번호: " + article.get("번호"));
			System.out.println("게시글 제목: " + article.get("제목"));
			System.out.println("게시글 내용: " + article.get("내용"));
			System.out.println("게시글 작성자: " + article.get("작성자"));
			System.out.println("게시글 작성일시: " + article.get("작성일시"));
			System.out.println("------------------------------------");
		}
		
		System.out.println("게시글 조회가 완료되엇습니다.");
		System.out.println("메뉴 돌아가기 = 0 입력: ");
		quit = sc.next();

		if(quit.equals("0"));{
			runProgram();
		}
	}

	// 실행 메소드-----------------------------------------
	public void runProgram() {
		int userChoice = 0;

		System.out.println("게시글 작성 =1, 게시 목록 조회 =2, 종료=0 입력:");
		userChoice = sc.nextInt();
		sc.nextLine();
		if (userChoice == 1) {
			System.out.println("** 게시글 작성 메뉴 **");
			writeBoard();
		} else if (userChoice == 2) {
			System.out.println("** 게시글 조회 메뉴 **");
			checkBoard();
		} else if (userChoice == 0) {
			System.out.println("프로그램을 종료합니다.");
		}

	}

}
