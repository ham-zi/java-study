package GptCodingTest;

import java.util.List;

public class PrintAverageOfList {


    public static void printScoresAverage(List<List<Integer>>list){
        double sum = 0; //선언 위치를 for 안쪽에 하는게 더 좋은 구조
        int numbers = 0; //numbers -> index  = 1;

        for(List<Integer>lists:list){ //(GPT)변수 이름 살짝 아쉬움, List<List<Integer>> scroeTable
            for (int score:lists){    //List<Integer> row
                sum += score;
            }
            numbers += 1; // index ++; index를 1로 두고 print아래로 내리기.
            System.out.printf(numbers +"번 평균: " + "%.1f\n",sum/lists.size() ); //double사용 했을 때 printf 사용해서 자릿수를 맞춰줘야함...>> "%.(자리수)f\n", <<
            sum = 0;
        }


    }

    public static void main(String[] args){
        List<List<Integer>> scroes = List.of(
                List.of(80,90,70),
                List.of(60,100,50),
                List.of(90,90,95)
        );

        printScoresAverage(scroes);

    }
}
