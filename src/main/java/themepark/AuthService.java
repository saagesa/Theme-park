package themepark;
import themepark.User;
import themepark.Repository;

import java.util.Optional;
import java.util.UUID;

public class AuthService {
    private final Repository<String, User> userRepo;

    public AuthService(Repository<String, User> userRepo) { this.userRepo = userRepo; }

    // simple register: store password "hash" directly (demo)
    public User register(String name, String email, String password) {
        String id = UUID.randomUUID().toString();
        String pwHash = hash(password);
        User u = new User(id, name, email, pwHash, User.Role.GUEST);
        userRepo.save(u);
        return u;
    }

    public Optional<User> login(String email, String password) {
        return userRepo.findAll().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .filter(u -> u.getPasswordHash().equals(hash(password)))
                .findFirst();
    }

    private String hash(String s) { return Integer.toHexString(s.hashCode()); }
}
