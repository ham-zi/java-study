package GptCodingTest;

public class MoneyOfCurrency {

    public static class Money{

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Money)) return false;
            Money money = (Money) o;
            return amount == money.amount && currency == money.currency;
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(amount, currency);
        }

        public enum Currency{
            KRW,
            USD,
            JPY
        }

        private final long amount;
        private final Currency currency;

        private Money(long amount, Currency currency){
            if(amount < 0){
                throw new IllegalArgumentException("amount");
            }
            if(currency == null){
                throw new IllegalArgumentException("currency");
            }

            this.amount = amount;
            this.currency = currency;

        }

        public static Money of(long amount, Currency currency){
            return new Money(amount, currency);
        }

        public long getMoney(){
            return amount;
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

            long result = Math.subtractExact(this.amount,other.amount);
            if(result<0){
                throw new IllegalArgumentException("Insufficient funds: "+ this.amount + " - " + other.amount);
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

            long result = Math.addExact(this.amount,other.amount);
            return new Money(result, this.currency);



        }

        public static void main(String[] args) {
            Money m1 = Money.of(30000,Currency.KRW);
            Money m2 = Money.of(15000,Currency.KRW);

            Money result = m1.minus(m2);
            System.out.println(result.getMoney());

            Money a = Money.of(1000, Currency.KRW);
            Money b = Money.of(1000, Currency.KRW);

            System.out.println(a.equals(b)); // true 나와야 함

        }

    }

}
