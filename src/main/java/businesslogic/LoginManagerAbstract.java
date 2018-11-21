package businesslogic;

import persistence.UserDTO;
import persistence.UserRepository;

import static persistence.UserRepository.convertLoginToUserDTO;

public class LoginManagerAbstract extends Session {

    private UserRepository userRepository = null;

    public LoginManagerAbstract() {
        getInstance();
        userRepository = new UserRepository();
    }

    public boolean getLogin(Login login) {
        UserDTO result = userRepository.getObject(convertLoginToUserDTO(login));

        if (result != null)
            super.setSessionID(result.getId());

        return result == null;
    }

}
