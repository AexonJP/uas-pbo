import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class menuUser{
    menuUser(int nomors){
        JFrame formUser = new JFrame("menu user");
        formUser.setSize(600,700);
        formUser.setLocation(100,150);
        formUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formUser.setLocationRelativeTo(null);
        formUser.setLayout(null);
        formUser.setBackground(Color.black);
        formUser.setResizable(false);

        JTextField tfCari = new JTextField(20){
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
        tfCari.setBounds(230,0,200,25);
        formUser.add(tfCari);
        tfCari.setVisible(true);

        JButton cari = new JButton("Cari");
        cari.setMargin( new Insets(5, 5, 5, 5) );
        cari.setBounds(435,0,50,25);
        cari.setFont(new Font("Dialog", Font.BOLD, 12));
        //add button to the frame
        formUser.add(cari);
        cari.setVisible(true);

        cari.addActionListener(new ActionListener() {
              // @Override

              public void actionPerformed(ActionEvent e) {
                  //your actions
                    // setVisible(false);
                menuUser login = new menuUser(1, tfCari.getText());
                formUser.dispose();
              }
          });



        JButton kulkas = new JButton("Daftar Kulkas");
        kulkas.setMargin( new Insets(5, 5, 5, 5) );
        kulkas.setBounds(0,0,220,25);
        kulkas.setFont(new Font("Dialog", Font.BOLD, 12));
        //add button to the frame
        formUser.add(kulkas);
        kulkas.setVisible(false);

        JLabel labelKulkas = new JLabel("Daftar Kulkas");
        labelKulkas.setBounds(0,0,220,25);
        labelKulkas.setHorizontalAlignment(JLabel.CENTER);
        labelKulkas.setFont(new Font("Dialog", Font.BOLD, 12));
        //add button to the frame
        formUser.add(labelKulkas);
        labelKulkas.setVisible(true);

        
        formUser.setVisible(true);

        JPanel panelKulkasUser = new JPanel();
        panelKulkasUser.setBounds(0,25,600,675);
        panelKulkasUser.setBackground(Color.black);
        panelKulkasUser.setLayout(null);


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
            new JLabel("Title"),
            new JLabel("harga"),
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
            panelKulkasUser.add(isi[i]);
        }

        for(int i =0;i<banyak;i++){
            panel[i] = new JPanel();
            judulKulkas[i] = new JLabel(dataKulkas.get(i).judul);
            hargaKulkas[i] = new JLabel(""+dataKulkas.get(i).harga);
            rank[i] = new JLabel(""+(i+1));
            detail[i] = new JButton("detail");
        }
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        for (int i =0;i<banyak;i++){
            final int final_i = dataKulkas.get(i).id;
            final int final_nomor = nomors;

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
                new rincianKulkasUser(final_i,final_nomor);
                formUser.dispose();
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
                panel[i].add(detail[i]);
                panel[i].setLayout(null);
                panelKulkasUser.add(panel[i]);
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
            
        }


        navigasi[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int navigasi0 = nomors;
                new menuUser(navigasiku[0]);
                formUser.dispose();
            }

        });
        panelKulkasUser.add(navigasi[0]);


        navigasi[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int navigasi1 = nomors;
                //your actions
                // panel_tambah.setVisible(true);
                 //or .remove(previousPanel);

                // panel_kulkas.setVisible(false);
                if(nomors>1){
                    new menuUser(navigasi1+navigasiku[1]);
                }
                else{
                    new menuUser(1);
                }
                formUser.dispose();
            }

        });
        panelKulkasUser.add(navigasi[1]);


        navigasi[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int navigasi2 = nomors;
                if(nomors<navigasiku[3]){
                    new menuUser(navigasi2+navigasiku[2]);
                }
                else{
                    new menuUser(navigasiku[3]);
                }
                formUser.dispose();
            }

        });
        panelKulkasUser.add(navigasi[2]);


        navigasi[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int navigasi3 = nomors;
                new menuUser(navigasiku[3]);
                formUser.dispose();
            }

        });
        panelKulkasUser.add(navigasi[3]);
    

        formUser.add(panelKulkasUser);

        kulkas.setVisible(false);
        labelKulkas.setVisible(true);
        

        // });
        JLabel nomor_halaman = new JLabel(Integer.toString(nomors));
        // navigasi[i].setBounds(((150*i)+60),600,20,20);
        nomor_halaman.setBounds(295,600,20,20);
        // nomor_halaman.setHorizontalAlignment(JLabel.CENTER);
        nomor_halaman.setForeground(Color.white);
        nomor_halaman.setFont(new Font("Dialog", Font.BOLD, 12));
        //add button to the frame
        panelKulkasUser.add(nomor_halaman);
        nomor_halaman.setVisible(true);
    }

    menuUser(int nomors, String dicari){
        JFrame formUser = new JFrame("menu user");
        formUser.setSize(600,700);
        formUser.setLocation(100,150);
        formUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formUser.setLocationRelativeTo(null);
        formUser.setLayout(null);
        formUser.setBackground(Color.black);
        formUser.setResizable(false);

        JTextField tfCari = new JTextField(20){
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
        tfCari.setBounds(230,0,200,25);
        formUser.add(tfCari);
        tfCari.setVisible(true);

        JButton cari = new JButton("Cari");
        cari.setMargin( new Insets(5, 5, 5, 5) );
        cari.setBounds(435,0,50,25);
        cari.setFont(new Font("Dialog", Font.BOLD, 12));
        //add button to the frame
        formUser.add(cari);
        cari.setVisible(true);

        cari.addActionListener(new ActionListener() {
              // @Override

              public void actionPerformed(ActionEvent e) {
                  //your actions
                    // setVisible(false);
                menuUser login = new menuUser(1, tfCari.getText());
                formUser.dispose();
              }
          });

        JButton kulkas = new JButton("Daftar Kulkas");
        kulkas.setMargin( new Insets(5, 5, 5, 5) );
        kulkas.setBounds(0,0,220,25);
        kulkas.setFont(new Font("Dialog", Font.BOLD, 12));
        //add button to the frame
        formUser.add(kulkas);
        kulkas.setVisible(false);

        JLabel labelKulkas = new JLabel("Daftar Kulkas");
        labelKulkas.setBounds(0,0,220,25);
        labelKulkas.setHorizontalAlignment(JLabel.CENTER);
        labelKulkas.setFont(new Font("Dialog", Font.BOLD, 12));
        //add button to the frame
        formUser.add(labelKulkas);
        labelKulkas.setVisible(true);

        
        formUser.setVisible(true);

        JPanel panelKulkasUser = new JPanel();
        panelKulkasUser.setBounds(0,25,600,675);
        panelKulkasUser.setBackground(Color.black);
        panelKulkasUser.setLayout(null);


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
                    "SELECT * FROM `kulkas` WHERE `nama` LIKE '%"+dicari+"%'");
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
            new JLabel("Title"),
            new JLabel("harga"),
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
            panelKulkasUser.add(isi[i]);
        }

        for(int i =0;i<banyak;i++){
            panel[i] = new JPanel();
            judulKulkas[i] = new JLabel(dataKulkas.get(i).judul);
            hargaKulkas[i] = new JLabel(""+dataKulkas.get(i).harga);
            rank[i] = new JLabel(""+(i+1));
            detail[i] = new JButton("detail");
        }
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        for (int i =0;i<banyak;i++){
            final int final_i = dataKulkas.get(i).id;
            final int final_nomor = nomors;

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
                new rincianKulkasUser(final_i,final_nomor);
                formUser.dispose();
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
                panel[i].add(detail[i]);
                panel[i].setLayout(null);
                panelKulkasUser.add(panel[i]);
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
            
        }


        navigasi[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int navigasi0 = nomors;
                new menuUser(navigasiku[0]);
                formUser.dispose();
            }

        });
        panelKulkasUser.add(navigasi[0]);


        navigasi[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int navigasi1 = nomors;
                //your actions
                // panel_tambah.setVisible(true);
                 //or .remove(previousPanel);

                // panel_kulkas.setVisible(false);
                if(nomors>1){
                    new menuUser(navigasi1+navigasiku[1]);
                }
                else{
                    new menuUser(1);
                }
                formUser.dispose();
            }

        });
        panelKulkasUser.add(navigasi[1]);


        navigasi[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int navigasi2 = nomors;
                if(nomors<navigasiku[3]){
                    new menuUser(navigasi2+navigasiku[2]);
                }
                else{
                    new menuUser(navigasiku[3]);
                }
                formUser.dispose();
            }

        });
        panelKulkasUser.add(navigasi[2]);


        navigasi[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int navigasi3 = nomors;
                new menuUser(navigasiku[3]);
                formUser.dispose();
            }

        });
        panelKulkasUser.add(navigasi[3]);
    

        formUser.add(panelKulkasUser);

        kulkas.setVisible(false);
        labelKulkas.setVisible(true);
        

        // });
        JLabel nomor_halaman = new JLabel(Integer.toString(nomors));
        // navigasi[i].setBounds(((150*i)+60),600,20,20);
        nomor_halaman.setBounds(295,600,20,20);
        // nomor_halaman.setHorizontalAlignment(JLabel.CENTER);
        nomor_halaman.setForeground(Color.white);
        nomor_halaman.setFont(new Font("Dialog", Font.BOLD, 12));
        //add button to the frame
        panelKulkasUser.add(nomor_halaman);
        nomor_halaman.setVisible(true);
    }


    
}