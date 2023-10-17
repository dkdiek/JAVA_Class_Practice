package board3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {

	List<Board> boardList;
	Scanner sc = new Scanner(System.in);

	// 생성자
	public Database() {
	boardList = new ArrayList();
	}

	// 쓰기 메소드
	public void writeContent() {
		
		Board board;
		boolean retry = false;
		int writeMenuInput;

		do {

			board = new Board();

			System.out.println();
			System.out.println("게시글을 작성합니다");

			System.out.printf("> 제목을 입력하세요 :");
			String title = sc.nextLine();
			board.setTitle(title);

			System.out.printf("> 내용을 입력하세요 :");
			String content = sc.nextLine();
			board.setContent(content);

			System.out.printf("> 작성자를 입력하세요 :");
			String writer = sc.nextLine();
			board.setWriter(writer);

			board.setBoardNo((boardList.size() + 1));
			board.setTime(getTime());
			board.setIsModified(false);
			board.setIsdeleted(false);
			
			boardList.add(board);

			System.out.println();
			System.out.println("** 게시판 쓰기 메뉴 **");
			System.out.println("1. 게시판 추가 쓰기");
			System.out.println("2. 게시판 보기");
			System.out.println("0. 메인 메뉴로 이동");
			System.out.printf("> 메뉴 번호를 입력하세요 :");
			writeMenuInput = sc.nextInt();
			sc.nextLine();

			if (1 == writeMenuInput) {
				retry = true;
			} else if (2 == writeMenuInput) {
				showBoard();
				retry = false;
			} else if (0 == writeMenuInput) {
				System.out.println("메인 메뉴로 이동합니다");
				retry = false;
			} else {
				System.out.println("Note : 잘못된 실행번호입니다");
				retry = false;
			}

		} while (retry);

	}

	// 읽기 메소드
	public void showBoard() {
		boolean retry = false;
		int showMenuInput;

		do {
			if (0 < getActiveBoard()) {
				System.out.println();
				System.out.println("게시판을 조회합니다");

				for (Board board : boardList) {

					if (!board.isIsdeleted()) {

						System.out.println("번호 : " + board.getBoardNo() + "  제목 : " + board.getTitle() + "  작성자 : "
								+ board.getWriter());
					} else {

					}

				}
			} else {
				System.out.println();
				System.out.println("Note : 현재 등록된 게시물이 없습니다");
				retry = false;
			}

			System.out.println();
			System.out.println("** 메인 메뉴 **");
			System.out.println("1. 게시판 상세 보기");
			System.out.println("0. 메인 메뉴로 이동");
			System.out.printf("> 메뉴 번호를 입력하세요 :");
			showMenuInput = sc.nextInt();
			sc.nextLine();

			if (1 == showMenuInput) {
				showBoardDetail();
				retry = false;
			} else if (0 == showMenuInput) {
				retry = false;
			} else {
				System.out.println("Note : 잘못된 실행번호입니다");
				retry = true;
			}

		} while (retry);

	}

	// 상세 보기 메소드
	public void showBoardDetail() {
		boolean retry = false;
		int showDetailNo;
		int showDetailMenuInput;
		boolean found=false;
		
		do {
			if(1 < getActiveBoard() ) {
				System.out.println("상세보기할 번호를 입력하세요.");
				showDetailNo = sc.nextInt();
				
				for (Board board : boardList) {
					if(showDetailNo == board.getBoardNo() && ! board.isIsdeleted()) {
						System.out.println();
						System.out.println("게시판을 상세 조회합니다");
						System.out.println("번호 : " + board.getBoardNo());
						System.out.println("제목 : " + board.getTitle());
						System.out.println("내용 : " + board.getContent());
						System.out.println("작성자 : " + board.getWriter());
						found = true;
					} 
					if(! found) {
						System.out.println();
						System.out.println("존재하지 않는 게시물입니다");
					}
				}
			}
			
			System.out.println();
			System.out.println("** 게시판 상세 보기 메뉴 **");
			System.out.println("1. 게시판 추가 상세 보기");
			System.out.println("2. 게시판 수정");
			System.out.println("3. 게시판 삭제");
			System.out.println("0. 메인 메뉴로 이동");
			System.out.printf("> 메뉴 번호를 입력하세요 :");
			showDetailMenuInput = sc.nextInt();
			sc.nextLine();

			if (1 == showDetailMenuInput) {
				retry = true;
			} else if (2 == showDetailMenuInput) {
				//게시판 수정
				retry = false;
			} else if (3 == showDetailMenuInput) {
				//게시판 삭제
				retry = false;
			}else if (0 == showDetailMenuInput) {
				retry = true;
			} else {
				System.out.println("Note : 존재하지 않는 게시물입니다");
				retry = true;
			}
			
		}while(retry);

	}
	
	// 수정 메소드
	public void modifyBoard() {
		boolean retry = false;
		int modifyBoardNo;
		int modifyMenuInput;
		
		if(1 < getActiveBoard() ) {
			do {

				System.out.println();
				System.out.println("게시글을 수정합니다");
				System.out.printf("> 수정 게시글 번호를 입력하시오 : ");
				modifyBoardNo = sc.nextInt();
				sc.nextLine();
				
				
				for (Board board : boardList) {
					
					if(modifyBoardNo == board.getBoardNo()){
						
					}
					
				}
				
				
				System.out.printf("> 제목을 입력하세요 :");
				String title = sc.nextLine();
				board.setTitle(title);

				System.out.printf("> 내용을 입력하세요 :");
				String content = sc.nextLine();
				board.setContent(content);

				System.out.printf("> 작성자를 입력하세요 :");
				String writer = sc.nextLine();
				board.setWriter(writer);

				board.setBoardNo((boardList.size() + 1));
				board.setTime(getTime());
				board.setIsModified(false);
				board.setIsdeleted(false);
				
				boardList.add(board);

				System.out.println();
				System.out.println("** 게시판 쓰기 메뉴 **");
				System.out.println("1. 게시판 추가 쓰기");
				System.out.println("2. 게시판 보기");
				System.out.println("0. 메인 메뉴로 이동");
				System.out.printf("> 메뉴 번호를 입력하세요 :");
				writeMenuInput = sc.nextInt();
				sc.nextLine();

				if (1 == writeMenuInput) {
					retry = true;
				} else if (2 == writeMenuInput) {
					showBoard();
					retry = false;
				} else if (0 == writeMenuInput) {
					System.out.println("메인 메뉴로 이동합니다");
					retry = false;
				} else {
					System.out.println("Note : 잘못된 실행번호입니다");
					retry = false;
				}

			} while (retry);
		} else {
			System.out.println("존재하지 않는 게시글입니다.");
		}
		

	}

	
	// 삭제 메소드
	public void deleteBoard() {
		
	}
	
	// 시간 리턴 메소드
	public String getTime() {
		LocalDateTime currentTime = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);

		return formattedTime;
	}

	// 게시물 개수 리턴
	public int getActiveBoard() {
		int activeBoardNo = 0;
		for (Board board : boardList) {
			if (!board.isIsdeleted()) {
				activeBoardNo++;
			}
		}
		return activeBoardNo;
	}

}
