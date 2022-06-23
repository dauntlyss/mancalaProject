package edu.westga.cs6910.mancala.test.humanPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.HumanPlayer;
import edu.westga.cs6910.mancala.model.Game;

/**
 * Test to ensure the humanPlayer object is working correctly.
 *
 * @author Alyssa Harris
 * @version Jun 14, 2022
 */
public class HumanPlayerTestWhenTakeTurn {

	/**
	 * Test method for takeTurn(int).
	 */
	@Test
	public void testTakeTurnMethodTakesFromDesignatedPit() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Alyssa", newGame);
		newGame.startNewGame(human, 1);
		human.takeTurn(0);
		int[] gameBoard = newGame.getGameBoard();
		
		assertEquals(0, gameBoard[0]);
	}
	
	/**
	 * Test method for takeTurn method.
	 */
	@Test
	public void testTakeTurnMethodAfterHumanTakesTurnIsMyTurnIsSetToFalse() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Alyssa", newGame);
		newGame.startNewGame(human, 1);
		human.takeTurn(0);
		
		assertEquals(false, human.getIsMyTurn());
	}

}
