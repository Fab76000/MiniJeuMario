package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//***** La classe Clavier gère les actions utilisateur au clavier *****//
public class Clavier implements KeyListener {

    // **** METHODES **//
    @Override
    public void keyPressed(KeyEvent e) {
        if (Scene.mario.isVivant() == true) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // flèche droite
                if (Main.scene.getxPos() == -1) {
                    Main.scene.setxPos(0); // Réinitialisation de setxPos
                    Main.scene.setxFond1(-50); // Réinitialisation de xFond1
                    Main.scene.setxFond2(750); // Réinitialisation de xFond2
                }
                Scene.mario.setMarche(true);
                Scene.mario.setVersDroite(true);
                Main.scene.setDx(1); // Déplacement du fond vers la gauche lors de l'appui sur la touche "flèche droite"
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // flèche gauche
                if (Main.scene.getxPos() == 4431) {
                    Main.scene.setxPos(4430);
                    Main.scene.setxFond1(-50);
                    Main.scene.setxFond2(750);
                }
                Scene.mario.setMarche(true);
                Scene.mario.setVersDroite(false);
                Main.scene.setDx(-1); // Déplacement du fond vers la droite lors de l'appui sur la touche "flèche gauche"
            }
            // mario saute
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                Scene.mario.setSaut(true);
                Audio.playSound("/audio/saut.wav");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Scene.mario.setMarche(false);
        Main.scene.setDx(0);// Remise à 0 de la variable dx de la l'objet scene lors du relâchement des touches
    } 

    @Override
    public void keyTyped(KeyEvent e) {}
}