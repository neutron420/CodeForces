import java.util.*;
public class capslock_131A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean ok = true;
        for (int i = 1; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                ok = false;
                break;
            }
        }
        if (ok) {
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isUpperCase(ch))
                    System.out.print(Character.toLowerCase(ch));
                else
                    System.out.print(Character.toUpperCase(ch));
            }
        } else {
            System.out.print(s);
            sc.close();
        }
    }
}