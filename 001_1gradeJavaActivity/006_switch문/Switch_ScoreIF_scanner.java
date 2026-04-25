import java.util.Scanner;
public class Switch_ScoreIF_scanner{
	public static void main (String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score=scan.nextInt();
		if(score>=90){
				System.out.println("A입니다.");
		}
		else if(score>=80){
				System.out.println("B입니다.");
		}
		else if(score>=70){					//기호주의, 오타주의
				System.out.println("C입니다.");
		}
		else{
				System.out.println("D입니다.");	
		}		
	}
}