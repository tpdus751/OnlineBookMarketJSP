package book;

import java.util.List;

import cart.CartItem;
import cart.CartService;
import cart.HashMapCartDAO;
import cart.SYCartService;

public class SYBookService implements BookService {
	
	BookDAO bookDao;
	
	public SYBookService(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public boolean regist(Book book) {
		if (book == null) return false;
		System.out.println("여기는됌");
		int result = bookDao.insert(book);
		return result == 1 ? true : false;
	}

	@Override
	public Book detail(int id) {
		Book book = bookDao.select(id);
		return book;
	}

	@Override
	public List<Book> listAll() {
		List<Book> bookList = bookDao.selectAll();
		return bookList;
	}

	@Override
	public boolean edit(Book book) {
		if (book == null) return false;
		int result = bookDao.update(book);
		return result == 1 ? true : false;
	}

	@Override
	public boolean remove(int id) {
		
		if (bookDao.select(id) == null) return false;
		System.out.println("여긴 패스");
		int result = 0;
		CartService cartService = new SYCartService(new HashMapCartDAO());
		List<CartItem> itemList = cartService.readByBookId(id);
		if (itemList.size() > 0) {
			cartService.removeByBookId(id);
		}
		result = bookDao.delete(id);
		return result == 1 ? true : false;
	}

}
