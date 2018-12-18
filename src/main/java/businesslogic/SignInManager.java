package businesslogic;

import businesslogic.entities.Session;
import businesslogic.entities.SignIn;
import persistence.UserDAO;
import persistence.UserDAOInterface;
import persistence.UserDTO;

import static persistence.UserDAO.convertLoginToUserDTO;

public class SignInManager implements SignInManagerInterface {

    private UserDAOInterface userRepository;

    public SignInManager() {
        userRepository = new UserDAO();
    }

    public boolean getSignIn(SignIn signIn) {
        UserDTO result = userRepository.isSignIn(convertLoginToUserDTO(signIn));

        if (result != null)
            Session.getInstance().setSessionID(result.getId());

        return result == null;
    }

}
