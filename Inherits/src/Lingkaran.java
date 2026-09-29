public class Lingkaran extends Bentuk {
    // Konstanta PHI
    private static final double PHI = 3.14159265358979;

    // Atribut radius (akses private sesuai diagram)
    private double radius;

    // Constructor
    public Lingkaran(double radius, String warna) {
        super(warna); // memanggil constructor parent class Bentuk
        this.radius = radius;
    }

    // Getter radius
    public double getRadius() {
        return radius;
    }

    // Setter radius
    public void setRadius(double r) {
        this.radius = r;
    }

    // Menghitung luas lingkaran (PHI * radius * radius)
    public double hitungLuas() {
        return PHI * radius * radius;
    }

    // Override printInfo dari parent class
    @Override
    public void printInfo() {
        System.out.println("Lingkaran " + getWarna() + ", luas = " + hitungLuas());
    }
}