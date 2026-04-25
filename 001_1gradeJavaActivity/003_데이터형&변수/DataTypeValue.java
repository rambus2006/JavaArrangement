public class DataTypeValue{
	public static void main(String args[]){

		//데이터 형에 따른 숫자의 값
		int a= 19;
		int b=2147483647;
		double c=3.14;
		double d =7.783;
	
		int e= a+b;
		double f=a+c;		
		double g= c+d;
		double h=c+d;

		System.out.println(e);	 //"-2147483630"
		System.out.println(f);		//" 22.14 "
		System.out.println(g);	//" 10.923 " 
		System.out.println(h);	//" 10.923"
		
	}
}