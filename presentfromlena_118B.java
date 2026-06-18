import java.util.*;

public class presentfromlena_118B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            printRow(i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            printRow(i, n);
        }
    }

    static void printRow(int i, int n) {
        for (int j = 0; j < 2 * (n - i); j++)
            System.out.print(" ");

        for (int j = 0; j <= i; j++) {
            if (j > 0) System.out.print(" ");
            System.out.print(j);
        }

        for (int j = i - 1; j >= 0; j--) {
            System.out.print(" " + j);
        }

        System.out.println();
    
    }
}