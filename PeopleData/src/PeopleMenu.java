import javax.swing.*; // Mengimpor pustaka Java Swing untuk komponen GUI dasar
import javax.swing.table.DefaultTableModel; // Mengimpor pustaka untuk mengatur model data pada tabel
import java.awt.*;    // Mengimpor pustaka AWT untuk pengaturan warna dan tata letak
import java.awt.event.ActionEvent; // Mengimpor pustaka untuk menangani aksi event komponen
import java.awt.event.ActionListener;     // Mengimpor pustaka antarmuka pendengar aksi tombol
import java.awt.event.MouseAdapter;       // Mengimpor pustaka adaptor mouse untuk interaksi tabel
import java.awt.event.MouseEvent;         // Mengimpor pustaka event klik mouse
import java.util.ArrayList; // Mengimpor pustaka struktur data dinamis ArrayList

public class PeopleMenu extends JFrame {  // Mendeklarasikan kelas PeopleMenu yang mewarisi JFrame
    public JPanel mainPanel;              // Komponen panel utama aplikasi (bawaan IntelliJ)
    private JTextField idField;           // Komponen kotak teks untuk input ID (bawaan IntelliJ)
    private JTextField namaField;         // Komponen kotak teks untuk input Nama (bawaan IntelliJ)
    private JTextField tahunField;        // Komponen kotak teks untuk input Tahun Lahir (bawaan IntelliJ)
    private JComboBox kategoriComboBox;   // Komponen combobox untuk pilihan Kategori (bawaan IntelliJ)
    private JComboBox jenisKelaminComboBox; // Komponen combobox untuk pilihan Jenis Kelamin (bawaan IntelliJ)
    private JButton addButton;            // Tombol khusus untuk Tambah data baru (bawaan IntelliJ)
    private JButton deleteButton;         // Tombol khusus untuk Hapus data (bawaan IntelliJ)
    private JButton cancelButton;         // Tombol untuk Batalkan/Bersihkan form (bawaan IntelliJ)
    private JTable peopleTable;           // Komponen tabel untuk menampilkan data orang (bawaan IntelliJ)
    private JButton updateButton;         // Tombol khusus untuk Ubah data (bawaan IntelliJ)
    private JLabel titleLabel;            // Label teks judul form (bawaan IntelliJ)

    private ArrayList<Person> listPerson; // Deklarasi wadah list untuk menampung objek-objek Person secara dinamis
    private int selectedIndex = -1;       // Menyimpan indeks baris tabel yang dipilih, nilai -1 berarti belum ada baris yang dipilih

