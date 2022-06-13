package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.Game;

/**
 * Test to confirm the game class is working as expected.
 * 
 * @author Alyssa Harris	
 * @version 06/13/2022
 *
 */

public class GameTestWhenGetBoardSize {
	
	/**
	 * Test method for Game classes getBoardSize() method returns the proper board size.
	 */
	@Test
	public void testGetBoardSizeIs8() {
		Game newGame = new Game();
		assertEquals(8, newGame.getBoardSize());
	}

}
