import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Main main= new Main();
        //main.logo();
        Scanner scanner= new Scanner(System.in);
        //String text=  scanner.next();
       // System.out.println(text);


        // create a new user
        Date currentDate = new Date();
        User user = new User(1, "John", "user@mail.com", "123456", "123456789", currentDate, currentDate);
        System.out.println(user.getName());
        user.insertIntoDatabase();

        // create a new admin

    }
    public void logo(){
        System.out.println("Welcome to the Library");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
    }



}