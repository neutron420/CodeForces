 import java.io.*;

public class ranksubsequence {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = nextInt(in);
            int[] l = new int[n + 1];
            int[] r = new int[n + 1];
            int[] u = new int[n + 1];
            int[] v = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                l[i] = nextInt(in);
                r[i] = nextInt(in);
                u[i] = nextInt(in);
                v[i] = nextInt(in);
            }

            int answer = 0;
            for (int m = n; m >= 1; m--) {
                int p = 1;
                for (int i = 1; i <= n; i++) {
                    if (p > m) break;
                    int tPos = p;
                    boolean blocked1 = (l[i] <= tPos && tPos <= r[i]);
                    if (blocked1) continue;
                    int rightRank = m - tPos + 1;
                    boolean blocked2 = (u[i] <= rightRank && rightRank <= v[i]);
                    if (blocked2) continue;
                    p++;
                }
                if (p - 1 == m) {
                    answer = m;
                    break;
                }
            }

            sb.append(answer).append('\n');
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