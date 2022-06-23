package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;

/**
 * Test to confirm the game class is working as expected.
 *
 * @author Alyssa Harris
 * @version Jun 13, 2022
 */
public class GameTestWhenDistributeStonesFrom {

	/**
	 * Test method for distributeStonesFrom(int) method.
	 */
	@Test
	public void testDistributeStonesFromDistributesStonesFromPit0ToPit1() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer, 1);
		
		newGame.distributeStonesFrom(0);
		assertEquals(2, newGame.getStones(1));
		
	}
	
	/**
	 * Test method for distributeStonesFrom(int) method, tests that stones go from pit 2 to store.
	 */
	@Test
	public void testDistributeStonesFromDistributesStonesFromPit2ToStore() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer, 1);
		
		newGame.distributeStonesFrom(2);
		assertEquals(1, newGame.getStones(3));
		
	}
	
	/**
	 * Test method for distributeStonesFrom(int) method, tests that 2 accumulated stones go from pit 2 to pit 4.
	 */
	@Test
	public void testDistributeStonesFromDistributes2StonesFromPit2IntoStoreAndPit4() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer, 1);
		
		newGame.distributeStonesFrom(1);
		newGame.distributeStonesFrom(2);
		assertEquals(2, newGame.getStones(4));
		
	}
	
	/**
	 * Test method for distributeStonesFrom(int) method, tests that stones go from pit 6 to store.
	 */
	@Test
	public void testDistributeStonesFromDistributesStonesFromPit6ToStore() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer, 1);
		
		newGame.distributeStonesFrom(6);
		assertEquals(1, newGame.getStones(7));
		
	}
	
	/**
	 * Test method for distributeStonesFrom(int) method, tests that 2 accumulated stones go from pit 6 to pit 0.
	 */
	@Test
	public void testDistributeStonesFromDistributes2StonesFromPit6IntoStoreAndPit0() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer, 1);
		
		newGame.distributeStonesFrom(5);
		newGame.distributeStonesFrom(6);
		assertEquals(2, newGame.getStones(0));
		
	}
	
	/**
	 * Test method for distributeStonesFrom(int) method, tests that when stones are distributed from a pit the pit is left empty.
	 */
	@Test
	public void testDistributeStonesFromDistributesStonesFromPit0AndLeavesPitEmpty() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer, 1);
		
		newGame.distributeStonesFrom(0);
		assertEquals(0, newGame.getStones(0));
		
	}
	
	/**
	 * Test method for distributeStonesFrom(int) method, tests error handling.
	 */
	@Test
	public void testDistributeStonesFromThrowsProperErrorIfNegativePitNumberIsPassed() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer, 1);
		
		try {
	        newGame.distributeStonesFrom(-1);     
	        fail();
	    } catch (IllegalArgumentException ex) {
	        assertEquals("Pit number cannot be negative", ex.getMessage());
	    }
	}
}
