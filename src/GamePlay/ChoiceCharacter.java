package GamePlay;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ChoiceCharacter {
    Scanner sc = new Scanner(System.in);

    public String[] choiceChar(String id) {
        ArrayList<String> charNickNameArr = checkChar(id);

        System.out.println("플레이할 캐릭터의 번호를 입력하세요: ");
        int choice = sc.nextInt() - 1;
        sc.nextLine();

        return checkChar(id, charNickNameArr.get(choice));
    }

    public static ArrayList<String> checkChar(String id) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        ArrayList<String> charNickNameArr = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            System.out.println("JDBC 로드 성공");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "ADAM";
            String password = "1234";

            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("DB 연결 성공");

            String sql = "SELECT * FROM GAME_CHARACTER";

            st = conn.createStatement();
            rs = st.executeQuery(sql);

            int i = 1;

            while (rs.next()) {
                String ID = rs.getString("ID");

                if (ID.equals(id)) {
                    String nickName = rs.getString("NICKNAME");
                    String tribe = rs.getString("TRIBE");
                    String job = rs.getString("JOB");

                    charNickNameArr.add(nickName);
                    System.out.printf("%d. 이름: %s | 종족: %s | 직업: %s\n", i, nickName, tribe, job);

                    i++;
                }
            }
            return charNickNameArr;
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

    public static String[] checkChar(String inputId, String inputNickName) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        String[] choiceChar = new String[3];

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            System.out.println("JDBC 로드 성공");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "ADAM";
            String password = "1234";

            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("DB 연결 성공");

            String sql = "SELECT * FROM GAME_CHARACTER";

            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String ID = rs.getString("ID");
                String nickName = rs.getString("NICKNAME");

                if (ID.equals(inputId) && nickName.equals(inputNickName)) {
                    String tribe = rs.getString("TRIBE");
                    String job = rs.getString("JOB");

                    choiceChar[0] = nickName;
                    choiceChar[1] = tribe;
                    choiceChar[2] = job;

                    System.out.printf("이름: %s | 종족: %s | 직업: %s 선택 완료\n", nickName, tribe, job);
                }
            }

            return choiceChar;

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