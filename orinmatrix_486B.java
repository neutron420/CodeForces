import java.util.*;

public class orinmatrix_486B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] B = new int[m][n];
        int[][] A = new int[m][n];

        // Initialize A with all 1s
        for (int i = 0; i < m; i++) {
            Arrays.fill(A[i], 1);
        }

        // Read B
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // Construct A
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (B[i][j] == 0) {

                    // Make entire row zero
                    for (int k = 0; k < n; k++) {
                        A[i][k] = 0;
                    }

                    // Make entire column zero
                    for (int k = 0; k < m; k++) {
                        A[k][j] = 0;
                    }
                }
            }
        }

        // Reconstruct matrix C
        int[][] C = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int rowOR = 0;
                int colOR = 0;

                for (int k = 0; k < n; k++) {
                    rowOR |= A[i][k];
                }

                for (int k = 0; k < m; k++) {
                    colOR |= A[k][j];
                }

                C[i][j] = rowOR | colOR;
            }
        }

        // Check if reconstructed matrix matches B
        boolean possible = true;

        for (int i = 0; i < m && possible; i++) {
            for (int j = 0; j < n; j++) {
                if (B[i][j] != C[i][j]) {
                    possible = false;
                    break;
                }
            }
        }

        if (!possible) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(A[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}