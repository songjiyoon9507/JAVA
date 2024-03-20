package bookManagement.model.service;

import java.util.List;

import bookManagement.model.dao.BookManagementDAO;
import bookManagement.model.dao.BookManagementDAOImpl;
import bookManagement.model.dto.Book;

public class BookManagementServiceImpl implements BookManagementService {
	
	// DAO와 연결
	private BookManagementDAO dao = null;
	
	public BookManagementServiceImpl() throws Exception {
		dao = new BookManagementDAOImpl();
	}

	@Override
	public List<Book> bookListFullView() {
		return dao.bookListFullView();
	}

	/**
	 * 추가 되면 true 추가 안 되면 false 반환
	 */
	@Override
	public boolean addBookList(String title, String author, int price, String publisher, String category) throws Exception {
		// TODO Auto-generated method stub
		return dao.addBookList(title, author, price, publisher, category);
	}

	@Override
	public List<Book> sortByLowPrice() {
		return dao.sortByLowPrice();
	}

	@Override
	public List<Book> sortByHighPrice() {
		return dao.sortbyHighPrice();
	}

	@Override
	public List<Book> sortByTitle() {
		return dao.sortByTitle();
	}

	@Override
	public List<Book> sortByCategory() {
		return dao.sortByCategory();
	}

	/**
	 * 도서 번호 존재하면 true 반환, 존재하지 않으면 false 반환
	 */
	@Override
	public int indexMatch(int bookNum) {
		return dao.indexMatch(bookNum);
	}

	@Override
	public boolean updateTitle(int index, String title) throws Exception {
		return dao.updateTitle(index,title);
	}

	@Override
	public boolean updateAuthor(int index, String author) throws Exception {
		return dao.updateAuthor(index, author);
	}

	@Override
	public boolean updatePrice(int index, int price) throws Exception {
		return dao.updatePrice(index, price);
	}

	@Override
	public boolean updatePublisher(int index, String publisher) throws Exception {
		return dao.updatePublisher(index, publisher);
	}

	@Override
	public boolean updateCategory(int index, String category) throws Exception {
		return dao.updateCategory(index, category);
	}

	@Override
	public boolean checkBookNum(int bookNum) {
		boolean check = false;
		
		for(int i = 0 ; i < bookListFullView().size() ; i++) {
			if(bookListFullView().get(i).getBookNum() == bookNum) {
				check = true;
				break;
			}
		}
		
		return check;
	}

	@Override
	public Book deleteBook(int bookNum) throws Exception {
		return dao.deleteBook(bookNum);
	}

}
