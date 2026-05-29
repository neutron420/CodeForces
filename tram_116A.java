import java.util.*;

public class tram_116A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int current = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            current -= a; // people leaving
            current += b; // people entering

            ans = Math.max(ans, current);
        }

        System.out.println(ans);
    }
}