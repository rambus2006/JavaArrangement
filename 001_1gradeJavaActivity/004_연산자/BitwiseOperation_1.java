public class BitwiseOperation_1{
	public static void main(String args[]){

		//비트연산자
		int a=8;
		int b=-9;
		System.out.println(a&b);	//"0"
		System.out.println(a|b);	//"-1"
		System.out.println(a^b);	//"-1"
		System.out.println(~a);	//"-9"
		System.out.println(~b);	//"8"
	}
}