package GptCodingTest;

public class PrintHelloWithWhile {
    public static void printHello(int count){
        for(int num=0; num < count; num++){
            System.out.println("Hello Java");
        }
    }

    public  static void printHelloUseWhile(int count){ //(GTP)메서드네이밍 printHellowwithWhile이 더 자연스러움
        int num = 1; // (GPT) 실무에서 num=0;을 선호함
        while(num <= count){ // (GPT) num=0일 때, <count
            System.out.println("Hello Java");
            num ++;
        }
    }

    public static void main(String[] args){
        printHello(3);
        System.out.println("---------------");
        printHelloUseWhile(3);
    }
}

