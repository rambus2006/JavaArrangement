import java.util.Scanner;
public class Switch_Score2_scanner{
	public static void main (String args[]){

		Scanner scan=new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score=scan.newInt();

		switch(score/10){
			case 10:	
				System.out.println("만점입니다.");				
			case 9:
				System.out.println("A입니다.");
				break;
			case 8:
				System.out.println("B입니다.");
				break;
			case 7:
				System.out.println("C입니다.");
				break;
		
			default:
				System.out.println("D입니다.");
				break;
		}		
	}
}