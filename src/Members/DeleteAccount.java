package Members;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAccount {
    public void deleteAccount(String inputId, String inputPw){
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");   // jdbc 연결
            System.out.println("JDBC Driver 로드 성공");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "ADAM";
            String pw = "1234";

            conn = DriverManager.getConnection(url, user, pw);  // db 로드
            System.out.println("DB 연결 성공");

            String sql = "DELETE FROM MEMBERS " +
                    "WHERE ID = ? AND PW = ?";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, inputId);
            pstm.setString(2, inputPw);


            int res = pstm.executeUpdate();

            if(res > 0){
                System.out.println("계정을 삭제했습니다.\n");
            } else{
                System.out.println("삭제 실패\n");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally{
            try {
                pstm.close();
                conn.close();
                System.out.println("DB 연결 해제");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
