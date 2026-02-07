package Tests;

import org.junit.Assert;
import org.junit.Test;
import Plateau.Case;

import static org.junit.Assert.*;

public class CaseTest {
    @Test
    public void caseTestConstructeurEtSetter(){
        Case case1 = new Case();
        Assert.assertFalse(case1.getEstOccupee() && case1.getSpot());
        case1.setEstOccupee(true);
        assertTrue(case1.getEstOccupee() && !case1.getSpot());

        Case case2 = new Case(true);
        Assert.assertFalse(case2.getEstOccupee());
        case2.setEstOccupee(true);
        assertTrue(case2.getEstOccupee() && case2.getSpot());

        System.out.println(case1.toString());
        System.out.println(case2.toString());

    }
    @Test
    public void caseTestCouleur(){
        Case caseOccupee = new Case();
        caseOccupee.setEstOccupee(true);
        caseOccupee.setCouleurDeLaPiece('R');
        assertEquals('R', caseOccupee.getCouleurDeLaPiece());

    }
    @Test
    public void testGetSpot() {
        Case caseInstance = new Case(true);
        assertTrue(caseInstance.getSpot());
    }
    @Test
    public void testIsCheminPossible() {
        Case caseInstance = new Case();
        caseInstance.setCheminPossible(true);
        assertTrue(caseInstance.isCheminPossible());
    }
    @Test
    public void testGetNumeroChemin() {
        Case caseInstance = new Case();
        caseInstance.setNumeroChemin(1, Case.directions.Horizontal);
        caseInstance.setNumeroChemin(2, Case.directions.Vertical);
        int[] expected = {1, 2, 0}; // Last element should be 0 as it's not set
        assertArrayEquals(expected, caseInstance.getNumeroChemin());
    }
    @Test
    public void testSetNumero() {
        Case caseInstance = new Case();
        caseInstance.setCheminPossible(true);
        caseInstance.setNumero(1, Case.directions.Horizontal, 0);
        assertEquals(1, caseInstance.getNumeroChemin()[0]);
        assertEquals(Case.directions.Horizontal, caseInstance.getDirections()[0]);
    }
    @Test
    public void testGetDirections() {
        Case caseInstance = new Case();
        caseInstance.setNumeroChemin(1, Case.directions.Horizontal);
        caseInstance.setNumeroChemin(2, Case.directions.Vertical);
        assertArrayEquals(new Case.directions[]{Case.directions.Horizontal, Case.directions.Vertical, Case.directions.NULL}, caseInstance.getDirections());
    }
}
