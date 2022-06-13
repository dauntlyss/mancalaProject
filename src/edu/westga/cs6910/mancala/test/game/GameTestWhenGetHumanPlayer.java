package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.Game;

/**
 * Test to confirm the game class is working as expected.
 *
 * @author Alyssa Harris
 * @version Jun 13, 2022
 */
public class GameTestWhenGetHumanPlayer {

	/**
	 * Test method for getHumanPlayer() to confirm correct functionality}.
	 */
	@Test
	public void testGetHumanPlayerWillGetHumanPlayer() {
		Game newGame = new Game();
		assertEquals("Human", newGame.getHumanPlayer().getName());
	}

}
