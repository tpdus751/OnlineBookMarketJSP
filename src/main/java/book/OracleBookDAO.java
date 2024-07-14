package book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.OracleJDBConnection;
import book.Book;
import book.BookDAO;

public class OracleBookDAO implements BookDAO {

	@Override
	public int insert(Book book) {
		OracleJDBConnection jdbc = new OracleJDBConnection();
		int result = 0;
		
		String sql = new StringBuilder()
				.append("insert into book (id, title, author, publisher, price, instock, regdate) ")
				.append("values (book_seq.nextval, ?, ?, ?, ?, ?, sysdate)")
				.toString();
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			jdbc.pstmt.setString(1, book.getTitle());
			jdbc.pstmt.setString(2, book.getAuthor());
			jdbc.pstmt.setString(3, book.getPublisher());
			jdbc.pstmt.setInt(4, book.getPrice());
			jdbc.pstmt.setInt(5, book.getInstock());
			
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 추가되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return result;
	}
	

	@Override
	public Book select(int id) {
		OracleJDBConnection jdbc = new OracleJDBConnection();
		Book book = null;
		
		String sql = "select * from book where id = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, id);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			
			if (jdbc.rs.next()) {
				book = new Book(
					jdbc.rs.getString("title"),
					jdbc.rs.getString("author"),
					jdbc.rs.getString("publisher"),
					jdbc.rs.getInt("price"),
					jdbc.rs.getInt("instock")
				);
				book.setId(jdbc.rs.getInt("id"));
				book.setRegDate(jdbc.rs.getDate("regdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		
		return book;
	}

	@Override
	public List<Book> selectAll() {
		OracleJDBConnection jdbc = new OracleJDBConnection();
		List<Book> bookList = new ArrayList<>();
		
		String sql = "select * from book";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.rs = jdbc.pstmt.executeQuery();
			
			while (jdbc.rs.next()) {
				Book book = new Book(
						jdbc.rs.getString("title"),
						jdbc.rs.getString("author"),
						jdbc.rs.getString("publisher"),
						jdbc.rs.getInt("price"),
						jdbc.rs.getInt("instock")
				);
				book.setId(jdbc.rs.getInt("id"));
				book.setRegDate(jdbc.rs.getDate("regdate"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return bookList;
	}

	@Override
	public int update(Book book) {
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		int result = 0;
		String sql = new StringBuilder()
				.append("update book set ")
				.append("title = ?, ")
				.append("author = ?, ")
				.append("publisher = ?, ")
				.append("price = ?, ")
				.append("instock = ? ")
				.append("where id = ?")
				.toString();
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			jdbc.pstmt.setString(1, book.getTitle());
			jdbc.pstmt.setString(2, book.getAuthor());
			jdbc.pstmt.setString(3, book.getPublisher());
			jdbc.pstmt.setInt(4, book.getPrice());
			jdbc.pstmt.setInt(5, book.getInstock());
			jdbc.pstmt.setInt(6, book.getId());
			
			result = jdbc.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return result;
	}

	@Override
	public int delete(int id) {
		OracleJDBConnection jdbc = new OracleJDBConnection();
		int result = 0;
		
		String sql = "delete book where id=?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, id);
			
			result = jdbc.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return result;
	}

}
