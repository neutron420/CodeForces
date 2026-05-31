import java.util.*;

public class boyorgirl_236A{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        HashSet<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        if (set.size() % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }
}