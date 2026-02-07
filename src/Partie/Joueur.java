package Partie;

import Plateau.Piece;
/**
 * La classe Joueur représente un joueur dans une partie.
 */
public class Joueur {
    /** Le nombre de points du joueur. */
    private int points;
    /** La pièce associée au joueur. */
    private Piece piece;
    /** La couleur du joueur ('R' pour rouge, 'B' pour bleu). */
    private char couleur;

    /**
     * Constructeur de la classe Joueur.
     * Crée un joueur avec une couleur donnée et une pièce aux positions spécifiées.
     * @param couleur La couleur du joueur.
     * @param x1 La coordonnée x de la première position de la pièce.
     * @param y1 La coordonnée y de la première position de la pièce.
     * @param x2 La coordonnée x de la deuxième position de la pièce.
     * @param y2 La coordonnée y de la deuxième position de la pièce.
     */
    public Joueur(char couleur, int x1, int y1, int x2, int y2){
        assert(x1>=0 && x1<=2);
        assert(x2>=0 && x2<=2);
        assert(y1>=0 && y1<=2);
        assert(y2>=0 && y2<=2);
        points = 0;
        piece = new Piece(couleur, x1, y1, x2, y2);
        this.couleur = couleur;
    }
    /**
     * Constructeur par défaut de la classe Joueur.
     * Crée un joueur avec une couleur par défaut ('R') et une pièce aux positions par défaut.
     */
    public Joueur(){
        this('R', 0, 1, 0, 2);
    }
    /**
     * Obtient la couleur du joueur.
     * @return La couleur du joueur.
     */
    public char getCouleur() {
        return couleur;
    }
    /**
     * Obtient le nombre de points du joueur.
     * @return Le nombre de points du joueur.
     */
    public int getPoints() {
        return points;
    }
    /**
     * Obtient la pièce associée au joueur.
     * @return La pièce associée au joueur.
     */
    public Piece getPiece() {
        return piece;
    }
    /**
     * Définit le nombre de points du joueur.
     * @param points Le nouveau nombre de points du joueur.
     */
    public void setPoints(int points) {
        this.points = points;
    }
}

