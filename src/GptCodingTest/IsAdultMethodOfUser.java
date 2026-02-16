package GptCodingTest;

// User클래스 만들기
// 필드:String name; int age;
// 기능: 생성자, isAdult 20이상이면 true

public class IsAdultMethodOfUser {
    public static class User{ //(gpt)static inner class도 사실 필요없음
        String name; //(gpt) 필드는 private가 정석
        int age; //(gpt) private가 정석

        public User(String name, int age){
            if(age>150 || age<0){
                throw new IllegalArgumentException("age 입력 오류");
            }
            if(name==null || name.isEmpty()){
                throw new IllegalArgumentException("name 입력 오류");
            }

            this.name = name;
            this.age = age;
        }

        public static boolean isAdult(int age) { //(gpt)지금 객체처럼 사용하지 못하고 있음,
            return age >= 20;                   // 베스트 구조 > return this.age >= 20;
        }                                        // 이렇게하면 사용도 편해짐 u1.isAdult();
    }                                            // 이게 OOP(객체지향)의 기본 패턴이다.

    public static void main(String[] args){
        User u1 = new User("이다산", 31);

        System.out.println(User.isAdult(u1.age)); // user.isAdult(31); > 함수스타일
    }
    // u1.isAdult(); > 객체 스타일
}

