package persistence;

import businesslogic.Login;
import businesslogic.User;

import java.sql.*;

import static java.lang.System.exit;

public class UserRepository extends Repository<UserDTO> {

    private static final String CON_STR_USERS = "jdbc:sqlite:C:/Users/User/.IntelliJIdea2018.2/StarGates/src/main/java/DataBase/Users.s3db";
    private Connection connection;
    private DBHandler instance;

    public UserRepository() {
        try {
            this.instance = new DBHandler(CON_STR_USERS);
            this.connection = instance.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            exit(0);
        }
    }

    @Override
    public UserDTO getObject(UserDTO dto) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM UserTable WHERE LOGIN=" + "\"" + dto.getLogin() + "\"" +
                    "AND PASSWORD=" + "\"" + dto.getPassword() + "\"");
            if (resultSet.next()) {
                int current_id = resultSet.getInt(1);
                resultSet = statement.executeQuery("SELECT * FROM UserTable WHERE ID=" + current_id);
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
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(
                    "INSERT INTO UserTable('LOGIN', 'PASSWORD', 'NAME', 'SURNAME') " +
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

    }

    @Override
    public void updateObject(UserDTO dto) {

    }

    public void deleteProduct(int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("DELETE FROM UserTable WHERE id = ?");
        statement.setObject(1, id);

        statement.execute();
    }

    public static UserDTO convertUserToUserDTO(User user) {
        return new UserDTO(user.getEmail(), user.getPassword(), user.getName(), user.getSurname());
    }

    public static UserDTO convertLoginToUserDTO(Login login) {
        return new UserDTO(login.getEmail(), login.getPassword(), null, null);
    }
}