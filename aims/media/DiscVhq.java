package hust.soict.dsai.aims.media;
public class DiscVHQ extends MediaVHQ {
    private int length;
    private String author;
    // Constructor đầy đủ
    public DiscVHQ(int id, String title, String category, String author, int length, float cost) {
        super(id, title, category, cost); // Gọi constructor lớp Media
        this.length = length;
        this.author = author;
    }
    public DiscVHQ(String title, float cost) {
        super(title, cost);
    }
    // Getters
    public int getLengthVHQ() {
        return length;
    }
    public String getAuthorVHQ() {
        return author;
    }
    // Setter
    public void setLengthVHQ(int length) {
        this.length = length;
    }
    public void setAuthorVHQ(String author) {
        this.author = author;
    }
}
