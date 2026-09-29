public class Silinder extends Lingkaran {
    // Atribut tinggi (akses private sesuai diagram)
    private double tinggi;

    // Constructor
    public Silinder(double tinggi, double radius, String warna) {
        super(radius, warna); // memanggil constructor parent class Lingkaran
        this.tinggi = tinggi;
    }

    // Getter tinggi
    public double getTinggi() {
        return tinggi;
    }

    // Setter tinggi
    public void setTinggi(double t) {
        this.tinggi = t;
    }

    // Menghitung volume silinder (luas alas * tinggi)
    // Volume = PHI * radius^2 * tinggi
    public double hitungVolume() {
        return hitungLuas() * tinggi;
    }

    // Override printInfo dari parent class
    @Override
    public void printInfo() {
        System.out.println("Silinder warna " + getWarna() + ", volume = " + hitungVolume());
    }
}