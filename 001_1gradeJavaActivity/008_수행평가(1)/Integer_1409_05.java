import java.util.Scanner;
public class Integer_1409_05{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);

		System.out.print("정수 3개 입력 : ");
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		int sum=(a+b+c);
		double avg = (double)sum/3;

		System.out.println("합 : "+sum);
		System.out.printf("평균: %.2f",avg);
		
	}
}