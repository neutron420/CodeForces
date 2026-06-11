import java.util.*;

public class erasingzeroes_1303A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int start = -1, end = -1;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    if (start == -1)
                        start = i;
                    end = i;
                }
            }

            if (start == -1) {
                System.out.println(0);
            } else {
                int count = 0;
                for (int i = start; i <= end; i++) {
                    if (s.charAt(i) == '0')
                        count++;
                }
                System.out.println(count);
            }
        }
        sc.close();
    }
}
