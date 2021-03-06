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
public class GameTestWhenGetCurrentPlayer {

	/**
	 * Test method for Game classes getCurrentPlayer() to see if it returns the expected player object.
	 */
	@Test
	public void testGetCurrentPlayerShouldBeComputerWhenNewGameStartedWithComputerFirst() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer, 1);
		assertEquals(simpleComputer, newGame.getCurrentPlayer());
	}
	
	/**
	 * Test method for Game classes getCurrentPlayer() to see if it returns the expected player object.
	 */
	@Test
	public void testGetCurrentPlayerShouldBeHumanWhenNewGameStartedWithHumanFirst() {
		Game newGame = new Game();
		
		HumanPlayer simpleHuman = new HumanPlayer("Alyssa", newGame);
		newGame.startNewGame(simpleHuman, 1);
		assertEquals(simpleHuman, newGame.getCurrentPlayer());
	}
	
	/**
	 * Test method for Game classes getCurrentPlayer() to see if it returns the expected player object.
	 */
	@Test
	public void testGetCurrentPlayerShouldBeSameasStartingPlayerAfterOddNumberOfRounds() {
		Game newGame = new Game();
		
		HumanPlayer simpleHuman = newGame.getHumanPlayer();
		
		newGame.startNewGame(simpleHuman, 1);
		newGame.play(0);
		newGame.play(5);
		newGame.play(2);
		
		assertEquals(simpleHuman, newGame.getCurrentPlayer());
	}
}
