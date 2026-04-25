import java.util.Scanner;
public class CondOp_Test{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);

		//삼항연산자 사용방법
		System.out.print("정수를 입력하세요 : ");
		int a = scan.nextInt();
		String k = (a%2==0)?"짝수":"홀수";
		System.out.print(a+"은(는)"+k+"입니다.");
	}
}