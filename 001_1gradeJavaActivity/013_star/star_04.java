public class star_04{
	public static void main(String args[]){
		for(int i =1; i<=5;i++){
			for(int j = 5;j>=i;j--)
				System.out.print(" "+" ");
			for(int j = 1;j<=i;j++)
				System.out.print("*"+" ");
	
			for(int L = 1;L<i;L++)
					System.out.print("*"+" ");
			for(int k = 5;k>=i;k--)
				System.out.print(" "+" ");
				
		
			System.out.print("\n");
		}
		
	}
}
//5까지 돌리는 거를 변수로 변경,숙제 