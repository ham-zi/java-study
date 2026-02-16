package GptCodingTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Step12ComparatorChaining {



    public static class Student{
        private final String name;
        private final int score;
        private final int age;


        private Student(String name, int score, int age){

            if(name == null || name.isEmpty()){
                throw new IllegalArgumentException("name error");
            }
            if(score < 0 || score > 100){
                throw  new IllegalArgumentException("score error");
            }
            if(age < 0 || age > 150){
                throw  new IllegalArgumentException("age error");
            }

            this.name = name;
            this.score = score;
            this.age = age;


        }

        public static Student of(String name, int score, int age){
            return new Student(name, score, age);
        }

        public String getName(){
            return name;
        }

        public int getAge(){
            return age;
        }

        public int getScore(){
            return score;
        }


    }

    public static void printStudents(List<Student>list){
        for (Student s : list){
            System.out.println(s.name+"("+s.age+")"+"의 점수 : " +s.score);
        }
    }

    public static void newStudents(List<Student>list) {
        List<Student>sorted = list.stream()
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .toList();
        printStudents(sorted);
    }


    public static void main(String[] args) {
        List<Student>Students = new ArrayList<>();
        Students.add(new Student("이다산",90,31));

        Students.add(new Student("아두부",80,31));
        Students.add(new Student("박된장",80,31));
        Students.add(new Student("최콜라",60,28));
        Students.add(new Student("사이다",70,22));

        newStudents(Students);
        }
    }
