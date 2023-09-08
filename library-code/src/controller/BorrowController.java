package controller;

import model.Borrow;
import repository.BorrowRepository;

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
        System.out.print("Enter the user_id of the borrow: ");
        int user_id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the book_id of the borrow: ");
        int book_id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the borrow_date of the borrow: ");
        String borrow_date = scanner.nextLine();
        System.out.print("Enter the return_date of the borrow: ");
        String return_date = scanner.nextLine();
        System.out.print("Enter the status of the borrow: ");
        String status = scanner.nextLine();
        System.out.print("Enter the description of the borrow: ");
        String description = scanner.nextLine();

        BorrowRepository.createBorrow(new Borrow(1, user_id, book_id, borrow_date, return_date, status, description));
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

    public static void getBorrowByUserId(int user_id) {
        List<Borrow> borrows = BorrowRepository.getBorrowByUserId(user_id);
        if (borrows.size() > 0) {
            System.out.println("\nBorrows found:");
            for (Borrow borrow : borrows) {
                System.out.println(borrow.toString());
            }
        } else {
            System.out.println("No borrows found.");
        }
    }

    public static void getBorrowByBookId(int book_id) {

        List<Borrow> borrows = BorrowRepository.getBorrowByBookId(book_id);
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
