import java.util.*;

public class whowatchesthewatchpig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            // Impossible if first k and last k overlap
            if (2 * k > n) {
                System.out.println(-1);
                continue;
            }

            int flips = 0;

            // First k positions must be 'R'
            for (int i = 0; i < k; i++) {
                if (s.charAt(i) == 'L') {
                    flips++;
                }
            }

            // Last k positions must be 'L'
            for (int i = n - k; i < n; i++) {
                if (s.charAt(i) == 'R') {
                    flips++;
                }
            }
            System.out.println(flips);
        }
        sc.close();
    }
}