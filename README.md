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
  * `String id` —> Identitas unik data.
  * `String nama` —> Nama lengkap.
  * `String tahunLahir` —> Tahun kelahiran.
  * `String kategori` —> Status/kategori (Siswa, Mahasiswa, Dosen, dll).
  * `String jenisKelamin` —> Pilihan jenis kelamin.
* **Method:** Constructor, serta *Getter* dan *Setter* untuk masing-masing atribut.

### 2. Class `PeopleMenu` extends `JFrame`
Berfungsi untuk menjadikan class tersebut sebagai jendela aplikasi desktop yang menampung seluruh komponen antarmuka grafis sekaligus mengatur logika programnya.
* **Fungsi Utama:**
  * `insertData()` —> Menambahkan data baru ke dalam list.
  * `updateData()` –> Memperbarui data objek yang sedang dipilih pada indeks tabel.
  * `deleteData()` –> Menghapus data dari list setelah konfirmasi.
  * `clearForm()` –> Mengosongkan input form, mereset pilihan ComboBox, dan mengaktifkan kembali field ID.
  * `setTable()` –> Mengatur struktur kolom dan memperbarui isi baris tabel secara dinamis berdasarkan data list.

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
* **`JButton` (`updateButton`):** Tombol untuk mengeksekusi perubahan data.
* **`JButton` (`deleteButton`):** Tombol untuk mengeksekusi penghapusan data.
* **`JButton` (`cancelButton`):** Tombol untuk membersihkan form dan mereset pilihan.

---

## Alur Program 

**1. Tampilan Utama**
Tampilan utama aplikasi berupa jendela desktop (PeopleMenu) yang menyajikan formulir input data diri serta tabel ringkasan. Komponen yang tersedia meliputi:

- ID: Kolom teks (JTextField) untuk mengisikan kode unik atau nomor identitas pengguna.

- Nama: Kolom teks (JTextField) untuk mengisikan nama lengkap.

- Tahun Lahir: Kolom teks (JTextField) untuk mengisikan tahun kelahiran.

- Kategori: Menu pilihan berlipat (dropdown / JComboBox) untuk menentukan status seperti Siswa, Mahasiswa, atau Dosen.

- Jenis Kelamin: Menu pilihan berlipat (dropdown / JComboBox) untuk memilih jenis kelamin (Laki-laki / Perempuan).

- Tombol Aksi: Terdiri dari 4 tombol operasional utama (Add, Update, Delete, dan Cancel).

- Tabel Data: Terletak di bagian bawah form untuk menampilkan seluruh daftar orang yang tersimpan di memori secara otomatis dan terstruktur.

**2. Penambahan Data Baru (Add)**
Pengguna dapat mengisikan seluruh data pada kolom formulir, lalu menekan tombol Add. Program akan memvalidasi kelengkapan isian; jika valid, data dibungkus menjadi objek Person, disimpan ke dalam memori (ArrayList), dan langsung dimunculkan pada tabel.

**3. Perubahan Data (Update)**
Setelah data dari tabel dimuat ke formulir, pengguna dapat memperbarui informasi (seperti Nama, Kategori, atau Jenis Kelamin), lalu menekan tombol Update. Sistem akan memperbarui nilai objek Person terkait di dalam daftar dan menyegarkan tampilan tabel.

**4. Penghapusan Data (Delete)**
Untuk menghapus data, pengguna memilih baris yang diinginkan lalu menekan tombol Delete. Sebelum data benar-benar dihapus dari daftar dan tabel, sistem akan memunculkan dialog konfirmasi (confirmation dialog) untuk memastikan tindakan.

**5. Pembatalan & Reset Form (Cancel)**

Pengguna dapat menekan tombol Cancel kapan saja untuk memanggil method clearForm(). Fitur ini berfungsi mengosongkan seluruh formulir, mengembalikan pilihan dropdown ke status awal, serta mengaktifkan kembali kolom ID untuk siap menerima input data baru.


---

## Dokumentasi

1. **Tambah Data**

   <img width="738" height="496" alt="tambah_data" src="https://github.com/user-attachments/assets/0b8eed97-ca12-430e-8450-452cee541bcb" />

2. **Update Data**

   <img width="736" height="515" alt="update_data" src="https://github.com/user-attachments/assets/f8dfc718-6f7a-452e-a536-8ad2dfa2146f" />

3. **Delete Data**

   <img width="735" height="498" alt="delete_data" src="https://github.com/user-attachments/assets/74d750f7-4852-4865-a1ca-f8b11c440f7e" />

---

