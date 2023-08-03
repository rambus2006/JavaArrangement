//package _21Comparable인터페이스;
//
//public class Student implements Comparable<Student>{
//    public int id;
//    public String name;
//    public double grade;
//
//    public Student(int id,String name,double grade){
//        this.id=id;
//        this.name=name;
//        this.grade=grade;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getGrade() {
//        return grade;
//    }
//
//    public void setGrade(double grade) {
//        this.grade = grade;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", grade=" + grade +
//                '}';
//    }
//
//
//    public int ccompareTo(Student o){
//        return this.name.compareTo(o.name);
//    }
//    @Override
//    public int compareTo(Student o) {
//        return this.id-o.id;
//    }
//}
//class ArrayListDemo{
//
//}
