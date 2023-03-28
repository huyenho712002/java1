
import com.mavenproject1.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Book_Management {

    private static int idCounter = 1;
    private static final List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWELCOME TO BOOK MANAGEMENT");
            System.out.println("1. Add a book");
            System.out.println("2. Find and list book");
            System.out.println("3. Update/Delete book");
            System.out.println("4. Display books sorted by price");
            System.out.println("5. Exit program");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    findBooks(scanner);
                    break;
                case 3:
                    updateOrDeleteBook(scanner);
                    break;
                case 4:
                    displayBooksSortedByPrice();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addBook(Scanner scanner) {
        while (true) {
            System.out.println("\nCreating a new book...");
            System.out.print("Enter title: ");
            String title = scanner.next();
            System.out.print("Enter author: ");
            String author = scanner.next();
            System.out.println("Enter genre (1: Network, 2: AI, 3: Programming): ");

            int genreChoice = scanner.nextInt();
            Book book = new Book();
            String genre = book.genreChoices[genreChoice - 1];

            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter ISBN: ");
            String isbn = scanner.next();
             book = new Book(idCounter, title, author, genre, price, isbn);
            bookList.add(book);
            idCounter++;

            if (bookList.size() >= 3) {
                System.out.print("Do you want to continue adding books? (Y/N): ");
                String choice = scanner.next();
                if (!choice.equalsIgnoreCase("Y")) {
                    break;
                }
            }
        }
    }

    private static void updateOrDeleteBook(Scanner scanner) {
        System.out.print("\nEnter ID of book to update/delete: ");
        int id = scanner.nextInt();
        Book bookToUpdate = null;

        for (Book book : bookList) {
            if (book.getId() == id) {
                bookToUpdate = book;
                break;
            }
        }

        if (bookToUpdate == null) {
            System.out.println("Book not found.");
        } else {
            System.out.print("Do you want to update (U) or delete (D) book? ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("U")) {
                System.out.println("\nEnter new information for the book:");
                System.out.print("Title: ");
                scanner.nextLine();
                String title = scanner.nextLine();
                System.out.print("Author: ");
                String author = scanner.nextLine();
                System.out.print("Genre: ");
                int genre = scanner.nextInt();
                System.out.print("Price: ");
                double price = scanner.nextDouble();
                bookToUpdate.setTitle(title);
                bookToUpdate.setAuthor(author);
                bookToUpdate.setGenre(genre);
                bookToUpdate.setPrice(price);
                System.out.println("Book updated successfully.");
            } else if (choice.equalsIgnoreCase("D")) {

                bookList.remove(bookToUpdate);
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void displayBooksSortedByPrice() {
        if (bookList.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        Collections.sort(bookList, Comparator.comparing(Book::getPrice));
        System.out.println("\nBook List sorted by price:\n");
        System.out.println("ID\tTitle\t\tAuthor\t\tGenre\t\tPrice\t\tISBN");
        for (Book book : bookList) {
            System.out.println(book.getId() + "\t" + book.getTitle() + "\t\t" + book.getAuthor() + "\t\t"
                    + book.getGenre() + "\t\t" + book.getPrice() + "\t\t" + book.getIsbn());
        }
    }

    private static void reportBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        Collections.sort(bookList, Comparator.comparing(Book::getPrice));
        System.out.println("\nBook List sorted by price:\n");
        System.out.println("ID\tTitle\tAuthor\tGenre\tPrice\tISBN");
        for (Book book : bookList) {
            System.out.println(book.getId() + "\t" + book.getTitle() + "\t" + book.getAuthor() + "\t"
                    + book.getGenre() + "\t" + book.getPrice() + "\t" + book.getIsbn());
        }
    }

    private static void findBooks(Scanner scanner) {
        System.out.print("\nEnter title or a part of title: ");
        String query = scanner.next();
        List<Book> matchingBooks = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getTitle().contains(query)) {
                matchingBooks.add(book);
            }
        }

        if (matchingBooks.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("\nMatching books:");
            for (Book book : matchingBooks) {
                System.out.println(book);
            }
        }
    }

}
