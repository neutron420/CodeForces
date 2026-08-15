import java.util.*;

public class DoremyPaint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            long n = scanner.nextLong();
            long[] a = new long[(int) n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }

            Map<Long, Long> frequencyMap = new HashMap<>();

            for (long value : a) {
                frequencyMap.put(value, frequencyMap.getOrDefault(value, 0L) + 1);
            }

            if (frequencyMap.size() >= 3) {
                System.out.println("No");
            } else {
                long freq1 = frequencyMap.values().iterator().next();
                long freq2 = (long) frequencyMap.values().toArray()[frequencyMap.size() - 1];

                if (freq1 == freq2) {
                    System.out.println("Yes");
                } else if (n % 2 == 1 && Math.abs(freq1 - freq2) == 1) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }

        scanner.close();
    }
}