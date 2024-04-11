package Main;

import GameCharacter.*;
import Members.*;

import java.util.Scanner;

public class Exe {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        SignUp su = new SignUp();       // signUp 객체 생성
        SignIn si = new SignIn();
        CreateCharacter cc = new CreateCharacter();
        String[] signInArr = new String[2];

        label : while(true) {
            System.out.println("1. 회원가입 | 2. 로그인 | 3. 캐릭터 생성 | 4. 게임 플레이 | 5. 로그아웃 | 6. 종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    su.signUp();                    // 회원가입 진행
                    break;

                case 2:
                    signInArr = si.signIn();
                    break;

                case 3:
                    cc.createChar(signInArr[0]);
                    break;

                case 4:

                case 5:

                case 6:
                    System.out.println("종료되었습니다.");
                    break label;
            }
        }
    }
}
