package cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapCartDAO implements CartDAO {
	
	static private HashMap<Integer, CartItem> cartTable = new HashMap<>();
	static int cart_seq = 0;

	@Override
	public int insert(CartItem cartItem) {
		int result = 0;
		
		cartItem.setCartId(++cart_seq);
		cartTable.put(cart_seq, cartItem);
		result++;
		return result;
	}

	@Override
	public CartItem select(int cartId, int loggedMemberNo) {
		CartItem item = cartTable.get(cartId);
		if (item.getMemberNo() == loggedMemberNo) return item;
		return null;
	}

	@Override
	public CartItem selectByBookId(int loggedMemberNo, int bookId) {
		List<CartItem> itemList = selectAll(loggedMemberNo);
		if (itemList.size() == 0) return null;
		
		for (CartItem item : itemList) {
			if (item.getBookId() == bookId) return item;
		}
		return null;
	}

	@Override
	public List<CartItem> selectByBookId(int bookId) {
		List<CartItem> itemList = new ArrayList<>();
		
		for (CartItem item : cartTable.values()) {
			if (item.getBookId() == bookId) {
				itemList.add(item);
			}
		}
		return itemList;
	}

	@Override
	public List<CartItem> selectAll(int loggedMemberNo) {
		List<CartItem> itemList = new ArrayList<>();
		
		for (CartItem item : cartTable.values()) {
			if (item.getMemberNo() == loggedMemberNo) {
				itemList.add(item);
			}
		}
		return itemList;
	}

	@Override
	public int update(int cartId, int loggedMemberNo, int quantity) {
		// 장바구니 아이템의 수량을 update
		
		CartItem item = cartTable.get(cartId);
		if (item == null) return 0;
		
		if (item.getMemberNo() != loggedMemberNo) return 0;
		
		item.setQuantity(quantity);
		
		return 1;
	}

	@Override
	public int delete(int cartId, int loggedMemberNo) {
		CartItem item = cartTable.get(cartId);
		if (item != null && item.getMemberNo() == loggedMemberNo) {
			cartTable.remove(cartId);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteByBookId(int bookId) {
		int result = 0;
		
		List<CartItem> itemList = selectByBookId(bookId);
		
		/*
		for (CartItem item : itemList) {
			cartTable.remove(item.getCartId());
			result += 1;
		}
		*/
		
		for (CartItem item : cartTable.values()) {
			if (item.getBookId() == bookId) {
				cartTable.remove(item.getCartId());
				result += 1;
				System.out.println("장바구니에서 책 삭제");
			}
		}
		return result;
	}

	@Override
	public int deleteAll(int loggedMemberNo) {
		int result = 0;
		
		List<CartItem> itemList = selectAll(loggedMemberNo);
		for (CartItem item : itemList) {
			cartTable.remove(item.getCartId());
			result += 1;
		}
		return result;
	}

}
