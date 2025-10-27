package lab.JDBCsqlite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class DBGui extends JFrame {
    private DB db;
    // GUI components
    private JTextField idField, surnameField, nameField;
    private JTextArea displayArea;

    public DBGui(DB db) {
        this.db = db;
        setTitle("Student Database Management");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Initialize components
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel surnameLabel = new JLabel("Surname:");
        surnameField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        JButton insertButton = new JButton("Insert");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton fetchButton = new JButton("Fetch All");

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        // Add components to the frame
        add(idLabel);
        add(idField);
        add(surnameLabel);
        add(surnameField);
        add(nameLabel);
        add(nameField);
        add(insertButton);
        add(updateButton);
        add(deleteButton);
        add(fetchButton);
        add(new JScrollPane(displayArea));

        // Button actions
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String surname = surnameField.getText();
                String name = nameField.getText();
                if (db.insertStudent(surname, name)) {
                    displayArea.append("Inserted: " + surname + " " + name + "\n");
                } else {
                    displayArea.append("Failed to insert: " + surname + " " + name + "\n");
                }
                clearFields();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String surname = surnameField.getText();
                String name = nameField.getText();
                if (db.updateStudent(id, surname, name)) {
                    displayArea.append("Updated Student ID: " + id + "\n");
                } else {
                    displayArea.append("Failed to update Student ID: " + id + "\n");
                }
                clearFields();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                if (db.deleteStudent(id)) {
                    displayArea.append("Deleted Student ID: " + id + "\n");
                } else {
                    displayArea.append("Failed to delete Student ID: " + id + "\n");
                }
                clearFields();
            }
        });

        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Student> students = db.getAllStudents();
                    displayArea.append("All Students:\n");
                    for (Student student : students) {
                        displayArea.append(student.getId() + ": " + student.getSurname() + " " + student.getName() + "\n");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    displayArea.append("Error fetching students.\n");
                }
            }
        });
    }

    private void clearFields() {
        idField.setText("");
        surnameField.setText("");
        nameField.setText("");
    }
}
