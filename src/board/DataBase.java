package board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {

	private List list = new ArrayList();

	void showList() {
		if ( 0 == list.size() ) {
			System.out.println("!!! 게시물이 없습니다 !!!");
		}
		for( int i = 0;i<list.size();i++ ) {
			Board board = (Board) list.get(i);
			System.out.println("번호: " + board.getNo());
			System.out.println("제목: " + board.getTitle());
			System.out.println("내용: " + board.getContent());
			System.out.println("작성자: " + board.getWriter());
			System.out.println("작성일시: " + board.getDate());
			System.out.println("-----------------------------");
		}

	}

	void writeBoard() {

		Board board = new Board();
		Scanner sc = new Scanner(System.in);

		System.out.println("제목을 입력하시오.");
		board.setTitle(sc.nextLine());

		System.out.println("내용을 입력하시오.");
		board.setContent(sc.nextLine());

		System.out.println("작성자를 입력하시오.");
		board.setWriter(sc.nextLine());

		board.setNo(list.size() + 1);
		board.setDate(getDate());

		list.add(board);
	}

	private String getDate() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
		return dateTime.format(formatter);
	}

}
