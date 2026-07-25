import java.util.*;

public class middleofthecoast_1133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String t1 = sc.next();
        String t2 = sc.next();

        // Convert first time to minutes
        int h1 = Integer.parseInt(t1.substring(0, 2));
        int m1 = Integer.parseInt(t1.substring(3, 5));
        int start = h1 * 60 + m1;

        // Convert second time to minutes
        int h2 = Integer.parseInt(t2.substring(0, 2));
        int m2 = Integer.parseInt(t2.substring(3, 5));
        int end = h2 * 60 + m2;

        // Middle time in minutes
        int mid = (start + end) / 2;

        // Convert back to HH:MM
        int h = mid / 60;
        int m = mid % 60;

        System.out.printf("%02d:%02d%n", h, m);

        sc.close();
    }
}