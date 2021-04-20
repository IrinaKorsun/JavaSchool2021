package galuza;

import java.util.Arrays;
import java.util.Objects;

public class UserSber {
    private String userName;
    private String email;
    private byte[] passwordHash;

    public UserSber(String userName, String email) {
        this.userName = userName;
        this.email = email;
        this.passwordHash = userName.getBytes();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSber userSber = (UserSber) o;
        return Objects.equals(userName, userSber.userName) && Objects.equals(email, userSber.email) && Arrays.equals(passwordHash, userSber.passwordHash);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userName, email);
        result = 31 * result + Arrays.hashCode(passwordHash);
        return result;
    }
}
