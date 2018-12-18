package businesslogic;

import businesslogic.entities.User;

public interface UserRegisterManagerInterface {
    boolean getUser(User user);

    void addUser(User user);
}
