import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;
public class numberofwhiteboard_1430C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                out.println(2);
                if (n == 1) {
                    continue;
                }
                int a = n;
                int b = n - 1;
                out.println(a + " " + b);
                int current = (a + b + 1) / 2;
                for (int i = n - 2; i >= 1; i--) {
                    out.println(current + " " + i);
                    current = (current + i + 1) / 2;
                }
            }
        }
        out.flush();
        sc.close();
    }
}
