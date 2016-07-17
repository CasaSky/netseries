package de.netseries.entities;

import de.netseries.utils.Kategorie;

/**
 * Created by talal on 17.07.16.
 */
public class Series extends Medium {

    @Override
    public Medium create(String name, Watcher creator, Kategorie genre) {
        this.initLists();
        this.setName(name);
        this.setCreator(creator);
        this.setGenre(genre);
        return new Series();
    }
}
