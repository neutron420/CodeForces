import java.util.*;
public class game23_1141A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        if (m % n != 0) {
            System.out.println(-1);
            return;
        }
        long x = m / n;
        int moves = 0;
        while (x % 2 == 0) {
            x /= 2;
            moves++;
        }
        while (x % 3 == 0) {
            x /= 3;
            moves++;
        }
        System.out.println(x == 1 ? moves : -1);
    }
}