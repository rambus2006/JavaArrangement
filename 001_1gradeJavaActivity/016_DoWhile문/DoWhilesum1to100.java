 public class DoWhilesum1to100{
	public static void main(String args[]){
		//변수 선언
		int num=1, sum=0;

		//100까지 반복
		do{
			
			sum+=num++;
		}while(num<=100);
		System.out.print(sum);
	
	}
}

		
		