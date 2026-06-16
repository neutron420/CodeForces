import java.util.*;

public class kstrings_219A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        String s = sc.next();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder base = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (freq[i] % k != 0) {
                System.out.println("-1");
                return;
            }

            for (int j = 0; j < freq[i] / k; j++) {
                base.append((char) ('a' + i));
            }
        }
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < k; i++) {
            ans.append(base);
        }
        System.out.println(ans);

    }
}