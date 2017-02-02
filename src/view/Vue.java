/*
*@author : Jules LE BRIS
 */

package view;

import controleur.Ctrl;
import model.Puissance4;

import javax.swing.*;

import java.awt.*;

public class Vue {


    //modele
    private Puissance4 jeu;
    private JPanel[][] lbls;
    private ImageIcon jB, jR;
    private JPanel pannelJeu;
    private JFrame f;

    public Vue(){
        f = new JFrame("Jeu du Puissance 4");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jB = new ImageIcon(new ImageIcon("src/view/img/jB.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        jR = new ImageIcon(new ImageIcon("src/view/img/jR.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));


        pannelJeu = new JPanel();
        jeu=new Puissance4();
        f.addKeyListener(new Ctrl(jeu, this));

        pannelJeu.setLayout(new GridLayout(8,10));

        lbls=new JPanel[8][10];

        for(int cpt=0; cpt<10; cpt++){
            lbls[0][cpt]=new JPanel();
            pannelJeu.add(lbls[0][cpt]);
        }

        JLabel tmp=new JLabel(jB);
        lbls[0][5].add(tmp);


        for(int i=1; i<8; i++){
            for(int j=0; j< 10;j++){
                lbls[i][j]=new JPanel();
                pannelJeu.add(lbls[i][j]);
                lbls[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            }
        }


        f.getContentPane().add(pannelJeu);
        f.setVisible(true);
        //f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setSize(600, 600);
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
        System.out.println("1");
        //f.removeAll();
        pannelJeu.removeAll();

        for(int cpt=0; cpt<10; cpt++){
            lbls[0][cpt]=new JPanel();
            pannelJeu.add(lbls[0][cpt]);
        }

        if(jeu.getTour()==Color.blue){
            JLabel bl=new JLabel(jB);
            lbls[0][jeu.getCurentC()].add(bl);
            //pannelJeu.add(lbls[0][/*jeu.getCurentC()*/3]);
            System.out.println(jeu.getCurentC());
        }else{
            JLabel bl=new JLabel(jR);
            lbls[0][jeu.getCurentC()].add(bl);
            //pannelJeu.add(lbls[0][jeu.getCurentC()]);
        }

        for(int i=0; i<7; i++) {
            for (int j = 0; j < 10; j++) {
                lbls[i+1][j]=new JPanel();
                if(jeu.getCase(i, j)!= null){
                    if(jeu.getCase(i, j)==Color.BLUE){
                        JLabel bl=new JLabel(jB);
                        lbls[i+1][j].add(bl);
                        pannelJeu.add(lbls[i+1][j]);

                    }else{
                        JLabel bl=new JLabel(jR);
                        lbls[i+1][j].add(bl);
                        pannelJeu.add(lbls[i+1][j]);
                    }
                }else{
                    pannelJeu.add(lbls[i+1][j]);
                }
            }
        }

        for(int i=1; i<8; i++){
            for(int j=0; j< 10;j++){
                lbls[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            }
        }


        //pannelJeu.repaint();
        //pannelJeu.revalidate();
        //f.repaint();
        f.revalidate();

        //f.add(pannelJeu);
    }
}

