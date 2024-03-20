package bookManagement.model.service;

import java.util.List;

import bookManagement.model.dto.Book;

public interface BookManagementService {
	
	List<Book> bookListFullView();

	boolean addBookList(String title, String author, int price, String publisher, String category) throws Exception;

	List<Book> sortByLowPrice();

	List<Book> sortByHighPrice();

	List<Book> sortByTitle();

	List<Book> sortByCategory();

	int indexMatch(int bookNum);

	boolean updateTitle(int index, String title) throws Exception;

	boolean updateAuthor(int index, String author) throws Exception;

	boolean updatePrice(int index, int price) throws Exception;

	boolean updatePublisher(int index, String publisher) throws Exception;

	boolean updateCategory(int index, String category) throws Exception;

	Book deleteBook(int bookNum) throws Exception;

	boolean checkBookNum(int bookNum);

}
