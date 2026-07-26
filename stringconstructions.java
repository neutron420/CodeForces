import java.util.*;
import java.io.*;

public class stringconstructions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int m = n - k; // number of runs needed

            if (m == 1) {
                sb.append(-1).append('\n');
                continue;
            }

            int numA = (m + 1) / 2; // runs of '0'
            int numB = m / 2;       // runs of '1'
            int LA = (n + 1) / 2;   // total '0's
            int LB = n / 2;         // total '1's

            int extraA = LA - numA;
            int extraB = LB - numB;

            int[] lenA = new int[numA];
            Arrays.fill(lenA, 1);
            lenA[0] += extraA;

            int[] lenB = new int[numB];
            Arrays.fill(lenB, 1);
            if (numB > 0) lenB[0] += extraB;

            StringBuilder res = new StringBuilder(n);
            int ai = 0, bi = 0;
            for (int i = 0; i < m; i++) {
                if (i % 2 == 0) {
                    int len = lenA[ai++];
                    for (int j = 0; j < len; j++) res.append('0');
                } else {
                    int len = lenB[bi++];
                    for (int j = 0; j < len; j++) res.append('1');
                }
            }
            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }
}