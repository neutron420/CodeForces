import java.util.*;
public class dicetower_1266B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t --> 0){
            long x = sc.nextLong();
            long rem = x % 14;
            if(rem >= 1 && rem <= 6 && x >= 14){
                System.out.println("YES");
            } else {
                System.out.println("NO");
        }
        }
        sc.close();
    }
}
