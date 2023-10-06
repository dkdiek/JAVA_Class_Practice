package boardPractice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Database {

	Scanner sc = new Scanner(System.in);

	List<Board> boardList = new ArrayList();
	Board board;

	// 게시글 작성 메소드
	public void writeBoard() {
		Board board = new Board();

		board.setBoardNo(boardList.size() + 1);
		System.out.println();
		System.out.println("> 제목을 입력하시오 :");
		String title = sc.nextLine();
		board.setTitle(title);

		System.out.println("> 내용을 입력하시오 :");
		String content = sc.nextLine();
		board.setContent(content);

		System.out.println("> 작성자를 입력하시오 :");
		String writer = sc.nextLine();
		board.setWriter(writer);

		board.setTime(getTime());

		boardList.add(board);
		
		System.out.println();
		System.out.println("** 게시글 작성 메뉴 **");
		System.out.println("** 1. 게시글 상세 보기 **");
		System.out.println("** 0. 메인 메뉴 돌아가기 **");
		System.out.println("> 실행 번호를 입력하시오 :");

//		readBoardInput = sc.nextInt();
//		sc.nextLine();
//
//		if (1 == readBoardInput) {
//			System.out.println();
//			System.out.println("> 상세 보기할 게시물 번호를 입력하시오 :");
//			int detailBoardNo = sc.nextInt();
//			sc.nextLine();
//			readDetailedBoard(detailBoardNo);
//		} else if (0 == readBoardInput) {
//			// 탈출
//		}

	}

	// 게시글 읽기 메소드
	public void readBoard() {

		int readBoardInput;
		int deletedBoard = 0;
		
		System.out.println();
		for (int i = 0; i < boardList.size(); i++) {

			Board readBoard = boardList.get(i);

			if (true == readBoard.isDeleted()) {
				deletedBoard++;
			} else {
				System.out
						.println("번호 : " + readBoard.getBoardNo()
						+ " 제목 : " + readBoard.getTitle()
						+ " 작성자 : " + readBoard.getWriter());
			}

		}
		System.out.println();
		System.out.println("** 게시글 보기 메뉴 **");
		System.out.println("** 1. 게시글 상세 보기 **");
		System.out.println("** 0. 메인 메뉴 돌아가기 **");
		System.out.println("> 실행 번호를 입력하시오 :");

		readBoardInput = sc.nextInt();
		sc.nextLine();

		if (1 == readBoardInput) {
			System.out.println();
			System.out.println("> 상세 보기할 게시물 번호를 입력하시오 :");
			int detailBoardNo = sc.nextInt();
			sc.nextLine();
			readDetailedBoard(detailBoardNo);
		} else if (0 == readBoardInput) {
			// 탈출
		}

	}

	// 게시글 상세 읽기 메소드
	public void readDetailedBoard(int boardNo) {

		int readDetailedBoardInput;
		
		System.out.println();
		for (int i = 0; i < boardList.size(); i++) {

			Board readBoard = boardList.get(i);

			if (boardNo == readBoard.getBoardNo()) {

				System.out.println("번호 : " + readBoard.getBoardNo());
				System.out.println("제목 : " + readBoard.getTitle());
				System.out.println("내용 : " + readBoard.getContent());
				System.out.println("작성자 : " + readBoard.getWriter());
				System.out.println("시간 : " + readBoard.getTitle());
			}

		}
		System.out.println();
		System.out.println("** 게시글 상세 보기 메뉴 **");
		System.out.println("** 1. 게시글 수정 **");
		System.out.println("** 2. 게시글 삭제 **");
		System.out.println("** 0. 메인 메뉴 돌아가기 **");
		System.out.println("> 실행 번호를 입력하시오 :");

		readDetailedBoardInput = sc.nextInt();
		sc.nextLine();

		if (1 == readDetailedBoardInput) {
			modifyBoard(boardNo);
		} else if (2 == readDetailedBoardInput) {
			deleteBoard(boardNo);
		} else if (0 == readDetailedBoardInput) {
			// 탈출
		}

	}

	// 게시글 수정 메소드
	public void modifyBoard(int boardNo) {

		Board modifyBoard = boardList.get(boardNo - 1);

		System.out.println("> 수정 제목을 입력하시오 :");
		String title = sc.nextLine();
		modifyBoard.setTitle(title);

		System.out.println("> 수정 내용을 입력하시오 :");
		String content = sc.nextLine();
		modifyBoard.setContent(content);

		System.out.println("> 수정 작성자를 입력하시오 :");
		String writer = sc.nextLine();
		modifyBoard.setWriter(writer);

		modifyBoard.setModified(true);

	}

	// 게시글 삭제 메소드
	public void deleteBoard(int boardNo) {

		Board deleteBoard = boardList.get(boardNo - 1);
		System.out.println();
		System.out.println(boardNo + "번 게시물을 삭제하였습니다");
		deleteBoard.setDeleted(true);

	}

	// 현재 타임 겟 메서드
	public static String getTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		String DateTime = dateFormat.format(new Date());
		return DateTime;
	}

}
