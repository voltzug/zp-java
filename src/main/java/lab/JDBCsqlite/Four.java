package lab.JDBCsqlite;

import base.Context;

import java.util.List;

public class Four extends Context {
    @Override
    protected void execute() throws Exception {
        DB bazaDanych = new DB();
        //bazaDanych.insertStudent( "Kowalski", "Jan");
        //bazaDanych.insertStudent( "Wiśniewski","Piotr");
        //bazaDanych.insertStudent( "Nowak", "Michał");
        List<Student> lista = bazaDanych.getStudents();
        for (Student s : lista) {
            System.out.println(s.getId() + " " + s.getSurname() + " " + s.getName() );
        }
        bazaDanych.closeConnection();
    }
}
