public class IncreaseOp{
	public static void main(String args[]){

		//증감연산자
		int num=0;
		num = num+1;
		System.out.println("num : "+num);	//"num : 1"
		System.out.println("++num : "+(++num)); //"++num : 2"
		System.out.println("num++ : "+(num++)); //"num++ : 2"
		System.out.println("num : " + num);	 //"num : 3"
		System.out.println("--num : "+(--num));	 //"--num : 2"
		System.out.println("num-- : " + (num--)); 	 //"num-- : 2"
		System.out.println("num : " +num);	 //"num : 1"

	}
}