import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class menuUpdate{
	menuUpdate(int id){
		JFrame formAdmin = new JFrame("menu update");
		formAdmin.setSize(600,700);
		formAdmin.setLocation(100,150);
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


        JLabel labelTambah = new JLabel("Update");
        // labelTambah.setMargin( new Insets(5, 5, 5, 5) );
        labelTambah.setBounds(500,0,70,25);
        labelTambah.setHorizontalAlignment(JLabel.CENTER);
        labelTambah.setFont(new Font("Dialog", Font.PLAIN, 10));
        //add button to the frame
        formAdmin.add(labelTambah);
        labelTambah.setVisible(true);

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
        

    	JPanel panel_update = new panelUpdate(id);
    	formAdmin.add(panel_update);
        // panel_update.setVisible(false);

        // JPanel f = new rincianAnime();
        // formAdmin.add(f);
        // f.setVisible(false);

        panel_update.setVisible(true);
                 //or .remove(previousPanel);

                // panel_anime.setVisible(false);
                

        // anime.setVisible(true);
        // labelAnime.setVisible(false);
        // labelTambah.setVisible(true);
        // tambah.setVisible(false); 

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

        // anime.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         //your actions
        //     	// panel_anime.setVisible(true);
        //         // formAdmin.getContentPane().remove(panel_anime);
        //         // formAdmin.getContentPane().remove(panel_anime);
        //         // JPanel panel_anime = new panelAnimeAdmin();
        //         // formAdmin.add(panel_anime);
        //         // // panel_anime.buildPanel(); // panel needs a builder method
        //         // formAdmin.revalidate(); // in- and validate in one !! 
        //         // formAdmin.pack();
        //         new menuAdmin(1);
        //         formAdmin.dispose();
        //     }
        // });

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