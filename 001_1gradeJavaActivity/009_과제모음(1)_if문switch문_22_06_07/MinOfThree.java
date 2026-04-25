import java.util.Scanner;
public class {
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		
		//220608 자바과제
		int min=0;
		System.out.print("첫 번째 수 입력 : ");
		int num1=scan.nextInt();
		System.out.print("두 번째 수 입력 : ");
		int num2=scan.nextInt();
		System.out.print("세 번째 수 입력 : ");
		int num3 = scan.nextInt();

		if(num1<num2){
			if(num1<num3) min=num1;	//if, else 문이 하나이기 때문에 바깥 if 문은 중괄호 없애고 들여써도 된다.
			else min=num3;		//num 3으로 써야 함. (3으로 씀)!!!!!!!제발 꼼꼼히 보자
		}
		else{
		   	 if(num2<num3) min=num2;
			else min=num3;
		}
		System.out.print(num1 +"와"+" " + num2 +"와 "+" " + num3 +" "+ "중 제일 작은 수는 " +min + "입니다.");

	}
}