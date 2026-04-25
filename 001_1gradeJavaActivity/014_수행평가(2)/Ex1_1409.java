import java.util.Scanner;
public class Ex1_1409{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		
		System.out.print("온도를 입력하세요 : ");
		int num=scan.nextInt();
		
		System.out.print("오늘의 추천활동 : ");
		switch(num/10){
			case 3 : case 4:
				System.out.print("수영");
				break;
			case 2 : 
				System.out.print("테니스");
				break;
			case 1 : 
				System.out.print("등산");
				break;
			case -1 :  
				System.out.print("스키");
				break;
			default : 
				System.out.print("스키");
		}
 	}
}