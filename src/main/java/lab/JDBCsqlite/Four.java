package lab.JDBCsqlite;

import base.Context;

import java.util.List;

public class Four extends Context {
    public Four() {
        super("Lab4", false);
    }

    @Override
    protected void execute() throws Exception {
        DB db = new DB();
        db.insertStudent( "Kowalski", "Jan");
        db.insertStudent( "Wiśniewski","Piotr");
        List<Student> allStudents = db.getAllStudents();
        for (Student s : allStudents) {
            System.out.println(s.toString());
        }
        int targetId = allStudents.getFirst().getId();
        System.out.println("Student z id="+targetId);
        System.out.println(db.getStudent(targetId).toString());
        System.out.println("Modyfikacja studenta o id=" + targetId);
        db.updateStudent(targetId, "Zmiana", "Imie");
        System.out.println(db.getStudent(targetId).toString());
        System.out.println("Usuniencie studenta o id=" + targetId + ": " + db.deleteStudent(targetId));

        var gui = new DBGui(db);
        gui.setVisible(true);
        System.in.read();

        db.closeConnection();
    }


    public static void main(String[] args){
        var l4 = new Four();
        l4.run();
    }
}
