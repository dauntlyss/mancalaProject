package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;

/**
 * Test to confirm the game class is working as expected.
 * 
 * @author Alyssa Harris
 * @version Jun 13, 2022
 */
public class GameTestWhenStartNewGame {
	
	/**
	 * Test method for Game classes startNewGame() method.
	 */
	@Test
	public void testStartNewGameWillStartNewGameWithComputerFirst() {
		Game newGame = new Game();
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer);
		assertEquals(simpleComputer, newGame.getCurrentPlayer());
		
	}

}
