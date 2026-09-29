# ðŸ“ Java OOP - Inheritance, Encapsulation & Polymorphism

Program Java yang mendemonstrasikan konsep **Encapsulation**, **Inheritance**, dan **Polymorphism** menggunakan hirarki kelas bentuk geometri.

---

## ðŸ“ Struktur Project

```
Inherits/
â”œâ”€â”€ src/
â”‚   â”œâ”€â”€ Bentuk.java         â† Parent class (superclass)
â”‚   â”œâ”€â”€ BujurSangkar.java   â† Child class dari Bentuk
â”‚   â”œâ”€â”€ Lingkaran.java      â† Child class dari Bentuk
â”‚   â”œâ”€â”€ Silinder.java       â† Child class dari Lingkaran
â”‚   â””â”€â”€ Main.java           â† Entry point program
â””â”€â”€ bin/
    â””â”€â”€ (compiled .class files)
```

---

## ðŸ”— Diagram Hierarki Kelas

```
Bentuk
â”œâ”€â”€ BujurSangkar  (extends Bentuk)
â””â”€â”€ Lingkaran     (extends Bentuk)
      â””â”€â”€ Silinder  (extends Lingkaran)
```

---

## ðŸ§± 1. Encapsulation (Enkapsulasi)

**Encapsulation** adalah konsep menyembunyikan data (atribut) dari akses luar, dan hanya mengizinkan akses melalui method getter dan setter.

### Contoh dalam kode:

**`BujurSangkar.java`** â€” atribut `sisi` bersifat `private`, hanya bisa diakses via getter/setter:

```java
public class BujurSangkar extends Bentuk {
    private double sisi;  // â† PRIVATE, tidak bisa diakses langsung dari luar

    public double getSisi() {    // â† Getter: untuk membaca nilai sisi
        return sisi;
    }

    public void setSisi(double sisi) {  // â† Setter: untuk mengubah nilai sisi
        this.sisi = sisi;
    }
}
```

**`Lingkaran.java`** â€” atribut `radius` bersifat `private`:

```java
public class Lingkaran extends Bentuk {
    private static final double PHI = 3.14159265358979;  // Konstanta kelas
    private double radius;  // â† PRIVATE

    public double getRadius() { return radius; }
    public void setRadius(double r) { this.radius = r; }
}
```

**`Silinder.java`** â€” atribut `tinggi` bersifat `private`:

```java
public class Silinder extends Lingkaran {
    private double tinggi;  // â† PRIVATE

    public double getTinggi() { return tinggi; }
    public void setTinggi(double t) { this.tinggi = t; }
}
```

### Tabel Encapsulation per Kelas

| Kelas         | Atribut     | Access Modifier | Getter           | Setter                  |
|---------------|-------------|-----------------|------------------|-------------------------|
| Bentuk        | warna       | public          | `getWarna()`     | `setWarna(String)`      |
| BujurSangkar  | sisi        | private         | `getSisi()`      | `setSisi(double)`       |
| Lingkaran     | radius      | private         | `getRadius()`    | `setRadius(double)`     |
| Silinder      | tinggi      | private         | `getTinggi()`    | `setTinggi(double)`     |

---

## ðŸ§¬ 2. Inheritance (Pewarisan)

**Inheritance** adalah konsep di mana sebuah class (child/subclass) mewarisi atribut dan method dari class lain (parent/superclass) menggunakan keyword `extends`.

### Hierarki Inheritance:

```
Bentuk  â†â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€ (Parent/Superclass)
  â”‚
  â”œâ”€â”€ BujurSangkar extends Bentuk  â† mewarisi: warna, getWarna(), setWarna(), printInfo()
  â”‚
  â””â”€â”€ Lingkaran extends Bentuk     â† mewarisi: warna, getWarna(), setWarna(), printInfo()
        â”‚
        â””â”€â”€ Silinder extends Lingkaran â† mewarisi: radius, getRadius(), hitungLuas(), dll.
```

### Contoh dalam kode:

**`Bentuk.java`** â€” Superclass:

```java
public class Bentuk {
    public String warna;

    public Bentuk(String warna) {
        this.warna = warna;
    }

    public String getWarna() { return warna; }
    public void setWarna(String warna) { this.warna = warna; }
    public void printInfo() {
        System.out.println("Bentuk berwarna " + warna);
    }
}
```

**`BujurSangkar.java`** â€” mewarisi Bentuk dengan `extends`:

```java
public class BujurSangkar extends Bentuk {
    public BujurSangkar(double sisi, String warna) {
        super(warna);  // â† memanggil constructor parent class Bentuk
        this.sisi = sisi;
    }
}
```

