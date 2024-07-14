package cart;

import java.util.List;

public class SYCartService implements CartService {
	
	CartDAO cartDao;
	
	public SYCartService(CartDAO cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public boolean add(CartItem item) {
		if (item == null) return false;
		int result = 0;
		
		// bookId의 책이 이미 Cart에 있으면, 수량만 업데이트하기
		CartItem inCartItem = cartDao.selectByBookId(item.getMemberNo(), item.getBookId());
		if (inCartItem == null) result = cartDao.insert(item);
		else {
			int quantity = item.getQuantity() + inCartItem.getQuantity();
			result = cartDao.update(inCartItem.getCartId(), item.getMemberNo(), quantity);
		}
		return result == 1 ? true : false;
	}

	@Override
	public List<CartItem> readByBookId(int bookId) {
		return cartDao.selectByBookId(bookId);
	}
	
	@Override
	public CartItem readByBookId(int cartId, int loggedMemberNo) {
		CartItem item = cartDao.select(cartId, loggedMemberNo);
		return item;
	}
	

	@Override
	public List<CartItem> listAll(int loggedMemberNo) {
		return cartDao.selectAll(loggedMemberNo);
	}

	@Override
	public boolean update(int cartId, int loggedMemberNo, int quantity) {
		int result = cartDao.update(cartId, loggedMemberNo, quantity);
		return result == 1 ? true : false;
	}

	@Override
	public boolean remove(int cartId, int loggedMemberNo) {
		int result = cartDao.delete(cartId, loggedMemberNo);
		return result == 1 ? true : false;
	}

	@Override
	public boolean removeByBookId(int bookId) {
		int result = cartDao.deleteByBookId(bookId);
		return result == 1 ? true : false;
	}

	@Override
	public boolean clear(int loggedMemberNo) {
		int result = cartDao.deleteAll(loggedMemberNo);
		return result > 0 ? true : false;
	}


}
