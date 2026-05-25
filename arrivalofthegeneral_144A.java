import java.util.Scanner;

public class arrivalofthegeneral_144A {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int maxIndex = 0;
        int minIndex = 0;

        for(int i = 0; i < n; i++) {

            if(a[i] > a[maxIndex]) {
                maxIndex = i;
            }

            if(a[i] <= a[minIndex]) {
                minIndex = i;
            }
        }

        int moves = maxIndex + (n - 1 - minIndex);

        if(maxIndex > minIndex) {
            moves--;
        }

        System.out.println(moves);
    }
}