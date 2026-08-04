import java.io.*;

public class marenolhardverison {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String a = br.readLine().trim();
            String b = br.readLine().trim();
            sb.append(solve(n, a, b)).append('\n');
        }
        System.out.print(sb);
    }

    static long solve(int n, String a, String b) {
        int totalA = 0, totalB = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == '1') totalA++;
            if (b.charAt(i) == '1') totalB++;
        }
        if (totalA != totalB) return -1;
        if (n == 1) return 0; // single char, counts equal => a.equals(b)

        long onesA = 0, onesB = 0;
        long xPrev = 0;   // x_0 = 0
        long ans = 0;
        long eLast = 0;   // will hold e_{n-1}

        for (int i = 1; i <= n - 1; i++) {
            char ca = a.charAt(i - 1);
            char cb = b.charAt(i - 1);
            if (ca == '1') onesA++;
            if (cb == '1') onesB++;
            long e = onesA - onesB;
            if (i <= n - 2) {
                long x = -e - xPrev;
                ans += Math.abs(x);
                xPrev = x;
            } else {
                eLast = e;
            }
        }

        if (eLast + xPrev != 0) return -1;
        return ans;
    }
}