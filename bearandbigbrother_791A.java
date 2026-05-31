import java.util.Scanner;

public class bearandbigbrother_791A {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int limak = sc.nextInt();
        int bob = sc.nextInt();

        int years = 0;

        while (limak <= bob) {
            limak = limak * 3;
            bob = bob * 2;
            years++;
        }

        System.out.println(years);
    }
}