package Tests;
import Partie.Joueur;
import Partie.Manche;
import org.junit.Test;
import static org.junit.Assert.*;

public class MancheTest {

    @Test
    public void testCompterPoints() {
        Manche manche = new Manche();
        Joueur joueur = new Joueur('R', 0, 1, 0, 2);
        manche.compterPoints(joueur);
        assertEquals(1, joueur.getPoints()); //car sur la position de base du jeu, la piece R est sur un spot
    }

    @Test
    public void testAfficherPoints() {
        Manche manche = new Manche();
        manche.getJoueur1().setPoints(3);
        manche.getJoueur2().setPoints(5);
        String expectedOutput = "JoueurR : 3 point(s) .\nJoueurB : 5 point(s) .";
        assertEquals(expectedOutput, manche.afficherPoints());
    }

    @Test
    public void testDeterminerVainqueur() {
        Manche manche = new Manche();
        manche.getJoueur1().setPoints(15);
        manche.getJoueur2().setPoints(4);
        assertEquals("Le Vainqueur est le joueur B", manche.determinerVainqueur());
    }

}
