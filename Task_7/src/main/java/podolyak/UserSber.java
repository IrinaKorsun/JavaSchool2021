package podolyak;

import java.util.*;

public class UserSber {
    private String username;
    private String email;
    private byte[] passwordHash;

    public UserSber(String username, String email) {
        this.username = username;
        this.email = email;
        this.passwordHash = username.getBytes();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSber)) return false;
        UserSber userSber = (UserSber) o;
        return getUsername().equals(userSber.getUsername()) &&
                getEmail().equals(userSber.getEmail()) &&
                Arrays.equals(getPasswordHash(), userSber.getPasswordHash());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getUsername(), getEmail());
        result = 31 * result + Arrays.hashCode(getPasswordHash());
        return result;
    }

    @Override
    public String toString() {
        return "UserSber{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash=" + Arrays.toString(passwordHash) +
                '}';
    }
}
