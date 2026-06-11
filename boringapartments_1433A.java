import java.util.*;

public class boringapartments_1433A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            int digit = s.charAt(0) - '0';
            int len = s.length();

            int ans = (digit - 1) * 10 + (len * (len + 1)) / 2;

            System.out.println(ans);
        }
    }
}