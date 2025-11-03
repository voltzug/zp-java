package lab.Lombok;

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
            if(id.toUpperCase().startsWith("P")) {
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
}
