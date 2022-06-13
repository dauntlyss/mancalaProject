package edu.westga.cs6910.mancala.test.humanPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.HumanPlayer;
import edu.westga.cs6910.mancala.model.Game;

/**
 * Test to ensure the humanPlayer object is working correctly.
 *
 * @author Alyssa Harris
 * @version Jun 13, 2022
 */
public class HumanPlayerTestWhenCreateHumanPlayer {

	/**
	 * Test method for humanPlayer constructor.
	 */
	@Test
	public void testHumanPlayerConstructorCreatesNewHumanPlayer() {
		Game newGame = new Game();
		HumanPlayer somePlayer = new HumanPlayer("Alyssa", newGame);
		assertEquals("Alyssa", somePlayer.getName());
	}

}
