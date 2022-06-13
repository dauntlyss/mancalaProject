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
public class GameTestWhenGetComputerPlayer {

	/**
	 * Test method for getComputerPlayer() method.
	 */
	@Test
	public void testGetComputerPlayerWillGetComputerPlayer() {
		Game newGame = new Game();
		assertEquals("Simple computer", newGame.getComputerPlayer().getName());
	}

}
