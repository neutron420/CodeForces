import java.util.*;

public class cityday_1199A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            boolean ok = true;

            // Check previous x days
            for (int j = Math.max(0, i - x); j < i; j++) {
                if (a[j] <= a[i]) {
                    ok = false;
                    break;
                }
            }

            // Check next y days
            if (ok) {
                for (int j = i + 1; j <= Math.min(n - 1, i + y); j++) {
                    if (a[j] <= a[i]) {
                        ok = false;
                        break;
                    }
                }
            }

            if (ok) {
                System.out.println(i + 1);
                return;
            }
            sc.close();
        }
    }
}