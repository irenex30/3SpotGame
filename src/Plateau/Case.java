package Plateau;

import static Plateau.Case.directions.NULL;
/**
 * La classe Case représente une case sur un plateau de jeu.
 */
public class Case {
    /** Le nombre maximal de chemins possibles depuis cette case. */
    private static final int MAXCHEMINS = 3;


    /** Les différentes directions possibles depuis cette case. */
    public static enum directions{Horizontal, Vertical, NULL}

    private boolean estOccupee;
    private final boolean spot;
    private char couleurDeLaPiece;
    private boolean cheminPossible;
    private int[] numeroChemin;
    private directions[] directions;

    /**
     * Constructeur de la classe Case.
     * @param spot true si la case est un spot, false sinon.
     */
    public Case(boolean spot){
        estOccupee = false;
        this.spot = spot;
        numeroChemin = new int[MAXCHEMINS];
        directions = new directions[MAXCHEMINS];
        for(int i =0; i<MAXCHEMINS; i++){
            directions[i]= NULL;}
    }
    /**
     * Constructeur par défaut de la classe Case.
     */
    public Case(){
        this(false);
    }
    /**
     * Obtient la couleur de la pièce présente sur cette case.
     * @return La couleur de la pièce.
     */
    public char getCouleurDeLaPiece() {
        //assert(estOccupee);
        return couleurDeLaPiece;
    }
    /**
     * Définit la couleur de la pièce présente sur cette case.
     * @param couleurDeLaPiece La couleur de la pièce.
     */
    public void setCouleurDeLaPiece(char couleurDeLaPiece) {
        assert(estOccupee);
        this.couleurDeLaPiece = couleurDeLaPiece;
    }
    /**
     * Vérifie si la case est occupée.
     * @return true si la case est occupée, false sinon.
     */
    public boolean getEstOccupee(){
        return estOccupee;
    }
    /**
     * Définit l'état d'occupation de la case.
     * @param etat true si la case est occupée, false sinon.
     */
    public void setEstOccupee(boolean etat){
        estOccupee = etat;
    }
    /**
     * Obtient l'état de la case.
     * @return true si la case est un spot, false sinon.
     */
    public boolean getSpot(){
        return spot;
    }
    /**
     * Vérifie si un chemin est possible depuis cette case.
     * @return true si un chemin est possible, false sinon.
     */
    public boolean isCheminPossible() {
        return cheminPossible;
    }
    /**
     * Définit si un chemin est possible depuis cette case.
     * @param cheminPossible true si un chemin est possible, false sinon.
     */
    public void setCheminPossible(boolean cheminPossible) {
        this.cheminPossible = cheminPossible;
    }
    /**
     * Obtient les numéros des chemins possibles depuis cette case.
     * @return Un tableau contenant les numéros des chemins possibles.
     */
    public int[] getNumeroChemin() {
        int[] tmp = new int[MAXCHEMINS];
        for(int i =0; i<MAXCHEMINS; i++ )
            tmp[i]=numeroChemin[i];
        return tmp;
    }
    /**
     * Définit le numéro d'un chemin possible depuis cette case.
     * @param numeroChemin Le numéro du chemin.
     * @param directions La direction du chemin.
     */
    public void setNumeroChemin(int numeroChemin, directions directions) {
        //assert(cheminPossible);
        assert(numeroChemin>=0);
        assert(numeroChemin<30);
        for(int i =0; i<MAXCHEMINS; i++){
            if(this.numeroChemin[i]==0){
                this.numeroChemin[i] = numeroChemin;
                this.directions[i] = directions;
                break;}

        }

    }
    /**
     * Attribue un numéro de chemin et une direction à un indice spécifique dans les tableaux correspondants.
     *
     * @param numeroChemin Le numéro de chemin à attribuer à la case.
     * @param directions La direction du chemin associée à la case.
     * @param indice L'indice dans les tableaux où le numéro de chemin et la direction doivent être enregistrés.
     */
    public void setNumero(int numeroChemin, directions directions, int indice) {
        //assert(cheminPossible);
        assert(numeroChemin>=0);
        assert(numeroChemin<30);
                this.numeroChemin[indice] = numeroChemin;
                this.directions[indice] = directions;
    }
    /**
     * Obtient les directions des chemins possibles depuis cette case.
     * @return Un tableau contenant les directions des chemins possibles.
     */
    public Case.directions[] getDirections() {

        //return directions;
        directions[] tmp = new directions[MAXCHEMINS];
        for(int i =0; i<MAXCHEMINS; i++ )
            tmp[i]=directions[i];
        return tmp;
    }
    /**
     * Retourne une représentation en chaîne de caractères de la case.
     * @return Une chaîne décrivant l'état de la case.
     */
    public String toString(){
        StringBuilder s = new StringBuilder("La case est ");
        if(estOccupee)
            s.append(" Occupée ") ;
        else
            s.append(" Libre ");
        s.append(" et ") ;
        if(spot)
            s.append("  spot ") ;
        else
            s.append("  pas spot ") ;
        if(cheminPossible){
            s.append("  chemin possible numéro : ")  ;
            for(int c = 0; c<MAXCHEMINS; c++){
                if(numeroChemin[c]!=0){
                    s.append(" num " );
                    s.append( numeroChemin[c]);}
            }

        }

        else
            s.append("  pas chemin possible") ;
        return s.toString();

    }
    /**
     * Initialise les tableaux des numéros de chemins et des directions.
     */
    public void initTab() {
        for(int i = 0; i< numeroChemin.length; i++){
            numeroChemin[i]=0;
            directions[i]=NULL;
            setCheminPossible(false);
        }

    }

}
