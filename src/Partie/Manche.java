package Partie;

import Plateau.Case;
import Plateau.Grille;

import java.util.Scanner;

/**
 * La classe Manche représente une manche dans une partie de jeu.
 */
public class Manche {
    /** Le nombre maximal de cases sur une ligne du plateau. */
    private static final int MAX = 3;
    /** Le plateau de jeu pour la manche. */
    private Grille plateau;
    /** Le premier joueur de la manche. */
    private Joueur joueur1;
    /** Le deuxième joueur de la manche. */
    private Joueur joueur2;
    /** La pièce blanche sur le plateau. */
    private Joueur PieceBlanche;

    /**
     * Constructeur de la classe Manche.
     * Crée une nouvelle manche avec les joueurs et le plateau initialisé.
     * @param couleurJ1 La couleur du premier joueur.
     */
    public Manche(char couleurJ1){
        plateau = new Grille();
        if(couleurJ1 == 'R'){
            joueur1 = new Joueur('R', 0, 1, 0, 2);
            joueur2 = new Joueur('B', 2, 1, 2, 2);
            PieceBlanche = new Joueur('W', 1,1,1,2);

        }
        else {
            joueur1 = new Joueur('B', 2, 1, 2, 2);
            joueur2 = new Joueur('R', 0, 1, 0, 2);
            PieceBlanche = new Joueur('W', 1,1,1,2);
        }

    }
    /**
     * Constructeur par défaut de la classe Manche.
     * Crée une nouvelle manche avec le premier joueur de couleur rouge par défaut.
     */
    public Manche(){
        this('R');
    }
    /**
     * Méthode pour déplacer une pièce du joueur sur le plateau.
     * @param joueurQuiDeplace Le joueur qui effectue le déplacement.
     * @param nbTours Le nombre de tours joués.
     */
    public void deplacerPiece(Joueur joueurQuiDeplace, int nbTours){
        plateau.reinitChemins();
        plateau.cheminsPossibles();
        int nombreDeChemins = plateau.numerotationChemin(joueurQuiDeplace.getCouleur());
        System.out.println(plateau.toString(joueurQuiDeplace.getCouleur()));
        Scanner scanner = new Scanner(System.in);
        int chemin =0;
        do{
        System.out.println("C'est à la pièce : " + joueurQuiDeplace.getCouleur() +
                " De déplacer sa pièce \nSaisir l'un des chemins indiqué :");
        if(!scanner.hasNextInt()){
            chemin = 1; break;}
        else{chemin = scanner.nextInt();
        if(chemin > nombreDeChemins || chemin<=0){
            System.out.println("Déplacement non autorisé, recommencez votre tour !\n");
        }}}while(chemin > nombreDeChemins || chemin<=0 );

        positionLibre(joueurQuiDeplace);
        int[] pos = new int[2];
            Case.directions dir = null;
        dir = directionDeplacement(chemin, pos, dir);
        joueurQuiDeplace.getPiece().setPos1(pos);
            if(dir == Case.directions.Horizontal){
                int[]pos2 = new int[2];
                pos2[1]    = pos[1]+1;
                pos2[0] = pos[0];
                joueurQuiDeplace.getPiece().setPos2(pos2);}
            else if (dir == Case.directions.Vertical){
                int[] pos2 = new int[2];
                pos2[0] =  pos[0]-1;
                pos2[1] = pos[1];
                joueurQuiDeplace.getPiece().setPos2(pos2);
            }
        positionPrise(joueurQuiDeplace);
        System.out.println(plateau.toString());
            ++nbTours;
            return;

    }

    private Case.directions directionDeplacement(int chemin, int[] pos, Case.directions dir) {
        for(int i = 0; i<MAX; i++){
            for(int y =0; y<MAX; y++){
                for(int z = 0 ; z< plateau.getCase(i, y).getNumeroChemin().length; z++){
                    if (plateau.getCase(i, y).getNumeroChemin()[z] == chemin){
                        pos[0]=i;
                        pos[1]=y;
                        dir = plateau.getCase(i, y).getDirections()[z];
                    }
                }
            }
        }
        return dir;
    }

