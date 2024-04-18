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
                case 1:     // 회원가입
                    su.signUp();                    // 회원가입 진행
                    break;

                case 2:     // 로그인
                    if (signInArr[0] == null && signInArr[1] == null) {
                        signInArr = si.signIn();        // 로그인
                    } else {
                        System.out.println("이미 로그인되어 있습니다.");
                    }
                    break;

                case 3:     // 캐릭터 생성
                    if(signInArr[0] != null || signInArr[1] != null) {         // 로그인 된 상태일 경우 캐릭터 생성
                        cc.createChar(signInArr[0]);
                        break;
                    } else {        // 로그인하지 않았을 경우 캐릭터 생성 불가
                        System.out.println("로그인한 뒤 캐릭터를 생성해주세요.\n");
                        break;
                    }

                case 4:     // 게임 플레이
                    if(signInArr[0] != null || signInArr[1] != null) {
                        System.out.println();

                        String[] getChar = chc.choiceChar(signInArr[0], "플레이");
                        int[] getStatus = chc.getStatus(signInArr[0], getChar[0]);

                        if(getChar[0] != null && getChar[1] != null && getChar[2] != null) {
                            System.out.print("""           
                                    \n1. 이어하기
                                    2. 처음부터 하기(선택 시 기존 정보가 모두 초기화됩니다.)\n>> """);
                            int choiceProgress = sc.nextInt();
                            sc.nextLine();

                            if (choiceProgress == 2) {
                                cc.resetChar(signInArr[0], getChar);
                                getStatus = chc.getStatus(signInArr[0], getChar[0]);
                            }

                            gp.gamePlay(signInArr[0], getChar, getStatus);
                        }
                        break;
                    } else {
                        System.out.println("로그인 후 게임 플레이가 가능합니다.\n");
                        break;
                    }
                    
                case 5:     // 캐릭터 삭제
                    if(signInArr[0] != null || signInArr[1] != null) {
                        String[] getChar = chc.choiceChar(signInArr[0], "삭제");

                        if(getChar[0] != null && getChar[1] != null && getChar[2] != null) {
                            System.out.print("정말 삭제하겠습니까?(y/n)\n>> ");
                            String finalChoice = sc.nextLine();
                            if (finalChoice.equals("y")) {
                                dc.deleteCharacter(signInArr[0], getChar);
                            }
                            System.out.println("메뉴로 돌아갑니다.");
                        }

                        break;
                    } else {
                        System.out.println("로그인 후 캐릭터 삭제가 가능합니다.\n");
                        break;
                    }

                case 6:     // 계정 삭제
                    if(signInArr[0] != null || signInArr[1] != null) {
                        System.out.println(RED + "[경고!]계정을 삭제하면 기존의 캐릭터도 모두 삭제됩니다." + EXIT);
                        System.out.print("계정을 정말 삭제하고 싶다면 비밀번호를 입력하세요: ");

                        String checkPw = sc.nextLine();

                        System.out.println();
                        
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

                case 7:     // 로그아웃
                    if(signInArr[0] != null || signInArr[1] != null) {
                        signInArr[0] = null;
                        signInArr[1] = null;
                        System.out.println("로그아웃 되었습니다.\n");
                        break;
                    } else {
                        System.out.println("이미 로그아웃 되어 있습니다.\n");
                        break;
                    }
                    
                case 8:     // 종료
                    sc.close();
                    System.out.println("종료되었습니다.");
                    break label;

                default:    // 메뉴 외의 다른 거 입력 시
                    sc.nextLine();
                    System.out.println("선택지 중 하나를 선택해주세요.");
            }
        }
    }

    // 메뉴 출력 및 입력 받음
    public static int menu(){
        System.out.println("""
                \n1. 회원가입 | 2. 로그인 | 3. 캐릭터 생성 | 4. 게임 플레이
                5. 캐릭터 삭제 | 6. 계정 삭제 | 7. 로그아웃 | 8. 종료""");
        System.out.print("선택: ");
        try {
            int choice = sc.nextInt();
            sc.nextLine();

            return choice;

        } catch (Exception e){
            sc.nextLine();

            return 0;
        }
    }
    
    // 콘솔 출력 문자 색 변경
    public static final String RED = "\u001B[31m";
    
    // 문자 색 변경 끝 위치 표시
    public static final String EXIT = "\u001B[0m";
}