**`Lingkaran.java`** â€” mewarisi Bentuk:

```java
public class Lingkaran extends Bentuk {
    public Lingkaran(double radius, String warna) {
        super(warna);  // â† memanggil constructor parent class Bentuk
        this.radius = radius;
    }
}
```

**`Silinder.java`** â€” mewarisi Lingkaran (multi-level inheritance):

```java
public class Silinder extends Lingkaran {
    public Silinder(double tinggi, double radius, String warna) {
        super(radius, warna);  // â† memanggil constructor parent class Lingkaran
        this.tinggi = tinggi;
    }

    public double hitungVolume() {
        return hitungLuas() * tinggi;  // â† hitungLuas() diwarisi dari Lingkaran!
    }
}
```

### Tabel Pewarisan

| Subclass      | Superclass  | Mewarisi                                          |
|---------------|-------------|---------------------------------------------------|
| BujurSangkar  | Bentuk      | `warna`, `getWarna()`, `setWarna()`, `printInfo()`|
| Lingkaran     | Bentuk      | `warna`, `getWarna()`, `setWarna()`, `printInfo()`|
| Silinder      | Lingkaran   | `radius`, `getRadius()`, `setRadius()`, `hitungLuas()`, + semua dari Bentuk |

---

## ðŸŽ­ 3. Polymorphism (Polimorfisme)

**Polymorphism** adalah kemampuan suatu method untuk memiliki banyak bentuk/perilaku berbeda. Dalam kode ini, polymorphism terjadi melalui **Method Overriding** â€” child class mendefinisikan ulang method `printInfo()` yang ada di parent class.

### Contoh Method Overriding `printInfo()`:

**`Bentuk.java`** (Original):
```java
public void printInfo() {
    System.out.println("Bentuk berwarna " + warna);
    // Output: Bentuk berwarna merah
}
```

**`BujurSangkar.java`** (@Override):
```java
@Override
public void printInfo() {
    System.out.println("Bujursangkar berwarna " + getWarna() + ", luas = " + hitungLuas());
    // Output: Bujursangkar berwarna biru, luas = 25.0
}
```

**`Lingkaran.java`** (@Override):
```java
@Override
public void printInfo() {
    System.out.println("Lingkaran " + getWarna() + ", luas = " + hitungLuas());
    // Output: Lingkaran kuning, luas = 153.938...
}
```

**`Silinder.java`** (@Override):
```java
@Override
public void printInfo() {
    System.out.println("Silinder warna " + getWarna() + ", volume = " + hitungVolume());
    // Output: Silinder warna hijau, volume = 785.398...
}
```

### Polymorphism via Referensi Parent Class:

```java
// Semua objek diperlakukan sebagai tipe Bentuk (parent)
Bentuk[] shapes = {
    new Bentuk("merah"),
    new BujurSangkar(5.0, "biru"),
    new Lingkaran(7.0, "kuning"),
    new Silinder(10.0, 5.0, "hijau")
};

// printInfo() memanggil versi yang berbeda sesuai objek aslinya
for (Bentuk shape : shapes) {
    shape.printInfo();  // â† Polymorphism!
}
```

---

## â–¶ï¸ Cara Menjalankan Program

### Kompilasi:
```bash
javac src/Bentuk.java src/BujurSangkar.java src/Lingkaran.java src/Silinder.java src/Main.java -d bin
```

### Jalankan:
```bash
java -cp bin Main
```

---

## ðŸ“¸ Screenshot Output Program

```
Bentuk berwarna merah
---
Bujursangkar berwarna biru, luas = 25.0
---
Lingkaran kuning, luas = 153.9380400258997
---
Silinder warna hijau, volume = 785.3981633974474
---
Tinggi: 15.0
Radius: 3.0
Warna: oranye
Volume: 424.1150082346217
Silinder warna oranye, volume = 424.1150082346217
```

---

## ðŸ“ Rumus Perhitungan

| Bentuk       | Rumus                          |
|--------------|--------------------------------|
| BujurSangkar | Luas = sisi Ã— sisi             |
| Lingkaran    | Luas = Ï€ Ã— radiusÂ²             |
| Silinder     | Volume = Ï€ Ã— radiusÂ² Ã— tinggi  |

> **Nilai PHI (Ï€)** = `3.14159265358979` â€” dijadikan konstanta kelas (`static final`) di dalam `Lingkaran.java`

---

## ðŸ‘¤ Informasi

| Field    | Keterangan                      |
|----------|---------------------------------|
| Mata Kuliah | Pemrograman Berbasis Objek   |
| Semester | 5                               |
| Topik    | Inheritance, Encapsulation, Polymorphism |
| Bahasa   | Java                            |