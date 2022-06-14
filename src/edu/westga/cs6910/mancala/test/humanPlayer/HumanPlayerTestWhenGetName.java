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
public class HumanPlayerTestWhenGetName {

	/**
	 * Test method for getName().
	 */
	@Test
	public void testGetNameWillReturnHumanPlayersName() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Alyssa", newGame);
		assertEquals("Alyssa", human.getName());
	}

}
