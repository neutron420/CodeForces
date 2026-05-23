import java.util.*;

public class sumoforundnumbers_1352A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            ArrayList<Integer> list = new ArrayList<>();

            int place = 1;

            while (n > 0) {
                int digit = n % 10;

                if (digit != 0) {
                    list.add(digit * place);
                }

                place *= 10;
                n /= 10;
            }

            System.out.println(list.size());

            for (int x : list) {
                System.out.print(x + " ");
            }

            System.out.println();
        }
    }
}