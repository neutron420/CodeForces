import java.util.Scanner;
public class jaggedswaps {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) { 
			long n = scanner.nextLong();
			long[] a = new long[(int) n]; 
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextLong();
			}
			if (a[0] == 1) {
				System.out.println("YES"); 
			} else {
				System.out.println("NO");
			}
		}
		scanner.close(); 
	}
}
