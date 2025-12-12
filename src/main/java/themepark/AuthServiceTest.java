package themepark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {
    private AuthService auth;

  
    void setup() {
        var repo = new InMemoryRepository<String, User>(u->u.getId());
        auth = new AuthService(repo);
    }

    void registerAndLogin_success() {
        var u = auth.register("Ana","ana@example.com","pw");
        var opt = auth.login("ana@example.com","pw");
        assertTrue(opt.isPresent());
        assertEquals(u.getEmail(), opt.get().getEmail());
    }


    void login_wrongPassword_fails() {
        auth.register("Bob","bob@example.com","secret");
        var opt = auth.login("bob@example.com","wrong");
        assertTrue(opt.isEmpty());
    }
}

