public class Whileodd1to100{
	public static void main(String args[]){
		
		//변수 선언(1부터 시작)
		int odd=1;
		
		//100까지 반복
		while(odd<=100){
			if(odd%2 !=0) System.out.println(odd); 
			odd++;
		}
		
	}
}
/*방법2
public class Whileodd1to100{
	public static void main(String args[]){
		
		//변수 선언(1부터 시작)
		int odd=1;
		
		//100까지 반복
		while(odd<=100){
			System.out.println(odd); 
			odd+=2;
		}
		
	}
}
*/