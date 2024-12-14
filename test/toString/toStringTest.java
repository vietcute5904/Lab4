package hust.soict.dsai.test.toString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import hust.soict.dsai.aims.media.*;

public class toStringTest {
    public static void main(String[] args) {
        // Create a list of Media objects
        List<MediaVHQ> mediaList = new ArrayList<>();
        
        mediaList.add(new CompactDiscVHQ(1, "Big Bang concert", "Music", "G-Dragon", "Top", 180, 9f));
        mediaList.add(new DVDVHQ("Dragon Ball", "Anime", 12f));
        mediaList.add(new BookVHQ(3, "Book 10000 question why", "hihi", 5f));
        
        // Print before sorting
        System.out.println("Before sorting:");
        for (MediaVHQ m : mediaList) {
            System.out.println(m);
        }

        // Sort by title and then cost (alphabetically and by descending cost)
        Collections.sort(mediaList, MediaVHQ.COMPARE_BY_TITLE_COST);
        
        System.out.println("\nAfter sorting by title and then cost:");
        for (MediaVHQ m : mediaList) {
            System.out.println(m);
        }
        
        // Sort by cost and then by title (by descending cost and alphabetically by title)
        Collections.sort(mediaList, MediaVHQ.COMPARE_BY_COST_TITLE);
        
        System.out.println("\nAfter sorting by cost and then title:");
        for (MediaVHQ m : mediaList) {
            System.out.println(m);
        }
    }
}
