import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Main main= new Main();
        //main.welcome();
        Scanner scanner= new Scanner(System.in);
        //String text=  scanner.next();
        //System.out.println(text);


        // create a new user
        Date currentDate = new Date();
        User user = new User( "mouad", "mouad@mail.com", "123456789", "12345679", currentDate);
        System.out.println(user.toString());
        user.insertIntoDatabase();

        // create a new admin

    }
    public void welcome(){
        System.out.println("Welcome to the Library");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
    }



}