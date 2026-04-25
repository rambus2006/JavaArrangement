public class constant {
	public static void main(String args[]){

		// 상수: 처음에 정해놓은 값이 바뀌지 않고 끝까지 가는 값(중간에 수정 불가. 물론 선언할 때 초기화하지 않았다면 단 한번 정할 수 있다.)
		/*a final 로 지정되어 있어서 원래 안되는 코드니까 당황하지 말 것. 
		a=10에서 변하지 않는 수로 지정되어 있다.*/
		
		final int a = 10;		//(=)기호는 assign 과 같다.
		System.out.println(a);								
						         
		a=20;				         
		System.out.println(a);	

		/*final 쓰는 이유:1. 잘못하는 것을 미연에 방지하기 위해 (프로그래머에 의해 잘못 쓰는 것을 방지하기 위해)
			         2.의미가 더 잘오기 때문에
			         3.한번에 바꿀 수 있기 때문에 (프로그램의 수정이 용이하다)*/
	}
}