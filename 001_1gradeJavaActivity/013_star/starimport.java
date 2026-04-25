import java.util.Scanner;
public class starimport{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);

		System.out.print("출력할 줄 수를 입력하세요 : ");
		int L=scan.nextInt();
		
		for(int i=1;i<=L;i++){
			for(int j = L;j>=i;j--)
				System.out.print(" "+" ");
			for(int j = 1;j<=i;j++)
				System.out.print("*"+" ");
	
			for(int k = 1;k<i;k++)
					System.out.print("*"+" ");
			for(int k = 5;k>=i;k--)
				System.out.print(" "+" ");
				
		
			System.out.print("\n");
		}
		
	}
}