import java.io.*;
import java.util.*;

public class shiolute {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt(in);
            long[] b = new long[n];
            for (int i = 0; i < n; i++) b[i] = nextLong(in);

            Integer[] order = new Integer[n];
            for (int i = 0; i < n; i++) order[i] = i;
            Arrays.sort(order, (x, y) -> Long.compare(b[x], b[y]));

            long[] c = new long[n];
            int[] m = new int[n];
            int[] groupStart = new int[n];
            int k = 0, i = 0;
            while (i < n) {
                long val = b[order[i]];
                int j = i;
                while (j < n && b[order[j]] == val) j++;
                c[k] = val;
                m[k] = j - i;
                groupStart[k] = i;
                k++;
                i = j;
            }

            boolean valid = (c[0] == 0);
            long[] v = new long[k];

            if (valid) {
                long S = 0;
                for (int g = 0; g < k - 1; g++) {
                    long numerator = c[g + 1] - S;
                    if (numerator <= 0 || numerator % m[g] != 0) { valid = false; break; }
                    long vg = numerator / m[g];
                    if (g >= 1 && vg <= v[g - 1]) { valid = false; break; }
                    v[g] = vg;
                    S = c[g + 1];
                }
                if (valid) {
                    if (k == 1) v[0] = 1;
                    else v[k - 1] = v[k - 2] + 1;
                }
            }

            if (!valid) {
                sb.append(-1).append('\n');
            } else {
                long[] a = new long[n];
                for (int g = 0; g < k; g++) {
                    int start = groupStart[g];
                    int end = (g == k - 1) ? n : groupStart[g + 1];
                    for (int p = start; p < end; p++) a[order[p]] = v[g];
                }
                for (int idx = 0; idx < n; idx++) {
                    sb.append(a[idx]);
                    sb.append(idx == n - 1 ? '\n' : ' ');
                }
            }
        }
        System.out.print(sb);
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0, b;
        do { b = in.read(); } while (b < '0' || b > '9');
        while (b >= '0' && b <= '9') { ret = ret * 10 + b - '0'; b = in.read(); }
        return ret;
    }

    private static long nextLong(DataInputStream in) throws IOException {
        long ret = 0; int b;
        do { b = in.read(); } while (b < '0' || b > '9');
        while (b >= '0' && b <= '9') { ret = ret * 10 + b - '0'; b = in.read(); }
        return ret;
    }
}