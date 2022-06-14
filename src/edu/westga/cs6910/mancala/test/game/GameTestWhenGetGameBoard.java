package edu.westga.cs6910.mancala.test.game;

import static org.junit.Assert.assertArrayEquals;

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
	 * Test method for getGameBoard method, testing it returns the gameBoard ready to play.
	 */
	@Test
	public void testGetGameBoardAtStartReturnsGameBoardReadyToPlay() {
		Game newGame = new Game();
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa", newGame);
		newGame.startNewGame(realHumanPlayer);
		
		int[] gameBoard = {1, 1, 1, 0, 1, 1, 1, 0};
		assertArrayEquals(gameBoard, newGame.getGameBoard());
	}
	
	/**
	 * Test method for getGameBoard method, testing it returns the gameBoard empty before the game starts.
	 */
	@Test
	public void testGetGameBoardBeforeStartReturnsEmptyGameBoard() {
		Game newGame = new Game();
		
		int[] gameBoard = {0, 0, 0, 0, 0, 0, 0, 0};
		assertArrayEquals(gameBoard, newGame.getGameBoard());
	}
	
	/**
	 * Test method for getGameBoard method, testing it returns an updated gameBoard when a play is made.
	 */
	@Test
	public void testGetGameBoardReturnsAccurateGameBoardAfterPlay() {
		Game newGame = new Game();
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa", newGame);
		newGame.startNewGame(realHumanPlayer);
		
		newGame.play(0);
		newGame.play(1);
		int[] gameBoard = {0, 0, 2, 1, 1, 1, 1, 0};
		assertArrayEquals(gameBoard, newGame.getGameBoard());
	}

}
