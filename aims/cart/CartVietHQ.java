package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.Collections;
public class CartVietHQ {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<MediaVHQ> itemsOrdered = new ArrayList<MediaVHQ>();  // Giỏ hàng chứa các đối tượng Media

    // Thêm Media vào giỏ hàng (DigitalVideoDisc, Book, CompactDisc...)
    public void addMediaVHQ(MediaVHQ media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The " + media.getClass().getSimpleName() + " \"" + media.getTitleVHQ() + "\" has been added!");
        } else {
            System.out.println("Your cart is full, cannot add more!");
        }
    }
    // Xóa Media khỏi giỏ hàng
    public void removeMediaVHQ(MediaVHQ media) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }
        boolean found = false;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitleVHQ().equals(media.getTitleVHQ())) {
                itemsOrdered.remove(i);
                found = true;
                System.out.println("Remove " + media.getClass().getSimpleName() + " \"" + media.getTitleVHQ() + "\" successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("Media not found in the cart.");
        }
    }
    // Tính tổng chi phí của tất cả các Media trong giỏ hàng
    public float totalCostVHQ() {
        float total = 0f;
        for (MediaVHQ media : itemsOrdered) {
            total += media.getCostVHQ();  // Giả sử mỗi lớp con của Media đều có phương thức getCostVHQ()
        }
        return total;
    }
    // Liệt kê tất cả các ID của Media trong giỏ hàng
    public void listID() {
        if (itemsOrdered.size() == 0) {
            System.out.println("Your cart is empty!");
            return;
        }
        System.out.println("List of items in the cart:");
        for (MediaVHQ media : itemsOrdered) {
            System.out.println(media.getClass().getSimpleName() + " ID: " + media.getIdVHQ() +
                    ", Title: " + media.getTitleVHQ());
        }
    }
    // In giỏ hàng với thông tin chi tiết của các Media
    public void printCartVHQ() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is currently empty");
        } else {
            StringBuilder output = new StringBuilder("*********************CART************************** \nOrdered items: \n");
            for (MediaVHQ media : itemsOrdered) {
                output.append(media.toString()).append("\n"); // Thêm thông tin media vào StringBuilder
            }
            output.append("Total: ").append(totalCostVHQ()).append(" $");
            output.append("\n***************************************************\n");
            System.out.println(output);
        }
    }
    
    // Tìm Media theo ID
    public MediaVHQ searchByIDVHQ(int id) {
        for (MediaVHQ media : itemsOrdered) {
            if (media.getIdVHQ() == id) {
                System.out.println(media.toString());
                return media; // Trả về đối tượng Media tìm thấy
            }
        }
        System.out.println("No Media found with Id = " + id + " in cart");
        return null; // Trả về null nếu không tìm thấy
    }
    // Tìm Media theo Title
    public MediaVHQ searchByTitleVHQ(String title) {
        for (MediaVHQ media : itemsOrdered) {
            if (media.isMatch(title)) {  // Giả sử là phương thức kiểm tra tiêu đề trong Media
                System.out.println(media.toString());
                return media; // Trả về đối tượng Media tìm thấy
            }
        }
        System.out.println("No Media found with title \"" + title + "\"" + " in cart");
        return null; // Trả về null nếu không tìm thấy
    }
    // Sắp xếp theo comparator
    public void sortCartByTitleThenCost() {
        Collections.sort(itemsOrdered, MediaVHQ.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title then cost.");
    }

    public void sortCartByCostThenTitle() {
        Collections.sort(itemsOrdered, MediaVHQ.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost then title.");
    }
    // Phương thức clear() để xóa tất cả các phần tử trong giỏ hàng
    public void clearVHQ() {
        itemsOrdered.clear();  // Dùng phương thức clear() của ArrayList để xóa tất cả các phần tử
        System.out.println("The cart has been cleared.");
    }
    // Kiểm tra giỏ hàng trống hay không
    public boolean isEmptyVHQ() {
        return itemsOrdered.isEmpty(); // itemsInCartVHQ là danh sách chứa các Media trong giỏ
    }
}
