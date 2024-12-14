package hust.soict.dsai.aims.media.comparators;

import java.util.Comparator;
import hust.soict.dsai.aims.media.MediaVHQ;

public class MediaComparatorByTitleCostVHQ implements Comparator<MediaVHQ> {
    @Override
    public int compare(MediaVHQ m1, MediaVHQ m2) {
        // Sort by title
        int titleCompare = m1.getTitleVHQ().compareToIgnoreCase(m2.getTitleVHQ());
        // If titles are the same, sort by cost in descending order
        if (titleCompare == 0) {
            return Float.compare(m2.getCostVHQ(), m1.getCostVHQ()); 
        }
        return titleCompare;
    }
}
