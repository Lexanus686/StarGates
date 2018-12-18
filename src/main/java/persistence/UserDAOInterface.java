package persistence;

public interface UserDAOInterface extends Repository<UserDTO> {
    UserDTO isSignIn(UserDTO dto);

    UserDTO isRegistered(UserDTO dto);
}
