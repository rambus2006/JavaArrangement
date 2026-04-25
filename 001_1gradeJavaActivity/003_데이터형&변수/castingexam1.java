public class castingexam1{
	public static void main(String args[]){
		//교과서 20p
		/*int a = 10;
		byte b =a; 여기에서 int 형이 더 작은 범위인 byte형으로 형 변환되므로 형 변환 연산자를 사용해 명시해야 한다. */
		//맞게 고치면
		int a = 10;
		byte b = (byte)a;
		
		System.out.print(b);
	

	}
}