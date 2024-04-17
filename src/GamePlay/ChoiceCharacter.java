package GamePlay;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ChoiceCharacter {
    Scanner sc = new Scanner(System.in);

    // 플레이할 캐릭터 선택
    public String[] choiceChar(String id, String fucn) {
        try {
            ArrayList<String> charNickNameArr = checkChar(id);

            System.out.printf("\n%s할 캐릭터의 번호를 입력하세요: ", fucn);
            int choice = sc.nextInt() - 1;
            sc.nextLine();

            return checkChar(id, charNickNameArr.get(choice));
        } catch (Exception e){
            System.out.println("선택지 중 하나를 선택해주세요.");
            return new String[3];
        }
    }

    // 로그인된 계정에서 만든 캐릭터 목록 출력 및 닉네임 어레이리스트 생성
    // 어레이리스트(플레이어가 캐릭터 선택하면 선택한 닉네임과 로그인되어 있는 아이디로 캐릭터 찾을 수 있도록 하는 용도)
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
            
            // 전체 캐릭터 목록 불러옴
            String sql = "SELECT * FROM GAME_CHARACTER";

            st = conn.createStatement();
            rs = st.executeQuery(sql);

            int i = 1;
            System.out.println("\n[캐릭터 목록]");
            while (rs.next()) {
                String ID = rs.getString("ID");
                
                // 현재 입력되어 있는 아이디와 같은 캐릭터만 불러옴
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

    // 선택한 캐릭터의 닉네임과 로그인된 아이디를 활용해 선택한 캐릭터의 스텟을 전부 불러오는 메소드
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
    
    // db에 저장된 스텟 받아옴
    public int[] getStatus(String inputId, String inputNickName) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int[] charStatus = new int[9];

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
                    int HP = rs.getInt("HP");
                    int nowHP = rs.getInt("NOWHP");
                    int MP = rs.getInt("MP");
                    int nowMP = rs.getInt("NOWMP");
                    int CP = rs.getInt("CP");
                    int nowCP = rs.getInt("NOWCP");
                    int exp = rs.getInt("EXP");
                    int level = rs.getInt("LEVEL");
                    int progress = rs.getInt("PROGRESS");

                    charStatus[0] = HP;
                    charStatus[1] = nowHP;
                    charStatus[2] = MP;
                    charStatus[3] = nowMP;
                    charStatus[4] = CP;
                    charStatus[5] = nowCP;
                    charStatus[6] = exp;
                    charStatus[7] = level;
                    charStatus[8] = progress;


                    System.out.println("\n캐릭터 정보 로드 완료\n");
                }
            }

            return charStatus;

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