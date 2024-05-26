package _009_2023_01_05_kiosk;

public class Order {
	
	//1.필드
	boolean isTakeOut;
	int dough;
	int topping;
	int side;
	int drink;
	int price;
	int time;
	
	//2.생성자
	public Order() {}
	public Order(boolean isTakeOut,int dough,int topping,int side,int drink,int price,int time) {
		this.isTakeOut=isTakeOut;
		this.dough=dough;
		this.topping=topping;
		this.side=side;
		this.drink=drink;
		this.price=price;
		this.time=time;
	}
	static int totalPrice=0;
	static int totalTime=0;
	static int sum=0;
	
	public int addPrice(int price) {
		
		sum=sum+price;
		return sum;
	}
	public int addTime(int time) {
		totalTime=totalTime+time;
		return totalTime;
	}
	public boolean isTakeOut() {
		return isTakeOut;
	}
	public void setTakeOut(boolean isTakeOut) {
		this.isTakeOut = isTakeOut;
	}
	public int getDough() {
		return dough;
	}
	public void setDough(int dough) {
		this.dough = dough;
	}
	public int getTopping() {
		return topping;
	}
	public void setTopping(int topping) {
		this.topping = topping;
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	public int getDrink() {
		return drink;
	}
	public void setDrink(int drink) {
		this.drink = drink;
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
