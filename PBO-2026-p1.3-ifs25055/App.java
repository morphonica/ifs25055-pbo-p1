import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(parts[j]);
            }
        }

        // Nilai Tengah: 1 sel jika n ganjil, 4 sel jika n genap
        int nilaiTengah;
        if (n % 2 == 1) {
            int c = n / 2;
            nilaiTengah = matrix[c][c];
        } else {
            int c1 = n / 2 - 1;
            int c2 = n / 2;
            nilaiTengah = matrix[c1][c1] + matrix[c1][c2] + matrix[c2][c1] + matrix[c2][c2];
        }

        // Bentuk L/Kebalikan L butuh bagian horizontal (kolom 1 s.d. n-2),
        // yang hanya ada jika n >= 3. Jika n < 3, L tidak bisa terbentuk.
        if (n < 3) {
            System.out.println("Nilai L: Tidak Ada");
            System.out.println("Nilai Kebalikan L: Tidak Ada");
            System.out.println("Nilai Tengah: " + nilaiTengah);
            System.out.println("Perbedaan: Tidak Ada");
            System.out.println("Dominan: " + nilaiTengah);
            sc.close();
            return;
        }

        // Nilai L: kolom pertama (semua baris) + baris terakhir (kolom 1 s.d. n-2)
        int nilaiL = 0;
        for (int i = 0; i < n; i++) {
            nilaiL += matrix[i][0];
        }
        for (int j = 1; j <= n - 2; j++) {
            nilaiL += matrix[n - 1][j];
        }

        // Nilai Kebalikan L: kolom terakhir (semua baris) + baris pertama (kolom 1 s.d. n-2)
        int nilaiKebalikanL = 0;
        for (int i = 0; i < n; i++) {
            nilaiKebalikanL += matrix[i][n - 1];
        }
        for (int j = 1; j <= n - 2; j++) {
            nilaiKebalikanL += matrix[0][j];
        }
        int perbedaan = Math.abs(nilaiL - nilaiKebalikanL);
        int dominan;
        if (nilaiL == nilaiKebalikanL) {
            dominan = nilaiTengah;
        } else {
            dominan = Math.max(nilaiL, nilaiKebalikanL);
        }

        System.out.println("Nilai L: " + nilaiL);
        System.out.println("Nilai Kebalikan L: " + nilaiKebalikanL);
        System.out.println("Nilai Tengah: " + nilaiTengah);
        System.out.println("Perbedaan: " + perbedaan);
        System.out.println("Dominan: " + dominan);

        sc.close();
    }
}