import java.util.Scanner;

public class repeatingcipher_1095A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        StringBuilder res = new StringBuilder();

        int i = 0;
        int jump = 1;

        while (i < n) {
            res.append(s.charAt(i));
            i += jump;
            jump++;
        }

        System.out.println(res);
        sc.close();
    }
}