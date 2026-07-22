import java.util.*;

public class chocolates_1139B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        long ans = 0;
        int limit = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {

            int take = Math.min(a[i], limit - 1);

            if (take < 0)
                take = 0;

            ans += take;
            limit = take;
        }

        System.out.println(ans);
        sc.close();
    }
}