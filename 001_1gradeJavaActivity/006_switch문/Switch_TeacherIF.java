import java.util.Scanner;
public class Switch_TeacherIF{
	public static void main(String args[]){
		
		Scanner scan=new Scanner(System.in);
		
		System.out.print("반을 입력하세요 : ");
		int teacher=scan.nextInt();
		
		if(teacher==1){						//들여쓰기 주의!
				System.out.println("정혜선 선생님");
		}
		else if(teacher==2){
				System.out.println("민주리선생님");
		}
		else if(teacher==3){
				System.out.println("김윤환 선생님");
		}
		else if(teacher==4){
				System.out.println("김영철 선생님");
		}
		else{
				System.out.println("잘못입력하셨습니다");
		}
		
	}
}