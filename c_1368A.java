import java.util.*;

public class c_1368A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long n = sc.nextLong();

            int count = 0;

            while (Math.max(a, b) <= n) {
                if (a < b) {
                    a += b;
                } else {
                    b += a;
                }
                count++;
            }

            System.out.println(count);
        }

        sc.close();
    }
}