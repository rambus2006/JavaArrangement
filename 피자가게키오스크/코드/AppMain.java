package _009_2023_01_05_kiosk;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp=new Employee("아이유 : ");
		System.out.println("=====미림피자가게=====");
		
		//직원이 인사
		emp.sayWelcome();
		
		//키오스크
		Kiosk kiosk=new Kiosk();
		Order order=kiosk.useKiosk();
		//키오스크 전체 가격 계산하기 
		kiosk.calc(order);
		//주문 가격과 시간 출력하기 
		System.out.println("총가격 : "+order.addPrice(0)+"원 ,소요시간 : "+order.addTime(0)+"분");
		//주문 정보 출력하기 
		System.out.println(order);
	}

}
