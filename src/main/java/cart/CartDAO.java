package cart;

import java.util.List;

public interface CartDAO {
	int insert(CartItem cartItem);
	CartItem select(int cartId, int loggedMemberNo);
	CartItem selectByBookId(int loggedMemberNo, int bookId);
	List<CartItem> selectByBookId(int bookId);
	List<CartItem> selectAll(int loggedMemberNo);
	int update(int cartId, int loggedMemberNo, int quantity);
	int delete(int cartId, int loggedMemberNo);
	int deleteByBookId(int bookId);
	int deleteAll(int loggedMemberNo);
}
