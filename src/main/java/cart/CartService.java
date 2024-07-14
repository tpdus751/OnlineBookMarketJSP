package cart;

import java.util.List;

public interface CartService {
	boolean add(CartItem item);
	List<CartItem> readByBookId(int bookId);
	CartItem readByBookId(int cartId, int loggedMemberNo);
	List<CartItem> listAll(int loggedMemberNo);
	boolean update(int cartId, int loggedMemberNo, int quantity);
	boolean remove(int cartId, int loggedMemberNo);
	boolean removeByBookId(int bookId);
	boolean clear(int loggedMemberNo);
}
