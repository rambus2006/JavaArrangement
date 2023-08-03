package Main_방민서_2305;//2305 방민서

abstract class Animal{
    private String name;
    public Animal(String name){
        name = this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
interface Barkable {
    public void bark();
}
 class Dog extends Animal implements Barkable{

     public Dog(String name) {
         super(name);
         System.out.println(name +  "가 짖습니다. ");
     }
     @Override
     public void bark() {

     }
 }

 //문제 2
interface Chargable{
    public void charge();
 }
 interface Playable{
     public void play();
 }
 interface MusicDevice extends Chargable,Playable{

 }
 class MP3Player implements MusicDevice{
    public void charge(){
        System.out.println("충전중입니다.");
    }
    public void play(){
        System.out.println("음악을 재생합니다.");
    }
 }
 //문제3
 abstract class Employee{
    double wage;
     public void setWage(double wage) {
         this.wage = wage;
     }
 }
 abstract class WageCalculable extends Employee{
     public abstract double calculateTotalWage(int totalHours);
 }
 class Developer extends WageCalculable{
     public double calculateTotalWage(int totalHours){
         return wage*totalHours;
     }
 }
 class AdvancedDeveloper extends WageCalculable{
    public double calculateTotalWage(int totalHours){
         return (wage*totalHours)*2;
     }
 }
//문제4
class PrintInput{
    private String content;

    public PrintInput(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
interface Printable{
    public void print();
}
class InkjetPrinter extends PrintInput implements Printable{

    public InkjetPrinter(String content) {
        super(content);
    }
    public void print() {
        System.out.println("잉크젯프린터로" + getContent() + "프린트 합니다.");
    }
}
class LaserPrinter extends PrintInput implements Printable{

    public LaserPrinter(String content) {
        super(content);
    }
    public void print() {
        System.out.println("레이저프린터로" + getContent() + "프린트 합니다.");
    }
}

 //Main
public class Main_방민서_2305 {
    public static void main(String[] args) {
        Dog d = new Dog("복순이");
        d.bark();

        MP3Player player = new MP3Player();
        player.charge(); // "충전중입니다." 출력
        player.play(); // "음악을 재생합니다." 출력

        Developer dev = new Developer();
// 세터 메서드로 시급 설정 및 변경 가능
        dev.setWage(1000);
        AdvancedDeveloper aDev = new AdvancedDeveloper();
        aDev.setWage(2000);
// 1000 * 10 * 1 = 10000 이므로, 10000.0 출력
        double devWage = dev.calculateTotalWage(10);
        System.out.println(devWage);
// 2000 * 10 * 2 = 40000 이므로, 40000.0 출력
        double aDevWage = aDev.calculateTotalWage(10);
        System.out.println(aDevWage);

        //문제4
        PrintInput input = new PrintInput("=== 인쇄 내용 1 ===");
// InkjetPrinter, LaserPrinter 타입의 두 객체가 포함된 Printable 배열을 정의하고
        Printable[] printables = new Printable[2];
        for(int i =0;i<2; i++){
            printables[i].print();
        }

// 반복문을 통해 위의 input 객체를 전달받아서 print 메서드를 출력하도록 코드 작성
    }

 }
