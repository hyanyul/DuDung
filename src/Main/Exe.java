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
        GamePlay gp = new GamePlay();
        DeleteCharacter dc = new DeleteCharacter();
        DeleteAccount da = new DeleteAccount();
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
                        System.out.println("로그인한 뒤 캐릭터를 생성해주세요.\n");
                        break;
                    }

                case 4:
                    if(signInArr[0] != null || signInArr[1] != null) {
                        System.out.println();

                        String[] getChar = chc.choiceChar(signInArr[0], "플레이");
                        int[] getStatus = chc.getStatus(signInArr[0], getChar[0]);

                        System.out.print("""           
                                \n1. 이어하기
                                2. 처음부터 하기(선택 시 기존 정보가 모두 초기화됩니다.)""");
                        int choiceProgress = sc.nextInt();
                        sc.nextLine();

                        if(choiceProgress == 2){
                            cc.resetChar(signInArr[0], getChar);
                            getStatus = chc.getStatus(signInArr[0], getChar[0]);
                        } else if(choiceProgress != 1){
                            System.out.println("선택지 중 하나를 선택해주세요.");
                        }

                        gp.gamePlay(signInArr[0], getChar, getStatus);

                        break;
                    } else {
                        System.out.println("로그인 후 게임 플레이가 가능합니다.\n");
                        break;
                    }

                case 5:
                    if(signInArr[0] != null || signInArr[1] != null) {
                        signInArr = null;
                        System.out.println("로그아웃 되었습니다.\n");
                        break;
                    } else {
                        System.out.println("이미 로그아웃 되어 있습니다.\n");
                        break;
                    }
                    
                case 6:
                    if(signInArr[0] != null || signInArr[1] != null) {
                        String[] getChar = chc.choiceChar(signInArr[0], "삭제");

                        System.out.print("정말 삭제하겠습니까?(y/n)\n>> ");
                        String finalChoice = sc.nextLine();
                        if (finalChoice.equals("y")){
                            dc.deleteCharacter(signInArr[0], getChar);
                        }
                        System.out.println("메뉴로 돌아갑니다.");

                        break;
                    } else {
                        System.out.println("로그인 후 캐릭터 삭제가 가능합니다.\n");
                        break;
                    }

                case 7:
                    if(signInArr[0] != null || signInArr[1] != null) {
                        System.out.println(RED + "[경고!]계정을 삭제하면 기존의 캐릭터도 모두 삭제됩니다." + EXIT);
                        System.out.print("계정을 정말 삭제하고 싶다면 비밀번호를 입력하세요: ");

                        String checkPw = sc.nextLine();

                        if(checkPw.equals(signInArr[1])){
                            da.deleteAccount(signInArr[0], signInArr[1]);
                            signInArr = new String[2];
                            break;
                        }
                        System.out.println("메뉴로 돌아갑니다.");

                        break;
                    } else {
                        System.out.println("로그인 후 계정 삭제가 가능합니다.\n");
                        break;
                    }
                    
                case 8:
                    sc.close();
                    System.out.println("종료되었습니다.");
                    break label;
            }
        }
    }

    public static int menu(){
        System.out.println("""
                \n1. 회원가입 | 2. 로그인 | 3. 캐릭터 생성 | 4. 게임 플레이
                5. 로그아웃 | 6. 캐릭터 삭제 | 7. 계정 삭제 | 8. 종료""");
        System.out.print("선택: ");
        int choice = sc.nextInt();
        sc.nextLine();

        return choice;
    }

    public static final String RED = "\u001B[31m";
    public static final String EXIT = "\u001B[0m";
}
