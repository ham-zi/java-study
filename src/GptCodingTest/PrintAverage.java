package GptCodingTest;

import java.util.List;

public class PrintAverage {

    public static void printAverageOfList(List<Integer>list){
        int sum = 0;
        for(int score:list){
            sum = sum+score; // (GPT)sum += score; 단순해짐
        }

        double average = sum / list.toArray().length; // (GPT) length안씀 -> ** size() *
        //double average = double sum  / list.size();
        System.out.println("점수의 평균은 " + average + " 입니다.");

    }

    public static void main(String[] args){
        List <Integer> scores = List.of(80,97,70,100,60);

        printAverageOfList(scores);

    } // 만약 결과를 소수점까지 보고싶다면 double?? float? 둘다 안되는데???
    // (GPT) 정수 나눗셈 함정, int / int = int -> 무조건 소수점 버림
    // 하나만 double로 바꿔줘도 전체가 double로 연산됨
    // 이 같은 경우 sum을 double로 바꿔주면 됨.





}


