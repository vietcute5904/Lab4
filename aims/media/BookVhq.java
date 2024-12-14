package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class BookVHQ extends MediaVHQ {
    private List<String> authors = new ArrayList<>();
    public BookVHQ(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    public BookVHQ(String title, float cost) {
        super(title, cost);
    }
    // Add an author 
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println(authorName + " has been added.");
        } else {
            System.out.println(authorName + " is already in the list.");
        }
    }
    // Remove an author
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println(authorName + " has been removed.");
        } else {
            System.out.println(authorName + " is not in the list.");
        }
    }
    // Phương thức lấy danh sách tác giả
    public List<String> getAuthorsVHQ() {
        return authors;
    }
    @Override
    public String toString() {
        return "Book [" + getTitleVHQ() + 
        " - " + getCategoryVHQ() + 
        // " - " + getAuthorsVHQ() +  
        " - " + getCostVHQ() + "]";
    }
    @Override
    public int compareTo(MediaVHQ other) {
        // Gọi phương thức compareTo từ lớp cha (so sánh title, category, cost)
        int baseComparison = super.compareTo(other);
        if (baseComparison != 0) {
            return baseComparison;
        }

        // So sánh thêm thuộc tính authors (nếu đối tượng kia cũng là Book)
        if (other instanceof BookVHQ) {
            BookVHQ otherBook = (BookVHQ) other;
            return Integer.compare(this.authors.size(), otherBook.authors.size());
        }

        return 0; // Nếu không cùng loại, giữ nguyên thứ tự so sánh cơ bản
    }
}