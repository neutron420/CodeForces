import java.util.*;

public class donttrytocount_1881{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            String x = sc.next();
            String s = sc.next();

            int operations = 0;

            while (!x.contains(s) && x.length() <= 100) {
                x += x;
                operations++;
            }

            if (x.contains(s)) {
                System.out.println(operations);
            } else {
                System.out.println(-1);
            }
        }

        sc.close();
    }
}