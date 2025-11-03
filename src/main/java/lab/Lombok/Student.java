package lab.Lombok;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;

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
    @NoArgsConstructor @AllArgsConstructor
    @Getter @Setter
    @ToString(callSuper = true)
    @SuperBuilder
    public static class lom extends Person.lom implements IIdentifiable {
        private String studentId;
        private String major;

        public String getId() {
            return studentId;
        }
        public void setId(String id) {
            if(isValidId(id)) {
                studentId = id;
            } else{
                throw new IllegalArgumentException("id must start with S");
            }
        }
    }

    private static boolean isValidId(@NotNull String id){
        return id.toUpperCase().startsWith("S");
    }
}
