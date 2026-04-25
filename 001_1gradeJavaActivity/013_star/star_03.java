public class star_03 {
	public static void main(String args[]){
		for(int i =0; i<5;i++){
			for(int k= 1;k<=i;k++)
				System.out.print(" "+" ");
			for(int j = 5;j>i;j--)
				System.out.print("*"+" ");
			System.out.print("\n");
		}
		
	}
}