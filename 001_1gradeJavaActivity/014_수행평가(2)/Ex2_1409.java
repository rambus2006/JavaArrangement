import java.util.Scanner;
public class Ex2_1409{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		
		int sum=0;
		//¹Ýº¹¹®
		for (int i=1;i<=10;i++){
			System.out.print(i+"¹øÂ° ½Â°´ ¿ä±Ý ÀÔ·Â : ");
			int num=scan.nextInt();
			sum += num;
		}
		System.out.println("¿À´ÃÀÇ ½Â°´ ¿ä±Ý ÇÕ»ê : "+sum+"¿ø");
	}
}