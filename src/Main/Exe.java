package Main;

import GameCharacter.*;
import Members.*;
import GamePlay.*;

import java.util.Objects;
import java.util.Scanner;

public class Exe {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);
        SignUp su = new SignUp();       // signUp 객체 생성
        SignIn si = new SignIn();
        CreateCharacter cc = new CreateCharacter();
        ChoiceCharacter chc = new ChoiceCharacter();
        String[] signInArr = new String[2];

        label : while(true) {

            int choice = menu();

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
                    if(signInArr[0] != null || signInArr[1] != null) {

                        GamePlay gp = new GamePlay();

                        String[] getChar = chc.choiceChar(signInArr[0]);
                        int[] getStatus = chc.getStatus(signInArr[0], getChar[0]);

                        gp.gamePlay(signInArr[0], getChar, getStatus);

                        break;
                    } else {
                        System.out.println("로그인 후 게임 플레이가 가능합니다.");
                        break;
                    }

                case 5:
                    if(signInArr[0] != null || signInArr[1] != null) {
                        signInArr = null;
                        System.out.println("로그아웃 되었습니다.");
                        break;
                    } else {
                        System.out.println("이미 로그아웃 되어 있습니다.");
                        break;
                    }

                case 6:
                    sc.close();
                    System.out.println("종료되었습니다.");
                    break label;
            }
        }
    }

    public static int menu(){
        System.out.println("1. 회원가입 | 2. 로그인 | 3. 캐릭터 생성 | 4. 게임 플레이 | 5. 로그아웃 | 6. 종료");
        System.out.print("선택: ");
        return sc.nextInt();
    }
}
