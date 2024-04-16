package Members;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;
import java.sql.*;


public class SignIn {

    private String signInId;
    private String signInPw;

    public String getSignInId() {
        return signInId;
    }

    public void setSignInId(String signInId) {
        this.signInId = signInId;
    }

    public String getSignInPw() {
        return signInPw;
    }

    public void setSignInPw(String signInPw) {
        this.signInPw = signInPw;
    }

    public static String inputId(){
        Scanner sc = new Scanner(System.in);

        System.out.print("[로그인] 아이디를 입력하세요: ");

        return sc.nextLine();
    }

    public static String inputPw(){
        Scanner sc = new Scanner(System.in);

        System.out.print("[로그인] 비밀번호를 입력하세요: ");

        return sc.nextLine();
    }

    public String[] signIn(){
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            System.out.println("JDBC 로드 성공");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "ADAM";
            String password = "1234";

            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("DB 연결 성공");

            String sql = "SELECT * FROM MEMBERS";

            st = conn.createStatement();
            rs = st.executeQuery(sql);

            String id = inputId();
            String pw = inputPw();

            while (rs.next()){
                String checkId = rs.getString("ID");
                String checkPw = rs.getString("PW");

                if(checkId.equals(id) && checkPw.equals(pw)){
                    String[] signInArr = new String[2];
                    System.out.println("로그인 성공");
                    signInArr[0] = id;
                    signInArr[1] = pw;
                    return signInArr;
                }
            }
            System.out.println("로그인 실패");
            System.out.println("존재하지 않는 계정이거나 잘못 입력하였습니다.");


            return new String[2];
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                Objects.requireNonNull(st).close();
                Objects.requireNonNull(rs).close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
