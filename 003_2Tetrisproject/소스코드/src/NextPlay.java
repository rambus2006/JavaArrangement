import java.util.Random;
/**
 * ��� ���� ������ ������ ����Ǹ� ȣ��Ǿ� ������ ����� ������ ���� Ŭ�����Դϴ�.
 * <br> Order ��� enum Ŭ������ ������ ��� ��� ����(����, ����, �ݺ�)�� �����ϰ�
 * <br> Order ��ü�� playOrder ����Ͽ� �������, �������, �ݺ������ ����� �����մϴ�.
 * <br> playOrder�� enum ��ü�� 
 * <br> �������� ���¸� ��Ÿ���� STRAIGHT, RANDOM, REPLAY ��� ����� �����ϴ�.
 * <br> �ڼ��� ������ �ҽ��ڵ��� �ּ��� �������ּ���.
 * 
 * @author jihun
 * @since JDK 1.6
 */
public class NextPlay {
	enum Order{STRAIGHT, RANDOM, REPLAY}
	public static Order playOrder = Order.STRAIGHT;

	NextPlay() {
		if(playOrder.equals(Order.STRAIGHT)) {  		 // 1.�������
			PlayList.nextFile();
		}
		else if(playOrder.equals(Order.RANDOM)) {  		 // 2.�������
			if(PlayList.getListSize() == 1) {
			}
			else {   // �� ���� �� �ݺ� ����
				Random random = new Random();
				int n = random.nextInt(PlayList.getListSize());
				while(n == PlayList.getplayNo()) {
					n = random.nextInt(PlayList.getListSize());
				}
				PlayList.setplayNo(n);
			}
		}
		else if(playOrder.equals(Order.REPLAY)) {   	 // 3.�ݺ����
		}
	}
}