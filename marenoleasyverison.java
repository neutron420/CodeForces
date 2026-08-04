import java.io.*;

public class marenoleasyverison {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt(in);
            byte[] a = nextToken(in, n);
            byte[] b = nextToken(in, n);

            long aOdd = 0, aEven = 0, bOdd = 0, bEven = 0;
            for (int i = 0; i < n; i++) {
                // i is 0-indexed; convert to 1-indexed parity
                boolean oddPos = ((i + 1) & 1) == 1;
                if (a[i] == '1') { if (oddPos) aOdd++; else aEven++; }
                if (b[i] == '1') { if (oddPos) bOdd++; else bEven++; }
            }

            sb.append((aOdd == bOdd && aEven == bEven) ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0, b;
        do { b = in.read(); } while (b < '0' || b > '9');
        while (b >= '0' && b <= '9') { ret = ret * 10 + b - '0'; b = in.read(); }
        return ret;
    }

    private static byte[] nextToken(DataInputStream in, int n) throws IOException {
        byte[] buf = new byte[n];
        int b;
        do { b = in.read(); } while (b != '0' && b != '1'); // skip whitespace
        int idx = 0;
        while (b == '0' || b == '1') {
            buf[idx++] = (byte) b;
            if (idx == n) break;
            b = in.read();
        }
        return buf;
    }
}