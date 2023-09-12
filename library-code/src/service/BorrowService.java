package service;

import model.Borrow;
import repository.BorrowRepository;

import java.util.List;

public class BorrowService {

    private static BorrowRepository borrowRepository;

    public BorrowService(BorrowRepository borrowRepository) {
        BorrowService.borrowRepository = borrowRepository;
    }

    public static String createBorrow(Borrow borrow) {
        return BorrowRepository.createBorrow(borrow);
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

    public static String deleteBorrow(int id) {
        // Check if the borrow exists
        Borrow existingBorrow = BorrowRepository.getBorrowById(id);
        if (existingBorrow != null) {
            if(BorrowRepository.deleteBorrow(id))
                return "Borrow with ID " + id + " deleted successfully.";
            else
                return "Borrow with ID " + id + " not deleted.";
        } else {
            return "Borrow with ID " + id + " not found.";
        }
    }

    public static void refreshBorrows() {
        BorrowRepository.refreshBorrows();
    }




}
