package hust.soict.dsai.aims.media;
import java.util.ArrayList;
public class CompactDiscVHQ extends DiscVHQ implements PlayableVHQ {
    private String artist;  
    private ArrayList<TrackVHQ> tracks;  // ArrayList chứa các đối tượng TrackVHQ    

    public void play() {
        System.out.println("Playing CompactDisc: " + getTitleVHQ());
        System.out.println("Artist: " + this.artist);

        if (tracks.isEmpty()) {
            System.out.println("No tracks to play.");
        } else {
            System.out.println("Tracks:");
            // Lặp qua tất cả các track và gọi phương thức play() của từng track
            for (TrackVHQ track : tracks) {
                track.play();
            }
        }
    }
    // Constructor với title và cost
    public CompactDiscVHQ(String title, float cost) {
        super(title, cost); 
        this.tracks = new ArrayList<TrackVHQ>();  // Khởi tạo danh sách tracks
    }
    // Constructor với các tham số đầy đủ
    public CompactDiscVHQ(int id, String title, String category,  String author, String artist, int length, float cost) {
        super(id, title, category, author, length, cost); 
        this.artist = artist;  // Gán giá trị cho trường artist
        this.tracks = new ArrayList<TrackVHQ>();  // Khởi tạo danh sách tracks
    }
    // Getter cho artist
    public String getArtistVHQ() {
        return artist;
    }
    // Phương thức thêm track vào danh sách tracks
    public void addTrackVHQ(TrackVHQ track) {
        if (track == null) {
            throw new IllegalArgumentException("Track cannot be null.");
        }
        // Kiểm tra xem track đã tồn tại chưa
        if (tracks.contains(track)) {
            System.out.println("Track already exists in the list.");
        } else {
            tracks.add(track);
            System.out.println("Track added.");
        }
    }
    // Phương thức xóa track khỏi danh sách tracks
    public void removeTrackVHQ(TrackVHQ track) {
        if (track == null) {
            throw new IllegalArgumentException("Track cannot be null.");
        }
        // Kiểm tra xem track có trong danh sách không
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed.");
        } else {
            System.out.println("Track not found.");
        }
    }
    // Phương thức tính tổng length của CompactDisc từ các track
    public int getLengthVHQ() {
        int totalLength = 0;
        for (TrackVHQ track : tracks) {
            totalLength += track.getLengthVHQ();  // Cộng tổng length của từng track
        }
        return totalLength;
    }
    @Override
    public String toString() {
        return "CD [" + getTitleVHQ() + 
        " - " + getAuthorVHQ() + 
        " - " + getArtistVHQ() + 
        " - " + tracks.size() + 
        " - " + getLengthVHQ() + 
        " - " + getCostVHQ() + "]";
    }
}
