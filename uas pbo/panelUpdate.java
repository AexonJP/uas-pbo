import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;
// import javax.swing.JTextArea.setLineWrap;

class panelUpdate extends JPanel{
	Integer code;
    String titles;
    Float hargas;
    Integer pintus;
    String mereks;
    String gambars;
	panelUpdate(int id){
		setBounds(0,25,600,675);
		setBackground(new Color(18,18,18));
		setLayout(null);

		JLabel label1 = new JLabel("Nama Kulkas");
		label1.setBounds(10,0,180,25);
		label1.setForeground(Color.white);
		add(label1);
		label1.setVisible(true);

		JLabel labelgenre =new JLabel("Merek Kulkas");
		labelgenre.setBounds(300,0,180,25); //20
		labelgenre.setForeground(Color.white);
		add(labelgenre);
		labelgenre.setVisible(true);

		JLabel labelfile =new JLabel("FILE PATH");
		labelfile.setBounds(303,200,180,25); //20
		labelfile.setForeground(Color.white);
		add(labelfile);
		labelfile.setVisible(true);

		

		Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kulkas",
                    "root", "");

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "SELECT * FROM kulkas WHERE `id` ="+id);
            // Integer code;
            // String title;
            // Float harga;
            // Integer pintu;
            // String merek;
            // String gambar;


            while (resultSet.next()) {
                code = resultSet.getInt("id");
                titles = resultSet.getString("nama").trim();
                hargas = resultSet.getFloat("harga");
                pintus  = resultSet.getInt("pintu");
                mereks = resultSet.getString("merek").trim();
                // studio = resultSet.getString("studio").trim();
                // merek = resultSet.getString("merek").trim();
                // sinopsis = resultSet.getString("sinopsis").trim();
                gambars = resultSet.getString("gambar").trim();
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

		

		String [] merek = {"Toshiba", "Panasonic", "Sharp", "Samsung", "Polytron", "Haier", "Aqua"};
		JComboBox cbmerek = new JComboBox<>(merek);
		cbmerek.setBounds(300,95,180,25);
		add(cbmerek);
		cbmerek.setVisible(true);

		JButton btfile= new JButton("PATH FILE");
        btfile.setMargin( new Insets(5, 5, 5, 5) );
        btfile.setBounds(300,160,100,20);
        btfile.setFont(new Font("Dialog", Font.PLAIN, 11 ));
        //add button to the frame
        add(btfile);
        btfile.setVisible(true);



		JTextField tfJudul = new JTextField(20){
	      @Override 
	      protected void paintComponent(Graphics g) {
	        if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
	          Graphics2D g2 = (Graphics2D) g.create();
	          g2.setPaint(getBackground());
	          g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
	              0, 0, getWidth() - 1, getHeight() - 1));
	          g2.dispose();
	        }
	        super.paintComponent(g);
	      }
	      
	      @Override
	    public void updateUI() {
	        super.updateUI();
	        setOpaque(false);
	        setBorder(new RoundedCornerBorder());
	      }
	    };
		tfJudul.setBounds(5,30,200,25);
		add(tfJudul);
		tfJudul.setVisible(true);

		JLabel labelPintu = new JLabel("Banyak Pintu");
		labelPintu.setBounds(10,65,180,25);
		labelPintu.setForeground(Color.white);
		add(labelPintu);
		labelPintu.setVisible(true);

		JRadioButton rb1=new JRadioButton("1");
		rb1.setBounds(5,95,60,25);
		add(rb1);
		rb1.setVisible(true);

		JRadioButton rb2=new JRadioButton("2");
		rb2.setBounds(65,95,60,25);
		add(rb2);
		rb2.setVisible(true);

		ButtonGroup bg=new ButtonGroup();    
		bg.add(rb1);bg.add(rb2);

		JLabel labelHarga = new JLabel("Harga Kulkas");
		labelHarga.setBounds(10,130,180,25);// 10
		labelHarga.setForeground(Color.white);
		add(labelHarga);
		labelHarga.setVisible(true);

		JTextField tfHarga = new JTextField(20){
	      @Override 
	      protected void paintComponent(Graphics g) {
	        if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
	          Graphics2D g2 = (Graphics2D) g.create();
	          g2.setPaint(getBackground());
	          g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
	              0, 0, getWidth() - 1, getHeight() - 1));
	          g2.dispose();
	        }
	        super.paintComponent(g);
	      }
	      
	      @Override
	    public void updateUI() {
	        super.updateUI();
	        setOpaque(false);
	        setBorder(new RoundedCornerBorder());
	      }
	    };
		tfHarga.setBounds(5,160,200,25);// 10
		add(tfHarga);
		tfHarga.setVisible(true);

		tfJudul.setText(titles);
    	int obes =0;
    	int obes1 = 0;
    	for(String oks : merek){
    			if (mereks.equals(oks)){

    				obes = obes1;

    			}
    			// System.out.println(oks);
    			obes1++;
    		}
    	cbmerek.setSelectedIndex(obes);
    	tfHarga.setText(String.valueOf(hargas));
    	labelfile.setText(gambars);



		JButton btTambah= new JButton("ubah");
        btTambah.setMargin( new Insets(5, 5, 5, 5) );
        btTambah.setBounds(270,595,60,20);
        btTambah.setFont(new Font("Dialog", Font.PLAIN, 11 ));
        //add button to the frame
        add(btTambah);
        btTambah.setVisible(true);


        btfile.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e){
        		JFileChooser pilihfile = new JFileChooser();
        		int returnValue = pilihfile.showOpenDialog(null);
        		if(returnValue == JFileChooser.APPROVE_OPTION){
        			File pathfile = pilihfile.getSelectedFile();
        			labelfile.setText(pathfile.getAbsolutePath());
        		}
        	}
        });

        btTambah.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e){
        		try{
        			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/kulkas", "root", "");
        			String sql = "UPDATE `kulkas` SET `merek`=?,`nama`=?,`pintu`=?,`harga`=?,`gambar`=? WHERE `id` = '"+id+"'";
        			PreparedStatement preparedStmt = conn.prepareStatement(sql);
						preparedStmt.setString(1, cbmerek.getSelectedItem().toString());
						preparedStmt.setString(2, tfJudul.getText());
						if (rb1.isSelected()){
							preparedStmt.setInt(3, 1);
						}
						else if(rb2.isSelected()){
							preparedStmt.setInt(3, 2);
						}
						preparedStmt.setFloat(4, Float.parseFloat(tfHarga.getText()));
						preparedStmt.setString(5, labelfile.getText());
						int masukan_row = preparedStmt.executeUpdate();

        			if(masukan_row > 0){
        				JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!!!");
        				tfJudul.setText("");
			        	tfHarga.setText("");
			        	cbmerek.setSelectedIndex(-1);
			        	labelfile.setText("OPEN FILE");
        			}

        			conn.close();
        		}catch(SQLException ex){
        			JOptionPane.showMessageDialog(null, "Data gak bisa masuk!!! terjadi error:" + ex.getMessage());
        		}
        	}

        });

	}

	
}