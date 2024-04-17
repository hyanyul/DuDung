package Members;

import java.sql.*;
import java.util.Scanner;

public class SignUp {
    public void signUp(){       // 회원가입 - 아이디와 비밀번호 입력 받아서 db에 저장
        String inputId = inputId(); 
        String inputPw = inputPw();

        if(inputId != null && inputPw != null) {
            inputDB(inputId, inputPw);
        } else {
            System.out.println("아이디와 비밀번호는 최대 30바이트로 입력 가능합니다.");
        }
    };

    public static String inputId(){     // 아이디 입력
        Scanner sc = new Scanner(System.in);

        System.out.print("[회원가입] 사용할 ID를 입력하세요: ");
        String id = sc.nextLine();

        if (id.getBytes().length <= 30) {
            return id;
        } else {
            return null;
        }
    };

    public static String inputPw(){         // 비밀번호 입력
        Scanner sc = new Scanner(System.in);

        System.out.print("[회원가입] 사용할 PW를 입력하세요: ");
        String pw = sc.nextLine();

        if (pw.getBytes().length <= 30) {
            return pw;
        } else {
            return null;
        }
    }

    public static void inputDB(String inputId, String inputPw){     // DB에 회원정보 저장
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");   // jdbc 연결
//            System.out.println("JDBC Driver 로드 성공");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "ADAM";
            String pw = "1234";

            conn = DriverManager.getConnection(url, user, pw);  // db 로드
//            System.out.println("DB 연결 성공");

            String sql = "INSERT INTO MEMBERS VALUES (?, ?)";

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, inputId);
            pstm.setString(2, inputPw);

            try {
                int res = pstm.executeUpdate();

                if (res > 0) {
                    System.out.println("입력 성공");
                    System.out.printf("[회원가입] 'ID: %s, PW: %s' 가 가입되었습니다.\n", inputId, inputPw);
                } else {
                    System.out.println("입력 실패");
                }
            } catch (SQLIntegrityConstraintViolationException e){
                System.out.println("이미 존재하는 계정입니다.");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            try {
                pstm.close();
                conn.close();
//                System.out.println("DB 연결 해제");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
