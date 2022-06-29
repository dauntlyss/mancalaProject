package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.Game;

/**
 * Test to confirm the game class is working as expected.
 *
 * @author Alyssa Harris
 * @version Jun 28, 2022
 */
public class GameTestWhenGetNumberOfStartingStones {

	/**
	 * Test method for getNumberOfStartingStones(int).
	 */
	@Test
	public void testGetNumberOfStartingStonesIsExpectedNumber() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer(), 3);

		assertEquals(3, newGame.getNumberOfStartingStones());
	}
}
