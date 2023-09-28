package _16Generic;

//VectorExample의 객체클래스
//객체(object) :
/* - 존재하는 사물 혹은 개념, 논리와 같은 무형적인 것들도 객체라 정의할 수 있다.
*  - 예를 들어 사람, 차, 책등 물리적으로 존재하는 것과 개념적인 주문, 계산등도 객체가 될 수 있다.
*  - 객체는 각각 독립적으로 존재하며 다른 객체와 상호작용을 할 수 있다.
*  - 자바에서는 클래스에서 생성된 데이터를 객체로 정의한다.
*/
public class Board {
    String subject;
    String content;
    String writer;

    public Board(String subject, String content, String writer){
        this.subject = subject;
        this.content = content;
        this.writer = writer;
    }
}
