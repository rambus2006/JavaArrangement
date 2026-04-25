import java.util.Scanner;
public class Max{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);

		//두수를 입력받아 큰 수 구하기
		System.out.print("첫 번째 수 입력 : ");
		int a=scan.nextInt();
		System.out.print("두 번째 수 입력 : ");
		int b = scan.nextInt();

		System.out.print(a+"와 "+b+" 중 큰 수는 ");
		if(a>b) System.out.print(a);
		else System.out.println(b);
		System.out.println("입니다.");
		//int max=(a>b)?a:b;
	}
}