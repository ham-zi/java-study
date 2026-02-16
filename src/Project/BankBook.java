package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankBook {


    public enum management {
        INCOME,
        EXPENSE
    }

    public static class Record {

        private final String type;
        private final int amount;
        private final String memo;

        public Record(String type, int amount, String memo) {
            // ******문제점********
            // 1. static이 아니라서 Account에서 사용을 못했었음
            // 2. 검증 먼저하고 대입이 깔끔함

            if (type == null || type.isEmpty()) {
                throw new IllegalArgumentException("타입 입력 오류입니다.");
            }
            if (amount < 0) {
                throw new IllegalArgumentException("금액을 0원 이상 입력해주세요.");
            }

            if (memo == null || memo.isEmpty()) {
                throw new IllegalArgumentException("메모 입력 오류입니다.");
            }

            this.type = type;
            this.amount = amount;
            this.memo = memo;
        }

//
//        public Record addIncomes(List<Record>list){
//            return list.add(getType(), getAmount(),getMemo() ); // 1. 이건가?? type,amount,memo 매개변수를 받고싶어서 했는데
//        } 역시 아니었따~!!!! 아래와 같이 class Account에서 메서드를 만들고, incomes 리스트를 호출하여, 그 안에서 Record생성자를 사용하여 해결.


        public String getType(){   //클래스가 static인데 안써지네
            return type;
        }
        public  int getAmount(){
            return  amount;
        }

        public  String getMemo(){
            return memo;
        }

    }


    public static class Account {
        String name;
        private final List<Record> incomes;
        private final List<Record> expenses;



        public Account(String name) {
            //, List<Record> incomes, List<Record> expenses ->incomes, expenses 생성자 인자 의미없음.
            // 왜냐면 밑에서 인자를 무시하고 완전 새로 만들어버림. new ArrayList<>(); <<
            //***********문제점***********
            // this.incomes = null;
            // 객체가 생성될 때 입금과 출금이 존재하지 않아야 하니 null 값으로 넣었다.
            // -> null을 넣으면 for문에서 터짐
            // 객체생성시점에서 new ArrayList<>()로 초기화 해야함
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("이름 설정 오류입니다.");
            }
            this.name = name;
            this.incomes = new ArrayList<>();
            this.expenses = new ArrayList<>();

        }

        public void printList(){ //list를 정확히 incomes를 받기 위해서 클래스 내부로 옮겼다
            System.out.println("------입금 내역------");
            for (Record list:incomes){
                System.out.println(list.getType() + "  " + list.getAmount() + "  " + list.getMemo());
            }
            System.out.println("------출금 내역------");
            for (Record list:expenses){
                System.out.println(list.getType() + "  " + "-"+list.getAmount() + "  " + list.getMemo());
            }
        }


        public int getTotalIncome(){
            int sumIncome = 0;
            for(Record list: incomes){
                sumIncome += list.amount;
            }
            return sumIncome;
        }

        public int getTotalExpense(){
            int sumExpense = 0;
            for(Record list: expenses){
                sumExpense += list.amount;
            }
            return sumExpense;
        }

        public int getBalance(){
            return getTotalIncome() - getTotalExpense();
        }

        public void addIncomes(int amount, String memo){
            incomes.add(new Record("수입", amount, memo));
            // 매개변수가 안들어가서 Record를 static으로 바꿔도 안됐었는데,
            // new( Record(type, amount, memo)를 사용할 수 있을지 몰랐음.
        }

        public void addExpenses(int amount, String memo){
            expenses.add(new Record("지출", amount, memo));
        }
        //필드는 "그 객체가 이미 만들어진 뒤"에만 존재한다
        //Record r = new Record("수입",1000,"알바") 해야만 그제서야 r.type이 존재
        // 그러므로


    }

   // public void addIncomes(List<Record>list) {
//        return list.add(getType());     //왜 Record의 필드를 불러오질 못하지? /Account의 incomes(list)를 호출한뒤 리스트.add(Record필드) -> 마찬가지로 객체가 만들어지지 않았기 때문에 호출이 불가능함.
//// list.add()는 참조이름을 변경하라는데..? 애초에 <Record>list라서 record는 알아서 불러올텐데 어째서 변수들이 들어가도 오류가 날까?
//        //내가 메서드를 잘 활용 못해서인가?
//        // Account 클래스 안에 넣고 해봐도 안되네 ㅠㅠ
//    }


    public static void main(String[] args) {

        Account a = new Account("이다산");
        System.out.println("------현재 잔고------");
//        System.out.println(Account.getBalance); // 클라스안에 메서드 불러오기가 힘든가 -> 객체가 만들어지지 않았기 때문에 호출이 불가능함 지금 필드 선언만 되었으니 호출이 될리가 없음

        Scanner scanner = new Scanner(System.in);
        boolean program = true;
        while(program) {

            System.out.println("------- 선택 -------");
            System.out.println("1.수입 입력");
            System.out.println("2.지출 입력");
            System.out.println("3.수입/지출 전체목록");
            System.out.println("4.현재 잔고");
            System.out.println("5.종료");
            System.out.println("\n번호를 입력해주세요.");

            int number = scanner.nextInt();



            switch (number) {
                case 1:
                    System.out.println("------수입 입력-------");
                    System.out.print("금액 : ");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("메모 : ");
                    String memo = scanner.nextLine();
                    a.addIncomes(amount, memo); //입력값들을 scanner로 받아야겠지?
                    continue;
                case 2:
                    System.out.println("------지출 입력-------");
                    System.out.print("금액 : ");
                    int amountExpense = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("메모 : ");
                    String memoExpense = scanner.nextLine();
                    a.addExpenses(amountExpense, memoExpense);
                    continue;

                case 3:
                    System.out.println("------전체 목록-------");
                    a.printList();
                    continue;

                case 4:
                    System.out.println("------현재 잔고-------");
                    System.out.println(a.getBalance());
                    continue;

                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    program = false;
                    break;

                default: {
                    System.out.println("잘못입력했습니다.");
                }
            }
        }




    }

}

// 해결된 문제
// 1. case를 했음에도 불구하고 가끔 case에 맞지 않는 경우가 실행되고 >> Scanner를 공부하고 나니 보이는 상황 -> scanner.nextLine()의 무분별한 사용이 문제였음 적재적소에만 활용하니 사라짐.
// 2. case 선택 후  메뉴로 돌아가겠습니까?를 물어보고 메뉴재실행이 되어야 매끄럽게 진행이 될거 같음 -> while을 사용해서 프로그램이 반복실행되게 진행하고, 5번 종료를 넣어서 마무리도 가능. while(boolean 변수를 활용)
// 3. Account 생성자 인자에 필요없이 들어가 있었다. >> 생성자에 대해 조금 더 고민할 것
// 4. 오타 조심 addExpenses를 addExpences라고 적음. >> 확인 후 변경
// 5. 캡슐화 Record의 캡슐화가 깨져있었음. 밑에 메서드에서 변수명을 사용함 >> list.getMethod로 대체
// 현재 문제
// 5. 고정 수입/수출 주는거 괜찮은데 문자열보다 enum을 쓰는게 더 안전함