import java.util.*;

public class luckysumofdigits_109A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int bestFour = -1;
        int bestSeven = -1;
        int minDigits = Integer.MAX_VALUE;

        for (int seven = 0; seven <= n / 7; seven++) {
            int rem = n - seven * 7;

            if (rem % 4 == 0) {
                int four = rem / 4;
                int digits = four + seven;

                if (digits < minDigits ||
                   (digits == minDigits && four > bestFour)) {

                    minDigits = digits;
                    bestFour = four;
                    bestSeven = seven;
                }
            }
        }

        if (bestFour == -1) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bestFour; i++)
            sb.append('4');

        for (int i = 0; i < bestSeven; i++)
            sb.append('7');

        System.out.println(sb);
    }
}