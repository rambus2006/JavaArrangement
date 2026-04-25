import java.util.Scanner;
public class method{
	public static void main(String args[]){
		Scanner scan =new Scanner (System.in);
		
		//메서드, 여러줄을 모아서 저장
		//if 설명할 때 같이 함
		int a =scan.nextInt();
		int b =scan.nextInt();
		int c ;
		c=add(a,b);		//넘겨주는 인자
		System.out.println(c);
	}
	static int add(int x,int y){		//int x, int y는 매개변수
		return x+y;
	}

	}
