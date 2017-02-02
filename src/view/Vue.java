/*
*@author : Jules LE BRIS
 */

package view;

import controleur.Ctrl;
import model.Puissance4;

import javax.swing.*;

import java.awt.*;

//proxyPort 1 à 65535
//http://proxyetu.iut-nantes.univ-nantes.prive:3128


public class Vue {


    //modele
    private Puissance4 jeu;
    private JPanel[][] lbls;
    private ImageIcon jB, jR;

    public Vue(){
        JFrame f = new JFrame("Jeu du Puissance 4");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jB = new ImageIcon(new ImageIcon("src/view/img/jB.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        jR = new ImageIcon(new ImageIcon("src/view/img/jR.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));


        JPanel pannel = new JPanel();
        pannel.setLayout(new BorderLayout());

        JPanel pannelJeu = new JPanel();
        jeu=new Puissance4();
        f.addKeyListener(new Ctrl(jeu, this));

        pannelJeu.setLayout(new GridLayout(7,11));

        lbls=new JPanel[8][10];
        for(int i=1; i<8; i++){
            for(int j=0; j< 10;j++){
                lbls[i][j]=new JPanel();
                pannelJeu.add(lbls[i][j]);

                lbls[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

            }
        }



        JLabel bl=new JLabel(jB);
        lbls[0][5].add(bl);


        pannel.add(pannelJeu, BorderLayout.CENTER);
        f.getContentPane().add(pannel);
        f.setVisible(true);
        //f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setSize(500, 500);
        //f.setExtendedState(Frame.MAXIMIZED_BOTH);

    }


    public static void setBestLookAndFeelAvailable(){
        String system_lf = UIManager.getSystemLookAndFeelClassName().toLowerCase();
        if(system_lf.contains("metal")){
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            }catch (Exception e) {}
        }else{
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        setBestLookAndFeelAvailable();
        Vue fenetre = new Vue();
    }

    public void maj() {
        for(int i=0; i<8; i++) {
            for (int j = 0; j < 10; j++) {
                lbls[i+1][j]=new JPanel();
                if(jeu.getCase(i, j)!= null){
                    if(jeu.getCase(i, j)==Color.BLUE){
                        JLabel bl=new JLabel(jB);
                        lbls[i+1][j].add(bl);
                    }else{
                        JLabel bl=new JLabel(jR);
                        lbls[i+1][j].add(bl);
                    }
                }
            }
        }

        for(int cpt=0; cpt<10; cpt++){
            lbls[0][cpt]=new JPanel();
        }

        if(jeu.getTour()==Color.blue){
            JLabel bl=new JLabel(jB);
            lbls[0][jeu.getCurentC()].add(bl);
        }else{
            JLabel bl=new JLabel(jR);
            lbls[0][jeu.getCurentC()].add(bl);
        }


    }
}

