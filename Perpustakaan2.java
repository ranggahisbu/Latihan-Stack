import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Buku {
    String judul;
    String pengarang;
    String penerbit;
    int tahun;
    int kategori;

    public Buku(String judul, String pengarang, String penerbit, int tahun, int kategori) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahun = tahun;
        this.kategori = kategori;
    }
}

public class Perpustakaan2 {
    public static void main(String[] args) {
        List<Buku> daftarBuku = new ArrayList<>();
        Stack<Buku> stackBuku = new Stack<>();
        List<Buku> bukuLawas = new ArrayList<>();
        List<Buku> bukuBaru = new ArrayList<>();

        stackBuku.push(new Buku("PBO dengan Java", "Abdul Kadir", "Erlangga", 2008, 1));
        stackBuku.push(new Buku("Dasar Pemrograman", "Indrijani", "Erlangga", 2020, 1));
        stackBuku.push(new Buku("Si Doel", "Indrijani", "Balai Pustaka", 1932, 3));

        while (!stackBuku.isEmpty()) {
            Buku buku = stackBuku.pop();
            daftarBuku.add(buku);
            if (buku.tahun < 2000) {
                bukuLawas.add(buku);
            } else {
                bukuBaru.add(buku);
            }
        }

        System.out.println("=======================================================================");
        System.out.println("Daftar Buku Java yang Tersedia");
        System.out.println("=======================================================================");
        System.out.println("No\tJudul\tPengarang\tPenerbit\tTahun\tKategori");
        System.out.println("=======================================================================");

        for (int i = 0; i < daftarBuku.size(); i++) {
            Buku buku = daftarBuku.get(i);
            System.out.println((i + 1) + "\t" + buku.judul + "\t" + buku.pengarang + "\t" + buku.penerbit + "\t" + buku.tahun + "\t" + kategoriToString(buku.kategori));
        }

        int[] jumlahBukuPerKategori = new int[4];

        for (Buku buku : daftarBuku) {
            jumlahBukuPerKategori[buku.kategori - 1]++;
        }

System.out.println("=======================================================================");

        System.out.println("\nJumlah buku yang tersedia: " + daftarBuku.size());
        System.out.println("Buku Teknik: " + jumlahBukuPerKategori[0]);
        System.out.println("Buku Manajemen: " + jumlahBukuPerKategori[1]);
        System.out.println("Buku Fiksi: " + jumlahBukuPerKategori[2]);
        System.out.println("Buku Lainnya: " + jumlahBukuPerKategori[3]);
        
System.out.println("=======================================================================");        

        System.out.println("\nDaftar Buku Lawas:");
        for (Buku buku : bukuLawas) {
            System.out.println(buku.judul + " (" + buku.tahun + ")");
        }

        System.out.println("\nDaftar Buku Baru:");
        for (Buku buku : bukuBaru) {
            System.out.println(buku.judul + " (" + buku.tahun + ")");
        }
    }

    public static String kategoriToString(int kategori) {
        switch (kategori) {
            case 1:
                return "Teknik";
            case 2:
                return "Manajemen";
            case 3:
                return "Fiksi";
            case 4:
                return "Lainnya";
            default:
                return "Kategori tidak valid";
        }
    }
}
