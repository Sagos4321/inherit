public class Bentuk {
    // Atribut warna (akses public sesuai diagram)
    public String warna;

    // Constructor
    public Bentuk(String warna) {
        this.warna = warna;
    }

    // Getter warna
    public String getWarna() {
        return warna;
    }

    // Setter warna
    public void setWarna(String warna) {
        this.warna = warna;
    }

    // Menampilkan informasi bentuk
    public void printInfo() {
        System.out.println("Bentuk berwarna " + warna);
    }
}