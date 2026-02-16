package JavaBasic;

import java.util.Scanner;

public class VarScannerExample {

    //    Scanner scanner = new Scanner(System.in); // Scanner클래스의 객체를 생성
//
//    String intput = scanner.nextLine(); //입력받은 내용을 input에 저장
//    // String intput = scanner.nextInt();
//
//    int num = Integer.parseInt(intput); //입력받은 내용을 int 타입의 값으로 변환
//    //Integer.parseInt() String을 int로 변환하는 도구
//    // int = num = scanner.nextInt(); 가능
//
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println("input = " + input);
        int age = 10;
        System.out.printf("age:%d", age); // ( "지시자(출력형식)",변수 )

    }


}
