package lab.Lombok;

import base.Context;

public class Six extends Context {
    @Override
    protected void execute() throws Exception {
        // def
        Student.def sd1 = new Student.def("Jan", "Kowalski", 20, "ul. Jasna 1", "S123", "Informatyka");
        Student.def sd2 = new Student.def("Anna", "Nowak", 22, "ul. Ciemna 2", "S124", "Matematyka");
        Professor.def pd1 = new Professor.def("Maria", "Wiśniewska", 45, "ul. Słoneczna 1", "P101", "Fizyka");
        Professor.def pd2 = new Professor.def("Tomasz", "Zalewski", 50, "ul. Księżycowa 3", "P102", "Chemia");
        System.out.println("Studenci:");
        System.out.println(sd1);
        System.out.println(sd2);
        System.out.println("\nProfesorzy:");
        System.out.println(pd1);
        System.out.println(pd2);

        // lom
        System.out.println("\n\nLOMBOK");
        Student.lom sl1 = Student.lom.builder()
                .name("Jan")
                .lastName("Kowalski")
                .age(20)
                .address("ul. Jasna 1")
                .studentId("134")
                .major("Informatyka")
                .build();
        Student.lom sl2 = Student.lom.builder()
                .name("Anna")
                .lastName("Nowak")
                .age(22)
                .address("ul. Ciemna 2")
                .studentId("S124")
                .major("Matematyka")
                .build();
        Professor.lom pl1 = Professor.lom.builder()
                .name("Maria")
                .lastName("Wiśniewska")
                .age(45)
                .address("ul. Słoneczna 1")
                .employeeId("1223")
                .department("Fizyka")
                .build();
        Professor.lom pl2 = Professor.lom.builder()
                .name("Tomasz")
                .lastName("Zalewski")
                .age(50)
                .address("ul. Księżycowa 3")
                .employeeId("P221")
                .department("Chemia")
                .build();
        System.out.println("Studenci:");
        System.out.println(sl1);
        System.out.println(sl2);
        System.out.println("\nProfesorzy:");
        System.out.println(pl1);
        System.out.println(pl2);
    }


    public static void main(String[] args){
        var l6 = new Six();
        l6.run();
    }
}
