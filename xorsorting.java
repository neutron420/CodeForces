import java.io.*;
import java.util.*;

public class xorsorting {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt(in);
            int q = nextInt(in); // q = 0 in easy version

            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt(in);

            int[] b = a.clone();
            Arrays.sort(b);

            long[] prefA = new long[n + 1];
            long[] prefB = new long[n + 1];
            for (int i = 0; i < n; i++) {
                prefA[i + 1] = prefA[i] + hash(a[i]);
                prefB[i + 1] = prefB[i] + hash(b[i]);
            }

            int ansT = 0;
            for (int tt = 0; ; tt++) {
                int size = 1 << tt;
                boolean ok = true;
                for (int start = 0; start < n; start += size) {
                    int end = Math.min(start + size, n);
                    long sa = prefA[end] - prefA[start];
                    long sb2 = prefB[end] - prefB[start];
                    if (sa != sb2) { ok = false; break; }
                }
                if (ok) { ansT = tt; break; }
                if (size >= n) { ansT = tt; break; } // safety net, always true by here
            }

            long answer = (ansT == 0) ? 0 : (1L << (ansT - 1));

            for (int i = 0; i < q; i++) { nextInt(in); nextInt(in); } // q=0, no-op

            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }

    static long hash(long v) {
        v += 0x9E3779B97F4A7C15L;
        v = (v ^ (v >>> 30)) * 0xBF58476D1CE4E5B9L;
        v = (v ^ (v >>> 27)) * 0x94D049BB133111EBL;
        v = v ^ (v >>> 31);
        return v;
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') b = in.read();
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return ret;
    }
}