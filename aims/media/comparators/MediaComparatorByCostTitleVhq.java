package hust.soict.dsai.aims.media.comparators;

import java.util.Comparator;
import hust.soict.dsai.aims.media.MediaVHQ;

public class MediaComparatorByCostTitleVHQ implements Comparator<MediaVHQ> {
    @Override
    public int compare(MediaVHQ m1, MediaVHQ m2) {
        // Sort by cost in descending order
        int costCompare = Float.compare(m2.getCostVHQ(), m1.getCostVHQ());        
        // If costs are the same, sort by title
        if (costCompare == 0) {
            return m1.getTitleVHQ().compareToIgnoreCase(m2.getTitleVHQ()); 
        }
        return costCompare;
    }
}
