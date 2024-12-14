package hust.soict.dsai.aims.media;

public class TrackVHQ implements PlayableVHQ {
    // Private fields
    private String title;
    private int length;  // Length in seconds

    public void play() {
        System.out.println("Playing track: " + this.getTitleVHQ());
        System.out.println("Track length: " + this.getLengthVHQ());
    }

    // Constructor
    public TrackVHQ(String title, int length) {
        // Validate title
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        // Validate length
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0.");
        }
        this.title = title;
        this.length = length;
    }

    // Getters
    public String getTitleVHQ() {
        return title;
    }
    public int getLengthVHQ() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        // Check if referencing itself
        if (this == obj) return true;
        // Check if obj is null or of a different class type
        if (obj == null || getClass() != obj.getClass()) return false;
        // Cast obj to TrackVHQ
        TrackVHQ track = (TrackVHQ) obj;
        // Compare title and length
        return this.title.equalsIgnoreCase(track.title) && this.length == track.length;
    }
}
