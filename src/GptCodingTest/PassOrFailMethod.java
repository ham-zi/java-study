package GptCodingTest;

public class PassOrFailMethod {
    public static void checkScore(int score){
        if(score<0 || score>100){
            throw new IllegalArgumentException("점수를 제대로 입력해주세요.");
        }

        if(score>=60){
            System.out.println("합격");
        }else {
            System.out.println("불합격");
        }
    }

    public static void main(String[] args){
        checkScore(66);
        checkScore(100);
    }
}
