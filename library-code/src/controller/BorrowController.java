package controller;

import model.Borrow;
import repository.BorrowRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BorrowController {

    private static final Scanner scanner = new Scanner(System.in);

    public static void listAllBorrows() {
        System.out.println("\nList All Borrows :");

        List<Borrow> borrows;
        borrows = BorrowRepository.getAllBorrows();

        for (Borrow borrow : borrows) {
            System.out.println(borrow.toString() + "\n");
        }

    }

    public static void addBorrow() {
        System.out.print("Enter the email of the user: ");
        String email = scanner.nextLine();
        System.out.print("Enter the ISBN of the book: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter the description of the borrow: ");
        String description = scanner.nextLine();
        BorrowRepository.createBorrow(new Borrow(1, email, ISBN, "borrow", description));
        System.out.println("Borrow added successfully.");
    }

    public static void addReturn() {
        System.out.print("Enter the email of the return: ");
        String email = scanner.nextLine();
        System.out.print("Enter the ISBN of the borrow: ");
        String ISBN = scanner.nextLine();

        System.out.print("Enter the description of the return: ");
        String description = scanner.nextLine();
        BorrowRepository.createBorrow(new Borrow(1, email, ISBN, "return", description));
        System.out.println("Borrow added successfully.");
    }

    public static void viewBorrowDetails() {
        System.out.print("Enter the id of the borrow: ");
        int id = Integer.parseInt(scanner.nextLine());

        Borrow borrow = BorrowRepository.getBorrowById(id);
        if (borrow != null) {
            System.out.println("\nBorrow Details:");
            System.out.println(borrow.toString());
        } else {
            System.out.println("Borrow not found.");
        }
    }

    public static void searchBorrow(String status){

                List<Borrow> borrows = BorrowRepository.getBorrowByStatus(status);
                if (borrows.size() > 0) {
                    System.out.println("\nBooks found:");
                    for (Borrow borrow : borrows) {
                        System.out.println(borrow.toString());
                    }
                } else {
                    System.out.println("No books found.");
                }

    }

    public static void getBorrowByEmail(String email) {
        List<Borrow> borrows = BorrowRepository.getBorrowByEmail(email);
        if (borrows.size() > 0) {
            System.out.println("\nBorrows found:");
            for (Borrow borrow : borrows) {
                System.out.println(borrow.toString());
            }
        } else {
            System.out.println("No borrows found.");
        }
    }

    public static void getBorrowByISBN(String ISBN) {

        List<Borrow> borrows = BorrowRepository.getBorrowByISBN(ISBN);
        if (borrows.size() > 0) {
            System.out.println("\nBorrows found:");
            for (Borrow borrow : borrows) {
                System.out.println(borrow.toString());
            }
        } else {
            System.out.println("No borrows found.");
        }
    }

}
