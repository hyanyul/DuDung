package GameCharacter;

import java.sql.*;
import java.util.Scanner;
import Members.*;

public class CreateCharacter {
    public void createChar(String inputId){     // 캐릭터 생성
        SignIn si = new SignIn();
        
        // 메서드를 통해 필요한 정보 입력받음
        String nickName = inputNickName();
        String tribe = inputTribe();

        if (nickName.getBytes().length <= 30 || tribe.getBytes().length <= 30) {
            System.out.println("닉네임과 종족명은 최대 30바이트로 입력 가능합니다.");
            return;
        }

        String job = inputJob();
    
        // 동일 계정에 같은 닉네임을 가진 캐릭터가 있는지 확인
        boolean check = checkNickname(inputId, nickName);

        if (!check) {
            // 생성된 캐릭터를 db에 넣음
            inputChar(inputId, nickName, tribe, job);
        } else {
            System.out.println("동일한 계정에 같은 닉네임의 캐릭터가 있습니다.");
        }
    }

    // 기존에 스토리를 진행했던 캐릭터로 처음부터 하기를 누를 경우 캐릭터 스텟 리셋하는 역할
    // 새로운 캐릭터를 만들지 않고 기존 캐릭터의 정보만 수정함
    public void resetChar(String inputId, String[] getChar){
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "ADAM";
            String password = "1234";

            conn = DriverManager.getConnection(url, user, password);
            
            // 테이블에 캐릭터 정보 수정하는 역할의 sql문
            // level과 exp의 경우 예약어라 컬럼명으로 인식되지 않는 문제 발생 -> ""로 묶음
            String sql = "UPDATE GAME_CHARACTER SET HP = ?, NOWHP = ?, MP = ?, " +
                    "NOWMP = ?, CP = ?, NOWCP = ?, \"EXP\" = ?, \"LEVEL\" = ?, progress = ? " +
                    "WHERE ID = ? AND NICKNAME = ?";

            pstm = conn.prepareStatement(sql);
            
            // 직업에 따라 스텟 다름
            if (getChar[2].equals("방패병")){
                pstm.setInt(1, 140);
                pstm.setInt(2, 140);
                pstm.setInt(3, 90);
                pstm.setInt(4, 90);
                pstm.setInt(5, 70);
                pstm.setInt(6, 70);
            } else if (getChar[2].equals("검사")){
                pstm.setInt(1, 100);
                pstm.setInt(2, 100);
                pstm.setInt(3, 80);
                pstm.setInt(4, 80);
                pstm.setInt(5, 120);
                pstm.setInt(6, 120);
            } else if (getChar[2].equals("법사")){
                pstm.setInt(1, 70);
                pstm.setInt(2, 70);
                pstm.setInt(3, 125);
                pstm.setInt(4, 125);
                pstm.setInt(5, 105);
                pstm.setInt(6, 105);
            }

            pstm.setInt(7, 0);
            pstm.setInt(8, 1);
            pstm.setInt(9, 0);

            pstm.setString(10, inputId);
            pstm.setString(11, getChar[0]);

            int res = pstm.executeUpdate();

            if (res>0) {
                System.out.println("캐릭터 정보가 리셋되었습니다.");
            } else {
                System.out.println("캐릭터 정보 리셋 실패");
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
    
    // 닉네임 입력받음
    public static String inputNickName(){
        Scanner sc = new Scanner(System.in);

        System.out.print("[캐릭터 생성] 캐릭터 이름을 설정해주세요: ");
        String nickName = sc.nextLine();

        if (nickName.getBytes().length <= 30) {
            return nickName;
        } else {
            return null;
        }
    }

    // 종족 입력받음
    public static String inputTribe(){
        Scanner sc = new Scanner(System.in);

        System.out.print("[캐릭터 생성] 종족을 입력해주세요: ");
        String tribe = sc.nextLine();

        if (tribe.getBytes().length <= 30) {
            return tribe;
        } else {
            return null;
        }

    }

    // 직업 입력받음
    public static String inputJob(){
        Scanner sc = new Scanner(System.in);

        while(true){
            try{
                System.out.print("[캐릭터 생성] 직업을 선택하세요(1. 방패병 / 2. 검사 / 3. 법사): ");
                int inputJob = sc.nextInt();
                sc.nextLine();

                if (inputJob == 1) {
                    return "방패병";
                } else if (inputJob == 2) {
                    return "검사";
                } else if (inputJob == 3) {
                    return "법사";
                } else {
                    System.out.println("선택지 중에서 선택해주세요.\n");
                }
            } catch (Exception e){
                sc.nextLine();
                System.out.println("선택지 중에서 선택해주세요.\n");
            }
        }
    }
    
    // 캐릭터 생성 후 db에 저장함
    public static void inputChar(String id, String nickName, String tribe, String job){
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
            
            // 테이블에 캐릭터 정보 입력하는 sql문
            String sql = "INSERT INTO GAME_CHARACTER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.setString(2, nickName);
            pstm.setString(3, tribe);
            pstm.setString(4, job);
            pstm.setInt(13, 0);

            // 직업에 따라 스텟 다름(처음 배정)
            if (job.equals("방패병")){
                pstm.setInt(5, 140);
                pstm.setInt(6, 140);
                pstm.setInt(7, 90);
                pstm.setInt(8, 90);
                pstm.setInt(9, 70);
                pstm.setInt(10, 70);
                pstm.setInt(11, 0);
                pstm.setInt(12, 1);
            } else if (job.equals("검사")){
                pstm.setInt(5, 100);
                pstm.setInt(6, 100);
                pstm.setInt(7, 80);
                pstm.setInt(8, 80);
                pstm.setInt(9, 120);
                pstm.setInt(10, 120);
                pstm.setInt(11, 0);
                pstm.setInt(12, 1);
            } else if (job.equals("법사")){
                pstm.setInt(5, 70);
                pstm.setInt(6, 70);
                pstm.setInt(7, 125);
                pstm.setInt(8, 125);
                pstm.setInt(9, 105);
                pstm.setInt(10, 105);
                pstm.setInt(11, 0);
                pstm.setInt(12, 1);
            }

            int res = pstm.executeUpdate();

            if(res > 0){
                System.out.printf("'이름: %s, 종족: %s, 직업: %s' 생성 완료\n\n", nickName, tribe, job);
            } else{
                System.out.println("캐릭터 생성 실패");
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
    
    // 아이디와 닉네임을 입력받아 동일한 캐릭터가 있는지 확인
    public static boolean checkNickname(String inputId, String nickName){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        int count = 0;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");   // jdbc 연결
//            System.out.println("JDBC Driver 로드 성공");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "ADAM";
            String pw = "1234";

            conn = DriverManager.getConnection(url, user, pw);  // db 로드
//            System.out.println("DB 연결 성공");

            // id와 nickname이 같은 캐릭터가 있을 경우 count하는 sql문
            String sql = "SELECT COUNT(*) AS CNT FROM GAME_CHARACTER WHERE ID = ? AND NICKNAME = ?";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, inputId);
            pstm.setString(2, nickName);

            rs = pstm.executeQuery();

            while(rs.next()){
                count = rs.getInt("CNT");
            }
            
            // 동일한 캐릭터가 있으면 true, 없으면 false 내보냄
            return (count>0) ? true: false;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
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
