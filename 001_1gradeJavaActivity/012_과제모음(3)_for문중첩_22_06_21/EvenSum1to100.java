public class EvenSum1to100{
	public static void main(String args[]){
		
		//220622
		//for문을 이용하여 1부터 100사이의 짝수의 합을 출력하는 프로그램
		int sum=0;
		for(int i=1;i<=100;i++) if(i%2==0) sum+=i;
		
		System.out.println(sum);
	}
}