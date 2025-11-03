package lab.Lombok;

import lombok.ToString;

public abstract class Student {
    public static class def extends Person.def implements IIdentifiable {
        private String studentId;
        private String major;

        public def() {
        }
        public def(String name, String lastName, int age, String address, String studentId, String major) {
            super(name, lastName, age, address);
            this.studentId = studentId;
            this.major = major;
        }

        public String getId() {
            return studentId;
        }
        public void setId(String id) {
            if(id.toUpperCase().startsWith("S")) {
                studentId = id;
            } else{
                throw new IllegalArgumentException("id must start with S");
            }
        }

        public String getMajor() {
            return major;
        }
        public void setMajor(String major) {
            this.major = major;
        }

        @Override
        public String toString() {
            return "Student{" + super.toString() +
                    "studentId='" + studentId + '\'' +
                    ", major='" + major + '\'' +
                    '}';
        }
    }
}
