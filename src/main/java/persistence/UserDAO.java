package persistence;

import businesslogic.entities.SignIn;
import businesslogic.entities.User;

import java.sql.*;

public class UserDAO implements UserDAOInterface {

    private Connection connection;

    public UserDAO() {
        try {
            this.connection = DBHandler.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDTO isSignIn(UserDTO dto) {
        return getObject(dto);
    }

    @Override
    public UserDTO isRegistered(UserDTO dto) {
        return getObject(dto);
    }

    @Override
    public UserDTO getObject(UserDTO dto) {
        try {

            int flag;
            if (dto.getName() == null && dto.getSurname() == null) {
                flag = 1;
            } else flag = 0;

            Statement statement = this.connection.createStatement();
            ResultSet resultSet = null;

            switch (flag) {
                case 0:
                    resultSet = statement.executeQuery(String.format("SELECT ID FROM Users WHERE LOGIN=\"%s\"", dto.getLogin()));
                    break;
                case 1:
                    resultSet = statement.executeQuery(String.format("SELECT ID FROM Users WHERE LOGIN=\"%s\" AND PASSWORD=\"%s\"", dto.getLogin(), dto.getPassword()));
                    break;
            }

            if (resultSet.next()) {
                int current_id = resultSet.getInt(1);
                resultSet = statement.executeQuery("SELECT * FROM Users WHERE ID=" + current_id);
                return new UserDTO(resultSet.getInt("ID"),
                        resultSet.getString("LOGIN"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getString("NAME"),
                        resultSet.getString("SURNAME"));
            } else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addObject(UserDTO dto) {
        PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement(
                    "INSERT INTO Users('LOGIN', 'PASSWORD', 'NAME', 'SURNAME') " +
                            "VALUES(?, ?, ?, ?)");
            statement.setObject(1, dto.getLogin());
            statement.setObject(2, dto.getPassword());
            statement.setObject(3, dto.getName());
            statement.setObject(4, dto.getSurname());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeObject(UserDTO dto) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM Users WHERE id = ?");
            statement.setObject(1, getObject(dto).getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObject(UserDTO dto) {

    }

    public static UserDTO convertUserToUserDTO(User user) {
        return new UserDTO(user.getEmail(), user.getPassword(), user.getName(), user.getSurname());
    }

    public static UserDTO convertLoginToUserDTO(SignIn signIn) {
        return new UserDTO(signIn.getEmail(), signIn.getPassword(), null, null);
    }
}