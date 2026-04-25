import java.util.Scanner;		//입력받을 때 반드시 써줘야 한다.
public class SSquare_1409 {
	public static void main (String args[]){
		Scanner scan = new Scanner(System.in);	//입력받기 전 문장에만 쓴다.(키보드에서 입력을 받겠다.)
		int a = scan.nextInt( );	
		int b= scan.nextInt( );
		
	
		System.out.print("가로길이 : "+ a +"," +" 세로길이 : "+ b +","+" 넓이 : "+ (a*b));

	}
}

