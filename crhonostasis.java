import java.util.*;
import java.io.*;

public class crhonostasis {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt(in);
            long[] b = new long[n];
            long total = 0;
            for (int i = 0; i < n; i++) {
                b[i] = nextInt(in);
                total += b[i];
            }
            if (total <= 0) {
                sb.append(-1).append('\n');
                continue;
            }
            TreeMap<Long, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) map.merge(b[i], 1, Integer::sum);

            long S = 0;
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < n; i++) {
                Long key = map.ceilingKey(-S + 1);
                S += key;
                line.append(S);
                if (i < n - 1) line.append(' ');
                int cnt = map.get(key);
                if (cnt == 1) map.remove(key); else map.put(key, cnt - 1);
            }
            sb.append(line).append('\n');
        }
        System.out.print(sb);
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0, b;
        boolean neg = false;
        do { b = in.read(); } while (b != '-' && (b < '0' || b > '9'));
        if (b == '-') { neg = true; b = in.read(); }
        while (b >= '0' && b <= '9') { ret = ret * 10 + b - '0'; b = in.read(); }
        return neg ? -ret : ret;
    }
}