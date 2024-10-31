package library.management.repository;

import library.management.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    private List<Book> bookList = new ArrayList<>();
    private static BookRepository bookRepository;
    private BookRepository(){}

    public static synchronized BookRepository getBookRepository() {
        if (bookRepository == null) {
            bookRepository = new BookRepository();
        }
        return bookRepository;
    }
}
