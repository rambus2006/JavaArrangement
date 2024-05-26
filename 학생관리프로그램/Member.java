package _010_2023_01_06_학생관리프로그램;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Member {
	
	List<MemberLogin> members = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	public Member() {
		members.add(new MemberLogin("admin", "admin", "SSam"));
	}
	//"[1]로그인 [2]회원가입 [3]전체회원 [0]종료"
	public void menuSystem() {
		
		int num = 0;		
		while (   (num = menu())   != 0) {
			switch (num) {
			case 1:
				teacherLogin();
				break;
			case 2:
				teacherJoin();
				break;
			case 3:
				teacherList();
				break;
			}
		}
	}
	public int menu() {
		System.out.print("[1]로그인 [2]회원가입 [3]전체회원 [0]종료");
		return scanner.nextInt();
	}
	//menu=2 회원가입 (선생님) 
	private void teacherJoin() {
		System.out.print("ID : ");
		String id = scanner.next(); 
		System.out.print("Password : ");		
		String password = scanner.next(); 
		System.out.print("Password 확인 : ");
		String password2 = scanner.next(); 
		System.out.print("Name : ");
		String name = scanner.next(); 		
		if  ( findId(id) != null) {
			System.out.println("중복된 ID입니다.");
		} else if(password.equals(password2)) {
			members.add(new MemberLogin(id, password, name));
			System.out.println("회원가입이 완료되었습니다.");
		} else {
			System.out.println("비밀번호를 다시 입력하시오.");
		}
	}
	
	private MemberLogin findId(String id) {
		for(MemberLogin memberLogin : members) {
			if(memberLogin.getId().equals(id)) {
				return memberLogin;
			}
		}
		return null;
	}
	
	//메뉴:1->로그인 
	private void teacherLogin() {
		while (true) {
			System.out.print("ID : ");
			String id = scanner.next(); 
			System.out.print("Password : ");		
			String password = scanner.next(); 
			MemberLogin member = findId(id);
			StudentHandler stuHdl = new StudentHandler();
			if (member == null) {
				System.out.println("입력하신 아이디가 일치하지 않습니다.");
				System.out.println("다시 입력하시오.");
			} else if(member.getPassword().equals(password)) {
				System.out.println("학생정보관리시스템에 접속하였습니다.");
				stuHdl.studentSystem();
				break;
			} else {
				System.out.println("입력하신 패스워드가 일치하지 않습니다.");
				System.out.println("다시 입력하시오.");
			}
		}
	}

	public void teacherList() {
		System.out.println("[관리자 목록]");
		for (MemberLogin memLog : members) {
			System.out.println(memLog);
		}		
	}
}
