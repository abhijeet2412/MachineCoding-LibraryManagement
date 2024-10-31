package library.management;

import java.util.Scanner;
import library.management.entities.Book;
import library.management.repository.BookRepository;
import library.management.service.BookService;


public class Solution {
    public static void main(String[] args) {
        BookRepository bookRepository = BookRepository.getBookRepository();
        BookService bookService = new BookService(bookRepository);
        System.out.println("Welcome to Abhijeet's book store. Select an option from below to get started: ");
        System.out.println("1. List Available Books");
        System.out.println("2. Add a book");
        System.out.println("3. Borrow a book");
        System.out.println("4. Return a book");
        System.out.println("5. Exit book store");
        Scanner scanner = new Scanner(System.in);
        Integer input = scanner.nextInt();

        do {
        switch (input) {
            case 1:
                bookService.showAvailableBooks();
                break;
            case 2:
                scanner.nextLine();
                System.out.println("Enter book name: ");
                String name = scanner.nextLine();
                System.out.println("Enter author name: ");
                String author = scanner.nextLine();
                Book toAdd = new Book(name, author, true);
                bookService.addBook(toAdd);
                break;
            case 3:
                System.out.println("Enter book id to borrow: ");
                Integer toBorrow = scanner.nextInt();
                bookService.borrowBook(toBorrow);
                break;
            case 4:
                System.out.println("Enter book id to return: ");
                Integer toReturn = scanner.nextInt();
                bookService.returnBook(toReturn);
                break;
            case 5:
                break;
            default:
                System.out.println("Please select a valid input.");
                break;
            }
            input = scanner.nextInt();
        } while (input != 5);
    }
}
