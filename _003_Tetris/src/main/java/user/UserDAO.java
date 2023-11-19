//package user;
//
////https://www.youtube.com/watch?v=RYo3OGlRoJw 이부분
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class UserDAO {
//    private Connection conn; //데이터 베이스에 참여할 수 있게 해주는 객체
//    private PreparedStatement pstmt;
//    private ResultSet rs;//정보를 담을 수 있는 객체
//
//    //생성자(mysql 에 접속하게 해주는 부분)
//    public UserDAO(){
//        try{
//            String dbURL="jdbc:mysql://localhost:3306/java_db";
//            String dbId="root";
//            String dbPassword="111111";
//            Class.forName("com.mysql.jdbc.Driver");
//            conn= DriverManager.getConnection(dbURL,dbId,dbPassword);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    // ? 에는 userId 를 사용
//    public int login(String userId,String userPassword){
//        String SQL="SELECT userPassword FROM USER WHERE userId = ?";
//        try{
//            pstmt=conn.prepareStatement(SQL);
//            pstmt.setString(1,userId);
//            rs=pstmt.executeQuery();
//            if(rs.next()){
//                if(rs.getString(1).equals(userPassword)){
//                    return 1; //로그인 성공
//                }else
//                    return 0; //비밀번호 불일치
//            }
//            return -1; //아이디가 없음
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return -2; //db 오류
//    }
//
//
//}
//
//
