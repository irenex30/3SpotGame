package Tests;
import Partie.Joueur;
import Plateau.Piece;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JoueurTest {
    @Test
    public void joueurTestConstructeurGetter(){
        Joueur j1 = new Joueur('R', 0, 1, 0, 2);
        assertEquals('R', j1.getCouleur());
        assertEquals(0, j1.getPoints());
        Assert.assertTrue(j1.getPiece().getPos1()[0]==0 && j1.getPiece().getPos1()[1]==1);
        Assert.assertTrue(j1.getPiece().getPos2()[0]==0 && j1.getPiece().getPos2()[1]==2);
        int[] tab = {1,1};
        j1.getPiece().setPos1(tab);
        Assert.assertFalse(j1.getPiece().getPos1()[0]==0 && j1.getPiece().getPos1()[1]==1);
        Assert.assertTrue(j1.getPiece().getPos1()[0]==1 && j1.getPiece().getPos1()[1]==1);
        Joueur j2 = new Joueur();
        assertEquals('R', j2.getCouleur());
        assertEquals(0, j2.getPoints());
        Assert.assertTrue(j2.getPiece().getPos1()[0]==0 && j2.getPiece().getPos1()[1]==1);
        Assert.assertTrue(j2.getPiece().getPos2()[0]==0 && j2.getPiece().getPos2()[1]==2);

    }
    @Test
    public void testGetCouleur() {
        Joueur joueur = new Joueur('R', 0, 1, 0, 2);
        assertEquals('R', joueur.getCouleur());
    }
    @Test
    public void testGetPoints() {
        Joueur joueur = new Joueur('R', 0, 1, 0, 2);
        assertEquals(0, joueur.getPoints());
    }
    @Test
    public void testGetPiece() {
        Joueur joueur = new Joueur('R', 0, 1, 0, 2);
        Piece piece = joueur.getPiece();
        assertNotNull(piece);
    }
    @Test
    public void testSetPoints() {
        Joueur joueur = new Joueur('R', 0, 1, 0, 2);
        joueur.setPoints(10);
        assertEquals(10, joueur.getPoints());
    }

}
