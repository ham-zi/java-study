package GptCodingTest;

public class MoneyOfCurrency {

    public static class Money{

        public enum Currency{
            KRW,
            USD,
            JPY
        }

        private final long money;
        private final Currency currency;

        private Money(long money, Currency currency){
            if(money < 0){
                throw new IllegalArgumentException("money");
            }
            if(currency == null){
                throw new IllegalArgumentException("currency");
            }

            this.money = money;
            this.currency = currency;

        }

        public static Money of(long money, Currency currency){
            return new Money(money, currency);
        }

        public long getMoney(){
            return money;
        }

        public Currency getCurrency(){
            return currency;
        }

        public Money minus(Money other){
            if(other == null){
                throw new IllegalArgumentException("other");
            }
            if(this.currency != other.currency){
                throw new IllegalArgumentException("Currency mismatch: "+ this.currency + " vs "+ other.currency );
            }

            long result = Math.subtractExact(this.money,other.money);
            if(result<0){
                throw new IllegalArgumentException("Insufficient funds: "+ this.money + " - " + other.money);
            }

            return new Money(result, this.currency);

        }

        public Money add(Money other){
            if(other == null){
                throw new IllegalArgumentException("other");
            }
            if(this.currency != other.currency){
                throw new IllegalArgumentException("Currency mismatch: "+ this.currency + " vs "+ other.currency );
            }

            long result = Math.addExact(this.money,other.money);
            return new Money(result, this.currency);

        }

        public static void main(String[] args) {
            Money m1 = Money.of(30000,Currency.KRW);
            Money m2 = Money.of(15000,Currency.KRW);

            Money result = m1.minus(m2);
            System.out.println(result.getMoney());

        }

    }

}
