public class BujurSangkar extends Bentuk {
    // Atribut sisi (akses private sesuai diagram)
    private double sisi;

    // Constructor
    public BujurSangkar(double sisi, String warna) {
        super(warna);
        this.sisi = sisi;
    }

    // Getter sisi
    public double getSisi() {
        return sisi;
    }

    // Setter sisi
    public void setSisi(double sisi) {
        this.sisi = sisi;
    }

    // Menghitung luas bujur sangkar (sisi * sisi)
    public double hitungLuas() {
        return sisi * sisi;
    }

    // Override printInfo dari parent class
    @Override
    public void printInfo() {
        System.out.println("Bujursangkar berwarna " + getWarna() + ", luas = " + hitungLuas());
    }
}