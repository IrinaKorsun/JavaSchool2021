package zatsepin;

import java.util.Arrays;
import java.util.Objects;

/**
 * A class representing the user of Sberbank.
 */
public class UserSber {
    private String username;
    private String email;
    private byte[] passwordHash;

    /**
     * Constructor for creating a user object.
     */
    public UserSber(String username, String email) {
        this.username = username;
        this.email = email;
        this.passwordHash = username.getBytes();
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return passwordHash
     */
    public byte[] getPasswordHash() {
        return passwordHash;
    }

    /**
     * Sets passwordHash
     */
    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSber userSber = (UserSber) o;
        return Objects.equals(username, userSber.username) && Objects.equals(email, userSber.email) && Arrays.equals(passwordHash, userSber.passwordHash);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(username, email);
        result = 31 * result + Arrays.hashCode(passwordHash);
        return result;
    }

    @Override
    public String toString() {
        return "UserSber{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
