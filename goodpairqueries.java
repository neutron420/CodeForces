import java.io.*;
public class goodpairqueries {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        StringBuilder sb = new StringBuilder();

        int t = nextInt(in);
        while (t-- > 0) {
            int n = nextInt(in);
            int q = nextInt(in);
            char[] s = nextToken(in, n);
            char[] tt = nextToken(in, n);

            int[] p01 = new int[n + 1];
            int[] p10 = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                char a = s[i - 1], b = tt[i - 1];
                p01[i] = p01[i - 1] + ((a == '0' && b == '1') ? 1 : 0);
                p10[i] = p10[i - 1] + ((a == '1' && b == '0') ? 1 : 0);
            }

            for (int i = 0; i < q; i++) {
                int l = nextInt(in);
                int r = nextInt(in);
                int n01 = p01[r] - p01[l - 1];
                int n10 = p10[r] - p10[l - 1];
                int len = r - l + 1;
                int lhs = len - n01 - n10; // n00 + n11
                int rhs = Math.abs(n01 - n10);
                sb.append(lhs >= rhs ? "YES\n" : "NO\n");
            }
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
        if (b == '-') { neg = true; b = in.read(); }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return neg ? -ret : ret;
    }

    private static char[] nextToken(DataInputStream in, int len) throws IOException {
        char[] buf = new char[len];
        int b = in.read();
        while (b == ' ' || b == '\n' || b == '\r') b = in.read();
        int idx = 0;
        while (b != -1 && b != ' ' && b != '\n' && b != '\r') {
            buf[idx++] = (char) b;
            b = in.read();
        }
        return buf;
    }
}