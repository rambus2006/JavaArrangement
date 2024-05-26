package _010_2023_01_06_학생관리프로그램;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentHandler {
	Scanner scanner = new Scanner(System.in);
	List<Student> stuList = new ArrayList<Student>();
	public void studentSystem() {	  
      int num = 0;
      loop: while ( (num = studentMenu()) != 0) {     
	      switch (num) {
	        case 1:
	          add();            break;
	        case 2:
	          scoreAdd();       break;
	        case 3:
	          studentList();    break;
	        case 4:
	          studentDetail();  break;
	        case 5:
	          studentUpdate();  break;
	        case 6:
	          studentDelete();  break;
	        case 7:
	          firstPlace();     break;        
	        case 9:
	          teacherComment(); break;
	        case 0:
	          System.out.println("학생등록시스템 종료");
	          break loop;
	        default:
	          System.out.println("잘못된 명령입니다.");
	      }
	      System.out.println();
      }    
	}
      public int studentMenu() {
  	    System.out.println("**0번을 누르면 메인 창으로 이동됩니다.**");
  	    System.out.print("[1]학생 정보 입력"
  	            + " [2]학생 성적 입력"
  	            + " [3]학생 목록"
  	            + " [4]학생 상세 조회\n"
  	            + "[5]학생 정보 수정"
  	            + " [6]학생 정보 삭제"
  	            + " [7]1등은? "
  	            + " [8]꼴찌는? "
  	            + " [9]선생님 코멘트");
  	    int menu = scanner.nextInt(); 
  	    return menu;  	        
  	}
      
  private void scoreAdd() {
    System.out.println("[학생 성적 입력]");
    System.out.print("학생 번호? ");
    int no = scanner.nextInt(); 
    Student student = findByNo(no);

    if (student == null) {
      System.out.println("해당 번호의 학생이 없습니다.");
      return;
    }
    System.out.println("국어성적? ");
    student.setKor(scanner.nextInt());
    System.out.println("영어성적? ");
    student.setEng(scanner.nextInt());
    System.out.println("수학성적? ");
    student.setMath(scanner.nextInt());
    student.setSum(student.getKor(), student.getEng(), student.getMath());
  }
  //학생 정보 입력
  private void add() {
	  System.out.println("[학생 정보 입력]");
	  Student student = new Student();
	  while (true) {
		  System.out.println("학생 번호?(0 : 등록취소)");
		  int number = scanner.nextInt();
		  if (number == 0) {
			  System.out.println("학생 등록을 취소합니다.");
			  return;
		  } else if (this.indexOf(number) != 0) {
			  student.setNo(number);
			  break;
		  } else {
			  System.out.println("이미 등록된 학생번호입니다.");
		  }
	  }
	  System.out.println("학생 이름? ");
	  student.setName(scanner.next());
	  System.out.println("학생 성별? (1: 남자 / 2 : 여자)");
	  student.setGender(scanner.nextInt());
	  System.out.println("학생 학년? ");
	  String grade = scanner.next();
	  int num = Integer.parseInt(grade);
	  if (num < 0 || num > 4) {
		  System.out.println("잘못된 입력값입니다.");
		  return;
	  } else {
		  student.setGrade(grade);
	  }
	  student.setRegisteredDate(new Date(System.currentTimeMillis()));
	  stuList.add(student);
  	}

  	public void studentList() {
  		System.out.println("[학생 목록]");
  		System.out.println("**학년을 입력해주세요.**");
  		String grade = scanner.next();   

    	for (Student student : stuList) {
    		if (student.getGrade().equals(grade)) {
    	        String genderLabel = null;
    	        switch (student.getGender()) {
    	          case 1:
    	            genderLabel = "남자";
    	            break;
    	          case 2:
    	            genderLabel = "여자";
    	            break;
    	        }

    	        System.out.printf(
    	            "이름 : %s\n성별 : %s\n학년 : %s\n국어 : %d\n영어 : %d\n"
    	                + "수학 : %d\n합계 : %d\n평균 : %.1f\n등록일 : %s\n\n",
    	                student.getName(), genderLabel, student.getGrade(), student.getKor(), student.getEng(),
    	                student.getMath(), student.getSum(), student.getAver(), student.getRegisteredDate());
    	      }
		}
  }

  public void studentDetail() {
	  
	  System.out.println("[학생 상세 조회]");
	  System.out.println("학생 번호? ");
	  int no = scanner.nextInt(); 
	  Student student = findByNo(no);

	  if (student == null) {
		  System.out.println("해당 번호의 학생이 없습니다.");
		  return;
	  }

	  System.out.printf("번호 : %s\n", student.getNo());
	  System.out.printf("이름 : %s\n", student.getName());
	  String genderLabel = null;
	  switch (student.getGender()) {
      	case 1:
      		genderLabel = "남자";
      		break;
      	case 2:
      		genderLabel = "여자";
      		break;
	  }
	  System.out.printf("성별 : %s\n", genderLabel);
	  System.out.printf("학년 : %s\n", student.getGrade());
	  System.out.printf("국어 : %s\n", student.getKor());
	  System.out.printf("영어 : %s\n", student.getEng());
	  System.out.printf("수학 : %s\n", student.getMath());
	  System.out.printf("총합 : %s\n", student.getSum());
	  System.out.printf("평균 : %s\n", student.getAver());
	
	  if (student.getComment() != null) {
		  System.out.printf("코멘트 : %s\n", student.getComment());
	  }
  }

  public void studentUpdate() {
    System.out.println("[학생 정보 변경]");
    System.out.println("학생 번호? ");
    int no = scanner.nextInt(); 
    Student student = findByNo(no);

    if (student == null) {
      System.out.println("해당 번호의 학생이 없습니다.");
      return;
    }
    System.out.print("이름? ");     
    String name = scanner.next(); 
    System.out.print("학년? ");     
    String grade = scanner.next();
    System.out.print("국어? ");     
    int kor = scanner.nextInt();
    System.out.print("영어? ");     
    int eng = scanner.nextInt();
    System.out.print("수학? ");     
    int math = scanner.nextInt();    
    student.setSum(kor, eng, math);
    System.out.print("정말 변경하시겠습니까?(y/N)  ");  
    String response = scanner.next(); 
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("변경을 취소하였습니다.");
      return;
    }
    student.setName(name);
    student.setGrade(grade);
    student.setKor(kor);
    student.setEng(eng);
    student.setMath(math);
    student.getSum();
    System.out.println("학생 정보를 변경하였습니다.");
    System.out.println();
  }

  public void studentDelete() {
    System.out.println("[학생 정보 삭제]");
    System.out.print("번호? ");
    int no = scanner.nextInt(); 
    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 학생이 없습니다.");
      return;
    }
    System.out.print("정말 변경하시겠습니까?(y/N)  ");  
    String response = scanner.next();     
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("삭제 취소.");
      return;
    }
    stuList.remove(index);
    System.out.println("삭제 완료.");
    System.out.println();
  }

  public void firstPlace() {
    System.out.println("[1등 출력]");
    Iterator<Student> iterator = stuList.iterator();

    int[] first = new int[stuList.size()];
    int max = first[0];
    String name = null;
    while (iterator.hasNext()) {
      Student student = iterator.next();
      if (student.getSum() > max) {
        max = student.getSum();
        name = student.getName();
      }
    }

    System.out.printf("1등은? ==> %s : %d점\n", name, max);
    System.out.println("축하해요!");
    System.out.println();
   
  }

  public void bottomPlace() {
    System.out.println("[꼴지 출력]");
    Iterator<Student> iterator = stuList.iterator();
    int min = stuList.get(0).getSum();
    String name = stuList.get(0).getName();

    while(iterator.hasNext()) {
      Student student = iterator.next();
      if(student.getSum() < min) {
        min = student.getSum();
        name = student.getName();
      }
    }
    
    System.out.printf("꼴지 ==> %s : %d\n", name, min);
    System.out.println("이 학생은 격려가 필요합니다.");
    System.out.println();
  }

  private void teacherComment() {
    System.out.println("[선생님 코멘트]");
    System.out.print("코멘트 입력할 학생 번호? ");
    int no = scanner.nextInt(); 
    Student student = findByNo(no);

    if (student == null) {
      System.out.println("해당 번호의 학생이 없습니다.");
      return;
    }
    System.out.print("한줄 코멘트를 입력하세요.\n ");
    String comment = scanner.next(); 
    student.setComment(comment);
  }

  private Student findByNo(int no) {
    for (int i = 0; i < stuList.size(); i++) {
      Student student = stuList.get(i);
      if (student.getNo() == no) {
        return student;
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < stuList.size(); i++) {
      Student student = stuList.get(i);
      if (student.getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
