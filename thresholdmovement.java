import java.util.*;
public class thresholdmovement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long maxEven = Long.MIN_VALUE;
            long minOdd = Long.MAX_VALUE;

            for (int i = 1; i <= n; i++) {
                long x = sc.nextLong();

                if (i % 2 == 1) {
                    minOdd = Math.min(minOdd, x);
                } else {
                    maxEven = Math.max(maxEven, x);
                }
            }
            if (n % 2 == 1) {
                System.out.println("NO");
            } else if (maxEven + 1 < minOdd) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}