package GptCodingTest;

// 문제6. 아래 구조 완성하기.
//  public class User {
//
//    private String name;
//    private int age;
//
//    private User(String name, int age) {
//        // 유효성 검사
//    }
//
//    public static User of(String name, int age) {
//        // 객체 생성해서 반환
//    }
//  }
//
//조건 1.age < 0 -> 예외
//    2. name null/빈문자 -> 예외

public class StaticFactoryUserMethod {
    public static final class User {

        private final String name;
        private final int age;

        private User(String name, int age){
            if(age<0 || age>150) {
                throw new IllegalArgumentException("나이 입력 오류");
            }
            if(name==null || name.isEmpty()) {
                throw  new IllegalArgumentException("이름 입력 오류");
            }

            this.name = name;
            this.age = age;
        }

        public static User of(String name, int age){
            return new User(name, age); // class User에 static이 없으면 오류남, 클라스 내부인데 static이 필요한 이유가 뭘까?
        }

    }

    public static void main(String[] args){
        User u1 = User.of("이다산",3);
    }
}
