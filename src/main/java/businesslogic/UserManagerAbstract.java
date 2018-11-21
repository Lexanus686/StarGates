package businesslogic;

import persistence.UserDTO;
import persistence.UserRepository;

import static persistence.UserRepository.convertUserToUserDTO;

public class UserManagerAbstract extends Session {

    private UserRepository userRepository = null;

    public UserManagerAbstract() {
        getInstance();
        userRepository = new UserRepository();
    }

    public boolean getUser(User user) {
        UserDTO result = userRepository.getObject(convertUserToUserDTO(user));

        if (result != null)
            super.setSessionID(result.getId());
        return result == null;
    }

    public void addUser(User user) {
        userRepository.addObject(convertUserToUserDTO(user));

        UserDTO result = userRepository.getObject(convertUserToUserDTO(user));
        super.setSessionID(result.getId());

    }

}