    public PeopleMenu() {                 // Konstruktor kelas PeopleMenu yang dijalankan saat pertama kali dipanggil
        listPerson = new ArrayList<>();   // Menginisialisasi pembuatan objek ArrayList baru untuk data
        
        peopleTable.setModel(setTable()); // Mengatur model awal tabel menggunakan pemanggilan method setTable()
        
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f)); // Mengubah gaya huruf judul form jadi tebal ukuran 20f
        
        String[] kategoriData = { "???", "Siswa", "Mahasiswa", "Dosen", "Staff", "Umum" }; // Array string pilihan data kategori
        kategoriComboBox.setModel(new DefaultComboBoxModel<>(kategoriData)); // Memasukkan pilihan array ke dalam ComboBox kategori

        String[] jenisKelaminData = { "???", "Laki-laki", "Perempuan" }; // Array string pilihan data jenis kelamin
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel<>(jenisKelaminData)); // Memasukkan pilihan array ke dalam ComboBox jenis kelamin

        addButton.addActionListener(new ActionListener() { // Menambahkan pendengar aksi ketika tombol add diklik
            @Override
            public void actionPerformed(ActionEvent e) { // Method yang dieksekusi saat tombol add ditekan
                insertData(); // Memanggil method insertData untuk memproses penambahan data
            }
        });

        updateButton.addActionListener(new ActionListener() { // Menambahkan pendengar aksi ketika tombol update diklik
            @Override
            public void actionPerformed(ActionEvent e) { // Method yang dieksekusi saat tombol update ditekan
                if (selectedIndex >= 0) {         // Mengecek apakah ada baris data tabel yang sedang dipilih
                    updateData();                 // Menjalankan method updateData jika baris valid
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Pilih data yang akan di-update terlebih dahulu pada tabel!", "Peringatan", JOptionPane.WARNING_MESSAGE); // Pesan peringatan jika belum memilih baris
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() { // Menambahkan pendengar aksi ketika tombol delete diklik
            @Override
            public void actionPerformed(ActionEvent e) { // Method yang dieksekusi saat tombol delete ditekan
                if (selectedIndex >= 0) {         // Mengecek apakah ada baris data tabel yang sedang dipilih
                    int konfirmasi = JOptionPane.showConfirmDialog( // Memunculkan jendela dialog konfirmasi pilihan Ya/Tidak
                        null,
                        "Apakah Anda yakin ingin menghapus data ini?",
                        "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION
                    );

                    if (konfirmasi == JOptionPane.YES_OPTION) { // Jika pengguna memilih tombol 'Yes'
                        deleteData();             // Memanggil method deleteData untuk menghapus data
                    }
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus terlebih dahulu pada tabel!", "Peringatan", JOptionPane.WARNING_MESSAGE); // Pesan peringatan jika belum memilih baris
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() { // Menambahkan pendengar aksi ketika tombol cancel diklik
            @Override
            public void actionPerformed(ActionEvent e) { // Method yang dieksekusi saat tombol cancel ditekan
                clearForm();                      // Memanggil method clearForm untuk membersihkan formulir
            }
        });

        peopleTable.addMouseListener(new MouseAdapter() { // Menambahkan pendengar aksi mouse pada komponen tabel
            @Override
            public void mousePressed(MouseEvent e) {      // Method yang berjalan saat mouse menekan baris tabel
                selectedIndex = peopleTable.getSelectedRow(); // Mengambil nomor indeks baris tabel yang diklik
                
                String curId = peopleTable.getModel().getValueAt(selectedIndex, 1).toString();     // Mengambil nilai ID dari tabel
                String curNama = peopleTable.getModel().getValueAt(selectedIndex, 2).toString();   // Mengambil nilai Nama dari tabel
                String curTahun = peopleTable.getModel().getValueAt(selectedIndex, 3).toString(); // Mengambil nilai Tahun dari tabel
                String curKategori = peopleTable.getModel().getValueAt(selectedIndex, 4).toString(); // Mengambil nilai Kategori dari tabel
                String curKelamin = peopleTable.getModel().getValueAt(selectedIndex, 5).toString();  // Mengambil nilai Kelamin dari tabel
                
                idField.setText(curId);           // Memasukkan data nilai ID ke dalam text field ID
                namaField.setText(curNama);       // Memasukkan data nilai Nama ke dalam text field Nama
                tahunField.setText(curTahun);     // Memasukkan data nilai Tahun ke dalam text field Tahun
                kategoriComboBox.setSelectedItem(curKategori);     // Menyesuaikan pilihan ComboBox Kategori
                jenisKelaminComboBox.setSelectedItem(curKelamin); // Menyesuaikan pilihan ComboBox Jenis Kelamin
                
                idField.setEnabled(false);        // Menonaktifkan field ID agar tidak dapat diubah saat proses update
            }
        });
    }

    public final DefaultTableModel setTable() {         // Method untuk membuat dan memperbarui struktur model tabel
        Object[] cols = { "No", "ID", "Nama", "Tahun Lahir", "Kategori", "Jenis Kelamin" }; // Menentukan judul kolom tabel
        
        DefaultTableModel tmp = new DefaultTableModel(null, cols); // Membuat objek model tabel baru dengan kolom tersebut
        
        for (int i = 0; i < listPerson.size(); i++) {   // Melakukan perulangan sebanyak data yang tersimpan di dalam listPerson
            Object[] row = {                            // Menyiapkan data baris berdasarkan isi ArrayList
                i + 1,                                  // Nomor urut baris (dimulai dari angka 1)
                listPerson.get(i).getId(),              // Mengambil data atribut ID
                listPerson.get(i).getNama(),            // Mengambil data atribut Nama
                listPerson.get(i).getTahunLahir(),      // Mengambil data atribut Tahun Lahir
                listPerson.get(i).getKategori(),        // Mengambil data atribut Kategori
                listPerson.get(i).getJenisKelamin()     // Mengambil data atribut Jenis Kelamin
            };
            tmp.addRow(row);                            // Menambahkan baris data tersebut ke dalam model tabel
        }
        return tmp;                                     // Mengembalikan model tabel yang sudah terisi data lengkap
    }

    public void insertData() {                          // Method untuk memproses penambahan data baru (Create)
        try {
            String id = idField.getText();              // Mengambil teks yang diketik pengguna pada inputan ID
            String nama = namaField.getText();          // Mengambil teks yang diketik pengguna pada inputan Nama
            String tahunLahir = tahunField.getText();   // Mengambil teks yang diketik pengguna pada inputan Tahun Lahir
            String kategori = kategoriComboBox.getSelectedItem().toString();     // Mengambil pilihan Kategori pada ComboBox
            String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString(); // Mengambil pilihan Jenis Kelamin pada ComboBox
            
            if (id.isEmpty() || nama.isEmpty() || tahunLahir.isEmpty()) {        // Validasi mendasar jika ada kolom teks utama yang kosong
                JOptionPane.showMessageDialog(null, "Semua data harus diisi!", "Error", JOptionPane.ERROR_MESSAGE); // Pesan peringatan error
                return;                                 // Menghentikan eksekusi jika validasi gagal
            }

            listPerson.add(new Person(id, nama, tahunLahir, kategori, jenisKelamin)); // Menambahkan objek Person baru ke ArrayList
            peopleTable.setModel(setTable());           // Memperbarui tampilan data di dalam komponen tabel
            clearForm();                                // Membersihkan formulir inputan setelah berhasil
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan"); // Pesan pop-up sukses penambahan data
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan!", "Error", JOptionPane.ERROR_MESSAGE); // Pesan error tangkapan sistem
        }
    }

    public void updateData() {                          // Method untuk memproses perubahan data yang dipilih (Update)
        try {
            String id = idField.getText();              // Mengambil teks terbaru dari inputan ID
            String nama = namaField.getText();          // Mengambil teks terbaru dari inputan Nama
            String tahunLahir = tahunField.getText();   // Mengambil teks terbaru dari inputan Tahun Lahir
            String kategori = kategoriComboBox.getSelectedItem().toString();     // Mengambil pilihan terbaru ComboBox Kategori
            String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString(); // Mengambil pilihan terbaru ComboBox Jenis Kelamin
            
            listPerson.get(selectedIndex).setId(id);              // Memperbarui atribut ID pada objek di dalam list
            listPerson.get(selectedIndex).setNama(nama);          // Memperbarui atribut Nama pada objek di dalam list
            listPerson.get(selectedIndex).setTahunLahir(tahunLahir); // Memperbarui atribut Tahun Lahir pada objek di dalam list
            listPerson.get(selectedIndex).setKategori(kategori);    // Memperbarui atribut Kategori pada objek di dalam list
            listPerson.get(selectedIndex).setJenisKelamin(jenisKelamin); // Memperbarui atribut Jenis Kelamin pada objek di dalam list
            
            peopleTable.setModel(setTable());           // Memperbarui tampilan data di dalam tabel
            clearForm();                                // Membersihkan formulir inputan setelah update selesai
            JOptionPane.showMessageDialog(null, "Data berhasil diubah"); // Pesan pop-up sukses perubahan data
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengubah data!", "Error", JOptionPane.ERROR_MESSAGE); // Pesan error sistem
        }
    }

    public void deleteData() {                          // Method untuk memproses penghapusan data (Delete)
        listPerson.remove(selectedIndex);               // Menghapus objek data dari ArrayList berdasarkan indeks baris terpilih
        peopleTable.setModel(setTable());               // Memperbarui tampilan data di dalam tabel setelah penghapusan
        clearForm();                                    // Membersihkan formulir inputan
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus"); // Pesan pop-up sukses penghapusan data
    }

    public void clearForm() {                           // Method untuk mengosongkan dan mereset seluruh formulir input
        idField.setText("");                            // Mengosongkan kotak teks ID
        namaField.setText("");                          // Mengosongkan kotak teks Nama
        tahunField.setText("");                         // Mengosongkan kotak teks Tahun Lahir
        kategoriComboBox.setSelectedIndex(0);           // Mengembalikan pilihan ComboBox Kategori ke indeks awal ("???")
        jenisKelaminComboBox.setSelectedIndex(0);       // Mengembalikan pilihan ComboBox Jenis Kelamin ke indeks awal ("???")
        idField.setEnabled(true);                       // Mengaktifkan kembali field ID agar bisa diisi untuk data baru
        selectedIndex = -1;                             // Mereset variabel indeks pilihan tabel kembali ke nilai -1
    }

    public static void main(String[] args) {            // Method utama untuk menjalankan keseluruhan program aplikasi GUI
        PeopleMenu menu = new PeopleMenu();             // Membuat instance objek jendela aplikasi PeopleMenu baru
        menu.setSize(750, 650);                         // Mengatur ukuran dimensi lebar dan tinggi jendela frame
        menu.setLocationRelativeTo(null);               // Mengatur posisi jendela agar muncul di tengah layar monitor
        menu.setContentPane(menu.mainPanel);            // Menetapkan panel utama (mainPanel) sebagai konten layout utama frame
        menu.getContentPane().setBackground(Color.WHITE); // Mengatur warna latar belakang jendela menjadi putih bersih
        menu.setVisible(true);                          // Mengatur agar jendela aplikasi tampak dan dapat dilihat pengguna
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Mengatur agar program berhenti total saat tombol silang (X) ditekan
    }
}
