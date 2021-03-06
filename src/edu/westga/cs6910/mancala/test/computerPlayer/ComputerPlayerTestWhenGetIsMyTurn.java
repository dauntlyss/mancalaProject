package edu.westga.cs6910.mancala.test.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;

/**
 * Test to ensure the computerPlayer object is working correctly.
 *
 * @author Alyssa Harris
 * @version Jun 14, 2022
 */
public class ComputerPlayerTestWhenGetIsMyTurn {
	
	/**
	 * Test method for getIsMyTurn method.
	 */
	@Test
	public void testGetIsMyTurnIsFalseBeforeGameStarts() {
		Game newGame = new Game();
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		
		assertEquals(false, simpleComputer.getIsMyTurn());
	}
	
	/**
	 * Test method for getIsMyTurn method.
	 */
	@Test
	public void testGetIsMyTurnIsFalseWhenHumansTurn() {
		Game newGame = new Game();
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(newGame.getHumanPlayer(), 1);
		
		assertEquals(false, simpleComputer.getIsMyTurn());
	}

}
