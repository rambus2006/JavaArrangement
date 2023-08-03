package _07AbstractMethod;

/*추상 메소드 없는 추상 클래스 */
public abstract class MyComponent { //추상 클래스 선언
    String name;
    public void load(String name){
        this.name = name;
    }
}
