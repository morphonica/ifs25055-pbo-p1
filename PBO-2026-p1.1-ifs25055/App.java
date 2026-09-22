import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String nim = input.nextLine();

        // Cek panjang NIM
        if (nim.length() != 8) {
            System.out.println("NIM harus 8 karakter");
            return;
        }

        // Ambil kode program studi
        String kodeProdi = nim.substring(0, 3);

        String programStudi;

        if (kodeProdi.equals("11S")) {
            programStudi = "Sarjana Informatika";
        } else if (kodeProdi.equals("12S")) {
            programStudi = "Sarjana Sistem Informasi";
        } else if (kodeProdi.equals("13S")) {
            programStudi = "Sarjana Teknik Elektro";
        } else if (kodeProdi.equals("21S")) {
            programStudi = "Sarjana Manajemen Rekayasa";
        } else if (kodeProdi.equals("22S")) {
            programStudi = "Sarjana Teknik Metalurgi";
        } else if (kodeProdi.equals("31S")) {
            programStudi = "Sarjana Teknik Bioproses";
        } else if (kodeProdi.equals("32S")) {
            programStudi = "Sarjana Bioteknologi";
        } else if (kodeProdi.equals("114")) {
            programStudi = "Diploma 4 Teknologi Rekasaya Perangkat Lunak";
        } else if (kodeProdi.equals("113")) {
            programStudi = "Diploma 3 Teknologi Informasi";
        } else if (kodeProdi.equals("133")) {
            programStudi = "Diploma 3 Teknologi Komputer";
        } else {
            System.out.println("Kode tidak tersedia");
            return;
        }

        // Ambil kode angkatan
        String kodeAngkatan = nim.substring(3, 5);
        int angkatan = Integer.parseInt("20" + kodeAngkatan);

        // Ambil nomor urut
        String kodeUrutan = nim.substring(5, 8);
        int urutan = Integer.parseInt(kodeUrutan);

        // Tampilkan hasil
        System.out.println("Inforamsi NIM " + nim + ": ");
        System.out.println(">> Program Studi: " + programStudi);
        System.out.println(">> Angkatan: " + angkatan);
        System.out.println(">> Urutan: " + urutan);
    }
}