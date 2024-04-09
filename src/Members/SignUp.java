package Members;

import java.util.Scanner;

public class SignUp {
    Scanner sc = new Scanner(System.in);

    String inputId = sc.nextLine();
    String inputPw = sc.nextLine();

    Info info = new Info(inputId, inputPw);
}
