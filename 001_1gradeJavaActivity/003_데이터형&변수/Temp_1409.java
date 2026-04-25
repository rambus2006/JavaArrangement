public class Temp_1409{
	public static void main ( String args[]){
		
		//int->double 형변환
		int c = 15;		//프로그래밍 하기 전 그전단계까지 실행되는지 꼭 확인하기!
		double F =(double)9.0/5*c+32 ;	//보통은 소수 첫째 자리까지 출력
						//정수와 정수 계산은 정수로 인식하므로 9랑 5중에 하나를 실수로 바꾸거나 둘 다 실수형							//으로 바꾸면 된다.제일 좋은 방법은 캐스팅해서 형 변환(컴퓨터는 거짓말을 하지 않는다.)

		
		System.out.print("섭씨 : "+c+" ==> "+" 화씨 : "+F);
	}
}