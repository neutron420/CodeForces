import java.util.Scanner;
public class dominotile {
    static final long MOD = 998244353L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            sc.nextInt();
            String s = sc.next();
            long evenWays = solve(s, 0);
            long oddWays = solve(s, 1);
            long answer = (evenWays * oddWays) % MOD;
            System.out.println(answer);
        }
        sc.close();
    }
    static long solve(String s, int start) {
        int len = 0;
        for (int i = start; i < s.length(); i += 2) {
            len++;
        }
        long[][] dp = new long[len][2];
        if (s.charAt(start) == '?' || s.charAt(start) == '0') {
            dp[0][0] = 1;
        }
        if (s.charAt(start) == '?' || s.charAt(start) == '1') {
            dp[0][1] = 1;
        }
        for (int i = 1; i < len; i++) {

            int pos = start + 2 * i;
            if (s.charAt(pos) == '?' || s.charAt(pos) == '0') {
                dp[i][0] = dp[i - 1][1];
            }
            if (s.charAt(pos) == '?' || s.charAt(pos) == '1') {
                dp[i][1] = dp[i - 1][0];
            }
        }
        return (dp[len - 1][0] + dp[len - 1][1]) % MOD;
    }
}