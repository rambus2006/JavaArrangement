public class casting{
	public static void main(String args[]){
		int a =12;
		byte b =(byte)a;		//강제형 변환
		byte d =(byte)(a+b);	//byte+byte=int	
		System.out.println("a+b : "+d);
	}
}