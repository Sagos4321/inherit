public class Main {
    public static void main(String[] args) {
        // Membuat objek Bentuk
        Bentuk bentuk = new Bentuk("merah");
        bentuk.printInfo();

        System.out.println("---");

        // Membuat objek BujurSangkar
        BujurSangkar bs = new BujurSangkar(5.0, "biru");
        bs.printInfo();

        System.out.println("---");

        // Membuat objek Lingkaran
        Lingkaran lg = new Lingkaran(7.0, "kuning");
        lg.printInfo();

        System.out.println("---");

        // Membuat objek Silinder
        Silinder sl = new Silinder(10.0, 5.0, "hijau");
        sl.printInfo();

        System.out.println("---");

        // Contoh penggunaan getter dan setter Silinder
        sl.setTinggi(15.0);
        sl.setRadius(3.0);
        sl.setWarna("oranye");
        System.out.println("Tinggi: " + sl.getTinggi());
        System.out.println("Radius: " + sl.getRadius());
        System.out.println("Warna: " + sl.getWarna());
        System.out.println("Volume: " + sl.hitungVolume());
        sl.printInfo();
    }
}