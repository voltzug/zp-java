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
    }


    public static void main(String[] args){
        var l6 = new Six();
        l6.run();
    }
}
