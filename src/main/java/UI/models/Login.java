package UI.models;

import persistence.DBHandler;

import java.sql.SQLException;

public class Login {
    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkLogin() throws SQLException {
        DBHandler dbHandler = DBHandler.getInstance();
        return dbHandler.findUser(this.getEmail(), this.getPassword());
    }
}
