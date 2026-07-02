import java.util.*;

public class dreamoonandstairs_476A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int minMoves = (n + 1) / 2;

        while (minMoves % m != 0) {
            minMoves++;
        }

        if (minMoves <= n)
            System.out.println(minMoves);
        else
            System.out.println(-1);

        sc.close();
    }
}