import java.util.Scanner;

public class insearchofeasyproblem_1030A {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if(x == 1) {
                System.out.println("HARD");
                return;
            }
        }

        System.out.println("EASY");
    }
}