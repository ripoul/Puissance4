package controleur;

import model.Puissance4;
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
        if (keyEvent.getKeyCode()==VK_UP){
            System.out.println("haut");
        }

        if (keyEvent.getKeyCode()==VK_DOWN){
            System.out.println("bas");
        }

        if (keyEvent.getKeyCode()==VK_LEFT){
            System.out.println("gauche");
        }

        if (keyEvent.getKeyCode()==VK_RIGHT){
            System.out.println("droite");
        }

        if(keyEvent.getKeyCode()==VK_F1){
            System.out.println("F1");

        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
