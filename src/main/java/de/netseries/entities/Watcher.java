package de.netseries.entities;

/**
 * Created by talal on 16.07.16.
 */
public class Watcher extends Entity {

    private String username;
    private String password;

    public Watcher() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Watcher)) return false;
        if (!super.equals(o)) return false;

        Watcher watcher = (Watcher) o;

        if (!username.equals(watcher.username)) return false;
        return password.equals(watcher.password);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Watcher{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
