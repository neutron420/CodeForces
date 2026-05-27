import java.util.Scanner;

public class presents_136A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] p = new int[n + 1];
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
            ans[p[i]] = i;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }

        sc.close();
    }
}