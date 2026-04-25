public class Local_Test{
	public static void main(String args[]){
		
		//논리연산자: !a에서 a가 true면 false / a가 false이면 true(반대로/부정형)
		boolean a =(10>20);
 		
		System.out.println(!a);
		System.out.println(a);
		//caps lock 같은 토글 키는 짝수면 원래대로 돌아옴
					
		boolean power=false;
		System.out.println(power);
		System.out.println(!power);
		power=!power;
		System.out.println(!power);
		
		
	}
}