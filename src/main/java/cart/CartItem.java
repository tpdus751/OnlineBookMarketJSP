package cart;

import java.sql.Date;

public class CartItem {
	private int cartId;
	private int memberNo;
	private int bookId;
	private int quantity;
	private Date addDate;
	
	public CartItem(int cartId, int memberNo, int bookId, int quantity, Date addDate) {
		this.cartId = cartId;
		this.memberNo = memberNo;
		this.bookId = bookId;
		this.quantity = quantity;
		this.addDate = addDate;
	}

	public CartItem(int cartId, int memberNo, int bookId, int quantity) {
		this.cartId = cartId;
		this.memberNo = memberNo;
		this.bookId = bookId;
		this.quantity = quantity;
	}

	public CartItem(int memberNo, int bookId, int quantity) {
		this.memberNo = memberNo;
		this.bookId = bookId;
		this.quantity = quantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	@Override
	public String toString() {
		return "CartItem [cartId=" + cartId + ", memberNo=" + memberNo + ", bookId=" + bookId + ", quantity=" + quantity
				+ ", addDate=" + addDate + "]";
	}
}
