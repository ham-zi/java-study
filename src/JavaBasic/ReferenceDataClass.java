package JavaBasic;

public class ReferenceDataClass {


        String subjectName;
        int score;

        public String getSubjectName() {
            return subjectName;
        }

        public int getScore() {
            return score;
        }

        public void setSubjectName(String subjectName) {
            this.subjectName = subjectName;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public ReferenceDataClass(String subjectName) {
            this.subjectName = subjectName;
            this.score = score;
        }

}
