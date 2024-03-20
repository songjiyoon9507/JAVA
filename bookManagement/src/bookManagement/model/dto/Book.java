package bookManagement.model.dto;

import java.io.Serializable;

public class Book implements Serializable {
	private int bookNum; // 도서 번호
	private String title; // 도서명
	private String author; // 저자
	private int price; // 가격
	private String publisher; // 출판사
	private String category; // 장르
	
	public Book() {}

	public Book(int bookNum, String title, String author, int price, String publisher, String category) {
		this.bookNum = bookNum;
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.category = category;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "[도서 번호] : " + bookNum + " / [제목] : " + title + " / [저자] : " + author + " / [가격] : " + price
				+ " / [출판사] : " + publisher + " / [장르] : " +  category ;
	}
}
