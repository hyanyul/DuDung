package GamePlay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogSave {
    
    // 게임 로그 저장
    public void logSave(String ID, String[] getChar, int[] getStatus){
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "ADAM";
            String password = "1234";

            conn = DriverManager.getConnection(url, user, password);
            
            // 게임 중 변경된 스텟을 db에 저장
            String sql = "UPDATE GAME_CHARACTER SET HP = ?, NOWHP = ?, MP = ?, " +
                         "NOWMP = ?, CP = ?, NOWCP = ?, \"EXP\" = ?, \"LEVEL\" = ?, PROGRESS = ? " +
                         "WHERE ID = ? AND NICKNAME = ?";

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, getStatus[0]);
            pstm.setInt(2, getStatus[1]);
            pstm.setInt(3, getStatus[2]);
            pstm.setInt(4, getStatus[3]);
            pstm.setInt(5, getStatus[4]);
            pstm.setInt(6, getStatus[5]);
            pstm.setInt(7, getStatus[6]);
            pstm.setInt(8, getStatus[7]);
            pstm.setInt(9, getStatus[8]);

            pstm.setString(10, ID);
            pstm.setString(11, getChar[0]);

            int res = pstm.executeUpdate();
            
            if (res>0) {
                System.out.println("자동 저장 성공");
            } else {
                System.out.println("자동 저장 실패");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                pstm.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
