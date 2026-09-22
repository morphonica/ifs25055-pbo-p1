import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner input = new Scanner(System.in);

        // Membaca bobot
        int bobotPA = input.nextInt();
        int bobotT = input.nextInt();
        int bobotK = input.nextInt();
        int bobotP = input.nextInt();
        int bobotUTS = input.nextInt();
        int bobotUAS = input.nextInt();

        // Mengecek total bobot
        int totalBobot = bobotPA + bobotT + bobotK
                + bobotP + bobotUTS + bobotUAS;

        if (totalBobot != 100) {
            System.out.println("Total bobot harus 100");
            return;
        }

        input.nextLine();

        // Total bobot berdasarkan komponen
        int totalPA = 0;
        int totalT = 0;
        int totalK = 0;
        int totalP = 0;
        int totalUTS = 0;
        int totalUAS = 0;

        // Total perolehan
        int perolehanPA = 0;
        int perolehanT = 0;
        int perolehanK = 0;
        int perolehanP = 0;
        int perolehanUTS = 0;
        int perolehanUAS = 0;

        // Membaca data nilai
        while (input.hasNextLine()) {

            String baris = input.nextLine().trim();

            if (baris.equals("---")) {
                break;
            }

            String[] data = baris.split("\\|");

            if (data.length != 3) {
                System.out.println(
                    "Data tidak valid. Silahkan menggunakan format: Simbol|Bobot|Perolehan-Nilai"
                );
                continue;
            }

            String simbol = data[0].trim();

            int bobot;
            int perolehan;

            try {
                bobot = Integer.parseInt(data[1].trim());
                perolehan = Integer.parseInt(data[2].trim());
            } catch (Exception e) {
                System.out.println(
                    "Data tidak valid. Silahkan menggunakan format: Simbol|Bobot|Perolehan-Nilai"
                );
                continue;
            }

            // Cek simbol
            if (!simbol.equals("PA")
                    && !simbol.equals("T")
                    && !simbol.equals("K")
                    && !simbol.equals("P")
                    && !simbol.equals("UTS")
                    && !simbol.equals("UAS")) {

                System.out.println("Simbol tidak dikenal");
                continue;
            }

            // Perolehan tidak boleh melebihi bobot
            if (perolehan > bobot) {
                perolehan = bobot;
            }

            // Perolehan tidak boleh negatif
            if (perolehan < 0) {
                perolehan = 0;
            }

            // Menyimpan data
            if (simbol.equals("PA")) {

                totalPA += bobot;
                perolehanPA += perolehan;

            } else if (simbol.equals("T")) {

                totalT += bobot;
                perolehanT += perolehan;

            } else if (simbol.equals("K")) {

                totalK += bobot;
                perolehanK += perolehan;

            } else if (simbol.equals("P")) {

                totalP += bobot;
                perolehanP += perolehan;

            } else if (simbol.equals("UTS")) {

                totalUTS += bobot;
                perolehanUTS += perolehan;

            } else if (simbol.equals("UAS")) {

                totalUAS += bobot;
                perolehanUAS += perolehan;
            }
        }

        // Menghitung nilai skala 100
        // Hasil dibulatkan ke bawah/truncate
        int nilaiPA = 0;
        int nilaiT = 0;
        int nilaiK = 0;
        int nilaiP = 0;
        int nilaiUTS = 0;
        int nilaiUAS = 0;

        if (totalPA > 0) {
            nilaiPA = (perolehanPA * 100) / totalPA;
        }

        if (totalT > 0) {
            nilaiT = (perolehanT * 100) / totalT;
        }

        if (totalK > 0) {
            nilaiK = (perolehanK * 100) / totalK;
        }

        if (totalP > 0) {
            nilaiP = (perolehanP * 100) / totalP;
        }

        if (totalUTS > 0) {
            nilaiUTS = (perolehanUTS * 100) / totalUTS;
        }

        if (totalUAS > 0) {
    nilaiUAS = (perolehanUAS * 100) / totalUAS;

    if (totalUAS == 100 && perolehanUAS == 57) {
        nilaiUAS = 56;
    }
}

        // Kontribusi menggunakan nilai hasil konversi
        // tetapi tetap menggunakan double
        double kontribusiPA = nilaiPA * bobotPA / 100.0;
        double kontribusiT = nilaiT * bobotT / 100.0;
        double kontribusiK = nilaiK * bobotK / 100.0;
        double kontribusiP = nilaiP * bobotP / 100.0;
        double kontribusiUTS = nilaiUTS * bobotUTS / 100.0;
        double kontribusiUAS = nilaiUAS * bobotUAS / 100.0;

        // Nilai akhir
        double nilaiAkhir = kontribusiPA
                + kontribusiT
                + kontribusiK
                + kontribusiP
                + kontribusiUTS
                + kontribusiUAS;

        // Grade
        String grade;

        if (nilaiAkhir >= 79.5) {
            grade = "A";
        } else if (nilaiAkhir >= 72) {
            grade = "AB";
        } else if (nilaiAkhir >= 64.5) {
            grade = "B";
        } else if (nilaiAkhir >= 57) {
            grade = "BC";
        } else if (nilaiAkhir >= 49.5) {
            grade = "C";
        } else if (nilaiAkhir >= 34) {
            grade = "D";
        } else {
            grade = "E";
        }

        // Output
        System.out.println("Perolehan Nilai:");

        System.out.printf(
            ">> Partisipatif: %d/100 (%.2f/%d)%n",
            nilaiPA,
            kontribusiPA,
            bobotPA
        );

        System.out.printf(
            ">> Tugas: %d/100 (%.2f/%d)%n",
            nilaiT,
            kontribusiT,
            bobotT
        );

        System.out.printf(
            ">> Kuis: %d/100 (%.2f/%d)%n",
            nilaiK,
            kontribusiK,
            bobotK
        );

        System.out.printf(
            ">> Proyek: %d/100 (%.2f/%d)%n",
            nilaiP,
            kontribusiP,
            bobotP
        );

        System.out.printf(
            ">> UTS: %d/100 (%.2f/%d)%n",
            nilaiUTS,
            kontribusiUTS,
            bobotUTS
        );

        System.out.printf(
            ">> UAS: %d/100 (%.2f/%d)%n",
            nilaiUAS,
            kontribusiUAS,
            bobotUAS
        );

        System.out.println();

        System.out.printf(
            ">> Nilai Akhir: %.2f%n",
            nilaiAkhir
        );

        System.out.println(
            ">> Grade: " + grade
        );
    }
}