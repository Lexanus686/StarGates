package DataBase;

import springpackage.spirngclasses.User;

import java.sql.SQLException;
import java.util.List;

public class MainDB {
    public static void main(String[] args) {
        try {
            // Создаем экземпляр по работе с БД
            DBHandler dbHandler = DBHandler.getInstance();
            // Добавляем запись
            //dbHandler.addProduct(new Product("Музей", 200, "Развлечения"));
            // Получаем все записи и выводим их на консоль
            List<User> users = dbHandler.getAllUsers();
            for (User user : users) {
                System.out.println(user.getName() + user.getSurname());
            }
            // Удаление записи с id = 2
            //dbHandler.deleteProduct(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
