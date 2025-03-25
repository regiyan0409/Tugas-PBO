// Superclass
class Buku {
    protected String judul;
    protected String pengarang;
    
    public Buku(String judul, String pengarang) {
        this.judul = judul;
        this.pengarang = pengarang;
    }
    
    // Method yang akan dioverride
    public void displayInfo() {
        System.out.println("Judul: " + judul + ", Pengarang: " + pengarang);
    }
    
    // Method overloading
    public void pinjam(String peminjam) {
        System.out.println("Buku " + judul + " dipinjam oleh " + peminjam);
    }
    
    public void pinjam(String peminjam, int durasi) {
        System.out.println("Buku " + judul + " dipinjam oleh " + peminjam + " selama " + durasi + " hari");
    }
}

// Subclass 1
class BukuFiksi extends Buku {
    private String genre;
    
    public BukuFiksi(String judul, String pengarang, String genre) {
        super(judul, pengarang);
        this.genre = genre;
    }
    
    // Overriding method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Genre: " + genre + " (Fiksi)");
    }
    
    // Method spesifik
    public void bacaSample() {
        System.out.println("Membaca sample buku fiksi " + judul);
    }
}

// Subclass 2
class BukuNonFiksi extends Buku {
    private String topik;
    
    public BukuNonFiksi(String judul, String pengarang, String topik) {
        super(judul, pengarang);
        this.topik = topik;
    }
    
    // Overriding method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Topik: " + topik + " (Non-Fiksi)");
    }
    
    // Method overloading
    public void cariReferensi() {
        System.out.println("Mencari referensi dari buku " + judul);
    }
    
    public void cariReferensi(String bab) {
        System.out.println("Mencari referensi dari buku " + judul + " bab " + bab);
    }
}

// Class Anggota untuk demonstrasi
class AnggotaPerpustakaan {
    private String nama;
    
    public AnggotaPerpustakaan(String nama) {
        this.nama = nama;
    }
    
    public void pinjamBuku(Buku buku) {
        System.out.println(nama + " meminjam buku:");
        buku.displayInfo();
    }
}

// Main class
public class PerpustakaanSystem {
    public static void main(String[] args) {
        // Membuat objek buku
        Buku buku1 = new BukuFiksi("Laskar Pelangi", "Andrea Hirata", "Drama");
        Buku buku2 = new BukuNonFiksi("Atomic Habits", "James Clear", "Pengembangan Diri");
        
        // Membuat anggota
        AnggotaPerpustakaan anggota = new AnggotaPerpustakaan("Budi");
        
        System.out.println("=== DEMO OVERRIDING ===");
        buku1.displayInfo(); // Memanggil method yang dioverride
        buku2.displayInfo();
        
        System.out.println("\n=== DEMO OVERLOADING ===");
        buku1.pinjam("Ani"); // Method overloading
        buku1.pinjam("Ani", 7);
        
        System.out.println("\n=== DEMO METHOD SPESIFIK ===");
        ((BukuFiksi)buku1).bacaSample(); // Downcasting
        ((BukuNonFiksi)buku2).cariReferensi();
        ((BukuNonFiksi)buku2).cariReferensi("3");
        
        System.out.println("\n=== DEMO POLYMORPHISM ===");
        anggota.pinjamBuku(buku1);
        anggota.pinjamBuku(buku2);
    }
}