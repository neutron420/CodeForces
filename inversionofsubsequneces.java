import java.io.*;
public class inversionofsubsequneces {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt(in);
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt(in);
            for (int i = 0; i < n; i++) b[i] = nextInt(in);

            boolean equal = true;
            boolean aAllZero = true;
            boolean bAllOne = true;
            int nA = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) equal = false;
                if (a[i] == 1) aAllZero = false;
                if (b[i] == 0) bAllOne = false;
                if (a[i] == 1 && b[i] == 0) nA++;
            }

            int ans;
            if (equal) {
                ans = 0;
            } else if (aAllZero) {
                ans = -1;
            } else if (bAllOne) {
                ans = -1;
            } else if ((nA & 1) == 1) {
                ans = 1;
            } else {
                ans = 2;
            }

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
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