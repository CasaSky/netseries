package de.netseries.entities;

import de.netseries.utils.Kategorie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by talal on 17.07.16.
 */
public abstract class Medium extends Entity{

    private static List<Watcher> fans;
    private Watcher creator;
    private static List<String> streamers; // TODO Service
    private Kategorie genre;

    public static void initLists() {
        fans = new ArrayList<>();
        streamers = new ArrayList<>();
    }

    public void addFan(Watcher fan) {
        fans.add(fan);
    }

    public List<Watcher> getFans() {
        return fans;
    }

    public void setFans(List<Watcher> fans) {
        this.fans = fans;
    }

    public Watcher getCreator() {
        return creator;
    }

    public void setCreator(Watcher creator) {
        this.creator = creator;
    }

    public List<String> getStreamers() {
        return streamers;
    }

    public void setStreamers(List<String> streamers) {
        this.streamers = streamers;
    }

    public Kategorie getGenre() {
        return genre;
    }

    public void setGenre(Kategorie genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Medium{" +
                "fans=" + fans +
                ", creator=" + creator +
                ", streamers=" + streamers +
                ", genre=" + genre +
                '}';
    }
}