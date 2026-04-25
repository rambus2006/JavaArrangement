import java.util.Scanner;
public class Scanner_1409 {
	public static void main(String args[]){
		
		//사각형의 넓이 구하기
		Scanner scan = new Scanner(System.in);
		System.out.print("사각형의 밑면 : ");
		 
		int a = scan.nextInt();
		
		System.out.print("사각형의 높이 : ");

		int b = scan.nextInt();
		
		System.out.print("사각형의 넓이 : " + a*b);
		
		

	}
}