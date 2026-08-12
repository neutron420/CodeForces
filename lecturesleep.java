import java.util.*;

public class lecturesleep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        int[] t = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }

        // Points Vasya gets normally
        int base = 0;

        for (int i = 0; i < n; i++) {
            if (t[i] == 1) {
                base += a[i];
            }
        }

        // First window of k minutes
        int window = 0;

        for (int i = 0; i < k; i++) {
            if (t[i] == 0) {
                window += a[i];
            }
        }

        int maxExtra = window;

        // Slide the window
        for (int i = k; i < n; i++) {

            // Add the new element
            if (t[i] == 0) {
                window += a[i];
            }

            // Remove the element leaving the window
            if (t[i - k] == 0) {
                window -= a[i - k];
            }

            maxExtra = Math.max(maxExtra, window);
        }

        System.out.println(base + maxExtra);
        sc.close();
    }
}