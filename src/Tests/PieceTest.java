package Tests;

import Plateau.Piece;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PieceTest {
    @Test
    public void pieceTestGetterSetterConstructeur(){
        Piece p1 = new Piece('R', 0, 1, 0, 2);
        assertEquals('R', p1.getCouleur());
        int[] verifp1 = new int[2];
        verifp1[0] = 0; verifp1[1] = 1;
        int[] verifp2 = new int[2];
        verifp2[0] = 0; verifp2[1] = 2;
        assertEquals(verifp1[0], p1.getPos1()[0]);
        assertEquals(verifp1[1], p1.getPos1()[1]);
        assertEquals(verifp2[0], p1.getPos2()[0]);
        assertEquals(verifp2[1], p1.getPos2()[1]);
        Piece p2 = new Piece('B', 1, 1, 1, 2);
        assertEquals('B', p2.getCouleur());
        int[] verifp3 = new int[2];
        verifp3[0] = 1; verifp3[1] = 1;
        int[] verifp4 = new int[2];
        verifp4[0] = 1; verifp4[1] = 2;
        assertEquals(verifp3[0], p2.getPos1()[0]);
        assertEquals(verifp3[1], p2.getPos1()[1]);
        assertEquals(verifp4[0], p2.getPos2()[0]);
        assertEquals(verifp4[1], p2.getPos2()[1]);

        int[] verifp5 = new int[2];
        verifp5[0] = 0; verifp5[1] = 1;
        int[] verifp6 = new int[2];
        verifp6[0] = 1; verifp6[1] = 0;
        Assert.assertNotEquals(verifp5[0], p2.getPos1()[0]);
        assertEquals(verifp5[1], p2.getPos1()[1]);
        assertEquals(verifp6[0], p2.getPos2()[0]);
        Assert.assertNotEquals(verifp6[1], p2.getPos2()[1]);

        p2.setPos1(verifp5);
        p2.setPos2(verifp6);
        assertEquals(verifp5[0], p2.getPos1()[0]);
        assertEquals(verifp5[1], p2.getPos1()[1]);
        assertEquals(verifp6[0], p2.getPos2()[0]);
        assertEquals(verifp6[1], p2.getPos2()[1]);
    }
    @Test
    public void testGetCouleur() {
        Piece piece = new Piece('R', 0, 1, 0, 2);
        assertEquals('R', piece.getCouleur());
    }
    @Test
    public void testGetPos1() {
        Piece piece = new Piece('R', 0, 1, 0, 2);
        int[] expectedPos1 = {0, 1};
        assertArrayEquals(expectedPos1, piece.getPos1());
    }
    @Test
    public void testGetPos2() {
        Piece piece = new Piece('R', 0, 1, 0, 2);
        int[] expectedPos2 = {0, 2};
        assertArrayEquals(expectedPos2, piece.getPos2());
    }
    @Test
    public void testSetPos1() {
        Piece piece = new Piece('R', 0, 1, 0, 2);
        int[] newPos1 = {1, 1};
        piece.setPos1(newPos1);
        assertArrayEquals(newPos1, piece.getPos1());
    }
    @Test
    public void testSetPos2() {
        Piece piece = new Piece('R', 0, 1, 0, 2);
        int[] newPos2 = {1, 2};
        piece.setPos2(newPos2);
        assertArrayEquals(newPos2, piece.getPos2());
    }
}
