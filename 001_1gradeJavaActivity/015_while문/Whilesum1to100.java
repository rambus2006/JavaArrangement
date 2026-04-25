public class Whilesum1to100{
	public static void main(String args[]){
		//변수 선언
		int num=1, sum=0;

		//100까지 반복
		while(num<=100){
			sum+=num;
			num++;
		}
		
		System.out.print(sum);
	}
}
/*방법2
 public class Whilesum1to100{
	public static void main(String args[]){
		//변수 선언
		int num=1, sum=0;

		//100까지 반복
		while(num<=100){
			sum+=num++;
		}
		
		System.out.print(sum);
	}
}
*/
		
		