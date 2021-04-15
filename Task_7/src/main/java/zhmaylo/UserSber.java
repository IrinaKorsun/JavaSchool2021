package zhmaylo;

import java.util.Arrays;

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

    /**
     * Переопределяем hashCode обьектов UserSber путем сложения всех полей обьекта
     * 31 не используем, ибо он уже используется в определении хэшкодов элементов
     *
     * @return int hashCode обьекта UserSber
     */
    @Override
    public int hashCode() {
        return (getUsername().hashCode() + getEmail().hashCode() + Arrays.hashCode(getPasswordHash()));
    }

    /**
     * Переопределяем метод equals, использую геттеры для получения данных а не обращаюсь напрямую,
     * так как раз они есть- надо использовать.
     *
     * @param obj обьект с которым происходит сравнение
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        UserSber convertedObj = (UserSber) obj;
        return getUsername().equals(convertedObj.getUsername()) &&
                getEmail().equals(convertedObj.getEmail()) &&
                Arrays.equals(getPasswordHash(), convertedObj.getPasswordHash());
    }
}
