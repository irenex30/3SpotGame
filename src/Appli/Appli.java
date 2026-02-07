package Appli;

import Partie.Manche;

import java.awt.*;
import java.util.Scanner;



/**
 * La classe Appli est la classe principale de l'application.
 * Elle permet de jouer une partie de 3SpotGame en instanciant une manche et en effectuant les déplacements des joueurs.
 */
public class Appli {
    /**
     * Méthode principale de l'application.
     * @param args Les arguments de la ligne de commande (non utilisés dans cette application).
     */
    public static void main(String[] args){

        // Demande à l'utilisateur de saisir la couleur du premier joueur
        System.out.println(/*Manche.getBlanc()+*/"Saisir la couleur du premier Joueur ("/*+ Manche.getRouge()*/+ "R"+ /*Manche.getBlanc() +*/" ou "/*+ Manche.getBleu()*/+"B"/*+Manche.getBlanc()*/+") :");
        Scanner scanner = new Scanner(System.in);
        char couleur = scanner.next().trim().charAt(0);
        if( couleur != 'R' && couleur !='B'){
            couleur='R';}

        // Instanciation d'une nouvelle manche avec la couleur du premier joueur saisie
        Manche manche = new Manche(couleur);
        int nbTour=1;

        // Boucle principale de la partie, se poursuit tant qu'aucun joueur n'a atteint 12 points
        while(manche.getJoueur1().getPoints()<12 && manche.getJoueur2().getPoints()<12){
            // Affichage du numéro du tour
            System.out.println("Tour "+ nbTour++);

            // Affichage du plateau de jeu
            System.out.println(manche.getPlateau().toString());

            // Tour du joueur 1
            manche.deplacerPiece(manche.getJoueur1(), nbTour);
            manche.deplacerPiece(manche.getPieceBlanche(), nbTour); // Déplacement de la pièce blanche
            manche.compterPoints(manche.getJoueur1()); // Comptage des points du joueur 1
            System.out.println(manche.afficherPoints()); // Affichage des points du joueur 1

            // Vérification si le joueur 1 a atteint 12 points, si oui, fin de la partie
            if(manche.getJoueur1().getPoints()>=12)break;

            // Réinitialisation des chemins possibles sur le plateau
            manche.getPlateau().reinitChemins();

            // Tour du joueur 2
            manche.deplacerPiece(manche.getJoueur2(), nbTour);
            manche.deplacerPiece(manche.getPieceBlanche(), nbTour); // Déplacement de la pièce blanche
            manche.compterPoints(manche.getJoueur2()); // Comptage des points du joueur 2
            System.out.println(manche.afficherPoints()); // Affichage des points du joueur 2
        }

        // Affichage du vainqueur de la partie
        System.out.println(manche.determinerVainqueur());
    }
}
