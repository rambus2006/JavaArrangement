package _010_2023_01_06_학생관리프로그램;

import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); 
		Member member = new Member(); //admin 1명은 기본 객체만들어짐. 		
	    loop:
	      while(true) {
	        System.out.println("[고등학교 성적관리시스템 메인]");
	        System.out.printf("[1]선생님 로그인  [0] 종료\n");
	        System.out.println("명령>");
	        int command = scan.nextInt();
	        switch(command) {
	          case 1: member.menuSystem(); 
	          	break;
	          case 0 : 
	            System.out.println("프로그램 종료");
	            break loop;
	          default : System.out.println("잘못된 명령입니다."); 
	        }
	        System.out.println();
	      }
	}
}