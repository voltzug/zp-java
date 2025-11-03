package lab.Lombok;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;

public abstract class Professor {
    public static class def extends Person.def implements IIdentifiable {
        private String employeeId;
        private String department;

        public def() {
        }
        public def(String name, String lastName, int age, String address, String employeeId, String department) {
            super(name, lastName, age, address);
            this.employeeId = employeeId;
            this.department = department;
        }

        public String getId() {
            return employeeId;
        }
        public void setId(String id) {
            if(isValidId(id)) {
                employeeId = id;
            } else{
                throw new IllegalArgumentException("id must start with P");
            }
        }

        public String getDepartment() {
            return department;
        }
        public void setDepartment(String department) {
            this.department = department;
        }

        @Override
        public String toString() {
            return "Professor{" + super.toString() +
                    "employeeId='" + employeeId + '\'' +
                    ", department='" + department + '\'' +
                    '}';
        }
    }
    @NoArgsConstructor @AllArgsConstructor
    @Getter @Setter
    @ToString(callSuper = true)
    @SuperBuilder
    public static class lom extends Person.lom implements IIdentifiable {
        private String employeeId;
        private String department;

        public String getId() {
            return employeeId;
        }
        public void setId(String id) {
            if(isValidId(id)) {
                employeeId = id;
            } else{
                throw new IllegalArgumentException("id must start with P");
            }
        }
    }

    private static boolean isValidId(@NotNull String id){
        return id.toUpperCase().startsWith("P");
    }
}
