package JavaBasic;

public class ReferenceDataStudent {
    public static class Student {

        private final int studentID;
        private final String studentName;
        private final ReferenceDataClass korea;
        private final ReferenceDataClass math;


        private Student(int studentID, String studentName) {
            this.studentID = studentID;
            this.studentName = studentName;

            korea = new ReferenceDataClass("국어");
            math = new ReferenceDataClass("수학");
        }

        public static Student of(int studentID,String studentName){
            return new Student(studentID, studentName);
        }

        public void setKorea(int score) {
            korea.setScore(score);
        }

        public void setMath(int score) {
            math.setScore(score);
        }

        public void showStudentInfo() {
            int total = korea.getScore() + math.getScore();
            System.out.println(studentName + "학생의 총점은 " + total + "점 입니다.");
        }

        public static void main(String[] args) {
            Student studentJames = of(1,"James");
            studentJames.setKorea(90);
            studentJames.setMath(100);

            Student studentTomas = of(2,"Tomas");
            studentTomas.setKorea(80);
            studentTomas.setMath(100);

            studentTomas.showStudentInfo();
            studentJames.showStudentInfo();

        }
    }


    }
