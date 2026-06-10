import java.util.*;

public class vanyaandcubes_492A{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int height = 0;
        int used = 0;
        int level = 1;

        while (true) {
            int cubesInLevel = level * (level + 1) / 2;

            if (used + cubesInLevel > n) {
                break;
            }

            used += cubesInLevel;
            height++;
            level++;
        }

        System.out.println(height);
    }
}