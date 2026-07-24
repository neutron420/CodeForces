import java.util.*;

public class shufflehasing_1278A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String p = sc.next();
            String h = sc.next();

            int m = p.length();
            int n = h.length();

            if (m > n) {
                System.out.println("NO");
                continue;
            }

            int[] need = new int[26];
            int[] have = new int[26];

            for (int i = 0; i < m; i++)
                need[p.charAt(i) - 'a']++;

            for (int i = 0; i < m; i++)
                have[h.charAt(i) - 'a']++;

            boolean ok = Arrays.equals(need, have);

            for (int i = m; i < n && !ok; i++) {
                have[h.charAt(i) - 'a']++;
                have[h.charAt(i - m) - 'a']--;

                if (Arrays.equals(need, have))
                    ok = true;
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }
}