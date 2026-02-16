package GptCodingTest;

//Student 클래스 작성

public class StudentPrintGrade {
    public static class Student{
        private final String name;
        private final int score;

        private Student(String name, int score){
            if(name == null || name.isEmpty()){
                throw new IllegalArgumentException("name error");
            }
            if(score < 0 || score > 100){
                throw new IllegalArgumentException("score error");
            }

            this.name = name;
            this.score = score;
        }

        public static Student of(String name, int score){
            return new Student(name,score);
        }

        public String getName(){
            return name;
        }

        public int getScore(){
            return score;
        }

        public static void printScoreLevel(Student student){
            int num = student.getScore() / 10;
            String level;
            switch(num){
                case 10, 9 -> level = "A";
                case 8, 7 -> level = "B";
                case 6, 5 -> level = "C";
                case 4, 3 -> level = "D";
                default -> level = "F";
            }
            System.out.println(student.getName()+ " : " + level);
        }

    }

    public static void main(String[] args) {
        Student dasan = Student.of("이다산",70);
        Student java = Student.of("김자바", 100);


        Student.printScoreLevel(dasan);
        Student.printScoreLevel(java);
    }

}
