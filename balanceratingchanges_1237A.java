import java.util.*;

public class balanceratingchanges_1237A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] ans = new int[n];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            ans[i] = a[i] / 2;
            sum += ans[i];
        }

        for (int i = 0; i < n && sum != 0; i++) {

            if (sum < 0 && a[i] > 0 && (a[i] & 1) != 0) {
                ans[i]++;
                sum++;
            }

            else if (sum > 0 && a[i] < 0 && (a[i] & 1) != 0) {
                ans[i]--;
                sum--;
            }
        }

        for (int x : ans)
            System.out.println(x);
    }
}