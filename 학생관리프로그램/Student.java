package _010_2023_01_06_학생관리프로그램;

import java.sql.Date;

public class Student {
  //필드
  private int no; //학번
  private String name; //이름
  private int gender; //성별
  private String grade;  //
  private int kor; //국어  
  private int eng; //영어
  private int math; //수학
  private int sum; //합계
  private double  aver; //평균
  private String comment; //선생님 입력하는 내용 (잔소리) 
  private Date registeredDate; //등록일 
  //생성자 추가
  public Student() {}
  public Student(int no, String name,String grade,int kor,int eng,int math,
		  int sum,double  aver,String comment,Date registeredDate) {
	  this.no = no;
	  this.name = name;
	  this.grade = grade;
	  this.kor = kor;
	  this.eng = eng;
	  this.math = math;
	  this.sum = sum;
	  this.aver = aver;
	  this.comment = comment;
	  this.registeredDate = registeredDate; 
  }
  private static final int LENGTH = 5;  //상수 선언 
  //getter, setter 
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int kor, int eng, int math) {
    sum = kor+eng+math;
    aver = sum/3.f;
  }

  public void setAver(float aver) {
    this.aver = aver;
  }

  public double getAver() {
    return aver;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public int getKor() {
    return kor;
  }

  public void setKor(int kor) {
    this.kor = kor;
  }

  public int getEng() {
    return eng;
  }

  public void setEng(int eng) {
    this.eng = eng;
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    this.math = math;
  }

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

  public static int getLength() {
    return LENGTH;
  }



}