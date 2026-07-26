import java.io.*;

public class permutationcuts {
    static final int MOD = 998244353;
    static long[] fact, invFact;

    public static void main(String[] args) throws IOException {
        final int MAXN = 1_000_006;
        fact = new long[MAXN];
        invFact = new long[MAXN];
        fact[0] = 1;
        for (int i = 1; i < MAXN; i++) fact[i] = fact[i-1] * i % MOD;
        invFact[MAXN-1] = modpow(fact[MAXN-1], MOD-2, MOD);
        for (int i = MAXN-2; i >= 0; i--) invFact[i] = invFact[i+1] * (i+1) % MOD;

        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 20));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();

        int MAXA = 1_000_006;
        int[] A = new int[MAXA];
        int[] lVal = new int[MAXA], lFree = new int[MAXA];
        int[] rVal = new int[MAXA], rFree = new int[MAXA];

        while (t-- > 0) {
            int n = nextInt(in);
            int len = n - 1;
            boolean invalid = false;
            for (int i = 0; i < len; i++) {
                int x = nextInt(in);
                A[i] = x;
                if (x >= n) invalid = true; // a_i must be <= n-1
            }
            if (invalid) {
                sb.append(0).append('\n');
                continue;
            }

            int Dz = 0;
            for (int i = 1; i < len; i++) {
                if (A[i] >= A[i-1]) Dz = i; else break;
            }
            int D = Dz + 1;

            int Uz = len - 1;
            for (int i = len - 2; i >= 0; i--) {
                if (A[i] >= A[i+1]) Uz = i; else break;
            }
            int U = Uz + 1;

            if (U > D + 1) {
                sb.append(0).append('\n');
                continue;
            }

            long total = 0;
            int c1 = U, c2 = D + 1;
            total = (total + process(n, A, len, c1, lVal, lFree, rVal, rFree)) % MOD;
            if (c2 != c1) {
                total = (total + process(n, A, len, c2, lVal, lFree, rVal, rFree)) % MOD;
            }
            sb.append(total).append('\n');
        }

        System.out.print(sb);
    }

    static long process(int n, int[] A, int len, int pos, int[] lVal, int[] lFree, int[] rVal, int[] rFree) {
        int leftLen = pos - 1;
        int rightLen = n - pos;

        int leftBoundary = (leftLen >= 1) ? A[leftLen - 1] : -1;
        int rightBoundary = (rightLen >= 1) ? A[leftLen] : -1;

        int maxB = Math.max(leftBoundary, rightBoundary);
        if (maxB != n - 1) return 0;

        int m1 = 0;
        int cur = 0;
        for (int i = 0; i < leftLen; i++) {
            int v = A[i];
            if (v > cur) {
                lVal[m1] = v; lFree[m1] = 0; m1++; cur = v;
            } else {
                lFree[m1 - 1]++;
            }
        }

        int m2 = 0;
        cur = 0;
        for (int i = len - 1; i >= leftLen; i--) {
            int v = A[i];
            if (v > cur) {
                rVal[m2] = v; rFree[m2] = 0; m2++; cur = v;
            } else {
                rFree[m2 - 1]++;
            }
        }

        long ways = 1;
        int i1 = 0, i2 = 0;
        int idx = 0;
        long runningUsed = 0;
        while (i1 < m1 || i2 < m2) {
            int val, need;
            boolean fromLeft;
            if (i2 >= m2 || (i1 < m1 && lVal[i1] < rVal[i2])) {
                val = lVal[i1]; need = lFree[i1]; fromLeft = true;
            } else if (i1 >= m1 || (i2 < m2 && rVal[i2] < lVal[i1])) {
                val = rVal[i2]; need = rFree[i2]; fromLeft = false;
            } else {
                return 0; 
            }
            long availableCount = (long) (val - 1) - idx - runningUsed;
            if (availableCount < 0 || availableCount < need) return 0;
            long p = fact[(int) availableCount] * invFact[(int) (availableCount - need)] % MOD;
            ways = ways * p % MOD;
            runningUsed += need;
            idx++;
            if (fromLeft) i1++; else i2++;
        }

        return ways;
    }

    static long modpow(long base, long exp, long mod) {
        long result = 1; base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') {
            b = in.read();
        }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return ret;
    }
}