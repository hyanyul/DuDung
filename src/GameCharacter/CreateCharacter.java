package GameCharacter;

import java.sql.*;
import java.util.Scanner;
import Members.*;

public class CreateCharacter {
    public void createChar(String inputId){
        SignIn si = new SignIn();

        String nickName = inputNickName();
        String tribe = inputTribe();
        String job = inputJob();
        inputChar(inputId, nickName, tribe, job);
    }

    public static String inputNickName(){
        Scanner sc = new Scanner(System.in);

        System.out.println("[캐릭터 생성] 캐릭터 이름을 설정해주세요: ");
        String inputNickName = sc.nextLine();

        return inputNickName;
    }

    public static String inputTribe(){
        Scanner sc = new Scanner(System.in);

        System.out.println("[캐릭터 생성] 종족을 입력해주세요: ");
        String inputTribe = sc.nextLine();

        return inputTribe;

    }

    public static String inputJob(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("[캐릭터 생성] 직업을 선택하세요(1. 방패병 / 2. 검사 / 3. 법사): ");
            int inputJob = sc.nextInt();
            sc.nextLine();

            if(inputJob == 1){
                return "방패병";
            } else if(inputJob == 2){
                return "검사";
            } else if (inputJob == 3) {
                return "법사";
            } else{
                System.out.println("선택지 중에서 선택해주세요.");
            }
        }
    }

    public static void inputChar(String id, String nickName, String tribe, String job){
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

            String sql = "INSERT INTO GAME_CHARACTER VALUES (?, ?, ?, ?)";

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.setString(2, nickName);
            pstm.setString(3, tribe);
            pstm.setString(4, job);

            int res = pstm.executeUpdate();

            if(res > 0){
                System.out.println("입력 성공");
            } else{
                System.out.println("입력 실패");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
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

    public static void checkJob(){

    }
}
