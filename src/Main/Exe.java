package Main;

import GameCharacter.*;
import Members.*;

import java.util.Objects;
import java.util.Scanner;

public class Exe {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
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
                    signInArr = si.signIn();        // 로그인
                    break;

                case 3:
                    if(signInArr[0] != null || signInArr[1] != null) {         // 로그인 된 상태일 경우 캐릭터 생성
                        cc.createChar(signInArr[0]);
                        break;
                    } else {        // 로그인하지 않았을 경우 캐릭터 생성 불가
                        System.out.println("로그인한 뒤 캐릭터를 생성해주세요.");
                        break;
                    }

                case 4:


                case 5:
                    signInArr = null;
                    System.out.println("로그아웃 되었습니다.");
                    break;

                case 6:
                    System.out.println("종료되었습니다.");
                    break label;
            }
        }
    }
}
