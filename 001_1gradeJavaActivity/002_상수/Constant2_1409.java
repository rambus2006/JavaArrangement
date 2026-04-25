import java.util.Scanner;
public class Constant2_1409{
	public static void main(String args[]){
	
		Scanner scan= new Scanner(System.in);	//명령문 main보다 안쪽으로 들어가야 함//
		System.out.print("반지름 : ");
		
		final double p = 3.14;
		int r = scan.nextInt();
	
		System.out.println ("반지름 "+ r +"인 원의 둘레 : "+(2*r*p));	//곱하기라 굳이 괄호로 묶지 않아도 됨, 만약 더하기나 빼기라면 괄호로 묶어야 함//
		System.out.println("반지름 "+ r+"인 원의 넓이 : "+(r*r*p));		//반지름과 r사이 띄여쓰기
	}
}
