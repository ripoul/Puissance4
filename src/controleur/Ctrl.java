package controleur;

import model.Puissance4;
import model.exception.DeplacementException;
import model.exception.PlacementException;
import view.Vue;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

/**
 * Created by zapoutou on 31/01/17.
 */
public class Ctrl implements KeyListener{
    Puissance4 jeu;
    Vue vue;

    public Ctrl(Puissance4 jeu, Vue vue){
        this.jeu=jeu;
        this.vue=vue;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode()==VK_DOWN){
            System.out.println("bas");
            try{
                jeu.put();
                jeu.changeTour();
                JOptionPane.showMessageDialog(null,"changement joueur");
            }catch (PlacementException e) {
                //e.printStackTrace();
                JOptionPane.showMessageDialog(null,"colone déja pleine","ERREUR",JOptionPane.ERROR_MESSAGE);
            }
            if (jeu.gagne()){
                JOptionPane.showMessageDialog(null,"GAGNE");
            }
        }

        if (keyEvent.getKeyCode()==VK_LEFT){
            System.out.println("gauche");
            try {
                jeu.gauche();
                vue.maj();
            } catch (DeplacementException e) {
                JOptionPane.showMessageDialog(null,"jeton deja a gauche","ERREUR",JOptionPane.ERROR_MESSAGE);
            }
        }

        if (keyEvent.getKeyCode()==VK_RIGHT){
            System.out.println("droite");
            try {
                jeu.droite();
                vue.maj();
            } catch (DeplacementException e) {
                JOptionPane.showMessageDialog(null,"jeton deja a droite","ERREUR",JOptionPane.ERROR_MESSAGE);
            }
        }

        if(keyEvent.getKeyCode()==VK_F1){
            System.out.println("F1");

        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
