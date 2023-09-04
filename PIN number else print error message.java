import java.util.Scanner;

public class BankingApplication {
    private static final int PIN_NUMBER = 1234;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        int enteredPIN = scanner.nextInt()
        if (enteredPIN == PIN_NUMBER) {
            System.out.println("PIN is correct. You can proceed with the withdrawal.");
            
        } else {
            System.out.println("Error: The entered PIN number is wrong.");
        }

        scanner.close();
    }
}
