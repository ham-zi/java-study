package JavaBasic;

public class ListExample {
    public static void printNumbers(java.util.List<Integer> list) {
        for (Integer num : list) {
            if (num > 10) {
                System.out.println(num);
            }

        }

    }

    public static void main(String[] args) {
        java.util.List<Integer> Numbers = java.util.List.of(1, 3, 6, 8, 10, 11, 13, 15, 18, 19, 20);
        printNumbers(Numbers);
    }

    public static class RandomNumExample {


        public static int getRandomNumber(){
            return (int)(Math.random()*31)+20;
            //     (int) Math.random()*(최대범위 - 최소범위) - 최소범위;
        }

        public static void main(String[] args) {
            System.out.println(getRandomNumber());
        }
    }
}