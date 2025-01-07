import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String user = myScanner.nextLine();
        System.out.println("Hello " + user);
    }
}
