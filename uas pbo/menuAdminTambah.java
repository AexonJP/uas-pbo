import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class menuAdminTambah{
	menuAdminTambah(){
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
        formAdmin.add(kulkas);
        kulkas.setVisible(true);
        kulkas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
                // panel_tambah.setVisible(true);
                 //or .remove(previousPanel);

                // panel_kulkas.setVisible(false);
                new menuAdmin(1);
                formAdmin.dispose();
                // kulkas.setVisible(true);
                // labelKulkas.setVisible(false);
                // labelTambah.setVisible(true);
                // tambah.setVisible(false); 

                // f.setVisible(false);

            }

        });
        

		JButton anime = new JButton("Daftar Kulkas");
		anime.setMargin( new Insets(5, 5, 5, 5) );
        anime.setBounds(0,0,220,25);
        anime.setFont(new Font("Dialog", Font.BOLD, 12));
        //add button to the frame
        formAdmin.add(anime);
        anime.setVisible(false);

        JLabel labelAnime = new JLabel("Daftar Kulkas");
        labelAnime.setBounds(0,0,220,25);
        labelAnime.setHorizontalAlignment(JLabel.CENTER);
        labelAnime.setFont(new Font("Dialog", Font.BOLD, 12));
        //add button to the frame
        formAdmin.add(labelAnime);
        labelAnime.setVisible(true);

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

    	// JPanel panel_anime = new panelAnimeAdmin();
    	// formAdmin.add(panel_anime);
    	// panel_anime.setVisible(true);
        

    	JPanel panel_tambah = new panelTambah();
    	formAdmin.add(panel_tambah);
        // panel_tambah.setVisible(false);

        // JPanel f = new rincianAnime();
        // formAdmin.add(f);
        // f.setVisible(false);

        panel_tambah.setVisible(true);
                 //or .remove(previousPanel);

                // panel_anime.setVisible(false);
                

        anime.setVisible(true);
        labelAnime.setVisible(false);
        labelTambah.setVisible(true);
        tambah.setVisible(false); 

    	// tambah.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         //your actions
        //     	panel_tambah.setVisible(true);
        //          //or .remove(previousPanel);

        //     	panel_anime.setVisible(false);
                

        //         anime.setVisible(true);
        //         labelAnime.setVisible(false);
        //         labelTambah.setVisible(true);
        //         tambah.setVisible(false); 

        //         // f.setVisible(false);

        //     }

        // });

        // rincian.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         //your actions
        //         t.setVisible(false);
        //         g.setVisible(false);
        //         f.setVisible(true);
        //         anime.setVisible(true);
        //         labelAnime.setVisible(false);
        //         labelTambah.setVisible(false);
        //         tambah.setVisible(true);
        //     }

        // });

        anime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
            	// panel_anime.setVisible(true);
                // formAdmin.getContentPane().remove(panel_anime);
                // formAdmin.getContentPane().remove(panel_anime);
                // JPanel panel_anime = new panelAnimeAdmin();
                // formAdmin.add(panel_anime);
                // // panel_anime.buildPanel(); // panel needs a builder method
                // formAdmin.revalidate(); // in- and validate in one !! 
                // formAdmin.pack();
                new menuAdmin(1);
                formAdmin.dispose();
            }
        });

        //     	panel_tambah.setVisible(false);
        //         anime.setVisible(false);
        //         labelAnime.setVisible(true);

        //         labelTambah.setVisible(false);
        //         tambah.setVisible(true);
                
        //         // f.setVisible(false);
                
        //     }

        // });

	}

}