import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormBiodata extends JFrame {
	
	public FormBiodata() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Form Biodata");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
		
		JLabel judulLabel = new JLabel("Form Biodata");
		judulLabel.setFont(new Font("ARIAL", Font.BOLD, 16));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		panel.add(judulLabel, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel labelNama = new JLabel("Nama");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		panel.add(labelNama, gbc);
		
		JTextField textNama = new JTextField(10);
		gbc.ipady = 10;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		panel.add(textNama, gbc);
		
		JLabel labelHp = new JLabel("Nomor HP");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 20;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		panel.add(labelHp, gbc);
		
		JTextField textHp = new JTextField(10);
		gbc.ipady = 10;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		panel.add(textHp, gbc);
		
		JLabel labelJk = new JLabel("Jenis Kelamin");
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		panel.add(labelJk, gbc);
		
		JRadioButton radioJk1 = new JRadioButton("Laki-laki", true);
		JRadioButton radioJk2 = new JRadioButton("Perempuan");
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioJk1);
		bg.add(radioJk2);
		
		JPanel genderPanel1 = new JPanel();
		genderPanel1.add(radioJk1);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		panel.add(genderPanel1, gbc);
		
		JPanel genderPanel2 = new JPanel();
		genderPanel2.add(radioJk2);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		panel.add(genderPanel2, gbc);
		
		JCheckBox wnCheck = new JCheckBox("Warga Negara Asing");
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		panel.add(wnCheck, gbc);
		
		JButton button = new JButton("Simpan");
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		panel.add(button, gbc);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nama = textNama.getText();
				String hp = textHp.getText();
				String jenisKelamin = radioJk1.isSelected() ? "Laki-laki" : "Perempuan";
				String wna = wnCheck.isSelected() ? "Ya" : "Tidak";
				
				JOptionPane.showMessageDialog(null, "Nama: " + nama + "\nNomor Hp: " + hp
						+ "\nJenis Kelamin: " + jenisKelamin + "\nWNA: " + wna, "Data Biodata"
						, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.add(panel);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormBiodata b = new FormBiodata();
				b.setVisible(true);
			}
		});
	}
}