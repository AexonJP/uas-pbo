import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class menuAdmin{
	menuAdmin(int nomors){
		JFrame formAdmin = new JFrame("menu admin");
		formAdmin.setSize(600,700);
		formAdmin.setLocation(100,150);
		formAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formAdmin.setLocationRelativeTo(null);
		formAdmin.setLayout(null);
        formAdmin.setBackground(Color.black);
        formAdmin.setResizable(false);

        

		JButton kulkas = new JButton("Daftar Kulkas");
		kulkas.setMargin( new Insets(5, 5, 5, 5) );
        kulkas.setBounds(0,0,220,25);
        kulkas.setFont(new Font("Dialog", Font.BOLD, 12));
        //add button to the frame
        formAdmin.add(kulkas);
        kulkas.setVisible(false);

        JLabel labelKulkas = new JLabel("Daftar Kulkas");
        labelKulkas.setBounds(0,0,220,25);
        labelKulkas.setHorizontalAlignment(JLabel.CENTER);
        labelKulkas.setFont(new Font("Dialog", Font.BOLD, 12));
        //add button to the frame
        formAdmin.add(labelKulkas);
        labelKulkas.setVisible(true);

        JButton tambah = new JButton("Tambah");
        tambah.setMargin( new Insets(5, 5, 5, 5) );
        tambah.setBounds(500,0,70,25);
        tambah.setFont(new Font("Dialog", Font.PLAIN, 10));
        //add button to the frame
        formAdmin.add(tambah);
        tambah.setVisible(true);

        JLabel labelTambah = new JLabel("Tambah");
        // labelTambah.setMargin( new Insets(5, 5, 5, 5) );
        labelTambah.setBounds(500,0,70,25);
        labelTambah.setHorizontalAlignment(JLabel.CENTER);
        labelTambah.setFont(new Font("Dialog", Font.PLAIN, 10));
        //add button to the frame
        formAdmin.add(labelTambah);
        labelTambah.setVisible(false);

        // JButton rincian = new JButton("rincian");
        // rincian.setMargin( new Insets(5, 5, 5, 5) );
        // rincian.setBounds(140,0,70,25);
        // rincian.setFont(new Font("Dialog", Font.PLAIN, 10));
        // //add button to the frame
        // formAdmin.add(rincian);
        // rincian.setVisible(true);
    	
    	formAdmin.setVisible(true);

        JPanel panelKulkasAdmin = new JPanel();
        panelKulkasAdmin.setBounds(0,25,600,675);
        panelKulkasAdmin.setBackground(Color.black);
        panelKulkasAdmin.setLayout(null);


        ArrayList<varKulkas> dataKulkas = new ArrayList<varKulkas>();


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
                    "SELECT * FROM kulkas");
            Integer code;
            String title;
            Float harga;
            Integer pintu;
            String merek;
            String gambar;


            while (resultSet.next()) {
                code = resultSet.getInt("id");
                title = resultSet.getString("nama").trim();
                harga = resultSet.getFloat("harga");
                pintu  = resultSet.getInt("pintu");
                merek = resultSet.getString("merek").trim();
                gambar = resultSet.getString("gambar").trim();
                varKulkas okk = new varKulkas(code,title,harga,pintu,merek,gambar);
                // okk();
                // if(nomors)
                dataKulkas.add(okk);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

        
        
        int banyak = dataKulkas.size();

        JButton[] detail = new JButton[banyak];
        JLabel[] isi = new JLabel[]{
            new JLabel("Rank"),
            new JLabel("Nama Kulkas"),
            new JLabel("Harga Kulkas"),
            new JLabel("Detail")
        };
        int x[] = new int[]{0,103,366,469};
        int panjang[] = new int[]{100,260,100,100};
        // int y[] = new int[]{0}

        JPanel[] panel = new JPanel[banyak];
        JLabel[] judulKulkas = new JLabel[banyak];
        JLabel[] hargaKulkas = new JLabel[banyak];
        JLabel[] rank = new JLabel[banyak];
        int[][] warna = new int[][]{
            {18,18,18},
            {24,24,24}
        };

        // JLabel[]

        // JLabel[] episodeKulkas = new JLabel[banyak];
        // JLabel[] genreKulkas = new JLabel[banyak];
        // JLabel[] studioKulkas = new JLabel[banyak];
        // JLabel[] hariKulkas = new JLabel[banyak];
        // JLabel[] sinopsisKulkas = new JLabel[banyak];
        

        JButton[] navigasi = new JButton[]{
            new JButton("<<"),
            new JButton("<"),
            new JButton(">"),
            new JButton(">>")
        };
        
        // JLabel nomor_halaman = new JLabel();

        int[] navigasiku = new int[]
            {1,-1,1,((banyak-1)/9)+1};


        for(int i =0;i<4;i++){
            isi[i].setBounds(x[i]+3,3,panjang[i],60);
            isi[i].setOpaque(true);
            isi[i].setBackground(new Color(51,51,51));
            isi[i].setForeground(Color.white);
            isi[i].setVisible(true);
            isi[i].setHorizontalAlignment(JLabel.CENTER);
            panelKulkasAdmin.add(isi[i]);
        }

        for(int i =0;i<banyak;i++){
            panel[i] = new JPanel();
            judulKulkas[i] = new JLabel(dataKulkas.get(i).judul);
            hargaKulkas[i] = new JLabel("" + dataKulkas.get(i).harga);
            rank[i] = new JLabel(""+(i+1));
            // episodeKulkas[i]= new JLabel("Episode : " + dataKulkas.get(i).episode);
            // genreKulkas[i] = new JLabel("Genre : "+ dataKulkas.get(i).genre);
            // studioKulkas[i] = new JLabel("Studio : "+ dataKulkas.get(i).studio);
            // hariKulkas[i] = new JLabel("Hari : "+ dataKulkas.get(i).hari);
            // sinopsisKulkas[i] = new JLabel("Sinopsis : "+ dataKulkas.get(i).sinopsis);
            detail[i] = new JButton("detail");
        }
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        for (int i =0;i<banyak;i++){
            final int final_i = dataKulkas.get(i).id;

            panel[i].setBounds(3,66+((i*53)%(477)),600,50);
            panel[i].setBackground(Color.black);
            // panel[i].setCursor(cursor);


            rank[i].setBounds(x[0],0,panjang[0],60);
            rank[i].setOpaque(true);
            rank[i].setHorizontalAlignment(JLabel.CENTER);
            rank[i].setBackground(new Color(warna[i%2][0],warna[i%2][1],warna[i%2][2]));
            detail[i].setFont(new Font("Dialog", Font.PLAIN, 20));
            rank[i].setForeground(new Color(163,163,163));
            rank[i].setVisible(false);


            detail[i].setBounds(x[3],0,panjang[3],60);
            detail[i].setForeground(Color.white);
            detail[i].setVisible(false);
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
                new rincianKulkasAdmin(final_i);
                formAdmin.dispose();
              }});

            judulKulkas[i].setBounds(x[1],0,panjang[1],60);
            judulKulkas[i].setOpaque(true);
            judulKulkas[i].setHorizontalAlignment(JLabel.CENTER);
            judulKulkas[i].setBackground(new Color(warna[i%2][0],warna[i%2][1],warna[i%2][2]));
            judulKulkas[i].setForeground(new Color(171,196,237));
            judulKulkas[i].setVisible(false);
            
            hargaKulkas[i].setBounds(x[2],0,panjang[2],60);
            hargaKulkas[i].setOpaque(true);
            hargaKulkas[i].setHorizontalAlignment(JLabel.CENTER);
            hargaKulkas[i].setBackground(new Color(warna[i%2][0],warna[i%2][1],warna[i%2][2]));
            hargaKulkas[i].setForeground(new Color(163,163,163));
            hargaKulkas[i].setVisible(false);

            // episodeKulkas[i].setBounds(220,30,180,20);
            // // episodeKulkas[i].setForeground(Color.white);
            // episodeKulkas[i].setVisible(true);

            // genreKulkas[i].setBounds(340,30,180,20);
            // // genreKulkas[i].setForeground(Color.white);
            // genreKulkas[i].setVisible(true);

            // panel[i].add(rank[i]);
            // panel[i].add(judulKulkas[i]);
            // panel[i].add(hargaKulkas[i]);
            // // panel[i].add(episodeKulkas[i]);
            // // panel[i].add(genreKulkas[i]);
            // panel[i].add(detail[i]);
            // panel[i].setLayout(null);
            // panelKulkasAdmin.add(panel[i]);
        }

        for (int i =0;i<banyak;i++){
            if((nomors-1)*9<=i){
                rank[i].setVisible(true);

                detail[i].setVisible(true);
                
                judulKulkas[i].setVisible(true);
                
                
                hargaKulkas[i].setVisible(true);
                panel[i].add(rank[i]);
                panel[i].add(judulKulkas[i]);
                panel[i].add(hargaKulkas[i]);
                // panel[i].add(episodeKulkas[i]);
                // panel[i].add(genreKulkas[i]);
                panel[i].add(detail[i]);
                panel[i].setLayout(null);
                panelKulkasAdmin.add(panel[i]);
            }
            

        }

        for(int i =0;i<4;i++){
            navigasi[i].setBounds(((150*i)+60),600,20,20);
            navigasi[i].setOpaque(false);
            navigasi[i].setMargin( new Insets(1, 1, 1, 1) );
            navigasi[i].setForeground(Color.white);
            navigasi[i].setBorder(null);
            navigasi[i].setBorderPainted(false);
            navigasi[i].setContentAreaFilled(false);
            navigasi[i].setOpaque(false);
            navigasi[i].setCursor(cursor);
            navigasi[i].setVisible(true);
            
            // navigasi[i].addActionListener(new ActionListener() {
            //     @Override
            //     public void actionPerformed(ActionEvent e) {
            //         //your actions
            //         // panel_tambah.setVisible(true);
            //          //or .remove(previousPanel);

            //         // panel_kulkas.setVisible(false);

            //         new menuAdmin(nomors=nomor+navigasiku[i]);
            //         // kulkas.setVisible(true);
            //         // labelKulkas.setVisible(false);
            //         // labelTambah.setVisible(true);
            //         // tambah.setVisible(false); 

            //         // f.setVisible(false);

            //     }

            // });
            // panelKulkasAdmin.add(navigasi[i]);
        }


        navigasi[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int navigasi0 = nomors;
                //your actions
                // panel_tambah.setVisible(true);
                 //or .remove(previousPanel);

                // panel_kulkas.setVisible(false);

                new menuAdmin(navigasiku[0]);
                formAdmin.dispose();
                // kulkas.setVisible(true);
                // labelKulkas.setVisible(false);
                // labelTambah.setVisible(true);
                // tambah.setVisible(false); 

                // f.setVisible(false);

            }

        });
        panelKulkasAdmin.add(navigasi[0]);


        navigasi[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int navigasi1 = nomors;
                //your actions
                // panel_tambah.setVisible(true);
                 //or .remove(previousPanel);

                // panel_kulkas.setVisible(false);
                if(nomors>1){
                    new menuAdmin(navigasi1+navigasiku[1]);
                }
                else{
                    new menuAdmin(1);
                }
                formAdmin.dispose();
                // kulkas.setVisible(true);
                // labelKulkas.setVisible(false);
                // labelTambah.setVisible(true);
                // tambah.setVisible(false); 

                // f.setVisible(false);

            }

        });
        panelKulkasAdmin.add(navigasi[1]);


        navigasi[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int navigasi2 = nomors;
                //your actions
                // panel_tambah.setVisible(true);
                 //or .remove(previousPanel);

                // panel_kulkas.setVisible(false);
                if(nomors<navigasiku[3]){
                    new menuAdmin(navigasi2+navigasiku[2]);
                }
                else{
                    new menuAdmin(navigasiku[3]);
                }
                formAdmin.dispose();
                // new menuAdmin(navigasi2+navigasiku[2]);
                // kulkas.setVisible(true);
                // labelKulkas.setVisible(false);
                // labelTambah.setVisible(true);
                // tambah.setVisible(false); 

                // f.setVisible(false);

            }

        });
        panelKulkasAdmin.add(navigasi[2]);


        navigasi[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int navigasi3 = nomors;
                //your actions
                // panel_tambah.setVisible(true);
                 //or .remove(previousPanel);

                // panel_kulkas.setVisible(false);

                new menuAdmin(navigasiku[3]);
                formAdmin.dispose();
                // kulkas.setVisible(true);
                // labelKulkas.setVisible(false);
                // labelTambah.setVisible(true);
                // tambah.setVisible(false); 

                // f.setVisible(false);

            }

        });
        panelKulkasAdmin.add(navigasi[3]);
    

        formAdmin.add(panelKulkasAdmin);

        kulkas.setVisible(false);
        labelKulkas.setVisible(true);
        labelTambah.setVisible(false);
        tambah.setVisible(true); 
        

    	// JPanel panel_tambah = new panelTambah();
    	// formAdmin.add(panel_tambah);
        // panel_tambah.setVisible(false);

        // JPanel f = new rincianKulkas();
        // formAdmin.add(f);
        // f.setVisible(false);

    	tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
            	// panel_tambah.setVisible(true);
                 //or .remove(previousPanel);

            	// panel_kulkas.setVisible(false);
                new menuAdminTambah();
                formAdmin.dispose();
                // kulkas.setVisible(true);
                // labelKulkas.setVisible(false);
                // labelTambah.setVisible(true);
                // tambah.setVisible(false); 

                // f.setVisible(false);

            }

        });

        // rincian.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         //your actions
        //         t.setVisible(false);
        //         g.setVisible(false);
        //         f.setVisible(true);
        //         kulkas.setVisible(true);
        //         labelKulkas.setVisible(false);
        //         labelTambah.setVisible(false);
        //         tambah.setVisible(true);
        //     }

        // });

        // kulkas.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         //your actions
        //     	// panel_kulkas.setVisible(true);
        //         // formAdmin.getContentPane().remove(panel_kulkas);
        //         formAdmin.getContentPane().remove(panel_kulkas);
        //         JPanel panel_kulkas = new panelKulkasAdmin();
        //         formAdmin.add(panel_kulkas);
        //         // panel_kulkas.buildPanel(); // panel needs a builder method
        //         formAdmin.revalidate(); // in- and validate in one !! 
        //         formAdmin.pack();

        //     	panel_tambah.setVisible(false);
        //         kulkas.setVisible(false);
        //         labelKulkas.setVisible(true);

        //         labelTambah.setVisible(false);
        //         tambah.setVisible(true);
                
        //         // f.setVisible(false);
                
        //     }

        // });
        JLabel nomor_halaman = new JLabel(Integer.toString(nomors));
        // navigasi[i].setBounds(((150*i)+60),600,20,20);
        nomor_halaman.setBounds(300,600,20,20);
        // nomor_halaman.setHorizontalAlignment(JLabel.CENTER);
        nomor_halaman.setForeground(Color.white);
        nomor_halaman.setFont(new Font("Dialog", Font.BOLD, 12));
        //add button to the frame
        panelKulkasAdmin.add(nomor_halaman);
        nomor_halaman.setVisible(true);
    }

	
}