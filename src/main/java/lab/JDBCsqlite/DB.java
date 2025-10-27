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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + TABLE_NAME + " VALUES (null,?,?)");
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

    private Student parseStudent(ResultSet resultSet) throws SQLException {
        return new Student(resultSet.getInt("id"), resultSet.getString("surname"), resultSet.getString("name"));
    }

    public Student getStudent(int id) throws Exception {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = " + id);
        if (resultSet.next()) {
            return parseStudent(resultSet);
        }
        throw new Exception("Nie ma takiego studenta");
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new LinkedList<>();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME);
        while (resultSet.next()) {
            students.add(parseStudent(resultSet));
        }
        return students;
    }

    public boolean updateStudent(int id, String surname, String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE " + TABLE_NAME + " SET surname = ?, name = ? WHERE id = " + id);
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.println("Błąd przy zmianie danych studenta: " + id);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteStudent(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE id = " + id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.println("Błąd przy usuwaniu studenta: " + id);
            e.printStackTrace();
            return false;
        }
        return true;
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
