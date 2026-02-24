package GptCodingTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentInList {
    public static class Student{

        private static List<Student>Students = new ArrayList<>();
        private final String name;
        private final int score;

        private Student(String name, int score){
            this.name = name;
            this.score = score;
        }

        public static Student of(String name, int score){
            return new Student(name, score);
        }

        public List<Student> getStudents(){
            return Students;
        }


        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }


        public static void main(String[] args) {

            Students.add(of("GET",75));
            Students.add(of("PUT",99));
            Students.add(of("PATCH",85));
            Students.add(of("POST",80));
            Students.add(of("DELETE",70));

         Students.sort((s1,s2) ->{
             if ( s2.getScore() != s1.getScore()) {
                 return s2.getScore() - s1.getScore();
             }
             return s1.getName().compareTo(s2.getName());
         });
         //Students.sort(Comparator.comparing(Student :: getScore));

        }
    }
}
