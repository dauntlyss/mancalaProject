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
public class GameTestWhenCreateGame {

	/**
	 * Test method for Game classes constructor method.
	 */
	@Test
	public void testShouldProduceGameWithNoScore() {
		Game newGame = new Game();
		assertEquals("Human: 0" + System.getProperty("line.separator") + 
				"Simple computer: 0" + System.getProperty("line.separator"), newGame.toString());
	}
	
	/**
	 * Test method for Game classes constructor method and tests game board size at creation.
	 */
	@Test
	public void testNewGameShouldHaveBoardSize8() {
		Game newGame = new Game();
		assertEquals(8, newGame.getBoardSize());
	}
}
