import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import javax.swing.JFileChooser.*;
import java.awt.event.*;
import java.sql.*;

public class rincianKulkasUser{
	Integer code;
    String titles;
    Float hargas;
    Integer pintus;
    String mereks;
    String gambars;

	rincianKulkasUser(Integer id, Integer nomors){
		

		JFrame formKulkas = new JFrame("rincian Kulkas");
        formKulkas.setSize(600,700);
        formKulkas.setLocation(700,150);
        // formKulkas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formKulkas.setLocationRelativeTo(null);
        formKulkas.setLayout(null);
        formKulkas.setResizable(false);
        
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
		// JLabel[] judulKulkas = new JLabel[banyak];
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

	    JLabel labelPintu = new JLabel("Bayak Pintu : "+pintus);
	    labelPintu.setBounds(30,430,180,25);
	    labelPintu.setVisible(true);
	    labelPintu.setForeground(Color.black);


	    formKulkas.add(labelMerek);
	    formKulkas.add(labelPintu);
	    formKulkas.add(labelHarga);
		formKulkas.add(judulKulkas);
		// add(sipnosis);
		formKulkas.add(gambar);
		formKulkas.setVisible(true);

        JButton btClose= new JButton("Close");
        btClose.setMargin( new Insets(5, 5, 5, 5) );
        btClose.setBounds(280,595,60,20);
        btClose.setFont(new Font("Dialog", Font.PLAIN, 11 ));
        //add button to the frame
        formKulkas.add(btClose);
        btClose.setVisible(true);

        btClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	new menuUser(nomors);
            	formKulkas.dispose();
            }
        });
	}

	

	// public void show(){

	// }
}