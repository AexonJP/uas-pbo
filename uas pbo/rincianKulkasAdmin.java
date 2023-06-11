import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import javax.swing.JFileChooser.*;
import java.awt.event.*;
import java.sql.*;

public class rincianKulkasAdmin{
	Integer code;
    String titles;
    Float hargas;
    Integer pintus;
    String mereks;
    String gambars;

	rincianKulkasAdmin(Integer id){
		

		JFrame formKulkas = new JFrame("rincian anime");
        formKulkas.setSize(600,700);
        formKulkas.setLocation(700,150);
        // formKulkas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formKulkas.setLocationRelativeTo(null);
        formKulkas.setLayout(null);
        formKulkas.setResizable(false);

        // Integer ids;
        // String juduls;
        // Float ratings;
        // Integer episodes;
        // String genres;
        // String studios;
        // String haris;
        // String sinopsiss;
        // String gambars;
        
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
                // hari = resultSet.getString("hari").trim();
                // sinopsis = resultSet.getString("sinopsis").trim();
                gambars = resultSet.getString("gambar").trim();
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }


		// int banyak =10;
		// JPanel[] panel = new JPanel[banyak];
		// JLabel[] judulAnime = new JLabel[banyak];
		// JLabel[] rating = new JLabel[banyak];
		// JLabel[] episode = new JLabel[banyak];
		// JLabel[] genre = new JLabel[banyak];

		JLabel judulKulkas = new JLabel(titles);
		judulKulkas.setBounds(20,5,300,30);
		judulKulkas.setVisible(true);


		tampilGambar gambar = new tampilGambar();
		gambar.setBounds(10,35,200,300);
		gambar.atur(gambars,gambar.getWidth(),gambar.getHeight());
		gambar.setVisible(true);


	    JLabel labelHarga = new JLabel("Harga : "+hargas);
	    labelHarga.setBounds(30,350,180,25);
	    labelHarga.setVisible(true);
	    labelHarga.setForeground(Color.black);

	    JLabel labelMerek = new JLabel("Merek : "+mereks);
	    labelMerek.setBounds(30,390,180,25);
	    labelMerek.setVisible(true);
	    labelMerek.setForeground(Color.black);

	    JLabel labelPintu = new JLabel("banyak Pintu : "+pintus);
	    labelPintu.setBounds(30,430,180,25);
	    labelPintu.setVisible(true);
	    labelPintu.setForeground(Color.black);

	    formKulkas.add(labelMerek);
	    formKulkas.add(labelPintu);
	    formKulkas.add(labelHarga);
		formKulkas.add(judulKulkas);
		formKulkas.add(gambar);
		formKulkas.setVisible(true);

		JButton btUbah= new JButton("Ubah");
        btUbah.setMargin( new Insets(5, 5, 5, 5) );
        btUbah.setBounds(250,595,60,20);
        btUbah.setFont(new Font("Dialog", Font.PLAIN, 11 ));
        //add button to the frame
        formKulkas.add(btUbah);
        btUbah.setVisible(true);

        JButton btHapus= new JButton("Hapus");
        btHapus.setMargin( new Insets(5, 5, 5, 5) );
        btHapus.setBounds(170,595,60,20);
        btHapus.setFont(new Font("Dialog", Font.PLAIN, 11 ));
        //add button to the frame
        formKulkas.add(btHapus);
        btHapus.setVisible(true);

        JButton btClose= new JButton("Close");
        btClose.setMargin( new Insets(5, 5, 5, 5) );
        btClose.setBounds(330,595,60,20);
        btClose.setFont(new Font("Dialog", Font.PLAIN, 11 ));
        //add button to the frame
        formKulkas.add(btClose);
        btClose.setVisible(true);

        btClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	new menuAdmin(1);
            	formKulkas.dispose();
            }
        });

        btUbah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

        	
		        new menuUpdate(id);
		        formKulkas.dispose();
            	// try{
        		// 	Class.forName("com.mysql.cj.jdbc.Driver");
		        //     connection = DriverManager.getConnection(
                //     "jdbc:mysql://localhost:3306/anime",
                //     "root", "");
        		// 	Statement statement;
		        //     statement = connection.createStatement();
		        //     ResultSet resultSet;
		        //     resultSet = statement.executeQuery(
                //     "DELETE FROM `animes` WHERE `id` = "+ids);

        		// 	connection.close();
        		// }catch(SQLException ex){
        		// 	JOptionPane.showMessageDialog(null, "Data gak bisa masuk!!! terjadi error:" + ex.getMessage());
        		// }
                // //your actions
            	// t.setVisible(true);
            	// g.setVisible(false);
                // anime.setVisible(true);
                // labelAnime.setVisible(false);
                // labelTambah.setVisible(true);
                // tambah.setVisible(false);

                // // f.setVisible(false);

            }

        });


        btHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

	            PreparedStatement stmt = connection.prepareStatement("DELETE FROM `kulkas` WHERE `id` = "+id);
	            // resultSet = statement.executeUpdate(
	            //         "DELETE FROM `animes` WHERE `id` = "+id);
	            // // connection.close();
	            // statement.close();
	            stmt.executeUpdate();
	            connection.close();
		        } catch (Exception exception) {
		            System.out.println(exception);
		        }
		        new menuAdmin(1);
		        formKulkas.dispose();
            	// try{
        		// 	Class.forName("com.mysql.cj.jdbc.Driver");
		        //     connection = DriverManager.getConnection(
                //     "jdbc:mysql://localhost:3306/anime",
                //     "root", "");
        		// 	Statement statement;
		        //     statement = connection.createStatement();
		        //     ResultSet resultSet;
		        //     resultSet = statement.executeQuery(
                //     "DELETE FROM `animes` WHERE `id` = "+ids);

        		// 	connection.close();
        		// }catch(SQLException ex){
        		// 	JOptionPane.showMessageDialog(null, "Data gak bisa masuk!!! terjadi error:" + ex.getMessage());
        		// }
                // //your actions
            	// t.setVisible(true);
            	// g.setVisible(false);
                // anime.setVisible(true);
                // labelAnime.setVisible(false);
                // labelTambah.setVisible(true);
                // tambah.setVisible(false);

                // // f.setVisible(false);

            }

        });

        // btHapus.addActionListener(new ActionListener(){
        	// @Override
        	// public void actionPerformed(ActionEvent e){
        		
        	// }

        // });
	}

	

	// public void show(){

	// }
}