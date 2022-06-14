package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;

/**
 * Test to confirm the game class is working as expected.
 *
 * @author Alyssa Harris
 * @version Jun 13, 2022
 */
public class GameTestWhenPlay {

	/**
	 * Test method for play(int), testing that current player switches as expected.
	 */
	@Test
	public void testWhenHumanPlaysTurnThenBecomesComputersTurn() {
		Game newGame = new Game();
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa", newGame);
		newGame.startNewGame(realHumanPlayer);
		
		newGame.play(0);
		newGame.play(1);
		assertEquals("Simple computer", newGame.getCurrentPlayer().getName());
	}
	
	/**
	 * Test method for play(int), testing that current player switches as expected.
	 */
	@Test
	public void testWhenHumanPlaysTurnPitSelectedBecomesEmpty() {
		Game newGame = new Game();
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa", newGame);
		newGame.startNewGame(realHumanPlayer);
		
		newGame.play(0);
		assertEquals(0, newGame.getStones(0));
	}

}
