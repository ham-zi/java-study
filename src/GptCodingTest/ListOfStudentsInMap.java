package GptCodingTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfStudentsInMap {

    public static class Students{

        Map<String, List<Integer>> scoreMap = new HashMap<>();
        private final String name;
        private final List<Integer> scores;


        private Students(String name, List<Integer> scores) {
            this.name = name;
            this.scores = scores;
        }

        public Students of() {
            return new Students(name, scores);
        }

        public String getName(){
            return name;
        }

        public List<Integer> getScores() {
            return scores;
        }

        public void printScoresAverage(){
            for (Map.Entry<String,List<Integer>> entry: scoreMap.entrySet()) {
                double Sum = 0;
                for (int score : scoreMap.get(name)) {
                    Sum += score;
                }
                System.out.println(name + "의 평균점수: " + Sum / scores.size());
            }
        }

    }

 //생성자(name,List<>)는 이중 for문을 하려했으나 오류가 발생 했다.
    //몰랐던것: for문은 이미 만들어진 것들만 가능하다
    //이미 생성하지 않은 생성자에 대해서 평균값 구하는 2중포문을 만들 수 없었다.
        //해결책: Map<String, List<>>scoreMap = new HashMap<>(); 을 생성하여
        // for문 Map -> List -> score 로 이중 포문을 만들었다.

    public static void main(String[] args) {



    }


}




