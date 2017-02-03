package model;

import model.exception.DeplacementException;
import model.exception.PlacementException;

import java.awt.*;

/**
 * Created by zapoutou on 01/02/17.
 */
public class Puissance4 {
    private Color[][] jeu;
    private Color tour;
    private int curentC;

    public Puissance4(){
        jeu = new Color[7][10];
        tour=Color.blue;
        curentC=5;
    }

    public void put()throws PlacementException{
        int cpt=6;
        boolean done = false;
        while(cpt>=0 && !done){
            //System.out.println("1");
            if (jeu[cpt][this.curentC]==null){
                //System.out.println("1");
                jeu[cpt][this.curentC]=tour;
                done=true;
            }else{
                //System.out.println("2");
                if(cpt==0){
                    throw new PlacementException("colone déja pleine");
                }
            }
            cpt--;
        }
    }

    public void droite()throws DeplacementException{
        if(curentC!=9){
            curentC++;
        }
        else{
            throw new  DeplacementException("deplacement impossible or du tableau");
        }
    }

    public void gauche()throws DeplacementException{
        if(curentC!=0){
            curentC=curentC-1;
        }
        else{
            throw new  DeplacementException("deplacement impossible or du tableau");
        }
    }

    public Color getTour() {
        return tour;
    }

    public void changeTour() {
        if(tour==Color.blue){
            tour=Color.red;
        }else{
            tour=Color.blue;
        }
    }

    public Color getCase(int ligne, int colone){
        return this.jeu[ligne][colone];
    }

    public boolean gagne(){
        for(int i=0; i<7; i++){
            for(int j=0; j<10; j++){
                if(jeu[i][j]!=null){
                    Color obj = jeu[i][j];

                    int cptLigne =1;
                    int cptDiagonal=1;
                    int cptColone=1;

                    int boucleL=1;
                    int boucleC=1;
                    int boucleD=1;
                    boolean fin=false;
                    //parcour de la ligne colone par colone
                    //gauche
                    while(boucleL<4 && !fin){
                        if(j+boucleL>10 || j+boucleL<0){//sort du tableau
                            fin=true;
                        }else{
                            if(jeu[i][j+boucleL]==null || jeu[i][j+boucleL]!=obj){//fin de chaine
                                fin=true;
                            }else{
                                cptLigne++;
                            }
                        }

                        boucleL++;
                    }

                    boucleL=1;
                    fin=false;

                    while(boucleL<4 && !fin){
                        if(j-boucleL>10 || j-boucleL<0){//sort du tableau
                            fin=true;
                        }else{
                            if(jeu[i][j-boucleL]==null || jeu[i][j-boucleL]!=obj){//fin de chaine
                                fin=true;
                            }else{
                                cptLigne++;
                            }
                        }

                        boucleL++;
                    }

                    fin=false;

                    //parcour colone

                    while(boucleC<4 && !fin){
                        if(i+boucleC>6 || i+boucleC<0){//sort du tableau
                            fin=true;
                        }else{
                            if(jeu[i+boucleC][j]==null || jeu[i+boucleC][j]!=obj){//fin de chaine
                                fin=true;
                            }else{
                                cptColone++;
                            }
                        }

                        boucleC++;
                    }

                    boucleC=1;
                    fin=false;

                    while(boucleC<4 && !fin){
                        if(i-boucleC>6 || i-boucleC<0){//sort du tableau
                            fin=true;
                        }else{
                            if(jeu[i-boucleC][j]==null || jeu[i-boucleC][j]!=obj){//fin de chaine
                                fin=true;
                            }else{
                                cptColone++;
                            }
                        }
                        boucleC++;
                    }

                    fin=false;

                    //parcour diagonal

                    while(boucleD<4 && !fin){
                        if(i+boucleD>6 || i+boucleD<0 || j+boucleD>10 || j+boucleD<0){//sort du tableau
                            fin=true;
                        }else{
                            if(jeu[i+boucleD][j+boucleD]==null || jeu[i+boucleD][j+boucleD]!=obj){//fin de chaine
                                fin=true;
                            }else{
                                cptDiagonal++;
                            }
                        }

                        boucleD++;
                    }

                    boucleD=1;
                    fin=false;
                    cptColone=1;

                    while(boucleD<4 && !fin){
                        if(i-boucleD>6 || i-boucleD<0 || j-boucleD>10 || j-boucleD<0){//sort du tableau
                            fin=true;
                        }else{
                            if(jeu[i-boucleD][j+boucleD]==null || jeu[i-boucleD][j+boucleD]!=obj){//fin de chaine
                                fin=true;
                            }else{
                                cptDiagonal++;
                            }
                        }
                        boucleD++;
                    }

                    if(cptLigne==4 || cptDiagonal==4 || cptColone==4){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getCurentC() {
        return curentC;
    }
}
