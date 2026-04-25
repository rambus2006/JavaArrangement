import java.util.Scanner;
public class Tri_1409_02{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int bignum;
		System.out.print("두 수를 입력하세요( 스페이스로 구분 ) :");
		int a = scan.nextInt();
		int b = scan.nextInt();
	
		bignum= (a>b) ? a : b;
		System.out.print("큰수 : " + bignum);
	}
}