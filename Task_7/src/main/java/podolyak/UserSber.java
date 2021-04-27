package podolyak;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * Метод находит дубликаты, ооооооооочень долго, около 3х мин. для двух коллекций по 100_000 значений
     *
     * @param collA UserSber
     * @param collB UserSber
     * @return список дубликатов
     */
    public static List<UserSber> findDuplicates1(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> duplicates = new ArrayList<>();
        for (UserSber user1 : collA) {
            for (UserSber user2 : collB) {
                if (user1.equals(user2)) {
                    duplicates.add(user1);
                    break;
                }
            }
        }
        return duplicates.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Метод находит дубликаты быстро, использует встроенную функцию Collection1.retainAll(Collection2)
     *
     * @param collA UserSber
     * @param collB UserSber
     * @return список дубликатов
     */
    public static List<UserSber> findDuplicates2(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> A = new HashSet<>(collA);
        Set<UserSber> B = new HashSet<>(collB);
        A.retainAll(B);
        List<UserSber> duplicates = new ArrayList<>(A);
        return duplicates;
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
