import java.util.*;

public class foxandsnak_510A{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {

            // Full # row
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    System.out.print("#");
                }
            }

            // Even rows with snake turn
            else {

                // # at end
                if (i % 4 == 1) {
                    for (int j = 0; j < m - 1; j++) {
                        System.out.print(".");
                    }
                    System.out.print("#");
                }

                // # at beginning
                else {
                    System.out.print("#");
                    for (int j = 0; j < m - 1; j++) {
                        System.out.print(".");
                    }
                }
            }

            System.out.println();
        }
    }
}