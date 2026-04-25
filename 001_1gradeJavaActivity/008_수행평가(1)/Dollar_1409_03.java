import java.util.Scanner;
public class Dollar_1409_03{
	public static void main(String args[]){
		Scanner scan= new Scanner(System.in);
		
		
		System.out.print("원화를 입력하세요( 단위 : 원) : ");
		int dollar=scan.nextInt();
		 double onedollar=(double)dollar/1260;
		
		System.out.printf("%d원은 $%.2f입니다.",dollar,onedollar);
		
	}
}