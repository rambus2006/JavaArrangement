import java.util.Scanner;
public class sTemp_1409{
	public static void main ( String args[]){
		Scanner scan = new Scanner(System.in);

		//입력받아서 온도 구하기
		System.out.print("섭씨 온도 입력 : ");
		int c = scan.nextInt( ) ;		//프로그래밍 하기 전 그전단계까지 실행되는지 꼭 확인하기!
		double F =(double)9.0/5*c+32 ;	//정수와 정수 계산은 정수로 인식하므로 9랑 5중에 하나를 실수로 바꾸거나 둘 다 실수형으로 바꾸면 된다.
						//제일 좋은 방법은 캐스팅해서 형 변환(컴퓨터는 거짓말을 하지 않는다.)

		
		System.out.print("섭씨 : "+c+" ==> "+" 화씨 : "+F);
	}
}