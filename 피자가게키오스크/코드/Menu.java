package _009_2023_01_05_kiosk;
/*
 * UML : 시스템을 모델로 표현해주는 대표적인 모델링 언어
 * UML다이어그램의 종류: 1. 구조 다이어그램 : 클래스 다이어그램, 객체 다이어그램, 복합체 다이어그램,배치 다이어그램, 컴포넌트 다이어그램,패키지 다이어그램
 * 					 2. 행위다이어그램 : 활동다이어그램,상태머신 다이어그램,유즈 케이스 다이어그램, 상호작용다이어그램
 */
public class Menu {
	private int price;
	private int time;

	public Menu() {}
	public Menu(int price,int time) {
		this.price=price;
		this.time=time;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}

//도우
class Normal extends Menu{
	public Normal() {
		super(16000,20);
	}
}
class CheeseCrust extends Menu{
	public CheeseCrust() {
		super(20000,30);
	}
}
class Gold extends Menu{
	public Gold() {
		super(18000,25);
	}
}
class Bite extends Menu{
	public Bite() {
		super(19000,30);
	}
}
class RichGold extends Menu{
	public RichGold() {
		super(22000,30);
	}
}
//토핑
class Combination extends Menu{
	public Combination() {
		super(2000,0);
	}
}
class peperoni extends Menu{
	public peperoni() {
		super(1000,2);
	}
}
class Cheese extends Menu{
	public Cheese() {
		super(1000,0);
	}
}
class potato extends Menu{
	public potato() {
		super(2000,1);
	}
}
class Bulgogi extends Menu{
	public Bulgogi() {
		super(3000,5);
	}
}
class SweetPotato extends Menu{
	public SweetPotato() {
		super(4000,6);
	}
}
class Shrimp extends Menu{
	public Shrimp() {
		super(3000,0);
	}
}

//사이드
class Spaghetti extends Menu{
	public Spaghetti() {
		super(6000,5);
	}
}
class Potatochips extends Menu{
	public Potatochips() {
		super(4000,5);
	}
}

class Wing extends Menu{
	public Wing() {
		super(6000,5);
	}
}
class Cidar extends Menu{
	public Cidar() {
		super(2000,0);
	}
}
class Cola extends Menu{
	public Cola() {
		super(2000,0);
	}
}
class Fanta extends Menu{
	public Fanta() {
		super(1800,0);
	}
}