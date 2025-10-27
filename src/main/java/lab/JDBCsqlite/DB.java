package lab.JDBCsqlite;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DB {
    // from pom.xml (org.xerial)
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:jdbc2.db";
    private static final String TABLE_NAME = "STUDENTS";
    private Connection connection;
    private Statement statement;

    public DB() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            System.err.println("Brak sterownika JDBC");
            ex.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
            createTable();
        } catch (SQLException ex) {
            System.err.println("Problem z otwarciem połączenia");
            ex.printStackTrace();
        }
    }

    public boolean createTable() {
        String tworz = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, surname String, name String)";
        try {
            statement.execute(tworz);
        } catch (SQLException e) {
            System.err.println("Błąd przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertStudent(String surname, String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + TABLE_NAME+ " VALUES (null,?,?)");
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.println("Błąd przy wprowadzaniu danych studenta: " + surname + " " + name);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Student> getStudents() {
        List<Student> wyjscie = new LinkedList<>();
        try {
            ResultSet resultSet =
                    statement.executeQuery("SELECT * FROM " + TABLE_NAME);
            int id;
            String surname, name;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                surname = resultSet.getString("surname");
                name = resultSet.getString("name");
                wyjscie.add(new Student(id, surname, name));
            }
        } catch (SQLException e) {
            System.err.println("Problem z wczytaniem danych z BD");
            e.printStackTrace();
            return null;
        }
        return wyjscie;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknięciem połączenia");
            e.printStackTrace();
        }
    }
}
