package UI.models;

import persistence.DBHandler;

import java.sql.SQLException;

public class User {

    private int id;

    private String email;

    private String password;

    private String name;

    private String surname;

    public User(int id, String name, String surname, String password, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean connector() throws SQLException {
        DBHandler dbHandler = DBHandler.getInstance();
        return dbHandler.findUser(this.getEmail(), this.getPassword());
    }

    public void establishUser() throws SQLException {
        DBHandler dbHandler = DBHandler.getInstance();
        dbHandler.addUser(this);
    }
}