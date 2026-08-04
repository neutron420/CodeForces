import java.util.*;

public class youdeleteidelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            StringBuilder sb = new StringBuilder(s);

            // Delete first 0 (Alice)
            int zero = sb.indexOf("0");
            sb.deleteCharAt(zero);

            // Delete first 1 (Bob)
            int one = sb.indexOf("1");
            sb.deleteCharAt(one);

            System.out.println(sb.toString());
        }
    }
}