package board2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Board {
	List<DataBase> boardList; // 수정: List<DataBase>로 타입 지정
	Scanner sc = new Scanner(System.in);

	// 생성자
	public Board() {
		boardList = new ArrayList<>();
	}

	// 현재 데이트 타임 스트링 리턴
	public String getTime() {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy:MM:dd HH:mm");
		String formattedDate = dateFormat.format(currentDate);
		return formattedDate;
	}

	// 게시글 보기
	public void showBoardList() {
		int activeBoardNo = 0;
		int showBoardListInput = 0;
		int boardNo = 0;

		for (int i = 0; i < boardList.size(); i++) {
			DataBase db = boardList.get(i);
			if (!db.isDeleted()) {
				activeBoardNo++;
			}
		}

		if (activeBoardNo < 1) {
			System.out.println("Note : 현재 등록된 게시물이 없습니다.");
		} else {
			for (int i = 0; i < boardList.size(); i++) {
				DataBase db = boardList.get(i);

				if (db.isDeleted()) {
					continue;
				} else {
					System.out.println("No : " + db.getBoardNo() + " | T: " + db.getTitle() + " | W:" + db.getWriter());
				}
			}

			System.out.println();
			System.out.println("** 게시글 보기 메뉴 **");
			System.out.println("1. 게시글 상세 보기");
			System.out.println("2. 게시글 수정");
			System.out.println("3. 게시글 삭제");
			System.out.println("0. 메인 메뉴 돌아가기");
			System.out.print("> 실행 번호를 입력하시오 : ");
			showBoardListInput = sc.nextInt();
			sc.nextLine(); // Enter 키 입력 소비

			if (1 == showBoardListInput) {
				System.out.print("> 상세보기 게시글 번호를 입력하시오 : ");
				boardNo = sc.nextInt();
				sc.nextLine(); // Enter 키 입력 소비
				showBoardList(boardNo);
			} else if (2 == showBoardListInput) {
				System.out.print("> 수정할 게시글 번호를 입력하시오 : ");
				boardNo = sc.nextInt();
				sc.nextLine(); // Enter 키 입력 소비
				modifyBoard(boardNo);
			} else if (3 == showBoardListInput) {
				System.out.print("> 삭제할 게시글 번호를 입력하시오 : ");
				boardNo = sc.nextInt();
				sc.nextLine(); // Enter 키 입력 소비
				deleteBoard(boardNo);
			} else if (0 == showBoardListInput) {
				// 메인 메뉴 돌아가기
			} else {
				System.out.println("Note : 잘못된 실행 번호입니다.");
			}
		}
	}

	// 게시글 상세 보기
	public void showBoardList(int boardNo) {
		int showBoardDetailInput = 0;
		boolean found = false;

		for (int i = 0; i < boardList.size(); i++) {
			DataBase db = boardList.get(i);

			if (!db.isDeleted() && boardNo == db.getBoardNo()) {
				found = true;
				System.out.println();
				System.out.println("게시물 번호 : " + db.getBoardNo());
				System.out.println("제목 : " + db.getTitle());
				System.out.println("내용 : " + db.getContent());
				System.out.println("작성자 : " + db.getWriter());
				System.out.println("일시 : " + db.getTime());

				System.out.println();
				System.out.println("** 게시글 상세 보기 메뉴 **");
				System.out.println("1. 게시글 수정");
				System.out.println("2. 게시글 삭제");
				System.out.println("0. 메인 메뉴 돌아가기");
				System.out.print("> 실행 번호를 입력하시오 : ");
				showBoardDetailInput = sc.nextInt();
				sc.nextLine(); // Enter 키 입력 소비

				if (1 == showBoardDetailInput) {
					modifyBoard(boardNo);
				} else if (2 == showBoardDetailInput) {
					deleteBoard(boardNo);
				} else if (0 == showBoardDetailInput) {
					// 메인 메뉴 돌아가기
					break;
				} else {
					System.out.println("Note : 잘못된 실행 번호입니다.");
				}
			}
		}

		if (!found) {
			System.out.println("Note : 존재하지 않는 게시물입니다.");
		}
	}

	// 게시글 작성
	public void writeBoard() {
		boolean retry = true;
		int writeBoardInput;

		while (retry) {
			DataBase db = new DataBase();

			db.setBoardNo(boardList.size() + 1);

			System.out.print("> 제목을 입력하시오 : ");
			String title = sc.nextLine();
			db.setTitle(title);

			System.out.print("> 내용을 입력하시오 : ");
			String content = sc.nextLine();
			db.setContent(content);

			System.out.print("> 작성자를 입력하시오 : ");
			String writer = sc.nextLine();
			db.setWriter(writer);

			db.setTime(getTime());

			db.setDeleted(false);

			boardList.add(db);

			System.out.println();
			System.out.println("** 게시글 작성 메뉴 **");
			System.out.println("1. 게시글 추가 작성");
			System.out.println("0. 메인 메뉴 돌아가기");
			System.out.print("> 실행 번호를 입력하시오 : ");
			System.out.println();
			writeBoardInput = sc.nextInt();
			sc.nextLine(); // Enter 키 입력 소비

			if (1 == writeBoardInput) {
				retry = true;
			}
			if (0 == writeBoardInput) {
				retry = false;
			}
		}

	}

	// 게시글 수정
	public void modifyBoard(int boardNo) {
		boolean modifyFound = false;

		for (int i = 0; i < boardList.size(); i++) {
			DataBase modify = boardList.get(i);

			if (!modify.isDeleted() && boardNo == modify.getBoardNo()) {
				DataBase db = modify;

				System.out.print("> 수정할 제목을 입력하시오 : ");
				String title = sc.nextLine();
				db.setTitle(title);

				System.out.print("> 수정할 내용을 입력하시오 : ");
				String content = sc.nextLine();
				db.setContent(content);

				System.out.print("> 수정할 작성자를 입력하시오 : ");
				String writer = sc.nextLine();
				db.setWriter(writer);

				db.setTime(getTime());

				db.setModified(true);

				System.out.println("게시글이 수정되었습니다.");
				modifyFound = true;
				break;
			}
		}
		if (!modifyFound) {
			System.out.println("Note : 존재하지 않는 게시물입니다.");
		}
	}

	// 게시물 삭제
	public void deleteBoard(int boardNo) {
		boolean deletefound = false;

		for (int i = 0; i < boardList.size(); i++) {
			DataBase delete = boardList.get(i);

			if (!delete.isDeleted() && boardNo == delete.getBoardNo()) {
				DataBase db = delete;

				db.setDeleted(true);

				System.out.println("게시글이 삭제되었습니다.");
				deletefound = true;
				break;
			}
		}
		if (!deletefound) {
			System.out.println("Note : 존재하지 않는 게시물입니다.");
		}
	}

	// --------------------------------------------------------------------------------------------------------------------------------------------

	// 관리자 모드
	public void adminMode() {
		DataBase db = new DataBase();
		int adminModeInput;

		System.out.println("> 관리자 PW를 입력하시오 : ");
		int adminPW = sc.nextInt();
		boolean pwCheck = false;

		if (db.checkAdminPassword(adminPW)) {
			pwCheck = true;
			System.out.println();
			System.out.println("** [관리자] 모드 메뉴 **");
			System.out.println("1. 수정 게시물 조회");
			System.out.println("2. 삭제 게시물 조회");
			System.out.println("0. 메인 메뉴 돌아가기");
			System.out.print("> 실행 번호를 입력하시오 : ");
			System.out.println();
			adminModeInput = sc.nextInt();
			sc.nextLine();

			if (1 == adminModeInput) {
				showModifiedBoardList();

			} else if (2 == adminModeInput) {
				showDeletedBoardList();
				
			} else if (0 == adminModeInput) {

			} else {
				System.out.println("Note : 잘못된 실행 번호입니다.");
			}

		}
		if (!pwCheck) {
			System.out.println("Note : 잘못된 PW 입력입니다.");
		}
	}

	// 수정된 게시글 보기 (관리자 모드)
	public void showModifiedBoardList() {
		int modifiedBoardNo = 0;
		int showModifiedBoardListInput = 0;
		int boardNo = 0;

		for (int i = 0; i < boardList.size(); i++) {
			DataBase db = boardList.get(i);
			if (!db.isModified()) {
				modifiedBoardNo++;
			}
		}

		if (modifiedBoardNo < 1) {
			System.out.println("Note : 현재 수정된 게시물이 없습니다.");
		} else {
			for (int i = 0; i < boardList.size(); i++) {
				DataBase db = boardList.get(i);

				if (db.isModified() && (! db.isDeleted())) {
					System.out.println("No : " + db.getBoardNo() + " | T: " + db.getTitle() + " | W:" + db.getWriter());
				} else {
					continue;
				}
			}

			System.out.println();
			System.out.println("** [관리자] 수정 게시물 보기 메뉴 **");
			System.out.println("1. 수정 게시글 상세 보기");
			System.out.println("0. 메인 메뉴 돌아가기");
			System.out.print("> 실행 번호를 입력하시오 : ");
			showModifiedBoardListInput = sc.nextInt();
			sc.nextLine(); // Enter 키 입력 소비

			if (1 == showModifiedBoardListInput) {
				System.out.print("> 상세보기 게시글 번호를 입력하시오 : ");
				boardNo = sc.nextInt();
				sc.nextLine(); // Enter 키 입력 소비
				showModifiedBoardList(boardNo);
			} else if (0 == showModifiedBoardListInput) {
				// 메인 메뉴 돌아가기
			} else {
				System.out.println("Note : 잘못된 실행 번호입니다.");
			}
		}
	}

	// 수정된 게시글 상세 보기 (관리자 모드)
	public void showModifiedBoardList(int boardNo) {
		int showBoardDetailInput = 0;
		boolean found = false;

		for (int i = 0; i < boardList.size(); i++) {
			DataBase db = boardList.get(i);

			if ( (! db.isDeleted()) && db.isModified() && boardNo == db.getBoardNo()) {
				found = true;
				System.out.println();
				System.out.println("게시물 번호 : " + db.getBoardNo());
				System.out.println("제목 : " + db.getTitle());
				System.out.println("내용 : " + db.getContent());
				System.out.println("작성자 : " + db.getWriter());
				System.out.println("일시 : " + db.getTime());

				System.out.println();
				System.out.println("** [관리자] 수정 게시물 상세 보기 메뉴 **");
				System.out.println("0. 메인 메뉴 돌아가기");
				System.out.print("> 실행 번호를 입력하시오 : ");
				showBoardDetailInput = sc.nextInt();
				sc.nextLine(); // Enter 키 입력 소비

				if (0 == showBoardDetailInput) {
					// 메인 메뉴 돌아가기
					break;
				} 
				
				if ( ! found ) {
					System.out.println("Note : 잘못된 실행 번호입니다.");
				}
			}
		}

	}

	// 삭제된 게시글 보기 (관리자 모드)
	public void showDeletedBoardList() {
		int deletedBoardNo = 0;
		int showDeletedBoardListInput = 0;
		int boardNo = 0;

		for (int i = 0; i < boardList.size(); i++) {
			DataBase db = boardList.get(i);
			if (db.isDeleted()) {
				deletedBoardNo++;
			}
		}

		if (deletedBoardNo < 1) {
			System.out.println("Note : 현재 삭제된 게시물이 없습니다.");
		} else {
			for (int i = 0; i < boardList.size(); i++) {
				DataBase db = boardList.get(i);

				if (db.isDeleted()) {
					System.out.println("No : " + db.getBoardNo() + " | T: " + db.getTitle() + " | W:" + db.getWriter());
				} else {
					continue;
				}
			}

			System.out.println();
			System.out.println("** [관리자] 삭제 게시물 보기 메뉴 **");
			System.out.println("1. 삭제 게시글 상세 보기");
			System.out.println("0. 메인 메뉴 돌아가기");
			System.out.print("> 실행 번호를 입력하시오 : ");
			showDeletedBoardListInput = sc.nextInt();
			sc.nextLine(); // Enter 키 입력 소비

			if (1 == showDeletedBoardListInput) {
				System.out.print("> 상세보기 게시글 번호를 입력하시오 : ");
				boardNo = sc.nextInt();
				sc.nextLine(); // Enter 키 입력 소비
				showDeletedBoardList(boardNo);
			} else if (0 == showDeletedBoardListInput) {
				// 메인 메뉴 돌아가기
			} else {
				System.out.println("Note : 잘못된 실행 번호입니다.");
			}
		}
	}

	// 삭제된 게시글 상세 보기 (관리자 모드)
	public void showDeletedBoardList(int boardNo) {
		int showBoardDetailInput = 0;
		boolean found = false;

		for (int i = 0; i < boardList.size(); i++) {
			DataBase db = boardList.get(i);

			if (db.isDeleted() && boardNo == db.getBoardNo()) {
				found = true;
				System.out.println();
				System.out.println("게시물 번호 : " + db.getBoardNo());
				System.out.println("제목 : " + db.getTitle());
				System.out.println("내용 : " + db.getContent());
				System.out.println("작성자 : " + db.getWriter());
				System.out.println("일시 : " + db.getTime());

				System.out.println();
				System.out.println("** [관리자] 삭제 게시물 상세 보기 메뉴 **");
				System.out.println("0. 메인 메뉴 돌아가기");
				System.out.print("> 실행 번호를 입력하시오 : ");
				showBoardDetailInput = sc.nextInt();
				sc.nextLine(); // Enter 키 입력 소비

				if (0 == showBoardDetailInput) {
					// 메인 메뉴 돌아가기
					break;
				} else {
					System.out.println("Note : 잘못된 실행 번호입니다.");
				}
			}
		}

	}
}