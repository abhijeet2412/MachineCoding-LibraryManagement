package library.management.service;

import library.management.entities.Book;
import library.management.repository.BookRepository;

import java.util.List;

public class BookService implements IBookService{

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book newBook) {
        Book bookToAdd = new Book(newBook.getTitle(), newBook.getAuthor(), true);
        Integer id = getMaxId() + 1;
        bookToAdd.setId(id);
        bookRepository.getBookList().add(bookToAdd);
        System.out.println("Book successfully added with id: " + id);
    }

    @Override
    public void returnBook(Integer id) {
        List<Book> isValidBook = bookRepository.getBookList().stream().filter(book -> book.getId().equals(id)).toList();
        if (isValidBook.isEmpty()) {
            System.out.println("No such book exist.");
        } else if (isValidBook.stream().findFirst().get().getAvailable()) {
            System.out.println("No such book exist.");
        } else {
            isValidBook.get(0).setAvailable(true);
        }
    }

    @Override
    public void borrowBook(Integer id) {
        List<Book> isValidBook = bookRepository.getBookList().stream().filter(book -> book.getId().equals(id)).toList();
        if (isValidBook.isEmpty()) {
            System.out.println("No such book exist.");
        } else if (!isValidBook.stream().findFirst().get().getAvailable()) {
            System.out.println("No such book exist.");
        } else {
            isValidBook.get(0).setAvailable(false);
            System.out.println("Book borrowed successfully");
        }
    }

    @Override
    public void showAvailableBooks() {
        List<Book> availableBooks = bookRepository.getBookList().stream().filter( book -> book.getAvailable()).toList();
        System.out.println(availableBooks);
    }

    public Integer getMaxId() {
        if (bookRepository.getBookList().isEmpty()) {
            return 0;
        }
        return bookRepository.getBookList().stream().sorted((Book a, Book b) -> b.getId() - a.getId()).limit(1).findFirst().get().getId();
    }

}
