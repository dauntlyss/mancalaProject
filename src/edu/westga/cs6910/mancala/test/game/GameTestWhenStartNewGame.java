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
public class GameTestWhenStartNewGame {
	
	/**
	 * Test method for Game classes startNewGame() method with ComputerPlayer having the first turn.
	 */
	@Test
	public void testStartNewGameWillStartNewGameWithComputerFirst() {
		Game newGame = new Game();
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer, 1);
		assertEquals(simpleComputer, newGame.getCurrentPlayer());
		
	}
	
	/**
	 * Test method for Game classes startNewGame() method with HumanPlayer having the first turn.
	 */
	@Test
	public void testStartNewGameWillStartNewGameWithHumanFirst() {
		Game newGame = new Game();
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa", newGame);
		newGame.startNewGame(realHumanPlayer, 1);
		assertEquals(realHumanPlayer, newGame.getCurrentPlayer());
		
	}

}
