package Members;

import java.util.Scanner;

public class SignUp {
    public void signUp(){
        String inputId = inputId();
        String inputPw = inputPw();
        Info info = new Info(inputId, inputPw);

        System.out.printf("[회원가입] 'ID: %s, PW: %s' 가 가입되었습니다.", inputId, inputPw);
    };

    public static String inputId(){
        Scanner sc = new Scanner(System.in);

        System.out.print("사용할 ID를 입력하세요: ");
        String inputId = sc.nextLine();

        return inputId;
    };

    public static String inputPw(){
        Scanner sc = new Scanner(System.in);

        System.out.print("사용할 PW를 입력하세요: ");
        String inputPw = sc.nextLine();

        return inputPw;
    }








}
