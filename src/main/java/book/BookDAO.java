package book;

import java.util.List;

public interface BookDAO {
	int insert(Book book);
	Book select(int id);
	List<Book> selectAll();
	int update(Book book);
	int delete(int id);
}
