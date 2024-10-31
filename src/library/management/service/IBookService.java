package library.management.service;

import library.management.entities.Book;

import java.util.List;

public interface IBookService {
    public void addBook(Book newBook);
    public void returnBook(Integer id);
    public void borrowBook(Integer id);
    public void showAvailableBooks();
}
