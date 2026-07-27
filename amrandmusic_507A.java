import java.util.*;

public class amrandmusic_507A {

    static class Pair {
        int difficulty;
        int index;

        Pair(int difficulty, int index) {
            this.difficulty = difficulty;
            this.index = index;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(sc.nextInt(), i + 1);
        }

        Arrays.sort(arr, (a, b) -> a.difficulty - b.difficulty);

        List<Integer> ans = new ArrayList<>();

        for (Pair p : arr) {

            if (p.difficulty <= k) {
                ans.add(p.index);
                k -= p.difficulty;
            } else {
                break;
            }
        }

        System.out.println(ans.size());

        for (int idx : ans) {
            System.out.print(idx + " ");
        }
    }
}