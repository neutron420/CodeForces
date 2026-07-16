import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        int w = sc.nextInt();

        int total = k * w * (w + 1) / 2;

        System.out.println(Math.max(0, total - n));
    }
}