package GptCodingTest;

public class UserIDStatic {


    public static class User{

        private final String name;
        private final int thisId;
        private static int id = 0;


        private User(String name){
            if(name==null || name.isEmpty()){
                throw new IllegalArgumentException("name");
            }
            id ++;
            this.name = name;
            this.thisId = id; // this.userId = ++ id; 한줄로 가능
            //userId가 더 깔끔
        }

        public String getName(){
            return name;
        }

        public int getId() {
            return thisId;
        }


        public static User of(String name){
            return new User(name);
        }



    }

    public static void main(String[] args) {
        User u1 = User.of("이다산");
        User u2 = User.of("김다산");

        System.out.println(u1.getId());
        System.out.println(u2.getId());
    }
}
