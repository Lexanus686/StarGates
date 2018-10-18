package DataBase;

import springpackage.spirngclasses.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBHandler {

    //Адрес подключения
    private static final String CON_STR = "jdbc:sqlite:Users.s3db";

    //Класс одиночка, чтобы не плодить мн-во экземпляров
    private static DBHandler instance = null;

    public static synchronized DBHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DBHandler();
        return instance;
    }

    //Объект для хранения соединения с БД
    private Connection connection;

    private DBHandler() throws SQLException {
        //DriverManager.registerDriver(new JDBC());

        this.connection = DriverManager.getConnection(CON_STR);
    }

    public List<User> getAllUsers() {

        //Statement для выполнения sql-запроса
        try {
            Statement statement = this.connection.createStatement();
            List<User> users = new ArrayList<User>();
            ResultSet resultSet = statement.executeQuery("SELECT ID, Login, Password, Name, Surname FROM Users");
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("ID"), resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getString("Name"), resultSet.getString("Surname")));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    //add user in BD
    public void addUser(User user) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "INSERT INTO Users('Email', 'Password', 'Name', 'Surname') " +
                            "VALUES(?, ?, ?, ?)");
            statement.setObject(1, user.getEmail());
            statement.setObject(2, user.getPassword());
            statement.setObject(3, user.getName());
            statement.setObject(4, user.getSurname());
            //Выполнение запроса
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM Products WHERE id = ?");
            statement.setObject(1, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
