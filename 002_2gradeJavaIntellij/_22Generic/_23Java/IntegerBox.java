package _22Generic._23Java;

//정수 타입을 저장하기 위한 IntegerBox클래스
public class IntegerBox {
    private Integer value; //Number클래스 int타입을 하나의 객체로 만들어준다.
    public void set(Integer value){
        this.value = value;
    }
    public Integer get(){
        return value;
    }
}
