import java.util.Scanner;
public class Compare_1409_09{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		
		System.out.print("a의 값을 입력하세요: ");
		int a=scan.nextInt();
		System.out.print("b의 값을 입력하세요: ");
		int b=scan.nextInt();
		
		if(a>b) System.out.println("1");
		else if(a<b) System.out.println("0");
		else if(a==b) System.out.println(a+" == "+b);
		
	}
}