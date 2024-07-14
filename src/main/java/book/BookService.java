package book;

import java.util.List;

public interface BookService {
	boolean regist(Book book);
	Book detail(int id);
	List<Book> listAll();
	boolean edit(Book book);
	boolean remove(int id);
}
