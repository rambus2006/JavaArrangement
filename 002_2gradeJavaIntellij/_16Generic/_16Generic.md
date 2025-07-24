<aside>
🌑 제네릭의 정의

</aside>

- 타입을 파라미터화 하는 것을 제네릭이라고 한다.

<aside>
🌒

제네릭 클래스 

</aside>

- 임의의 값을 저장하고 꺼내올 수 있는 Box라는 클래스를 작성할 때
    - 클래스에서 제공하는 set메서드를 통해 값을 저장하고 get을 통해 가져올 수 있어야 한다.
    
    ```java
    //정수 타입을 저장하기 위한 IntegerBox클래스
    public class IntegerBox {
        private Integer value; //[Number클래스](https://www.notion.so/Object-Wrapper-bb0dc865aa5f4fcaae27f2ea0fe97904?pvs=21) int타입을 하나의 객체로 만들어준다. 
        public void set(Integer value){
            this.value = value;
        }
        public Integer get(){
            return value;
        }
    }
    ```
    
    ```java
    // 실수 타입을 저장하기 위한 DoubleBox
    class DoubleBox {
        private Double value; //Number클래스 
        public void set(Double value) { 
            this.value = value;
        }
        public Double get() { 
            return value; 
        }
    }
    ```
    
    ```java
    // 문자열 타입을 저장하기 위한 StringBox
    class StringBox { /* ... */ }
    // 프로그래머가 직접 작성한 Student 타입을 저장하기 위한 StudentBox
    class StudentBox { /* ... */ }
    // ... 기타 여러 Box들 정의 필요
    ```
    
    > 타입을 Object로 바꾼 Box클래스 작성해보기
    > 
    
    ```java
    class ObjectBox {
        private Object value;
        public void set(Object object) { 
            this.value = value;
        }
        public Object get() {
            return value; 
        }
    }
    //단점) 반환된 Object 객체를 다시 원하는 타입으로 다운캐스팅을 통해서 타입 변환해야 하며, 
    //이때 예외(ClassCastException)가 발생할 가능성이 존재함
    ```
    
    > 제네릭 기술을 사용한 Box클래스 작성해보기
    > 
    
    ```java
    class GenericBox<T> {
        private T value;
        public void set(T object) { 
            this.value = value;
        }
        public T get() {
            return value; 
        }
    }
    ```
    
    - 활용
        
        ```java
        // Integer 타입을 저장할 Box 객체 생성
        GenericBox<Integer> integerBox = new GenericBox<Integer>();
        
        // 컴파일 타임에 타입 검사가 진행되므로 숫자만 받게 됨
        integerBox.set(10);
        // 밑의 코드는 타입이 String이므로 컴파일 타입에 오류로 인식됨
        // integerBox.set("String");
        
        // 컴파일 타임에 타입 검사가 진행되므로 숫자 타입을 반환하게 됨
        Integer value = integerBox.get();
        // 밑의 코드는 반환 받을 값의 타입이 String이므로 컴파일 타입에 오류로 인식됨
        // String sValue = integerBox.get();
        
        // Double 타입을 저장할 Box 객체 생성
        GenericBox<Double> doubleBox = new GenericBox<Double>();
        // 자바 1.7부터 뒤에 있는 다이아몬드 연산자(<>) 내부 타입은 생략 가능 
        GenericBox<String> stringBox = new GenericBox<>();
        
        // 타입 지정을 하지 않는 경우 raw 타입으로 지정됨 => Object처럼 동작한다고 생각하기
        // (하위호환성을 위해서 남겨놓는 기능이므로 쓰지 말 것, 항상 제네릭 타입을 지정)
        GenericBox rawBox = new GenericBox();
        rawBox.set("Hello");
        rawBox.set(1);
        rawBox.set(2.0);
        //컴파일 타임에 타입 검사가 진행되므로 타입에 더 안전하게 프로그래밍 가능하며
        //ClassCastException을 방지하는 효과가 있음
        여러 타입을 지정 가능
        ```