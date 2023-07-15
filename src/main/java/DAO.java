public interface DAO {
    List<User> getAllUsers();
    User getUserById(int id);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
