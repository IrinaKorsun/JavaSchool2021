package starikov;

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

    public void setUsername(String username) {
        this.username = username;
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

    //HashSet и HashSet
    public static List<UserSber> findDuplicates1(Collection<UserSber> collA, Collection<UserSber> collB) {

        HashSet<UserSber> setFromCollA = new HashSet<>(collA);
        HashSet<UserSber> setFromCollB = new HashSet<>(collB);

        ArrayList<UserSber> listOfDuplicates = new ArrayList<>();

        for (UserSber user : setFromCollB
        ) {
            if (setFromCollA.contains(user)) {
                listOfDuplicates.add(user);
            }
        }
        return listOfDuplicates;
    }

    //HashSet и ArrayList
    public static List<UserSber> findDuplicates2(Collection<UserSber> collA, Collection<UserSber> collB) {

        HashSet<UserSber> setFromCollA = new HashSet<>(collA);
        ArrayList<UserSber> listFromCollB = new ArrayList<>(collB);

        HashSet<UserSber> setOfDuplicates = new HashSet<>();

        for (UserSber user : listFromCollB
        ) {
            if (setFromCollA.contains(user)) {
                setOfDuplicates.add(user);
            }
        }
        return new ArrayList<>(setOfDuplicates);
    }

    public static List<UserSber> findDuplicates3(Collection<UserSber> collA, Collection<UserSber> collB) {

        HashSet<UserSber> setFromCollA = new HashSet<>(collA);
        ArrayList<UserSber> listFromCollB = new ArrayList<>(collB);

        listFromCollB.retainAll(setFromCollA);

        HashSet<UserSber> setFromListCollB = new HashSet<>(listFromCollB);

        return new ArrayList<>(setFromListCollB);
    }

    @Override
    public String toString() {
        return username + ": " + email;
    }
}
