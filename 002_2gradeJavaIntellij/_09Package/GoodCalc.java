package _09Package;

abstract class Calculator2{ //abstract 추상 클래스
    public abstract int add(int a,int b); //추상 메서드 선언
    public abstract int substract(int a,int b); //추상 메서드 선언
    public abstract double average(int[]a); //추상 메서드 선언 (abstract붙어 있으니까)
}
public class GoodCalc extends Calculator2 { //상속
    public int add(int a,int b){
        return a+b;
    } //추상 메서드 구현
    public int substract(int a,int b){
        return a-b;
    } //추상메서드 구현
    public double average(int[]a){ //추상 메서드 구현
        double sum=0;
        for(int i=0;i<a.length;i++)
            sum +=a[i];
        return sum/a.length; //평균 값 구하기
    }

    public static void main(String[] args) {
        Calculator2 c = new GoodCalc(); //Calculator타입의 변수 c를 GoodCalc객체 만듬
        System.out.println(c.add(2,3)); //add 메서드 실행
        System.out.println(c.substract(2,3)); //substract메서드 실행
        System.out.println(c.average(new int[]{2,3,4})); //무명 배열(1번만 실행 가능)
    }
}
/*[추상 메서드와 추상 클래스 ]
<추상 클래스>
* 1. 추상 메소드를 하나라도 가진 클래스
* 2. 추상 메소드가 없지만 abstract로 선언된 클래스
* 3. 객체를 생성할 수 없다.
* 4. 상속 :
*       1) 단순 상속:추상클래스를 상속 받아, 추상 메소드를 구현하지 않으면 추상클래스가 된다. 서브 클래스도 abstract로 선언해야 한다.
*       2) 추상클래스 구현 상속: 서브 클래스에서 슈퍼 클래스의 추상 메소드를 구현(오버라이딩), 이때 서브 클래스는 추상 클래스가 아니다.
* 5. 용도: -슈퍼클래스에서는 개념정의(서브 클래스마다 다른 구현이 필요한 메소드는 추상메소드로 선언한다.
*         -각 서브 클래스에서 구체적 행위 구현(서브 클래스마다 목적에 맞게 추상 메소드 다르게 구현한다. )
*         - 계층적 상속 관계를 클래스 구조를 만들 때 쓰인다.
<추상메소드>
1. abstract키워드를 사용해서 정의한 클래스를 추상 클래스라고 한다.
2. 구현 내용이 없는 메소드
3. 서브 클래스에서 오버라이딩 하여 구현해야 한다.

[상속]
1. 기존에 존재하는 클래스에 기능을 추가하거나 재정의하여 새로운 클래스를 정의하는 것
2. 클래스의 다중 상속을 지원하지 않기 때문에 한번에 하나의 클래스만 상속받을 수 있음
3. 상속 횟수는 무제한이며,상속의 최상위 조상 클래스는 java.lang.Object클래스이다. (모든 클래스는 자동으로 java.lang.Object를 상속 받고, 자바 컴파일러에 의해 자동으로 된다._)
4. 상수를 정의하기 위해서 사용하는 final 키워드를 클래스 앞에 붙이면 상속이 불가능한 클래스를 정의할 수 있다.
5. 부모클래스=슈퍼클래스/자식클래스=서브 클래스
6. extends키워드 사용: 슈퍼 클래스를 확장한다는 의미

<장점>
-클래스의 간결화(멤버 변수의 중복 작성 불필요)
-클래스 관리 용이(클래스들의 계층적 분류)
-소프트웨어의 생산성 향상(클래스의 재사용과 확장 용이/새로운 클래스의 작성속도 빠름)
* */