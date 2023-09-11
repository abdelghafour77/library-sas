package service;

import model.Borrow;
import repository.BorrowRepository;

import java.util.List;

public class BorrowService {

    private static BorrowRepository borrowRepository;

    public BorrowService(BorrowRepository borrowRepository) {
        BorrowService.borrowRepository = borrowRepository;
    }

    public static void createBorrow(Borrow borrow) {
        BorrowRepository.createBorrow(borrow);
    }

    public static List<Borrow> getAllBorrows() {
        return BorrowRepository.getAllBorrows();
    }

    public static Borrow getBorrowById(int id) {
        return BorrowRepository.getBorrowById(id);
    }

    public static List<Borrow> getBorrowByEmail(String email) {
        return BorrowRepository.getBorrowByEmail(email);
    }

    public static List<Borrow> getBorrowByBookId(String ISBN) {
        return BorrowRepository.getBorrowByISBN(ISBN);
    }

    public static List<Borrow> getBorrowByStatus(String status) {
        return BorrowRepository.getBorrowByStatus(status);
    }

    public static Borrow updateBorrow(Borrow borrow) {
        return BorrowRepository.updateBorrow(borrow);
    }

    public static void deleteBorrow(int id) {
        // Check if the borrow exists
        Borrow existingBorrow = BorrowRepository.getBorrowById(id);
        if (existingBorrow != null) {
            BorrowRepository.deleteBorrow(id);
        } else {
            throw new IllegalArgumentException("Borrow with ID " + id + " not found.");
        }
    }

    public static void refreshBorrows() {
        BorrowRepository.refreshBorrows();
    }




}
