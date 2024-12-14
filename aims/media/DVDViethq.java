package hust.soict.dsai.aims.media;

public class DVDVietHQ extends DiscVHQ implements PlayableVHQ {
    private static int nbDigitalVideoDiscsVHQ = 0;

    public void play() {
        System.out.println("Playing DVD: " + this.getTitleVHQ());
        System.out.println("DVD length: " + this.getLengthVHQ());
    }
    
    // Constructor with automatic id generation
    public DVDVietHQ(String title) {
        super(++nbDigitalVideoDiscsVHQ, title, null, null, 0, 0.0f);
    }
    
    // Constructor with title and cost
    public DVDVietHQ(String title, float cost) {
        super(title, cost); // Call DiscVHQ constructor
    }
    
    // Constructor with title, category, and cost
    public DVDVietHQ(String title, String category, float cost) {
        this(title, cost);
        this.setCategoryVHQ(category);
    }
    
    // Constructor with title, category, author, and cost
    public DVDVietHQ(String title, String category, String author, float cost) {
        this(title, category, cost);
        this.setAuthorVHQ(author);
    }
    
    // Constructor with title, category, author, length, and cost
    public DVDVietHQ(String title, String category, String author, int length, float cost) {
        this(title, category, author, cost);
        this.setLengthVHQ(length);
    }
    
    // Method to check if the title matches
    public boolean isMatch(String title) {
        return this.getTitleVHQ().equalsIgnoreCase(title); // Compare titles case-insensitively
    }
    
    @Override
    public String toString() {
        return "DVD [" + getTitleVHQ() + 
        " - " + getCategoryVHQ() + 
        " - " + getAuthorVHQ() + 
        " - " + getLengthVHQ() + 
        " - " + getCostVHQ() + "]";
    }
}
