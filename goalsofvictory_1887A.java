import java.util.Scanner;
public class goalsofvictory_1887A {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) { 
			long n = scanner.nextLong(); 
			long[] a = new long[(int) n - 1]; 
			for (int i = 0; i < n - 1; i++) { 
				a[i] = scanner.nextLong(); 
			}

			long sum = 0; 
			for (int i = 0; i < n - 1; i++) { 
				sum += a[i]; 
			}

			System.out.println(-1 * sum); 
		}
		scanner.close(); 
	}
}
