import java.util.Scanner;

public class sumoforundnumbers_1352A {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int sum = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    sum += i * j;
                }
            }

            System.out.println(sum);
        }
    }

}
