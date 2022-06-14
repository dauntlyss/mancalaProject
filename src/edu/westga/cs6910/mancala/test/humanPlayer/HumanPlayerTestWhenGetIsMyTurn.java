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
public class HumanPlayerTestWhenGetIsMyTurn {

	/**
	 * Test method for getIsMyTurn() for humanPlayer object.
	 */
	@Test
	public void testGetIsMyTurnIsFalseBeforeGameStarts() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Human", newGame);
		
		assertEquals(false, human.getIsMyTurn());
	}
	
	/**
	 * Test method for getIsMyTurn method.
	 */
	@Test
	public void testGetIsMyTurnIsFalseWhenHumansTurn() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Human", newGame);
		newGame.startNewGame(newGame.getHumanPlayer());
		
		assertEquals(false, human.getIsMyTurn());
	}

}
