package JavaBasic;

public class ImmutableUserExample {
    public static final class User{
        private final String name;
        private final int age;

        private User(String name, int age){
            if ( age < 0 || age > 150){
                throw new IllegalArgumentException(); // 중복
            }
            if ( name == null || name.isEmpty() ){
                throw new IllegalArgumentException(); // 중복을 하나로 합칠순없을까?
            }

            this.name = name;
            this.age = age;

        }

        public static User of(String name, int age){
            return new User(name, age);
        }

        public boolean isMinor(){
            return this.age < 20 ;
        }

        public String getUserName(){
            return name;
        }

        public User withAge(int newAge){
            return new User(name,newAge);
        }

        public int getAge(){
            return age;
        }

    }

    public static void main(String[] args){
        User u2 = User.of("까미",8);
        User u1 = User.of("이다산",31);
        System.out.println(u1.getUserName());
        System.out.println(u2.isMinor());

        u1 = u1.withAge(32);
        System.out.println(u1.getAge()); //나이가 변경된 객체는 이름이 뭐지? 선언을 한적이 없으니... 모르겠네...
    }

}

