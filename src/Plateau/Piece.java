package Plateau;
/**
 * La classe Piece représente une pièce sur le plateau de jeu.
 */
public class Piece {
    /** La couleur de la pièce ('R' pour rouge, 'B' pour bleu, 'W' pour blanc). */
    private char couleur;
    /** Les coordonnées de la première position de la pièce. */
    private int[] pos1;
    /** Les coordonnées de la deuxième position de la pièce. */
    private int[] pos2;

    /**
     * Constructeur de la classe Piece.
     * @param couleur La couleur de la pièce.
     * @param x1 La coordonnée x de la première position de la pièce.
     * @param y1 La coordonnée y de la première position de la pièce.
     * @param x2 La coordonnée x de la deuxième position de la pièce.
     * @param y2 La coordonnée y de la deuxième position de la pièce.
     */
    public Piece(char couleur, int x1, int y1, int x2, int y2){
        assert(couleur == 'R' || couleur == 'B' || couleur == 'W');
        assert(x1>=0 && x1<=2);
        assert(x2>=0 && x2<=2);
        assert(y1>=0 && y1<=2);
        assert(y2>=0 && y2<=2);
        this.couleur= couleur;
        pos1 = new int[2];
        pos2 = new int[2];
        pos1[0] = x1; pos1[1] = y1;
        pos2[0] = x2; pos2[1] = y2;

    }
    /**
     * Obtient la couleur de la pièce.
     * @return La couleur de la pièce.
     */
    public char getCouleur() {
        return couleur;
    }
    /**
     * Obtient les coordonnées de la première position de la pièce.
     * @return Un tableau contenant les coordonnées de la première position.
     */
    public int[] getPos1() {
        int[] tmp = new int[2];
        for(int i = 0; i<2; i++)
            tmp[i]=pos1[i];
        return tmp;
    }
    /**
     * Obtient les coordonnées de la deuxième position de la pièce.
     * @return Un tableau contenant les coordonnées de la deuxième position.
     */
    public int[] getPos2() {
        int[] tmp = new int[2];
        for(int i = 0; i<2; i++)
            tmp[i]=pos2[i];
        return tmp;
    }
    /**
     * Définit les coordonnées de la première position de la pièce.
     * @param pos1 Un tableau contenant les coordonnées de la première position.
     */
    public void setPos1(int[] pos1) {
        assert(pos1[0]>=0 && pos1[0]<=2);
        assert(pos1[1]>=0 && pos1[1]<=2);
        this.pos1 = pos1;
    }
    /**
     * Définit les coordonnées de la deuxième position de la pièce.
     * @param pos2 Un tableau contenant les coordonnées de la deuxième position.
     */
    public void setPos2(int[] pos2) {
        assert(pos1[0]>=0 && pos1[0]<=2);
        assert(pos1[1]>=0 && pos1[1]<=2);
        this.pos2 = pos2;
    }
}