    private void positionPrise(Joueur joueurQuiDeplace) {
        plateau.getCase(joueurQuiDeplace.getPiece().getPos1()[0], joueurQuiDeplace.getPiece().getPos1()[1]
                ).setEstOccupee(true);
        plateau.getCase(joueurQuiDeplace.getPiece().getPos2()[0], joueurQuiDeplace.getPiece().getPos2()[1]
        ).setEstOccupee(true);
        plateau.getCase(joueurQuiDeplace.getPiece().getPos1()[0], joueurQuiDeplace.getPiece().getPos1()[1]
        ).setCouleurDeLaPiece(joueurQuiDeplace.getCouleur());
        plateau.getCase(joueurQuiDeplace.getPiece().getPos2()[0], joueurQuiDeplace.getPiece().getPos2()[1]
        ).setCouleurDeLaPiece(joueurQuiDeplace.getCouleur());
    }

    private void positionLibre(Joueur joueurQuiDeplace) {
        plateau.getCase(joueurQuiDeplace.getPiece().getPos1()[0], joueurQuiDeplace.getPiece().getPos1()[1]).setCouleurDeLaPiece(' ');
        plateau.getCase(joueurQuiDeplace.getPiece().getPos1()[0], joueurQuiDeplace.getPiece().getPos1()[1]).setEstOccupee(false);
        plateau.getCase(joueurQuiDeplace.getPiece().getPos2()[0], joueurQuiDeplace.getPiece().getPos2()[1]).setCouleurDeLaPiece(' ');
        plateau.getCase(joueurQuiDeplace.getPiece().getPos2()[0], joueurQuiDeplace.getPiece().getPos2()[1]).setEstOccupee(false);
    }

    /**
     * Méthode pour compter les points du joueur après un déplacement.
     * @param joueurQuiJoue Le joueur dont les points doivent être comptés.
     */
    public void compterPoints(Joueur joueurQuiJoue){
        if(plateau.getCase(joueurQuiJoue.getPiece().getPos1()[0], joueurQuiJoue.getPiece().getPos1()[1]).getSpot()){
            joueurQuiJoue.setPoints(joueurQuiJoue.getPoints()+1);
        }
        if(plateau.getCase(joueurQuiJoue.getPiece().getPos2()[0], joueurQuiJoue.getPiece().getPos2()[1]).getSpot()){
            joueurQuiJoue.setPoints(joueurQuiJoue.getPoints()+1);
        }

    }
    /**
     * Méthode pour afficher les points des joueurs.
     * @return Une chaîne de caractères représentant les points des joueurs.
     */
    public String afficherPoints(){
        return "Joueur"+ joueur1.getCouleur()+" : "+ joueur1.getPoints()+ " point(s) .\n" +
                "Joueur"+ joueur2.getCouleur()+" : "+ joueur2.getPoints()+ " point(s) .";
    }
    /**
     * Méthode pour déterminer le vainqueur de la manche.
     * @return Une chaîne de caractères indiquant le vainqueur de la manche.
     */
    public String determinerVainqueur(){
        if((joueur1.getPoints()>=12 && joueur2.getPoints()>=6)||(joueur2.getPoints()>=12 && joueur1.getPoints()<6))
            return "Le Vainqueur est le joueur " + joueur1.getCouleur();
        if((joueur2.getPoints()>=12 && joueur2.getPoints()>=6)||(joueur1.getPoints()>=12 && joueur2.getPoints()<6))
            return "Le Vainqueur est le joueur " + joueur2.getCouleur();
        return null;
    }
    /**
     * Obtient le premier joueur de la manche.
     * @return Le premier joueur de la manche.
     */
    public Joueur getJoueur1() {
        return joueur1;
    }
    /**
     * Obtient le deuxième joueur de la manche.
     * @return Le deuxième joueur de la manche.
     */
    public Joueur getJoueur2() {
        return joueur2;
    }
    /**
     * Obtient le plateau de jeu de la manche.
     * @return Le plateau de jeu de la manche.
     */
    public Grille getPlateau() {
        return plateau;
    }
    /**
     * Obtient la pièce blanche de la manche.
     * @return La pièce blanche de la manche.
     */
    public Joueur getPieceBlanche() {
        return PieceBlanche;
    }
    public static String getRouge() {
        return "\033[31m";
    }    public static String getBlanc() {
        return "\u001B[37m";
    }    public static String getBleu() {
        return "\u001B[34m";
    }
}
