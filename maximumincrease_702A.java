import java.util.*;

public class maximumincrease_702A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int curr = 1;
        int ans = 1;

        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                curr++;
            } else {
                curr = 1;
            }

            ans = Math.max(ans, curr);
        }

        System.out.println(ans);
    }
}