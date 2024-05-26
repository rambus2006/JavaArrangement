package _009_2023_01_05_kiosk;

import java.util.Scanner;

public class Kiosk {
	Scanner sc=new Scanner(System.in);
	
	//포장여부 묻기 
	private boolean checkTakeOut() {
		System.out.print("포장하시겠습니까?(y/n) : ");
		String result=sc.nextLine();
		if(result.equalsIgnoreCase("y")) {		//대소문자 구별 하지 않고 비교한다. 
			return true;
		}else {
			return false;
		}
	}
	public Order useKiosk() {
		boolean isTakeOut=checkTakeOut();
		int dough=selectDough();
		int topping=selectTopping();
		int side=selectSide();
		int drink=selectDrink();
		int price=0;
		int time=0;
		Order order=new Order(isTakeOut,dough,topping,side,drink,price,time);
		return order;
	}
	public void calc(Order od) {
		//선택지에 따른 가격
		calcDough(od);
		calcTopping(od);
		calcSide(od);
		calcDrink(od);
	}
	private void calcDough(Order od) {
		Menu menu=null;
		int dough=od.getDough();
		switch(dough) {
			case 1:menu=new Normal(); break;
			case 2:menu=new Cheese(); break;
			case 3:menu=new Gold(); break;
			case 4:menu=new Bite(); break;
			case 5:menu=new RichGold(); break;
			default: System.out.println("다시 입력하십시오");
		}
		od.addPrice(menu.getPrice());
		od.addTime(menu.getTime());
	}
	//토핑
	private void calcTopping(Order od) {
		Menu menu=null;
		int topping =od.getTopping();
		switch(topping) {
			case 1:menu=new Combination(); break;
			case 2:menu=new peperoni(); break;
			case 3:menu=new Cheese(); break;
			case 4:menu=new potato(); break;
			case 5:menu=new Bulgogi(); break;
			case 6:menu=new SweetPotato(); break;
			case 7:menu=new Shrimp(); break;
		}
		od.addPrice(menu.getPrice());
		od.addTime(menu.getTime());
	}
	//사이드
	private void calcSide(Order od) {
		Menu menu=null;
		int side=od.getSide();
		switch(side) {
			case 1: menu=new Spaghetti(); break;
			case 2: menu=new Potatochips(); break;
			case 3: menu=new Wing(); break;
			case 4: break;
			default: System.out.println("다시 입력하십시오.");
		}
	
	}
	//음료
	private void calcDrink(Order od) {
		Menu menu=null;
		int drink=od.getDrink();
		switch(drink) {
			case 1: menu=new Cidar(); break;
			case 2: menu=new Cola(); break;
			case 3: menu=new Fanta();break;
			case 4: break;
		}
		
	}
	//도우 선택
	private int selectDough() {
		//선택지 보여주기 
		System.out.println("==========도우==========");
		System.out.println("1. 일반도우......16000원(20분)");
		System.out.println("2. 치즈 크러스트..20000원(30분)");
		System.out.println("3. 골드.........18000원(25분)");
		System.out.println("4. 바이트.......19000원(30분)");
		System.out.println("5. 리치 골드.....22000원(30분)");
		System.out.print(">>");
		int result=sc.nextInt();
		return result;
	}
	//토핑....
	private int selectTopping() {
		System.out.println("==========토핑==========");
		System.out.println("1. 콤비네이션...2000원(0분)");
		System.out.println("2. 페페로니.....1000원(2분)");
		System.out.println("3. 치즈........1000원(0분)");
		System.out.println("4. 포테이토.....2000원(1분)");
		System.out.println("5. 불고기......3000원(5분)");
		System.out.println("6. 고구마......4000원(6분)");
		System.out.println("7. 쉬림프......3000원(5분)");
		System.out.print(">>");
		int result =sc.nextInt();
		return result;
	}
	//사이트 선택
	private int selectSide() {
		System.out.println("==========사이드==========");
		System.out.println("1. 스파게티.....6000원(5분)");
		System.out.println("2. 감자튀김.....4000원(5분)");
		System.out.println("3. 윙.........6000원(5분)");
		System.out.println("4. 사이드 없음");
		System.out.print(">>");
		int result=sc.nextInt();
		return result;
	}
	private int selectDrink() {
		System.out.println("==========음료==========");
		System.out.println("1. 사이다......2000원(0분)");
		System.out.println("2. 콜라.......2000원(0분)");
		System.out.println("3. 환타.......1800원(0분)");
		System.out.println("4. 음료없음");
		System.out.print(">>");
		int result =sc.nextInt();
		return result;
	}
}
