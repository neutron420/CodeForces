import java.util.*;

public class riptide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int[] a = new int[3];
            a[0] = sc.nextInt();
            a[1] = sc.nextInt();
            a[2] = sc.nextInt();

            int rounds = 0;

            while (true) {
                // If any two are equal, game ends
                if (a[0] == a[1] || a[1] == a[2] || a[0] == a[2]) {
                    break;
                }

                int maxIndex = 0;
                int minIndex = 0;

                // Find index of maximum
                for (int i = 1; i < 3; i++) {
                    if (a[i] > a[maxIndex]) {
                        maxIndex = i;
                    }
                }

                // Find index of minimum
                for (int i = 1; i < 3; i++) {
                    if (a[i] < a[minIndex]) {
                        minIndex = i;
                    }
                }

                // Transfer one token
                a[maxIndex]--;
                a[minIndex]++;

                rounds++;
            }

            System.out.println(rounds);
        }

        sc.close();
    }
}