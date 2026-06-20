import java.util.*;
public class buttons_268B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ans = n;
        for (long i = 1; i < n; i++) {
            ans += (n - i) * i;
        }
        System.out.println(ans);
        sc.close();
    }
}   