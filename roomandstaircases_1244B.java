import java.util.*;

public class roomandstaircases_1244B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int ans = n;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    ans = Math.max(ans, 2 * (i + 1));
                    ans = Math.max(ans, 2 * (n - i));
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}