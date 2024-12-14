package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class StoreVHQ {
    public static final int MAX_NUMBERS_IN_STORE = 100;

    // Attribute: dynamic list of Media objects available in the store
    private List<MediaVHQ> itemsInStoreVHQ;

    // Constructor to initialize the store
    public StoreVHQ() {
        itemsInStoreVHQ = new ArrayList<>(); // Use ArrayList for dynamic resizing
    }

    // Method to add a Media to the store (DigitalVideoDisc, Book, CompactDisc...)
    public void addMediaVHQ(MediaVHQ media) {
        if (itemsInStoreVHQ.size() >= MAX_NUMBERS_IN_STORE) {
            System.out.println("The store is full, cannot add more items.");
            return;
        }
        itemsInStoreVHQ.add(media);
        System.out.println("The " + media.getClass().getSimpleName() + " \"" + 
        media.getTitleVHQ() + "\" has been added to the store!");
    }

    // Method to remove a Media from the store
    public void removeMediaVHQ(MediaVHQ media) {
        boolean found = false;
        for (MediaVHQ storeMedia : itemsInStoreVHQ) {
            if (storeMedia == media) {
                itemsInStoreVHQ.remove(storeMedia);
                System.out.println("The " + storeMedia.getClass().getSimpleName() + 
                " \"" + storeMedia.getTitleVHQ() + "\" has been removed from the store.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found in the store that matches the given media.");
        }
    }

    // Method to search for a Media by its title
    public MediaVHQ searchByTitleVHQ(String title) {
        for (MediaVHQ media : itemsInStoreVHQ) {
            if (media.getTitleVHQ().equalsIgnoreCase(title)) {
                return media; // Return the found Media object
            }
        }
        System.out.println("No media with the title \"" + title + "\" was found in the store.");
        return null; // Return null if no media is found
    }

    // Display the list of all media in the store
    public void displayStoreVHQ() {
        if (itemsInStoreVHQ.isEmpty()) {
            System.out.println("The store is currently empty.");
            return;
        }
        for (MediaVHQ media : itemsInStoreVHQ) {
            System.out.println(media.toString());
        }
    }

    public void printMediaInfo(MediaVHQ media) {
        if (media == null) {
            System.out.println("Media not found.");
            return;
        }
        // Print information using the toString() method
        System.out.println(media.toString());
    }
}
