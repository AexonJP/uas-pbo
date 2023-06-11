import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.ArrayList;

public class panelAnime extends	JPanel{
	panelAnime(){
		setBounds(0,25,600,675);
		setBackground(Color.black);
		setLayout(null);


		ArrayList<varAnime> dataAnime = new ArrayList<varAnime>();

        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/anime",
                    "root", "");

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "SELECT * FROM animes");
            Integer code;
            String title;
            Float rating;
            Integer episode;
            String genre;
            String studio;
            String hari;
            String sinopsis;
            String gambar;


            while (resultSet.next()) {
                code = resultSet.getInt("id");
                title = resultSet.getString("judul").trim();
                rating = resultSet.getFloat("rating");
                episode  = resultSet.getInt("episode");
                genre = resultSet.getString("genre").trim();
                studio = resultSet.getString("studio").trim();
                hari = resultSet.getString("hari").trim();
                sinopsis = resultSet.getString("sinopsis").trim();
                gambar = resultSet.getString("gambar").trim();
                varAnime okk = new varAnime(code,title,rating,episode,genre,studio,hari,sinopsis,gambar);
                // okk();
                dataAnime.add(okk);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

        
	    
		int banyak = dataAnime.size();

		JButton[] detail = new JButton[banyak];
		JLabel[] isi = new JLabel[]{
			new JLabel("Rank"),
			new	JLabel("Title"),
			new JLabel("Rating"),
			new JLabel("Detail")
		};
		int x[] = new int[]{0,103,366,469};
		int panjang[] = new int[]{100,260,100,100};
		// int y[] = new int[]{0}

		JPanel[] panel = new JPanel[banyak];
		JLabel[] judulAnime = new JLabel[banyak];
		JLabel[] ratingAnime = new JLabel[banyak];
		JLabel[] rank = new JLabel[banyak];
		int[][] warna = new int[][]{
			{18,18,18},
			{24,24,24}
		};

		// JLabel[]

		// JLabel[] episodeAnime = new JLabel[banyak];
		// JLabel[] genreAnime = new JLabel[banyak];
		// JLabel[] studioAnime = new JLabel[banyak];
		// JLabel[] hariAnime = new JLabel[banyak];
		// JLabel[] sinopsisAnime = new JLabel[banyak];
		

		JLabel[] navigasi = new JLabel[]{
			new JLabel("<<"),
			new JLabel("<"),
			new JLabel(">"),
			new JLabel(">>")
		};

		for(int i =0;i<4;i++){
			isi[i].setBounds(x[i]+3,3,panjang[i],60);
			isi[i].setOpaque(true);
			isi[i].setBackground(new Color(51,51,51));
			isi[i].setForeground(Color.white);
			isi[i].setVisible(true);
			isi[i].setHorizontalAlignment(JLabel.CENTER);
			add(isi[i]);
		}

		for(int i =0;i<banyak;i++){
			panel[i] = new JPanel();
			judulAnime[i] = new JLabel(dataAnime.get(i).judul);
			ratingAnime[i] = new JLabel("Rating : " + dataAnime.get(i).rating);
			rank[i] = new JLabel(""+(i+1));
			// episodeAnime[i]= new JLabel("Episode : " + dataAnime.get(i).episode);
			// genreAnime[i] = new JLabel("Genre : "+ dataAnime.get(i).genre);
			// studioAnime[i] = new JLabel("Studio : "+ dataAnime.get(i).studio);
			// hariAnime[i] = new JLabel("Hari : "+ dataAnime.get(i).hari);
			// sinopsisAnime[i] = new JLabel("Sinopsis : "+ dataAnime.get(i).sinopsis);
			detail[i] = new JButton("detail");
		}

		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		for (int i =0;i<banyak;i++){
			final int final_i = dataAnime.get(i).id;

			panel[i].setBounds(3,66+((i*53)%540),600,50);
			panel[i].setBackground(Color.black);
			// panel[i].setCursor(cursor);


			rank[i].setBounds(x[0],0,panjang[0],60);
			rank[i].setOpaque(true);
			rank[i].setHorizontalAlignment(JLabel.CENTER);
			rank[i].setBackground(new Color(warna[i%2][0],warna[i%2][1],warna[i%2][2]));
			detail[i].setFont(new Font("Dialog", Font.PLAIN, 20));
			rank[i].setForeground(new Color(163,163,163));
			rank[i].setVisible(true);


			detail[i].setBounds(x[3],0,panjang[3],60);
			detail[i].setForeground(Color.white);
			detail[i].setVisible(true);
			detail[i].setHorizontalAlignment(JLabel.CENTER);
			detail[i].setBackground(new Color(warna[i%2][0],warna[i%2][1],warna[i%2][2]));
			detail[i].setMargin( new Insets(2, 2, 2, 2) );
			detail[i].setFont(new Font("Dialog", Font.PLAIN, 12));
			detail[i].setCursor(cursor);
			detail[i].addActionListener(new ActionListener() {
              // @Override

              public void actionPerformed(ActionEvent e) {
                  //your actions
                    // setVisible(false);
              	new rincianAnime(final_i);
              }});

			judulAnime[i].setBounds(x[1],0,panjang[1],60);
			judulAnime[i].setOpaque(true);
			judulAnime[i].setHorizontalAlignment(JLabel.CENTER);
			judulAnime[i].setBackground(new Color(warna[i%2][0],warna[i%2][1],warna[i%2][2]));
			judulAnime[i].setForeground(new Color(171,196,237));
			judulAnime[i].setVisible(true);
			
			ratingAnime[i].setBounds(x[2],0,panjang[2],60);
			ratingAnime[i].setOpaque(true);
			ratingAnime[i].setHorizontalAlignment(JLabel.CENTER);
			ratingAnime[i].setBackground(new Color(warna[i%2][0],warna[i%2][1],warna[i%2][2]));
			ratingAnime[i].setForeground(new Color(163,163,163));
			ratingAnime[i].setVisible(true);

			// episodeAnime[i].setBounds(220,30,180,20);
			// // episodeAnime[i].setForeground(Color.white);
			// episodeAnime[i].setVisible(true);

			// genreAnime[i].setBounds(340,30,180,20);
			// // genreAnime[i].setForeground(Color.white);
			// genreAnime[i].setVisible(true);

			panel[i].add(rank[i]);
			panel[i].add(judulAnime[i]);
			panel[i].add(ratingAnime[i]);
			// panel[i].add(episodeAnime[i]);
			// panel[i].add(genreAnime[i]);
			panel[i].add(detail[i]);
			panel[i].setLayout(null);
			add(panel[i]);
		}
		for(int i =0;i<4;i++){
			navigasi[i].setBounds(((150*i)+60),600,20,20);
			navigasi[i].setForeground(Color.white);
			navigasi[i].setCursor(cursor);
			navigasi[i].setVisible(true);
			add(navigasi[i]);
		}
	}
}