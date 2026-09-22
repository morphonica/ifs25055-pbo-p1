import java.util.Scanner;

public class App {

    static int freqOf(int val, int[] uniq, int[] freq, int u) {
        for (int j = 0; j < u; j++) {
            if (uniq[j] == val) return freq[j];
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] values = new int[100000];
        int n = 0;

        while (sc.hasNextInt()) {
            values[n++] = sc.nextInt();
        }

        if (n == 0) {
            return;
        }

        // cari nilai tertinggi & terendah
        int tertinggi = values[0], terendah = values[0];
        for (int i = 1; i < n; i++) {
            if (values[i] > tertinggi) tertinggi = values[i];
            if (values[i] < terendah) terendah = values[i];
        }

        // hitung frekuensi tiap nilai unik
        int[] uniq = new int[n];
        int[] freq = new int[n];
        int u = 0;
        for (int i = 0; i < n; i++) {
            int found = -1;
            for (int j = 0; j < u; j++) {
                if (uniq[j] == values[i]) { found = j; break; }
            }
            if (found == -1) {
                uniq[u] = values[i];
                freq[u] = 1;
                u++;
            } else {
                freq[found]++;
            }
        }

        // cari frekuensi maksimum & minimum
        int maxFreq = freq[0], minFreq = freq[0];
        for (int j = 1; j < u; j++) {
            if (freq[j] > maxFreq) maxFreq = freq[j];
            if (freq[j] < minFreq) minFreq = freq[j];
        }

        // Terbanyak: di antara nilai berfrekuensi maxFreq, ambil yang PALING BESAR
        // Tersedikit: di antara nilai berfrekuensi minFreq, ambil yang PALING KECIL
        int terbanyakVal = 0, tersedikitVal = 0;
        boolean terbanyakSet = false, tersedikitSet = false;
        for (int j = 0; j < u; j++) {
            if (freq[j] == maxFreq) {
                if (!terbanyakSet || uniq[j] > terbanyakVal) {
                    terbanyakVal = uniq[j];
                    terbanyakSet = true;
                }
            }
            if (freq[j] == minFreq) {
                if (!tersedikitSet || uniq[j] < tersedikitVal) {
                    tersedikitVal = uniq[j];
                    tersedikitSet = true;
                }
            }
        }

        int freqTertinggi = freqOf(tertinggi, uniq, freq, u);
        int freqTerendah = freqOf(terendah, uniq, freq, u);

        System.out.println("Tertinggi: " + tertinggi);
        System.out.println("Terendah: " + terendah);
        System.out.println("Terbanyak: " + terbanyakVal + " (" + maxFreq + "x)");
        System.out.println("Tersedikit: " + tersedikitVal + " (" + minFreq + "x)");
        System.out.println("Jumlah Tertinggi: " + tertinggi + " * " + freqTertinggi + " = " + (tertinggi * freqTertinggi));
        System.out.println("Jumlah Terendah: " + terendah + " * " + freqTerendah + " = " + (terendah * freqTerendah));
    }
}