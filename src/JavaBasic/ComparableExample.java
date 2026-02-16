package JavaBasic;

import java.util.ArrayList;
import java.util.List;

public class ComparableExample {

    public static class Student implements Comparable<Student>{

        private String name;
        private int score;

        public Student(String name, int score){
            this.name = name;
            this. score = score;
        }

        public String getName(){
            return name;
        }

        public int getScore(){
            return score;
        }

//        @Override
//        public  int compareTo(Student other){ //compareTo 원리
//            // 음수 0 -> 내가 앞 // 0 -> 동일 // 양수 0 -> 내가 뒤
//            return  this.score - other.score; // 점수 기준 오름차순
//        }
          @Override
          public  int compareTo(Student other){
            return  other.score - this.score;
          }

        // 점수 내림차순((s1, s2) -> s2.getscore() - s1.getscore());
        // 이름 기준 오름차순 list.sort((s1, s2) -> s1.getName().comepareTo(s2.getName()));

        @Override
        public  String toString() {
            return name + " : " + score;
        }

    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("이다산", 90));
        list.add(new Student("방지원", 70));
        list.add(new Student("김홍차", 85));
        list.add(new Student("김성수", 75));
        list.add(new Student("차차차", 91));


        list.sort(null); // or Collections.sort(list);

    }
}