package edu.westga.cs6910.mancala.test.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;

/**
 * Test to ensure the computerPlayer object is working correctly.
 * 
 * @author Alyssa Harris
 * @version Jun 13, 2022
 */
public class ComputerPlayerTestWhenCreateComputerPlayer {

	/**
	 * Test method for computerPlayer constructor.
	 */
	@Test
	public void testComputerPlayerConstructorCreatesNewComputerPlayer() {
		Game newGame = new Game();
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		assertEquals("Simple computer", simpleComputer.getName());
	}

}
