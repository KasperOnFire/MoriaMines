/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moriamines;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brein
 */
public class GameControlTest {
    
    public GameControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getP method, of class GameControl.
     */
    @Test
    public void testGetP() {
        System.out.println("getP");
        GameControl instance = new GameControl();
        Player expResult = null;
        Player result = instance.getP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startGame method, of class GameControl.
     */
    @Test
    public void testStartGame() {
        System.out.println("startGame");
        GameControl instance = new GameControl();
        instance.startGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endGame method, of class GameControl.
     */
    @Test
    public void testEndGame() {
        System.out.println("endGame");
        GameControl instance = new GameControl();
        instance.endGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gameSetup method, of class GameControl.
     */
    @Test
    public void testGameSetup() {
        System.out.println("gameSetup");
        GameControl instance = new GameControl();
        instance.gameSetup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gameRun method, of class GameControl.
     */
    @Test
    public void testGameRun() {
        System.out.println("gameRun");
        GameControl instance = new GameControl();
        instance.gameRun();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMap method, of class GameControl.
     */
    @Test
    public void testCreateMap() {
        System.out.println("createMap");
        GameControl instance = new GameControl();
        instance.createMap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
