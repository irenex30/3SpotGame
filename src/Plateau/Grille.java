package Plateau;

/**
 * La classe Grille représente un plateau de jeu constitué de cases.
 */
public class Grille {
    /** Le nombre maximal de cases dans la grille. */
    private static final int MAXCASES = 3;
    /** Tableau bidimensionnel contenant les cases de la grille. */
    private Case[][] cases;

    /**
     * Constructeur de la classe Grille.
     * Initialise la grille avec des cases vides ou occupées selon les règles du 3SpotGame.
     */
    public Grille() {
        cases = new Case[MAXCASES][MAXCASES];
        for (int i = 0; i < MAXCASES; i++) {
            for (int y = 0; y < MAXCASES; y++) {
                if (y == 2)
                    cases[i][y] = new Case(true);
                else
                    cases[i][y] = new Case();
            }
        }
        initCasesOccupee();
    }
    /**
     * Initialise les cases occupées de la grille avec la configuration initiale.
     */
    private void initCasesOccupee() {
        getCase(0, 1).setEstOccupee(true);
        getCase(0, 1).setCouleurDeLaPiece('R');
        getCase(0, 2).setEstOccupee(true);
        getCase(0, 2).setCouleurDeLaPiece('R');
        getCase(2, 1).setEstOccupee(true);
        getCase(2, 1).setCouleurDeLaPiece('B');
        getCase(2, 2).setEstOccupee(true);
        getCase(2, 2).setCouleurDeLaPiece('B');
        getCase(1, 1).setEstOccupee(true);
        getCase(1, 1).setCouleurDeLaPiece('W');
        getCase(1, 2).setEstOccupee(true);
        getCase(1, 2).setCouleurDeLaPiece('W');
    }
    /**
     * Obtient la case à la position spécifiée dans la grille.
     * @param x L'indice de ligne de la case.
     * @param y L'indice de colonne de la case.
     * @return La case à la position spécifiée.
     */
    public Case getCase(int x, int y) {
        return cases[x][y];
    }
    /**
     * Retourne une représentation en chaîne de caractères de la grille.
     * @return Une chaîne décrivant l'état de la grille.
     */
    public String toString() {
        int i = 0;
        StringBuilder s = new StringBuilder();
        while (i < MAXCASES) {
            s.append("* * * * * * * * * * * * *\n") ;
            s.append(toStringLigne(i)) ;
            ++i;
        }
        s.append("* * * * * * * * * * * * *\n") ;
        return s.toString();
    }

    private String toStringLigne(int nbLigne) {
        assert (nbLigne >= 0);
        assert (nbLigne <= 2);
        StringBuilder s = new StringBuilder("*       *       *       *\n") ;
        for (int y = 0; y < MAXCASES; y++) {
            if (getCase(nbLigne, y).getEstOccupee()) {
                s.append("*   ") ;
                s.append(getCase(nbLigne, y).getCouleurDeLaPiece()) ;
                s.append("   ") ;
            } else if (getCase(nbLigne, y).getSpot() && !getCase(nbLigne, y).getEstOccupee()) {
                s.append("*   O   ") ;

            } else
                s.append("*       ") ;
        }
        s.append("*\n*       *       *       *\n") ;
        return s.toString();
    }
    /**
     * Met à jour l'état des chemins possibles depuis chaque case de la grille.
     */
    public void cheminsPossibles() {
        for (int i = 0; i < MAXCASES; i++) {
            for (int y = 0; y < MAXCASES; y++) {
                if(cases[i][y].getEstOccupee()){
                    cases[i][y].setCheminPossible(false);
                }
                else if(!cases[i][y].getEstOccupee()){
                    cases[i][y].setCheminPossible(true);
                }
                 else{cases[i][y].setCheminPossible(false);}

            }
        }
    }
    /**
     * Numérote les chemins possibles pour une couleur de pièce donnée.
     * @param couleurpiece La couleur de la pièce pour laquelle numéroter les chemins.
     * @return Le nombre total de chemins numérotés.
     */
        public int numerotationChemin(char couleurpiece) {
            int w = 1;
            for (int i = 0; i < MAXCASES; i++) {
                for (int y = 0; y < MAXCASES; y++) {
                    if (cases[i][y].isCheminPossible()) {
                        if (isInTable(i + 1, y) && (cases[i + 1][y].isCheminPossible()|| cases[i+1][y].getCouleurDeLaPiece() == couleurpiece)) {
                        cases[i + 1][y].setNumeroChemin(w, Case.directions.Vertical);
                        ++w;
                    }
                    if (isInTable(i, y + 1) && (cases[i][y+1].isCheminPossible() || cases[i][y+1].getCouleurDeLaPiece() == couleurpiece)) {
                    cases[i][y].setNumeroChemin(w, Case.directions.Horizontal);
                    ++w;
                }
            }
                    if(cases[i][y].getCouleurDeLaPiece() == couleurpiece) {
                    if (isInTable(i + 1, y) && cases[i + 1][y].isCheminPossible()) {
                    cases[i + 1][y].setNumeroChemin(w, Case.directions.Vertical);
                    ++w;
                }
                    if (isInTable(i, y + 1) && cases[i][y + 1].isCheminPossible()) {
                    cases[i][y].setNumeroChemin(w, Case.directions.Horizontal);
                    ++w;
                }
        }
    }
    numerBien(w);
}
            return w-1;
        }
    /**
     * Met à jour les numéros de chemin pour chaque case de la grille.
     * Les numéros de chemin sont attribués de manière séquentielle à partir de 1.
     * Cette méthode parcourt toutes les cases de la grille et, pour chaque case,
     * vérifie les chemins possibles enregistrés. Elle attribue ensuite un numéro à chaque chemin trouvé.
     *
     * @param nbChemins Le nombre total de chemins attendus dans la grille.
     *                  Cette valeur doit correspondre au nombre total de chemins réellement calculés.

     * @throws AssertionError Si le nombre de chemins trouvés ne correspond pas au nombre attendu.
     */
        private void numerBien(int nbChemins){
            int chemin = 1;
            for(int i =0; i<MAXCASES; i++){
                for(int y =0; y<MAXCASES; y++){
                    for(int z = 0; z<MAXCASES; z++){
                        if(getCase(i, y).getNumeroChemin()[z]!=0){
                            getCase(i, y).setNumero(chemin, getCase(i,y).getDirections()[z], z);
                            ++chemin;
                        }
                    }
                }
            }
         assert(nbChemins == chemin);
        }
    /**
     * Vérifie si une position est valide dans la grille.
     * @param i L'indice de ligne.
     * @param y L'indice de colonne.
     * @return true si la position est valide, false sinon.
     */
    private boolean isInTable(int i, int y) {
        if(i<0 || i>2)
            return false;
        else return y >= 0 && y <= 2;
    }
    /**
     * Retourne une représentation en chaîne de caractères de la grille avec des indications sur les chemins possibles.
     * @param couleurPiece La couleur de la pièce pour laquelle afficher les chemins possibles.
     * @return Une chaîne décrivant l'état de la grille avec les chemins possibles.
     */
    public String toString(char couleurPiece) {
        int i = 0;
        StringBuilder s = new StringBuilder();
        while (i < MAXCASES) {
            s.append("* * * * * * * * * * * * *\n") ;
            s.append(toStringLigne(i, couleurPiece)) ;
            ++i;
        }
        s.append("* * * * * * * * * * * * *\n") ;
        return s.toString();
    }

