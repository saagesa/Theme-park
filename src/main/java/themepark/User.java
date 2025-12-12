package themepark;

import java.util.Objects;

public class User {
    private final String id;
    private String name;
    private String email;
    private String passwordHash; // simplistic - in real app use salted hashing libs
    private Role role;

    public enum Role { GUEST, STAFF, ADMIN }

    public User(String id, String name, String email, String passwordHash, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public Role getRole() { return role; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setRole(Role role) { this.role = role; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
    @Override
    public String toString() { return "User{" + id + ":" + email + "}"; }
}

