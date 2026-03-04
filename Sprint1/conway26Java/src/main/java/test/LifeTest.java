package main.java.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.conway.domain.Life;
import main.java.conway.domain.LifeInterface;
import main.java.conway.domain.ICell;

public class LifeTest {

    private LifeInterface life;

    @Before
    public void setup() {
        System.out.println("LifeTest | setup");
        life = Life.CreateLife(3, 3); // piccola griglia 3x3
    }

    @After
    public void down() {
        System.out.println("LifeTest | down");
    }

    @Test
    public void testCellInitialDead() {
        System.out.println("LifeTest | testCellInitialDead");
        // tutte le celle devono inizialmente essere morte
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                assertTrue(!life.isAlive(r, c));
            }
        }
    }

    @Test
    public void testSetCellAlive() {
        System.out.println("LifeTest | testSetCellAlive");
        life.setCell(1, 1, true);
        assertTrue(life.isAlive(1, 1));
    }

    @Test
    public void testResetGrids() {
        System.out.println("LifeTest | testResetGrids");
        life.setCell(1, 1, true);
        life.resetGrids();
        assertTrue(!life.isAlive(1, 1));
    }
}