    private String toStringLigne(int nbLigne, char couleurPiece) {
        assert (nbLigne >= 0);
        assert (nbLigne <= 2);
        StringBuilder s = new StringBuilder();
        s.append("*       *       *       *\n") ;
        for (int y = 0; y < MAXCASES; y++) {
            int compteur =0;
            for(int i=0; i<getCase(nbLigne, y).getNumeroChemin().length; i++){
                if(getCase(nbLigne, y).getNumeroChemin()[i]!=0)
                    ++compteur;
            }
            if(getCase(nbLigne, y).isCheminPossible() && compteur>0){
                s.append(afficherCaseChemin(nbLigne, y));
            } else if (getCase(nbLigne, y).getEstOccupee() && getCase(nbLigne, y).getCouleurDeLaPiece()== couleurPiece &&
                    compteur>0) { s.append(afficherCaseChemin(nbLigne, y));

            } else if (getCase(nbLigne, y).getEstOccupee() && getCase(nbLigne, y).getCouleurDeLaPiece()!= couleurPiece) {
                s.append("*   ") ;
                s.append(getCase(nbLigne, y).getCouleurDeLaPiece()) ;
                s.append("   ") ;
            } else if (getCase(nbLigne, y).getSpot()) {
                if(!getCase(nbLigne, y).getEstOccupee() || getCase(nbLigne, y).getCouleurDeLaPiece()==couleurPiece)
                    s.append("*   O   ") ;

            } else
                s.append("*       ") ;
        }
        s.append("*\n*       *       *       *\n") ;
        return s.toString();
    }

    private String afficherCaseChemin(int nbLigne, int y) {
        StringBuilder s= new StringBuilder();
        int compteur=0;
        for(int i=0; i<getCase(nbLigne,y).getNumeroChemin().length; i++){
            if(getCase(nbLigne, y).getNumeroChemin()[i] !=0)
                ++compteur;
        }
        if(compteur == 1){
            s.append("*   ") ;
            s.append(getCase(nbLigne, y).getNumeroChemin()[0])  ;
            s.append("   ") ;
        }
        else{
            s.append("* ");
            for(int i=0; i<getCase(nbLigne,y).getNumeroChemin().length; i++){
                if(getCase(nbLigne, y).getNumeroChemin()[i]>0){
                    s.append(getCase(nbLigne, y).getNumeroChemin()[i]);
                    if(getCase(nbLigne, y).getNumeroChemin()[i+1]==0){s.append(" ");break;}
                    s.append(" - ");
                }
            }
        }
        return s.toString();
    }
    /**
     * Réinitialise les numéros de chemins pour toutes les cases de la grille.
     */
    public void reinitChemins(){
        for(int i=0; i<MAXCASES; i++){
            for(int y=0; y<MAXCASES; y++){
                cases[i][y].initTab();
            }
        }
    }



}
