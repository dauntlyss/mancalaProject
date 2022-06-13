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
public class GameTestWhenGetIsGameOver {

	/**
	 * Test method for getIsGameOver() testing if game starts and pits become empty game will be over.
	 */
	@Test
	public void testGetIsGameOverWhenGameIsOver() {
		Game newGame = new Game();
		HumanPlayer simpleHuman = newGame.getHumanPlayer();
		
		newGame.startNewGame(simpleHuman);
		for (int pitNumber = 0; pitNumber < 8; pitNumber++) {
			if (pitNumber != 3 || pitNumber != 7) {
				newGame.play(pitNumber);
			}
		}
		
		assertEquals(true, newGame.getIsGameOver());
	}
	
	/**
	 * Test method for getIsGameOver() testing game should not be over before game starts.
	 */
	@Test
	public void testBeforeGameStartsIsNotOver() {
		Game newGame = new Game();
		HumanPlayer simpleHuman = newGame.getHumanPlayer();
		
		newGame.startNewGame(simpleHuman);
				
		assertEquals(false, newGame.getIsGameOver());
	}
	
}
