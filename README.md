# Java OOP - Inheritance, Encapsulation, dan Polymorphism

Program Java yang mendemonstrasikan konsep Encapsulation, Inheritance, dan Polymorphism menggunakan hirarki kelas bentuk geometri.

---

## Struktur Project

```
Inherits/
├── src/
│   ├── Bentuk.java         (Parent class / Superclass)
│   ├── BujurSangkar.java   (Child class dari Bentuk)
│   ├── Lingkaran.java      (Child class dari Bentuk)
│   ├── Silinder.java       (Child class dari Lingkaran)
│   └── Main.java           (Entry point program)
└── bin/
    └── (compiled .class files)
```

---

## Hierarki Kelas

```
Bentuk
├── BujurSangkar  (extends Bentuk)
└── Lingkaran     (extends Bentuk)
      └── Silinder  (extends Lingkaran)
```

---

## 1. Encapsulation

Encapsulation adalah konsep menyembunyikan atribut dari akses luar menggunakan access modifier `private`, dan hanya mengizinkan akses melalui method getter dan setter.

Contoh pada BujurSangkar.java:

```java
public class BujurSangkar extends Bentuk {
    private double sisi; // atribut private, tidak bisa diakses langsung dari luar

    public double getSisi() {       // getter untuk membaca nilai sisi
        return sisi;
    }

    public void setSisi(double sisi) { // setter untuk mengubah nilai sisi
        this.sisi = sisi;
    }
}
```

Contoh pada Lingkaran.java:

```java
public class Lingkaran extends Bentuk {
    private static final double PHI = 3.14159265358979; // konstanta kelas
    private double radius; // atribut private

    public double getRadius() { return radius; }
    public void setRadius(double r) { this.radius = r; }
}
```

Contoh pada Silinder.java:

```java
public class Silinder extends Lingkaran {
    private double tinggi; // atribut private

    public double getTinggi() { return tinggi; }
    public void setTinggi(double t) { this.tinggi = t; }
}
```

Tabel Encapsulation:

| Kelas        | Atribut | Access Modifier | Getter        | Setter             |
|--------------|---------|-----------------|---------------|--------------------|
| Bentuk       | warna   | public          | getWarna()    | setWarna(String)   |
| BujurSangkar | sisi    | private         | getSisi()     | setSisi(double)    |
| Lingkaran    | radius  | private         | getRadius()   | setRadius(double)  |
| Silinder     | tinggi  | private         | getTinggi()   | setTinggi(double)  |

---

## 2. Inheritance

Inheritance adalah konsep di mana sebuah class (child) mewarisi atribut dan method dari class lain (parent) menggunakan keyword `extends`. Child class juga dapat memanggil constructor parent menggunakan `super()`.

Contoh pada BujurSangkar.java:

```java
public class BujurSangkar extends Bentuk { // mewarisi class Bentuk
    public BujurSangkar(double sisi, String warna) {
        super(warna); // memanggil constructor parent class Bentuk
        this.sisi = sisi;
    }
}
```

Contoh pada Lingkaran.java:

```java
public class Lingkaran extends Bentuk { // mewarisi class Bentuk
    public Lingkaran(double radius, String warna) {
        super(warna); // memanggil constructor parent class Bentuk
        this.radius = radius;
    }
}
```

Contoh pada Silinder.java (multi-level inheritance):

```java
public class Silinder extends Lingkaran { // mewarisi class Lingkaran
    public Silinder(double tinggi, double radius, String warna) {
        super(radius, warna); // memanggil constructor parent class Lingkaran
        this.tinggi = tinggi;
    }

    public double hitungVolume() {
        return hitungLuas() * tinggi; // hitungLuas() diwarisi dari Lingkaran
    }
}
```

Tabel Pewarisan:

| Subclass     | Superclass | Yang Diwarisi                                     |
|--------------|------------|---------------------------------------------------|
| BujurSangkar | Bentuk     | warna, getWarna(), setWarna(), printInfo()         |
| Lingkaran    | Bentuk     | warna, getWarna(), setWarna(), printInfo()         |
| Silinder     | Lingkaran  | radius, getRadius(), setRadius(), hitungLuas(), dan semua dari Bentuk |

---

## 3. Polymorphism

Polymorphism adalah kemampuan sebuah method untuk memiliki banyak bentuk atau perilaku berbeda tergantung pada class yang mengimplementasikannya. Dalam kode ini, polymorphism terjadi melalui method overriding pada method `printInfo()`.

Bentuk.java (method asli):

```java
public void printInfo() {
    System.out.println("Bentuk berwarna " + warna);
}
```

BujurSangkar.java (override):

```java
@Override
public void printInfo() {
    System.out.println("Bujursangkar berwarna " + getWarna() + ", luas = " + hitungLuas());
}
```

Lingkaran.java (override):

```java
@Override
public void printInfo() {
    System.out.println("Lingkaran " + getWarna() + ", luas = " + hitungLuas());
}
```

Silinder.java (override):

```java
@Override
public void printInfo() {
    System.out.println("Silinder warna " + getWarna() + ", volume = " + hitungVolume());
}
```

Meski method yang dipanggil sama yaitu `printInfo()`, setiap class menghasilkan output yang berbeda sesuai implementasinya masing-masing.

---

## Cara Menjalankan Program

Kompilasi:

```
javac src/Bentuk.java src/BujurSangkar.java src/Lingkaran.java src/Silinder.java src/Main.java -d bin
```

Jalankan:

```
java -cp bin Main
```

---

## Screenshot Output Program

![Screenshot Output Program](Screenshot%202026-09-29%20094553.png)

Output di terminal:

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

## Rumus Perhitungan

| Bentuk       | Rumus                         |
|--------------|-------------------------------|
| BujurSangkar | Luas = sisi x sisi            |
| Lingkaran    | Luas = PHI x radius x radius  |
| Silinder     | Volume = Luas x tinggi        |

Nilai PHI = 3.14159265358979 (konstanta kelas di Lingkaran.java)

---

## Informasi

| Field       | Keterangan                                       |
|-------------|--------------------------------------------------|
| Mata Kuliah | Pemrograman Berbasis Objek                       |
| Semester    | 5                                                |
| Topik       | Inheritance, Encapsulation, Polymorphism         |
| Bahasa      | Java                                             |