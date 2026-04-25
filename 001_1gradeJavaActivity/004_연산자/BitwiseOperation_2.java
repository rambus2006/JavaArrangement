public class BitwiseOperation_2{
	public static void main(String args[]){

		//비트연산자_2
		int a =3;
		int b =5;
		System.out.println(a&b);	//"1 "AND연산자 : a와 b, 두비트가 모두 1이면 1,하나라도 0 이면 0
		System.out.println(a|b);	//"7" OR 연산자 : a와 b, 두비트가 모두 0이면 0
		System.out.println(a^b);	//"6"eXcluesive OR : a 와 b, 두비트가 서로 다르면 1, 같으면 0
		System.out.println(~a);	//"-4"보수 : 0과 1을 반전
		
	}
}