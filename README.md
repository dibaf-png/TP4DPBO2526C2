## Janji

Saya Farah Diba Nur Malinda dengan NIM 2502083 mengerjakan Tugas Praktikum 4 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin

---

## Fitur Utama

Aplikasi ini menyediakan 4 fungsi utama untuk pengoperasian data:
1. **Tambah Data (Create / Add):** Menyimpan data baru (ID, Nama, Tahun Lahir, Kategori, dan Jenis Kelamin) 
2. **Ubah Data (Update):** Memperbarui atau mengubah informasi data yang sudah ada.
3. **Hapus Data (Delete):** Menghapus data yang dipilih.
4. **Batal/Reset (Cancel):** Mengosongkan seluruh kolom input, mengembalikan pilihan dropdown ke status awal, dan mengaktifkan kembali kolom ID melalui method `clearForm()`.

---

## Struktur Class

Program ini dibagi menjadi dua kelas utama:

### 1. Class `Person`
Berfungsi sebagai model data atau wadah untuk merepresentasikan dan menyimpan atribut individual dari setiap orang yang dikelola dalam aplikasi.
* **Atribut:**
  * `String id` — Identitas unik data.
  * `String nama` — Nama lengkap.
  * `String tahunLahir` — Tahun kelahiran.
  * `String kategori` — Status/kategori (Siswa, Mahasiswa, Dosen, dll).
  * `String jenisKelamin` — Pilihan jenis kelamin.
* **Method:** Constructor, serta *Getter* dan *Setter* untuk masing-masing atribut.

### 2. Class `PeopleMenu` extends `JFrame`
Berfungsi untuk menjadikan class tersebut sebagai jendela aplikasi desktop yang menampung seluruh komponen antarmuka grafis sekaligus mengatur logika programnya.
* **Fungsi Utama:**
  * `insertData()` – Menambahkan data baru ke dalam list.
  * `updateData()` – Memperbarui data objek yang sedang dipilih pada indeks tabel.
  * `deleteData()` – Menghapus data dari list setelah konfirmasi.
  * `clearForm()` – Mengosongkan input form, mereset pilihan ComboBox, dan mengaktifkan kembali field ID.
  * `setTable()` – Mengatur struktur kolom dan memperbarui isi baris tabel secara dinamis berdasarkan data list.

---

## Komponen GUI & Fungsinya

Antarmuka dibangun menggunakan **Java Swing** dengan rincian komponen visual sebagai berikut:

<img width="698" height="456" alt="GUI" src="https://github.com/user-attachments/assets/4196ddf8-e787-4522-9c67-144f433186f9" />

* **`JPanel` (`mainPanel`):** Kontainer utama penampung seluruh tata letak visual form.
* **`JLabel` (`titleLabel`):** Menampilkan teks judul di bagian atas antarmuka.
* **`JTextField` (`idField`):** Menerima input ID unik (dikunci atau dinonaktifkan saat mode *update*).
* **`JTextField` (`namaField`):** Menerima input nama lengkap.
* **`JTextField` (`tahunField`):** Menerima input tahun lahir.
* **`JComboBox` (`kategoriComboBox`):** Menu pilihan *drop-down* untuk kategori (Siswa, Mahasiswa, Dosen, dll).
* **`JComboBox` (`jenisKelaminComboBox`):** Menu pilihan *drop-down* untuk jenis kelamin (Laki-laki, Perempuan).
* **`JTable` (`peopleTable`):** Menampilkan daftar keseluruhan data secara otomatis dalam format baris dan kolom lengkap dengan nomor urut.
* **`JButton` (`addButton`):** Tombol untuk mengeksekusi penambahan data baru.
* **`JButton` (`updateButton`):** Tombol untuk mengeksekusi perubahan data terpilih.
* **`JButton` (`deleteButton`):** Tombol untuk mengeksekusi penghapusan data terpilih.
* **`JButton` (`cancelButton`):** Tombol untuk membersihkan form dan mereset pilihan.

---

## Dokumentasi

1. **Tambah Data**

   <img width="738" height="496" alt="tambah_data" src="https://github.com/user-attachments/assets/0b8eed97-ca12-430e-8450-452cee541bcb" />

3. **Update Data**

   <img width="736" height="515" alt="update_data" src="https://github.com/user-attachments/assets/f8dfc718-6f7a-452e-a536-8ad2dfa2146f" />

5. **Delete Data**

   <img width="735" height="498" alt="delete_data" src="https://github.com/user-attachments/assets/74d750f7-4852-4865-a1ca-f8b11c440f7e" />


