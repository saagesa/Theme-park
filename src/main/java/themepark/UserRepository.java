package themepark;

public class UserRepository extends InMemoryRepository<String, User> {
    private static UserRepository instance;

    private UserRepository() { super(u -> u.getId()); }

    public static synchronized UserRepository getInstance() {
        if(instance == null) instance = new UserRepository();
        return instance;
    }
}
