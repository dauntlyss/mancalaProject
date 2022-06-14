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
public class GameTestWhenGetGameBoard {

	/**
	 * Test method for getGameBoard method, testing it returns the gameBoard.
	 */
	@Test
	public void testGetGameBoardReturnsGameBoard() {
		Game newGame = new Game();
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa", newGame);
		newGame.startNewGame(realHumanPlayer);
		
		int[] gameBoard = {1, 1, 1, 0, 1, 1, 1,0};
		assertEquals(gameBoard, newGame.getGameBoard());
	}

}
