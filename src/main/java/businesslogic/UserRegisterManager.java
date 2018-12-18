package businesslogic;

import businesslogic.entities.Session;
import businesslogic.entities.User;
import persistence.UserDAO;
import persistence.UserDTO;

import static persistence.UserDAO.convertUserToUserDTO;

public class UserRegisterManager implements UserRegisterManagerInterface {

    private UserDAO userRepository;

    public UserRegisterManager() {
        userRepository = new UserDAO();
    }

    public boolean getUser(User user) {
        UserDTO result = userRepository.isRegistered(convertUserToUserDTO(user));

        if (result != null)
            Session.getInstance().setSessionID(result.getId());
        return result == null;
    }

    public void addUser(User user) {
        userRepository.addObject(convertUserToUserDTO(user));

        UserDTO result = userRepository.isRegistered(convertUserToUserDTO(user));
        Session.getInstance().setSessionID(result.getId());

    }

}
