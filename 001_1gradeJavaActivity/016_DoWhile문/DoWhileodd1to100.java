public class DoWhileodd1to100{
	public static void main(String args[]){
		
		//변수 선언(1부터 시작)
		int odd=1;
		
		//100까지 반복
		do{
			System.out.println(odd); 
			odd+=2;
		}
		while(odd<=100);
		
	}
}
