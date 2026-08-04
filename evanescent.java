import java.util.*;

public class evanescent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            // Compute initial compressed length (number of groups)
            int base = 1;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) != s.charAt(i - 1))
                    base++;
            }

            int ans = Integer.MAX_VALUE;

            // Delete every valid position
            for (int i = 1; i <= n - 2; i++) {
                char L = s.charAt(i - 1);
                char M = s.charAt(i);
                char R = s.charAt(i + 1);

                int oldBoundary = 0;
                if (L != M) oldBoundary++;
                if (M != R) oldBoundary++;

                int newBoundary = (L != R) ? 1 : 0;

                int groups = base - oldBoundary + newBoundary;

                ans = Math.min(ans, groups);
            }

            System.out.println(ans);
        }

        sc.close();
    }
}