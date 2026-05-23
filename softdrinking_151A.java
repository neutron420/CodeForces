import java.util.*;

public class softdrinking_151A{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        int nl = sc.nextInt();
        int np = sc.nextInt();

        int totalDrinkToasts = (k * l) / nl;
        int totalLimeToasts = c * d;
        int totalSaltToasts = p / np;

        int totalToasts = Math.min(totalDrinkToasts,
                          Math.min(totalLimeToasts, totalSaltToasts));

        System.out.println(totalToasts / n);
    }
}