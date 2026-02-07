package Tests;

import Plateau.Case;
import org.junit.Assert;
import Plateau.Grille;
import org.junit.Test;

import static org.junit.Assert.*;

public class GrilleTest {
    private static final int MAXCASES = 3;

    @Test
    public void testGetCase() {
        Grille grille = new Grille();
        Case caseTest = grille.getCase(0, 0);
        assertNotNull(caseTest);
    }

    @Test
    public void grilleTestConstructeurGetter(){
        Grille plateau = new Grille();
        for(int i =0; i<MAXCASES; i++) {
            for (int y = 0; y < MAXCASES; y++) {
                if (y == 2) {
                    assertTrue(plateau.getCase(i, y).getSpot());
                    assertFalse(plateau.getCase(i, y).getEstOccupee());
                } else {
                    assertFalse(plateau.getCase(i, y).getSpot());
                    assertFalse(plateau.getCase(i, y).getEstOccupee());
                }
            }
        }
    }
    @Test
    public void testToString() {
        Grille grille = new Grille();
        String expected = "* * * * * * * * * * * * *\n" +
                "*       *       *       *\n" +
                "*       *   R   *   R   *\n" +
                "*       *       *       *\n" +
                "* * * * * * * * * * * * *\n" +
                "*       *       *       *\n" +
                "*       *   W   *   W   *\n" +
                "*       *       *       *\n" +
                "* * * * * * * * * * * * *\n" +
                "*       *       *       *\n" +
                "*       *   B   *   B   *\n" +
                "*       *       *       *\n" +
                "* * * * * * * * * * * * *\n";
        assertEquals(expected, grille.toString());
    }
    @Test
    public void grilleTestCheminsPossibles(){
        Grille plateau = new Grille();
        for (int i = 0; i < MAXCASES; i++) {
            for (int y = 0; y < MAXCASES; y++) {
                System.out.println(plateau.getCase(i, y).toString());
            }
        }
        plateau.cheminsPossibles();
        for (int i = 0; i < MAXCASES; i++) {
            for (int y = 0; y < MAXCASES; y++) {
                //Assert.assertTrue(plateau.getCase(i, y).isCheminPossible());
                System.out.println(plateau.getCase(i, y).toString());
            }
        }
        System.out.println(plateau.toString());
        plateau.numerotationChemin('R');
        System.out.println(plateau.toString('R'));
        assertEquals(1, plateau.getCase(0, 0).getNumeroChemin()[0]);
        assertEquals(2, plateau.getCase(1, 0).getNumeroChemin()[0]);
        assertEquals(3, plateau.getCase(2, 0).getNumeroChemin()[0]);
        for (int i = 0; i < MAXCASES; i++) {
            for (int y = 0; y < MAXCASES; y++) {
                assertFalse(plateau.getCase(0, 1).isCheminPossible());
                assertFalse(plateau.getCase(0, 2).isCheminPossible());
                System.out.println(plateau.getCase(i, y).toString());
            }
        }

    }
    @Test
    public void grilleTestNumérotationCheminsAffichage(){
        Grille plateau = new Grille();
        plateau.cheminsPossibles();
        int nombreDeChemins = plateau.numerotationChemin('R');
        for (int i = 0; i < MAXCASES; i++) {
            for (int y = 0; y < MAXCASES; y++) {
                System.out.println(plateau.getCase(i, y).toString());
            }
        }
        System.out.println(plateau.toString('R') +"\n" + nombreDeChemins);
        plateau.reinitChemins();
        plateau.getCase(0,1).setEstOccupee(true);
        plateau.getCase(0,1).setCouleurDeLaPiece('R');
        plateau.getCase(0,2).setEstOccupee(true);
        plateau.getCase(0,2).setCouleurDeLaPiece('R');
        plateau.cheminsPossibles();
        nombreDeChemins =plateau.numerotationChemin('B');
        System.out.println(plateau.toString('B') +"\n" + nombreDeChemins);

        plateau.reinitChemins();
        plateau.getCase(0,1).setEstOccupee(true);
        plateau.getCase(0,1).setCouleurDeLaPiece('R');
        plateau.getCase(0,2).setEstOccupee(true);
        plateau.getCase(0,2).setCouleurDeLaPiece('R');
        plateau.cheminsPossibles();
        nombreDeChemins =plateau.numerotationChemin('R');
        System.out.println("\n" + plateau.getCase(1, 2).getNumeroChemin()[0]);
        System.out.println(plateau.toString('R') +"\n" + nombreDeChemins);

        plateau.reinitChemins();
        plateau.getCase(0,1).setEstOccupee(true);
        plateau.getCase(0,1).setCouleurDeLaPiece('R');
        plateau.getCase(0,2).setEstOccupee(true);
        plateau.getCase(0,2).setCouleurDeLaPiece('R');
        plateau.getCase(1,1).setEstOccupee(true);
        plateau.getCase(1,1).setCouleurDeLaPiece('W');
        plateau.getCase(1,2).setEstOccupee(true);
        plateau.getCase(1,2).setCouleurDeLaPiece('W');
        plateau.getCase(2,1).setEstOccupee(true);
        plateau.getCase(2,1).setCouleurDeLaPiece('B');
        plateau.getCase(2,2).setEstOccupee(true);
        plateau.getCase(2,2).setCouleurDeLaPiece('B');
        System.out.println(plateau.toString());
        plateau.cheminsPossibles();
        nombreDeChemins =plateau.numerotationChemin('R');
        System.out.println("\n" + plateau.getCase(1, 2).getNumeroChemin()[0]);
        System.out.println(plateau.toString('R') +"\n" + nombreDeChemins);

    }
}
