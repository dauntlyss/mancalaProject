package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;

/**
 * Test to confirm the game class is working as expected.
 *
 * @author Alyssa Harris
 * @version Jun 13, 2022
 */
public class GameTestWhenGetStones {

	/**
	 * Test method for testing the getStones(int) method, before the start of each game each pit amount can be retrieved and is 0.
	 */
	@Test
	public void testGetStonesBeforeStartWillReturnZeroStonesPerPit() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(0));
	}
	
	/**
	 * Test method for testing the getStones(int) method, test that at the start of each game each pit amount can be retrieved and is 1.
	 */
	@Test
	public void testGetStonesAtStartWillReturnOneStonePerPitOnHumanSide() {
		Game newGame = new Game();
		HumanPlayer simpleHuman = newGame.getHumanPlayer();
		
		newGame.startNewGame(simpleHuman);
		
		for (int pitNumber = 0; pitNumber < 3; pitNumber++) {
			if (newGame.getStones(pitNumber) != 1) {
				fail("Number of stones in " + pitNumber + "is " + newGame.getStones(pitNumber));
			}
		}
		
	}

	/**
	 * Test method for testing the getStones(int) method, test that at the start of each game each pit amount can be retrieved and is 1.
	 */
	@Test
	public void testGetStonesAtStartWillReturnOneStonePerPitOnComputerSide() {
		Game newGame = new Game();
		HumanPlayer simpleHuman = newGame.getHumanPlayer();
		
		newGame.startNewGame(simpleHuman);
		
		for (int pitNumber = 4; pitNumber < 7; pitNumber++) {
			if (newGame.getStones(pitNumber) != 1) {
				fail("Number of stones in " + pitNumber + " is " + newGame.getStones(pitNumber));
			}
		}
		
	}
	
	/**
	 * Test method for Game classes getStones() method, test that at the start of each game each store amount can be retrieved and is 0.
	 */
	@Test
	public void testStartNewGameWillStartNewGameWithComputerStoresHavingZeroStones() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer);
		
		assertEquals(0, newGame.getStones(7));
	}
	
	/**
	 * Test method for Game classes getStones() method, test that at the start of each game each store amount can be retrieved and is 0.
	 */
	@Test
	public void testStartNewGameWillStartNewGameWithHumanStoresHavingZeroStones() {
		Game newGame = new Game();
		HumanPlayer simpleHuman = newGame.getHumanPlayer();
		
		newGame.startNewGame(simpleHuman);
		
		assertEquals(0, newGame.getStones(3));
	}
	
	/**
	 * Test method Game classes getStones() method, tests error handling.
	 */
	@Test
	public void testDistributeStonesFromThrowsProperErrorIfNegativePitNumberIsPassed() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer);
		
		try {
	        newGame.getStones(-1);     
	        fail();
	    } catch (IllegalArgumentException ex) {
	        assertEquals("Pit number cannot be negative", ex.getMessage());
	    }
		
	}
	
}
