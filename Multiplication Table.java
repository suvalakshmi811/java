
public class MultiplicationTable {
    public static void main(String[] args) {
        int n = 10; 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) 
{
                int product = i * j;
                System.out.printf("%4d", product);
            }
            System.out.println(); 
        }
    }
}