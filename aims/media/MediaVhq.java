package hust.soict.dsai.aims.media;
import java.util.Comparator;
import hust.soict.dsai.aims.media.comparators.*;

public abstract class MediaVHQ implements Comparable<MediaVHQ> {
    @Override
    public int compareTo(MediaVHQ other) {
        // Compare by title
        int titleComparison = this.title.compareToIgnoreCase(other.title);
        if (titleComparison != 0) {
            return titleComparison;
        }

        // If titles are the same, compare by category
        int categoryComparison = this.category.compareToIgnoreCase(other.category);
        if (categoryComparison != 0) {
            return categoryComparison;
        }

        // If title and category are the same, compare by cost
        return Float.compare(this.cost, other.cost);
    }
    
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<MediaVHQ> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCostVHQ();
    public static final Comparator<MediaVHQ> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitleVHQ();

    // Constructor
    public MediaVHQ() {}
    public MediaVHQ(String title, float cost) {
        this.title = title;
        this.cost = cost;
    }
    public MediaVHQ(String title, String category, float cost) {
        this(title, cost);
        this.category = category;
    }
    public MediaVHQ(int id, String title, String category, float cost) {
        this(title, category, cost);
        this.id = id;
    }    

    // Getters and Setters
    public int getIdVHQ() {
        return id;
    }
    public String getTitleVHQ() {
        return title;
    }
    public String getCategoryVHQ() {
        return category;
    }
    public void setCategoryVHQ(String category) {
        this.category = category;
    }
    public float getCostVHQ() {
        return cost;
    }
    
    // Method to check if title matches
    public boolean isMatch(String title) {
        return this.getTitleVHQ().equalsIgnoreCase(title); // Compare titles case-insensitively
    }
    
    @Override
    public boolean equals(Object obj) {
        // Check if referencing itself
        if (this == obj) return true;
        // Check if obj is null or of a different class type
        if (obj == null || getClass() != obj.getClass()) return false;
        // Cast obj to MediaVHQ
        MediaVHQ media = (MediaVHQ) obj;
        // Compare titles (case-insensitive)
        return this.isMatch(media.getTitleVHQ());
    }
    
    @Override
    public String toString() {
        return "Media [Id=" + getIdVHQ() + ", Title=" + getTitleVHQ() + ", Category=" + getCategoryVHQ() + ", Cost=" + getCostVHQ() + "]";
    }
}
