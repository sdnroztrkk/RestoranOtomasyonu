package PROJE3;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class proje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField kulad;
	private JPasswordField passwordField;
	private JTable table_1;
	private JTextField masadurum1;
	private JTextField masadurum2;
	private JTable table;
	private JTable table_2;
	private JTable table_3;
	

	/**
	 * Launch the application.
	 */
	public void masaGoster() {
		try {
	        Connection connection = Baglan.bagkur();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM MASALAR");
	        
	        DefaultTableModel model2 = new DefaultTableModel();

	        // Sütun başlıklarını ekle (opsiyonel)
	        ResultSetMetaData metaData = resultSet.getMetaData();
	        int columnCount = metaData.getColumnCount();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            if (!metaData.getColumnLabel(columnIndex).equals("id")) {
	                model2.addColumn(metaData.getColumnLabel(columnIndex));
	            }
	        }

	        // Verileri tablo modeline ekle
	        while (resultSet.next()) {
	            Object[] rowData = new Object[columnCount - 1];
	            int index = 0;
	            for (int i = 1; i <= columnCount; i++) {
	                if (!metaData.getColumnLabel(i).equals("id")) {
	                    rowData[index++] = resultSet.getObject(i);
	                }
	            }
	            model2.addRow(rowData);
	        }

	        table_3.setModel(model2); // Tabloya modeli set et
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	public void kasaGoster() {
		try {
	        Connection connection = Baglan.bagkur();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM KASA");
	        
	        DefaultTableModel model1 = new DefaultTableModel();

	        // Sütun başlıklarını ekle (opsiyonel)
	        ResultSetMetaData metaData = resultSet.getMetaData();
	        int columnCount = metaData.getColumnCount();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            if (!metaData.getColumnLabel(columnIndex).equals("id")) {
	                model1.addColumn(metaData.getColumnLabel(columnIndex));
	            }
	        }

	        // Verileri tablo modeline ekle
	        while (resultSet.next()) {
	            Object[] rowData = new Object[columnCount - 1];
	            int index = 0;
	            for (int i = 1; i <= columnCount; i++) {
	                if (!metaData.getColumnLabel(i).equals("id")) {
	                    rowData[index++] = resultSet.getObject(i);
	                }
	            }
	            model1.addRow(rowData);
	        }

	        table_2.setModel(model1); // Tabloya modeli set et
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
		
	
	public void siparisleriGoster() {
	    try {
	        Connection connection = Baglan.bagkur();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM SİPARİSLAR");
	        
	        DefaultTableModel model = new DefaultTableModel();

	        // Sütun başlıklarını ekle (opsiyonel)
	        ResultSetMetaData metaData = resultSet.getMetaData();
	        int columnCount = metaData.getColumnCount();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            if (!metaData.getColumnLabel(columnIndex).equals("id")) {
	                model.addColumn(metaData.getColumnLabel(columnIndex));
	            }
	        }

	        // Verileri tablo modeline ekle
	        while (resultSet.next()) {
	            Object[] rowData = new Object[columnCount - 1];
	            int index = 0;
	            for (int i = 1; i <= columnCount; i++) {
	                if (!metaData.getColumnLabel(i).equals("id")) {
	                    rowData[index++] = resultSet.getObject(i);
	                }
	            }
	            model.addRow(rowData);
	        }

	        table_1.setModel(model); // Tabloya modeli set et
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proje frame = new proje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public proje() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 803, 463);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("GİRİŞ", null, panel, null);
		panel.setLayout(null);
		
		JButton giris = new JButton("GİRİŞ YAP");
		giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String kullaniciAdi = kulad.getText();
		        String sifre = new String(passwordField.getPassword());

		        if (kullaniciAdi.equals("TUSUZE") && sifre.equals("1234")) {
		            tabbedPane.setSelectedIndex(1); 
		        } else {
		            JOptionPane.showMessageDialog(null, "Hatalı kullanıcı adı veya şifre!");
		            kulad.setText("");
		            passwordField.setText("");
		        }
			}
			
			
		});
		giris.setBackground(new Color(153, 204, 153));
		giris.setFont(new Font("Tahoma", Font.BOLD, 15));
		giris.setBounds(437, 299, 136, 49);
		panel.add(giris);
		
		JLabel lblNewLabel_1 = new JLabel("KULLANICI ADI:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(326, 122, 136, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ŞİFRE:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(326, 161, 96, 59);
		panel.add(lblNewLabel_2);
		
		kulad = new JTextField();
		kulad.setBounds(483, 118, 182, 33);
		panel.add(kulad);
		kulad.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(483, 176, 182, 33);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sude Nur Öztürk\\Desktop\\proje\\user-icon-6.jpg"));
		lblNewLabel.setBounds(47, 82, 247, 264);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("YÖNETİM", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Sude Nur Öztürk\\Desktop\\proje\\yeyo.jpg"));
		lblNewLabel_3.setBounds(466, 41, 295, 273);
		panel_1.add(lblNewLabel_3);
		
		JButton anacıkısbtn = new JButton("ÇIKIŞ YAP");
		anacıkısbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cevap = JOptionPane.showConfirmDialog(null, "Çıkış yapmak istediğinize emin misiniz?", "Çıkış Onayı", JOptionPane.YES_NO_OPTION);

		        // Eğer kullanıcı "Evet"i seçerse
		        if (cevap == JOptionPane.YES_OPTION) {
		            // Paneli kapat
		            dispose();
		        } else if (cevap == JOptionPane.NO_OPTION) {
		            // Eğer kullanıcı "Hayır"ı seçerse, Giriş paneline geri dön
		            tabbedPane.setSelectedIndex(0); // 0, Giriş panelinin index'i
		        }
			
			}
		});
		anacıkısbtn.setBackground(new Color(204, 153, 153));
		anacıkısbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		anacıkısbtn.setBounds(544, 338, 150, 46);
		panel_1.add(anacıkısbtn);
		
		JButton anamenubtn = new JButton("MENÜ");
		anamenubtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		anamenubtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		anamenubtn.setBounds(68, 87, 134, 127);
		panel_1.add(anamenubtn);
		
		JButton anamasabtn = new JButton("MASALAR");
		anamasabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				masaGoster();
				tabbedPane.setSelectedIndex(3);
			}
		});
		anamasabtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		anamasabtn.setBounds(253, 87, 134, 127);
		panel_1.add(anamasabtn);
		
		JButton anasiparisbtn = new JButton("SİPARİŞLER");
		anasiparisbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siparisleriGoster(); // Siparişleri gösteren metodu çağır
				tabbedPane.setSelectedIndex(4);
			}
		});
		anasiparisbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		anasiparisbtn.setBounds(68, 250, 134, 127);
		panel_1.add(anasiparisbtn);
		
		JButton anakasabtn = new JButton("KASA");
		anakasabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaGoster(); 
				tabbedPane.setSelectedIndex(5);
			}
		});
		anakasabtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		anakasabtn.setBounds(253, 250, 134, 127);
		panel_1.add(anakasabtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("MENÜ", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Sude Nur Öztürk\\Downloads\\png-transparent-simit-bagel-bakery-pogača-borek-bagel-baked-goods-food-cheese-thumbnail-removebg-preview.png"));
		lblNewLabel_5.setBounds(267, 87, 95, 78);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Sude Nur Öztürk\\Downloads\\png-transparent-hamburger-hot-dog-cheeseburger-fast-food-hamburger-hamburger-food-cheeseburger-american-food-removebg-preview.png"));
		lblNewLabel_6.setBounds(279, 153, 148, 128);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Sude Nur Öztürk\\Downloads\\png-transparent-chicago-style-pizza-italian-cuisine-vegetarian-cuisine-neapolitan-pizza-piz-removebg-preview (2).png"));
		lblNewLabel_7.setBounds(267, 271, 95, 78);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("KAÇINCI MASA?");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(210, 374, 152, 35);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\Sude Nur Öztürk\\Downloads\\WhatsApp_Görsel_2023-12-22_saat_14.53.24_82485634-removebg-preview.png"));
		lblNewLabel_10.setBounds(631, 75, 110, 103);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\Sude Nur Öztürk\\Downloads\\WhatsApp_Görsel_2023-12-22_saat_14.56.05_5aeec999-removebg-preview.png"));
		lblNewLabel_11.setBounds(668, 192, 61, 71);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\Sude Nur Öztürk\\Downloads\\WhatsApp_Görsel_2023-12-22_saat_15.00.26_1c757ff4-removebg-preview (1) (1).png"));
		lblNewLabel_12.setBounds(631, 257, 110, 103);
		panel_2.add(lblNewLabel_12);
		
		JComboBox comboBoxmasa = new JComboBox();
		comboBoxmasa.setBackground(new Color(255, 255, 204));
		comboBoxmasa.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxmasa.setModel(new DefaultComboBoxModel(new String[] {"Masa1", "Masa2", "Masa3", "Masa4", "Masa5"}));
		comboBoxmasa.setBounds(390, 376, 95, 35);
		panel_2.add(comboBoxmasa);
		
		JButton simitbtn = new JButton("SİMİT 25TL");
		simitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String MasaAdi = (String) comboBoxmasa.getSelectedItem();
			        String YemekAdi = "SİMİT"; // Örnek olarak "SİMİT" olarak ayarlanmıştır, gerçek duruma göre değiştirin

			        // Siparişi almak için SiparisAl sınıfını kullan
			        SiparisAl siparisAl = new SiparisAl();
			        siparisAl.Siparis(MasaAdi, YemekAdi);
			        
			        // İlgili işlemleri yapabilirsiniz, örneğin sipariş onay mesajı göstermek
			        JOptionPane.showMessageDialog(null, "Sipariş alındı!");

			}
		});
		simitbtn.setBackground(new Color(153, 204, 153));
		simitbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		simitbtn.setBounds(79, 100, 138, 49);
		panel_2.add(simitbtn);
		
		JButton hamburbtn = new JButton("HAMBURGER 100TL ");
		hamburbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MasaAdi = (String) comboBoxmasa.getSelectedItem();
		        String YemekAdi = "HAMBURGER"; 

		        // Siparişi almak için SiparisAl sınıfını kullan
		        SiparisAl siparisAl = new SiparisAl();
		        siparisAl.Siparis(MasaAdi, YemekAdi);
		        
		        // İlgili işlemleri yapabilirsiniz, örneğin sipariş onay mesajı göstermek
		        JOptionPane.showMessageDialog(null, "Sipariş alındı!");
			}
		});
		hamburbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		hamburbtn.setBackground(new Color(153, 204, 153));
		hamburbtn.setBounds(79, 192, 192, 63);
		panel_2.add(hamburbtn);
		
		JButton pizzbtn = new JButton("PİZZA 150TL");
		pizzbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MasaAdi = (String) comboBoxmasa.getSelectedItem();
		        String YemekAdi = "PİZZA"; // Örnek olarak "SİMİT" olarak ayarlanmıştır, gerçek duruma göre değiştirin

		        // Siparişi almak için SiparisAl sınıfını kullan
		        SiparisAl siparisAl = new SiparisAl();
		        siparisAl.Siparis(MasaAdi, YemekAdi);
		        
		        // İlgili işlemleri yapabilirsiniz, örneğin sipariş onay mesajı göstermek
		        JOptionPane.showMessageDialog(null, "Sipariş alındı!");
			}
		});
		pizzbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		pizzbtn.setBackground(new Color(153, 204, 153));
		pizzbtn.setBounds(79, 281, 138, 49);
		panel_2.add(pizzbtn);
		
		JButton caybtn = new JButton("ÇAY 20TL");
		caybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MasaAdi = (String) comboBoxmasa.getSelectedItem();
		        String YemekAdi = "ÇAY"; // Örnek olarak "SİMİT" olarak ayarlanmıştır, gerçek duruma göre değiştirin

		        // Siparişi almak için SiparisAl sınıfını kullan
		        SiparisAl siparisAl = new SiparisAl();
		        siparisAl.Siparis(MasaAdi, YemekAdi);
		        
		        // İlgili işlemleri yapabilirsiniz, örneğin sipariş onay mesajı göstermek
		        JOptionPane.showMessageDialog(null, "Sipariş alındı!");
			}
		});
		caybtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		caybtn.setBackground(new Color(153, 204, 153));
		caybtn.setBounds(468, 102, 138, 49);
		panel_2.add(caybtn);
		
		JButton subtn = new JButton("SU 10TL");
		subtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MasaAdi = (String) comboBoxmasa.getSelectedItem();
		        String YemekAdi = "SU"; // Örnek olarak "SİMİT" olarak ayarlanmıştır, gerçek duruma göre değiştirin

		        // Siparişi almak için SiparisAl sınıfını kullan
		        SiparisAl siparisAl = new SiparisAl();
		        siparisAl.Siparis(MasaAdi, YemekAdi);
		        
		        // İlgili işlemleri yapabilirsiniz, örneğin sipariş onay mesajı göstermek
		        JOptionPane.showMessageDialog(null, "Sipariş alındı!");
			}
		});
		subtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		subtn.setBackground(new Color(153, 204, 153));
		subtn.setBounds(468, 192, 138, 49);
		panel_2.add(subtn);
		
		JButton ayranbtn = new JButton("AYRAN 15TL");
		ayranbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MasaAdi = (String) comboBoxmasa.getSelectedItem();
		        String YemekAdi = "AYRAN"; // Örnek olarak "SİMİT" olarak ayarlanmıştır, gerçek duruma göre değiştirin

		        // Siparişi almak için SiparisAl sınıfını kullan
		        SiparisAl siparisAl = new SiparisAl();
		        siparisAl.Siparis(MasaAdi, YemekAdi);
		        
		        // İlgili işlemleri yapabilirsiniz, örneğin sipariş onay mesajı göstermek
		        JOptionPane.showMessageDialog(null, "Sipariş alındı!");
			}
		});
		ayranbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		ayranbtn.setBackground(new Color(153, 204, 153));
		ayranbtn.setBounds(468, 281, 138, 49);
		panel_2.add(ayranbtn);
		
		JButton btnNewButton = new JButton("GERİ DÖN");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(204, 51, 51));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				
			}
		});
		btnNewButton.setBounds(551, 376, 120, 33);
		panel_2.add(btnNewButton);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("MASALAR", null, panel_3, null);
		panel_3.setLayout(null);
		
		table_3 = new JTable();
		
		JScrollPane scrollPane_2 = new JScrollPane(table_3);
		scrollPane_2.setBounds(319, 73, 313, 273);
		panel_3.add(scrollPane_2);
		
		
		
		
		JButton btnNewButton_1 = new JButton("GERİ DÖN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(204, 51, 51));
		btnNewButton_1.setBounds(608, 376, 120, 33);
		panel_3.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Sude Nur Öztürk\\Desktop\\proje\\masa (1).jpg"));
		lblNewLabel_4.setBounds(24, 73, 268, 273);
		panel_3.add(lblNewLabel_4);
		
		JButton btnNewButton_5 = new JButton("GÜNCELLE");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				masaGoster(); 
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.setBounds(426, 376, 132, 29);
		panel_3.add(btnNewButton_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("SİPARİŞLER", null, panel_4, null);
		
		
		
		JButton btnNewButton_2 = new JButton("GÜNCELLE");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 siparisleriGoster(); // Siparişleri gösteren metodu çağır
				tabbedPane.setSelectedIndex(4); // Siparişler sekmesine geç
			        
			    }
			
		});
		panel_4.add(btnNewButton_2);
		
		table_1 = new JTable();
		JScrollPane scrollPane = new JScrollPane(table_1);
		panel_4.add(scrollPane);
		
		JButton btnNewButton_4 = new JButton("GERİ DÖN");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.setBackground(new Color(204, 51, 51));
		panel_4.add(btnNewButton_4);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("KASA", null, panel_5, null);
		panel_5.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masa1", "Masa2", "Masa3", "Masa4", "Masa5"}));
		comboBox.setBounds(88, 301, 135, 38);
		panel_5.add(comboBox);
		
		JButton btnNewButton_3 = new JButton("ÖDEME AL");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MasaAdi = (String) comboBox.getSelectedItem();
				SiparisYonetim odes =new SiparisYonetim();
				odes.getPaid(MasaAdi);
				 kasaGoster(); 
					tabbedPane.setSelectedIndex(5);
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(88, 349, 135, 27);
		panel_5.add(btnNewButton_3);
		
		table_2 = new JTable();
		
		JScrollPane scrollPane_1 = new JScrollPane(table_2);
		scrollPane_1.setBounds(317, 10, 362, 387);
		panel_5.add(scrollPane_1);
		
		JButton btnNewButton_4_1 = new JButton("GERİ DÖN");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4_1.setBackground(new Color(204, 51, 51));
		btnNewButton_4_1.setBounds(88, 386, 123, 27);
		panel_5.add(btnNewButton_4_1);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Sude Nur Öztürk\\Desktop\\proje\\pos.png"));
		lblNewLabel_9.setBounds(63, 10, 214, 250);
		panel_5.add(lblNewLabel_9);
		
		
		
		
		
	}

}
