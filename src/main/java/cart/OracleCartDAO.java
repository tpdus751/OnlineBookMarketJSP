package cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.OracleJDBConnection;

public class OracleCartDAO implements CartDAO {

	@Override
	public int insert(CartItem cartItem) {
		int result = 0;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = new StringBuilder("insert into cart ")
				.append("(id, member_no, book_id, quantity, regdate) ")
				.append("values (cart_seq.nextval, ?, ?, ?, sysdate)")
				.toString();
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, cartItem.getMemberNo());
			jdbc.pstmt.setInt(2, cartItem.getBookId());
			jdbc.pstmt.setInt(3, cartItem.getQuantity());
			
			result = jdbc.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public CartItem select(int cartId, int loggedMemberNo) {
		CartItem item = null;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "select * from cart where id = ? and member_no = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, cartId);
			jdbc.pstmt.setInt(2, loggedMemberNo);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			if (jdbc.rs.next()) {
				item = new CartItem(
						jdbc.rs.getInt("id"),
						jdbc.rs.getInt("member_no"),
						jdbc.rs.getInt("book_id"),
						jdbc.rs.getInt("quantity"),
						jdbc.rs.getDate("regdate")
					);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return item;
	}

	@Override
	public CartItem selectByBookId(int loggedMemberNo, int bookId) {
		CartItem item = null;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "select * from cart where member_no = ? and book_id = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, loggedMemberNo);
			jdbc.pstmt.setInt(2, bookId);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			if (jdbc.rs.next()) {
				item = new CartItem(
						jdbc.rs.getInt("id"),
						jdbc.rs.getInt("member_no"),
						jdbc.rs.getInt("book_id"),
						jdbc.rs.getInt("quantity"),
						jdbc.rs.getDate("regdate")
					);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return item;
	}

	@Override
	public List<CartItem> selectByBookId(int bookId) { // for admin
		List<CartItem> itemList = new ArrayList<>();
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "select * from cart where book_id = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, bookId);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			while (jdbc.rs.next()) {
				CartItem item = new CartItem(
						jdbc.rs.getInt("id"),
						jdbc.rs.getInt("member_no"),
						jdbc.rs.getInt("book_id"),
						jdbc.rs.getInt("quantity"),
						jdbc.rs.getDate("regdate")
					);
				itemList.add(item);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itemList;
	}

	@Override
	public List<CartItem> selectAll(int loggedMemberNo) {
		List<CartItem> itemList = new ArrayList<>();
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "select * from cart where member_no = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, loggedMemberNo);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			while (jdbc.rs.next()) {
				CartItem item = new CartItem(
						jdbc.rs.getInt("id"),
						jdbc.rs.getInt("member_no"),
						jdbc.rs.getInt("book_id"),
						jdbc.rs.getInt("quantity"),
						jdbc.rs.getDate("regdate")
						);
				itemList.add(item);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itemList;
	}

	@Override
	public int update(int cartId, int loggedMemberNo, int quantity) {
		int result = 0;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = new StringBuilder()
						.append("update cart ")
						.append("set quantity = ? ")
						.append("where id = ? and member_no = ?")
						.toString();
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, quantity);
			jdbc.pstmt.setInt(2, cartId);
			jdbc.pstmt.setInt(3, loggedMemberNo);
			
			result = jdbc.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(int cartId, int loggedMemberNo) {
		int result = 0;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "delete cart where id = ? and member_no = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, cartId);
			jdbc.pstmt.setInt(2, loggedMemberNo);
			
			result = jdbc.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteByBookId(int bookId) {
		int result = 0;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "delete cart where book_id = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, bookId);
			
			result = jdbc.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteAll(int loggedMemberNo) {
		int result = 0;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "delete cart where member_no = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, loggedMemberNo);
			
			result = jdbc.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
