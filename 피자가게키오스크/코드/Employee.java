package _009_2023_01_05_kiosk;
//직원
public class Employee {
	private String nickname;
	
	public Employee() {}
	public Employee(String nickname) {
		this.nickname=nickname;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "Employee [nickname=" + nickname + "]";
	}
	public void sayWelcome() {
		System.out.println(nickname+" 안녕하세요?미림 피자가게입니다.주문은 키오스크에서 진행해주세요");
	}
}
