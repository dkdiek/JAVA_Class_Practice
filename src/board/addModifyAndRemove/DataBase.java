package board.addModifyAndRemove;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {

	Scanner sc = new Scanner(System.in);
	private List<Board> list = new ArrayList();

	// 생성자
	public DataBase() {
		list = new ArrayList<>();
	}

	// 게시글 보기
	void showList() {
		System.out.println();
		boolean hasActivePosts = false; // 활성 상태인 게시글이 있는지 여부를 나타내는 플래그

		for (int i = 0; i < list.size(); i++) {
			Board board = list.get(i);

			// board가 null이 아니고, 활성 상태인 게시글인 경우에만 출력
			if (board != null && !board.getNoShow()) {
				System.out.println("----------------------------");
				System.out.println(
						board.getNo() + " | " + board.getTitle() + " | " + board.getWriter() + " | " + board.getDate());
				hasActivePosts = true; // 활성 상태인 게시글이 있다고 플래그 설정
			}
		}

		if (!hasActivePosts) {
			System.out.println("Note : 등록된 활성화된 게시물이 없습니다.");
		}
	}

	// 게시글 상세보기
	public void showContent(int bNumber) {

		for (int i = 0; i < list.size(); i++) {
			Board board = (Board) list.get(i);

			if (!board.getNoShow()) {

				if (board.getNo() == bNumber) {
					System.out.println();
					System.out.println("----------------------------");
					System.out.println("번호 : " + board.getNo());
					System.out.println("제목 : " + board.getTitle());
					System.out.println("내용 : " + board.getContent());
					System.out.println("작성자 : " + board.getWriter());
					System.out.println("작성일시 : " + board.getDate());
					System.out.println("----------------------------");
					break;
				}
			} else if ( board.getNoShow() ) {
				System.out.println("Note : 존재하지 않는 게시물입니다.");
			}
		}
	}

	// 게시글 작성
	void writeBoard() {

		Board board = new Board();
		board.setNoShow(false);

		System.out.println();
		System.out.println("> 제목을 입력하시오.");
		board.setTitle(sc.nextLine());

		System.out.println("> 내용을 입력하시오.");
		board.setContent(sc.nextLine());

		System.out.println("> 작성자를 입력하시오.");
		board.setWriter(sc.nextLine());

		board.setNo(list.size() + 1);
		board.setDate(getDate());

		list.add(board);

		System.out.println("게시글이 등록되었습니다.");

	}

	// 게시글 수정
	void modifyBoard(int boardNo) {

		for (Board board : list) {
			if (board.getNo() == boardNo && !board.getNoShow()) {
				Scanner sc = new Scanner(System.in);

				System.out.println("> 수정할 제목을 입력하시오.");
				board.setTitle(sc.nextLine());

				System.out.println("> 수정할 내용을 입력하시오.");
				board.setContent(sc.nextLine());

				System.out.println("> 수정할 작성자를 입력하시오.");
				board.setWriter(sc.nextLine());

				board.setDate(getDate());

				System.out.println("게시글이 수정되었습니다.");
				return;
			} else {
				System.out.println("존재하지 않는 게시글 입니다.");
				return;
			}
		}
	}

	// 게시글 삭제
	void deleteBoard(int boardNo) {
		int deleteCheck;

		System.out.println("> " + boardNo + "번 게시물을 정말 삭제하시겠습니까?");
		System.out.println("1. 삭제");
		System.out.println("0. 이전 메뉴 돌아가기");
		deleteCheck = sc.nextInt();

		if (1 == deleteCheck) {
			for (Board board : list) {
				if (board.getNo() == boardNo && !board.getNoShow()) {
					board.setNoShow(true); // 게시글을 비활성화 상태로 표시
					System.out.println("게시글이 삭제되었습니다.");
					return;
				}
			}
		}

		System.out.println("해당 게시글을 찾을 수 없습니다.");
	}

	// 년월일시
	private String getDate() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd HH:mm");
		return dateTime.format(formatter);
	}

	int getListSize() {
		return this.list.size();
	}

}
