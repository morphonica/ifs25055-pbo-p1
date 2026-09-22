import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            return;
        }

        String timeLine = scanner.nextLine().trim();

        // Validasi format jam: harus HH:MM, masing-masing bagian hanya digit
        if (!timeLine.matches("\\d{1,2}:\\d{1,2}")) {
            System.out.println("Jam tidak valid");
            return;
        }

        String[] parts = timeLine.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            System.out.println("Jam tidak valid");
            return;
        }

        // cum = posisi menit absolut (tidak dibungkus modulo tiap langkah)
        int cum = hour * 60 + minute;
        int totalDelta = 0;
        int dayChange = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (line.equals("---")) {
                break;
            }

            if (line.matches("[+-]\\d+")) {
                int delta = Integer.parseInt(line);
                int newCum = cum + delta;

                // Hitung pergantian hari lewat perbandingan "hari ke berapa"
                // sebelum & sesudah pergeseran (aritmetika menit, modulo 1440)
                int oldDay = Math.floorDiv(cum, 1440);
                int newDay = Math.floorDiv(newCum, 1440);
                dayChange += Math.abs(newDay - oldDay);

                totalDelta += delta;
                cum = newCum;
            } else {
                System.out.println("Perintah tidak valid");
            }
        }

        int finalCum = Math.floorMod(cum, 1440);
        int endHour = finalCum / 60;
        int endMinute = finalCum % 60;

        String totalStr;
        if (totalDelta > 0) {
            totalStr = "+" + totalDelta;
        } else if (totalDelta == 0) {
            totalStr = "0";
        } else {
            totalStr = String.valueOf(totalDelta);
        }

        System.out.printf("Jam Awal: %02d:%02d%n", hour, minute);
        System.out.printf("Jam Akhir: %02d:%02d%n", endHour, endMinute);
        System.out.println("Total Menit: " + totalStr);
        System.out.println("Pergantian Hari: " + dayChange);
    }
}