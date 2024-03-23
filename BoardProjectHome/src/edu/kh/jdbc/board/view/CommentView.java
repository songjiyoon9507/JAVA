package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.board.model.service.CommentService;
import edu.kh.jdbc.common.Session;

public class CommentView {
	
	private Scanner sc = new Scanner(System.in);
	
	private CommentService service = new CommentService();
	
	/** 댓글 메뉴
	 * @param boardNo
	 */
	public void commentMenu(int boardNo) {
		int input = -1;
		try {
			System.out.println("\n=== 댓글 기능 ===\n");
			System.out.println("1) 댓글 등록");
			System.out.println("2) 댓글 수정");
			System.out.println("3) 댓글 삭제");
			System.out.println("0. 댓글 기능 종료");
			System.out.print("\n선택 : ");
			input = sc.nextInt();
			sc.nextLine();
			
			switch (input) {
			case 1 : insertComment(boardNo);  break; // 댓글 등록
			// !wq가 입력 될 때까지 댓글 내용을 입력 받고
			// 내용, 게시글 번호, 로그인 회원 번호를 이용해
			// 댓글 삽입 서비스 호출
		
			case 2 : updateComment(boardNo); break; // 댓글 수정
			// 댓글 번호를 입력 받아서
			// 1) 해당 댓글이 현재 게시글의 댓글이며
			//    로그인한 회원이 쓴 댓글이 맞는지 확인하는 서비스 호출
			
			// 2-1) 1번 결과가 맞지 않으면 
			//		"작성한 댓글만 수정할 수 있습니다" 출력
			
			// 2-2) !wq가 입력될 때 까지 내용 입력 후
			//		댓글번호, 내용을 이용해 댓글을 수정하는 서비스 호출
		
			case 3 : deleteComment(boardNo); break; // 댓글 삭제
			// 1) 해당 댓글이 현재 게시글의 댓글이며
			//    로그인한 회원이 쓴 댓글이 맞는지 확인하는 서비스 호출
			
			// 2-1) 1번 결과가 맞지 않으면 
			//		"작성한 댓글만 삭제할 수 있습니다" 출력
			
			// 2-2) 맞으면 "정말로 삭제 하시겠습니까?(Y/N) : " 출력 후
			//   Y 입력 시 : 삭제 서비스 호출(댓글번호)
			//   N 입력 시 : "취소되었습니다";
			
			case 0 : return;
			default : System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n");
			
			}
		} catch (InputMismatchException e) {
			System.out.println("\n*** 입력 형식이 올바르지 않습니다***\n");
			sc.nextLine();
		}
	}

	/** 댓글 등록 서비스
	 * @param boardNo
	 */
	public void insertComment(int boardNo) {
		System.out.println("[댓글 입력] <!wq 입력 시 종료>");
		
		// String : 불변성
		// StringBuffer : 가변성
		
		StringBuffer sb = new StringBuffer();
		
		// 특정 단어가 입력될 때까지 무한히 입력
		while(true) {
			String str = sc.nextLine();
			
			if(str.equals("!wq")) break;
			
			// append : 제일 뒤에 추가
			sb.append(str);
			sb.append("\n"); // 줄바꿈 추가
		}
	
		try {
			// 게시글 번호, 등록할 댓글 내용, 현재 로그인한 사람의 회원번호
			int result = service.insertComment(boardNo, sb.toString(), Session.loginMember.getMemberNo());
			
			if(result > 0) {
				// 댓글 등록 성공
				System.out.println("\n=== 댓글이 등록 되었습니다. ===\n");
			} else {
				System.out.println("\n*** 댓글 등록 실패 ***\n");
			}
			
		} catch(Exception e) {
			System.out.println("\n***** 댓글 등록 중 예외 발생 *****\n");
			e.printStackTrace();
		}
		
	}
	
	/** 댓글 수정
	 * @param boardNo
	 */
	public void updateComment(int boardNo) {
		
		try {
			System.out.println("\n[댓글 수정]\n");
			
			System.out.print("수정할 댓글 번호 입력 : ");
			int commentNo = sc.nextInt();
			sc.nextLine();
			
			// 입력한 댓글 번호가 해당 게시글에 대해 로그인한 회원이 작성한 댓글이 맞는지 확인
			int check = service.checkCommentNo(commentNo, boardNo, Session.loginMember.getMemberNo());
			
			// check 에 0 아니면 1
			if(check == 0) {
				// 조건 안 맞을 때
				System.out.println("\n*** 작성한 댓글만 수정할 수 있습니다. ***\n");
				return;
			}
			
			// 조건 맞을 때 실제로 수정해야함
			System.out.println("[댓글 수정 내용 입력] <!wq 입력 시 종료>");
			StringBuffer sb = new StringBuffer();
			
			// 특정 단어가 입력될 때까지 무한히 입력
			while(true) {
				String str = sc.nextLine();
				
				if(str.equals("!wq")) break;
				
				// append : 제일 뒤에 추가
				sb.append(str);
				sb.append("\n"); // 줄바꿈 추가
			}
			
			// 위에서 로그인한 사람 조건 체크 했음 또 전달할 필요 없음
			int result = service.updateComment(commentNo, sb.toString());
			
			if(result > 0) {
				// 댓글 수정 성공
				System.out.println("\n=== 댓글이 수정 되었습니다. ===\n");
			} else {
				System.out.println("\n*** 댓글 수정 실패 ***\n");
			}
			
		} catch (Exception e) {
			System.out.println("\n*** 댓글 수정 중 예외 발생 ***\n");
			e.printStackTrace();
		}
		
	}
	
	public void deleteComment(int boardNo) {
		try {
			// 해당 댓글이 현재 게시글의 댓글이며 로그인한 회원이 쓴 댓글이 맞는지 확인
			System.out.println("\n[댓글 삭제]\n");
			
			System.out.print("삭제할 댓글 번호 입력 : ");
			int commentNo = sc.nextInt();
			sc.nextLine();
			
			// 입력한 댓글 번호가 해당 게시글에 대해 로그인한 회원이 작성한 댓글이 맞는지 확인
			int check = service.checkCommentNo(commentNo, boardNo, Session.loginMember.getMemberNo());
			
			// check 에 0 아니면 1
			if(check == 0) {
				// 조건 안 맞을 때
				System.out.println("\n*** 작성한 댓글만 삭제할 수 있습니다. ***\n");
				return;
			}
			
			while(true) {
				// 정말로 삭제하시겠습니까?
				System.out.print("정말로 삭제하시겠습니까?(Y/N) :  ");
				char answer = sc.next().toUpperCase().charAt(0);
				
				if (answer == 'N') { // 삭제 취소
					System.out.println("[삭제 취소]");
					return;
				}
				
				if(answer != 'Y') {
					System.out.println("[잘못 입력하셨습니다]");
					continue;
				}
				
				break; // check == 'Y' 인 경우 삭제 서비스 호출
				
			}
			
			int result = service.deleteComment(commentNo);
			
			if(result > 0) {
				System.out.println("\n=== 댓글이 삭제 되었습니다. ===\n");
			} else {
				System.out.println("\n*** 댓글 삭제 실패 ***\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
