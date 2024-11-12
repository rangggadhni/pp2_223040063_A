import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerpustakaanApp extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public PerpustakaanApp() {
        setTitle("Aplikasi Perpustakaan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menambahkan menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuItem1 = new JMenuItem("Form Buku");
        JMenuItem menuItem2 = new JMenuItem("Keluar");

        menuItem1.addActionListener(e -> showFormBuku());
        menuItem2.addActionListener(e -> System.exit(0));

        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Tabel untuk menampilkan data
        String[] columnNames = {"ID Buku", "Judul", "Penulis", "Penerbit", "Status", "Kategori", "Genre", "Tahun Terbit", "Jumlah Halaman"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void showFormBuku() {
        JDialog formDialog = new JDialog(this, "Form Buku", true);
        formDialog.setSize(400, 400);
        formDialog.setLayout(new GridLayout(10, 2));

        // Komponen Form
        formDialog.add(new JLabel("ID Buku:"));
        JTextField idField = new JTextField();
        formDialog.add(idField);

        formDialog.add(new JLabel("Judul:"));
        JTextField judulField = new JTextField();
        formDialog.add(judulField);

        formDialog.add(new JLabel("Penulis:"));
        JTextField penulisField = new JTextField();
        formDialog.add(penulisField);

        formDialog.add(new JLabel("Penerbit:"));
        JTextField penerbitField = new JTextField();
        formDialog.add(penerbitField);

        formDialog.add(new JLabel("Status:"));
        JRadioButton baruButton = new JRadioButton("Baru");
        JRadioButton lamaButton = new JRadioButton("Lama");
        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(baruButton);
        statusGroup.add(lamaButton);
        JPanel statusPanel = new JPanel();
        statusPanel.add(baruButton);
        statusPanel.add(lamaButton);
        formDialog.add(statusPanel);

        formDialog.add(new JLabel("Kategori:"));
        JCheckBox fiksiBox = new JCheckBox("Fiksi");
        JCheckBox nonfiksiBox = new JCheckBox("Nonfiksi");
        JPanel kategoriPanel = new JPanel();
        kategoriPanel.add(fiksiBox);
        kategoriPanel.add(nonfiksiBox);
        formDialog.add(kategoriPanel);

        formDialog.add(new JLabel("Genre:"));
        JComboBox<String> genreCombo = new JComboBox<>(new String[]{"Novel", "Biografi", "Sejarah", "Romansa", "Pendidikan", "Horor", "Agama"});
        formDialog.add(genreCombo);

        // Menambahkan JSlider untuk Tahun Terbit
        formDialog.add(new JLabel("Tahun Terbit:"));
        JSlider tahunSlider = new JSlider(1900, 2024, 2023); // range tahun
        tahunSlider.setMajorTickSpacing(25);
        tahunSlider.setMinorTickSpacing(5);
        tahunSlider.setPaintTicks(true);
        tahunSlider.setPaintLabels(true);
        formDialog.add(tahunSlider);

        // Menambahkan JSpinner untuk Jumlah Halaman
        formDialog.add(new JLabel("Jumlah Halaman:"));
        JSpinner halamanSpinner = new JSpinner(new SpinnerNumberModel(100, 10, 2000, 10)); // default 100, min 10, max 2000
        formDialog.add(halamanSpinner);

        JButton addButton = new JButton("Tambah");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menambah data ke tabel
                String id = idField.getText();
                String judul = judulField.getText();
                String penulis = penulisField.getText();
                String penerbit = penerbitField.getText();
                String status = baruButton.isSelected() ? "Baru" : "Lama";
                String kategori = (fiksiBox.isSelected() ? "Fiksi " : "") + (nonfiksiBox.isSelected() ? "Nonfiksi" : "");
                String genre = (String) genreCombo.getSelectedItem();
                int tahunTerbit = tahunSlider.getValue();  // Nilai dari JSlider
                int jumlahHalaman = (int) halamanSpinner.getValue();  // Nilai dari JSpinner

                // Menambahkan data ke tabel
                tableModel.addRow(new Object[]{id, judul, penulis, penerbit, status, kategori, genre, tahunTerbit, jumlahHalaman});
                formDialog.dispose();
            }
        });
        formDialog.add(addButton);

        formDialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PerpustakaanApp().setVisible(true));
    }
}
