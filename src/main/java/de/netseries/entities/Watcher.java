package de.netseries.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by talal on 16.07.16.
 */
public class Watcher extends Entity {

    private String username;
    private String password;

    private Integer age;
    private String country;
    //private static List<Medium> createdMedia;
    //private static List<Medium> likedMedia;
    private Long stars;

    public Watcher() {}

   /* private static void initLists() {
        createdMedia = new ArrayList<>();
        likedMedia = new ArrayList<>();
    }*/

    private Watcher(String name, String username, String password, Integer age, String country) {
        this.setName(name);
        this.username = username;
        this.password = password;
        this.age = age;
        this.country = country;
    }
    public static Watcher createWatcher(String name, String username, String password, Integer age, String country) {
        //initLists();
        return new Watcher(name, username, password, age, country);
    }

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
