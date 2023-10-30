import java.util.Random;
/**
 * 재생 중인 음악이 끝까지 재생되면 호출되어 다음에 재생할 음악을 고르는 클래스입니다.
 * <br> Order 라는 enum 클래스를 가지고 재상 방식 상태(순차, 랜덤, 반복)을 정의하고
 * <br> Order 객체인 playOrder 사용하여 순차재생, 임의재생, 반복재생을 기능을 실행합니다.
 * <br> playOrder는 enum 객체로 
 * <br> 재생방식의 상태를 나타내는 STRAIGHT, RANDOM, REPLAY 라는 상수를 갖습니다.
 * <br> 자세한 내용은 소스코드의 주석을 참고해주세요.
 * 
 * @author jihun
 * @since JDK 1.6
 */
public class NextPlay {
	enum Order{STRAIGHT, RANDOM, REPLAY}
	public static Order playOrder = Order.STRAIGHT;

	NextPlay() {
		if(playOrder.equals(Order.STRAIGHT)) {  		 // 1.순차재생
			PlayList.nextFile();
		}
		else if(playOrder.equals(Order.RANDOM)) {  		 // 2.임의재생
			if(PlayList.getListSize() == 1) {
			}
			else {   // ※ 같은 곡 반복 금지
				Random random = new Random();
				int n = random.nextInt(PlayList.getListSize());
				while(n == PlayList.getplayNo()) {
					n = random.nextInt(PlayList.getListSize());
				}
				PlayList.setplayNo(n);
			}
		}
		else if(playOrder.equals(Order.REPLAY)) {   	 // 3.반복재생
		}
	}
}