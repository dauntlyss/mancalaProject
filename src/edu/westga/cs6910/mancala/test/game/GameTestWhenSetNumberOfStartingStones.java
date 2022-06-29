package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.Game;

/**
 * Test to confirm the game class is working as expected.
 *
 * @author Alyssa Harris
 * @version Jun 28, 2022
 */
public class GameTestWhenSetNumberOfStartingStones {

	/**
	 * Test method for setNumberOfStartingStones(int).
	 */
	@Test
	public void testWhenSetNumberOfStartingStonesTo1NumberOfStartingStonesIs1() {
		Game newGame = new Game();
		newGame.setNumberOfStartingStones(1);

		assertEquals(1, newGame.getNumberOfStartingStones());
	}
	
	/**
	 * Test method for setNumberOfStartingStones(int) method, tests error handling.
	 */
	@Test
	public void testSetNumberOfStartingStonesThrowsProperErrorIfNegativeNumberIsPassed() {
		Game newGame = new Game();
		
		try {
			newGame.setNumberOfStartingStones(-1);     
	        fail();
	    } catch (IllegalArgumentException ex) {
	        assertEquals("Please enter a valid number.", ex.getMessage());
	    }
	}

}
