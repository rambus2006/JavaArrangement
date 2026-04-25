import java.util.Scanner;
public class Triangle_1409_10{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 3개를 입력하시오 >>");
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
	
		if((a+b)>c) System.out.print("삼각형이 됩니다.");
		else if((b+c)>a) System.out.print("삼각형이 됩니다.");
		else if((a+c)>b) System.out.print("삼각형이 됩니다.");
		else System.out.print("삼각형이 되지 않습니다.");
	}
}