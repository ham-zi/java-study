package GptCodingTest;

import java.util.List;

public class FinalAndList {

    public enum Level{
        BASIC(0),
        VIP(10),
        VVIP(20);

        private final int salePercent;

        Level(int salePersent){
            this.salePercent = salePersent;
        }

        public int getSalePercent(){
            return salePercent;
        }
    }

    public static class Member{
        private final String name;
        private final Level level;
        private final int discountRate;

        private Member(String name,Level level){
            this.name = name;
            this.level = level;
            this.discountRate = level.getSalePercent(); // 나중에 등급이 바뀌는 요구가 들어오면
            // discountRate가 불일치하는 버그가 생길 수 있음. -> 필드 제거 후 getter에서 계산
        }

        public String getName(){
            return name;
        }

        public Level getLevel(){
            return level;
        }

        public int getDiscountRate(){
            return discountRate;
        }

        public static Member of(String name, Level level){
            return new Member(name, level);
        }

    }

    public static void printSalePercent(List<Member>list){
        for(Member m:list){
            System.out.println(m.getName() + " 할인율 : " + m.getDiscountRate() +"%");
        }
    }


    public static void main(String[] args) {
        List<Member> members = List.of(
                Member.of("이다산",Level.VIP),
                Member.of("김자바",Level.VVIP),
                Member.of("박스프링",Level.BASIC)
        );


        printSalePercent(members);

    }

}
