
package GptCodingTest;

public class SalePercentInLevel {

    public enum Level {
        BASIC(10),
        VIP(20),
        VVIP(30);

        private final int salePercent;

        Level(int salePercent) {

            this.salePercent = salePercent;
        }

        public int salePercent() {
            return salePercent;
        }
    }

    public static class Member {
        private final String name;
        private final Level level;
        private final int sale; // level 기반으로 고정

        private Member(String name, Level level) {
            if (name == null || name.isBlank()) throw new IllegalArgumentException("이름 오류");
            if (level == null) throw new IllegalArgumentException("레벨 오류");

            this.name = name;
            this.level = level;
            this.sale = level.salePercent();
        }

        public static Member of(String name, Level level) {
            return new Member(name, level);
        }

        public void printSale() {
            System.out.println("할인율은 " + sale + "%입니다.");
        }
    }

    public static void main(String[] args) {
        Member m = Member.of("이다산", Level.VIP);
        m.printSale();
    }
}