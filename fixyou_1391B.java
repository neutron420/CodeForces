import java.util.Scanner;
public class fixyou_1391B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = sc.next().toCharArray();
            }
            int ans = 0;
            for (int j = 0; j < m - 1; j++) {
                if (grid[n - 1][j] != 'R') {
                    ans++;
                }
            }
            for (int i = 0; i < n - 1; i++) {
                if (grid[i][m - 1] != 'D') {
                    ans++;
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}