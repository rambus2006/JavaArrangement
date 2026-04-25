import java.util.Scanner;
public class Score_1409_04{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		System.out.print("점수를 입력하세요( 0~100 ) : ");
		int score=scan.nextInt();
		System.out.print("학년을 입력하세요( 1~3 ) : ");
		int grade=scan.nextInt();
		
		if (grade==3){
			if(score>=70){ System.out.println("합격");
			}
			else System.out.print("불합격");
		}
		else {
			if(score>=60){
			 	System.out.println("합격");
			}
			else{
				System.out.println("불합격");
			}
		}
	}
}
