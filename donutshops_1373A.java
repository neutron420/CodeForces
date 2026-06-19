import java.util.*;

public class donutshops_1373A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();

            long x = (a < c) ? 1 : -1;
            long y = (a * b > c) ? b : -1;

            System.out.println(x + " " + y);
        }

        sc.close();
    }
}