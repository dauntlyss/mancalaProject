package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class GameTestWhenPlay {
	
	/**
	 * Test method for Game classes play() method.
	 */
	@Test
	public void testWhenComputerPlaysTurnThenBecomesHumansTurn() {
		Game newGame = new Game();
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer, 1);
		
		newGame.play(6);
		assertEquals("Human", newGame.getCurrentPlayer().getName());
	}
	
	/**
	 * Test method for Game classes play() method.
	 */
	@Test
	public void testWhenHumanPlaysTurnPitSelectedBecomesEmpty() {
		Game newGame = new Game();
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa", newGame);
		newGame.startNewGame(realHumanPlayer, 1);
		
		newGame.play(0);
		assertEquals(0, newGame.getStones(0));
	}
	
	/**
	 * Test method for Game classes play() method.
	 */
	@Test
	public void testWhenGameOverCurrentPlayerIsNull() {
		Game newGame = new Game();
		HumanPlayer simpleHuman = newGame.getHumanPlayer();
		
		newGame.startNewGame(simpleHuman, 1);
		newGame.play(2);
		newGame.play(1);
		newGame.play(6);
		newGame.play(5);
		
		assertEquals(null, newGame.getCurrentPlayer());
	}
}
