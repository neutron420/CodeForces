import java.io.*;
import java.util.*;

public class mergetomatch {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        StringBuilder sb = new StringBuilder();

        int t = nextInt(in);
        while (t-- > 0) {
            int n = nextInt(in);
            int m = nextInt(in);
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt(in);
            int[] b = new int[m];
            for (int i = 0; i < m; i++) b[i] = nextInt(in);

            if (n < 2L * m) {
                sb.append("NO\n");
                continue;
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int p = 0, countLow = 0;
            for (int i = 0; i < m; i++) {
                if (p < n && a[p] < b[i]) {
                    p++;
                    countLow++;
                }
            }

            boolean ok = countLow >= m;

            if (ok) {
                int q = n - 1, countHigh = 0;
                for (int i = m - 1; i >= 0; i--) {
                    if (q >= 0 && a[q] > b[i]) {
                        q--;
                        countHigh++;
                    }
                }
                ok = countHigh >= m;
            }

            sb.append(ok ? "YES\n" : "NO\n");
        }

        System.out.print(sb);
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') {
            if (b == '-') break;
            b = in.read();
        }
        boolean neg = false;
        if (b == '-') {
            neg = true;
            b = in.read();
        }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return neg ? -ret : ret;
    }
}