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
public class ComputerPlayerTestWhenTakeTurn {
	
	/**
	 * Test method for takeTurn method.
	 */
	@Test
	public void testTakeTurnMethodTakesFromDesignatedPit() {
		Game newGame = new Game();
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer, 1);
		simpleComputer.takeTurn(6);
		int[] gameBoard = newGame.getGameBoard();
		
		assertEquals(0, gameBoard[6]);
	}
	
	/**
	 * Test method for takeTurn method.
	 */
	@Test
	public void testTakeTurnMethodAfterComputerTakesTurnIsMyTurnIsSetToFalse() {
		Game newGame = new Game();
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer, 1);
		simpleComputer.takeTurn(6);
		
		assertEquals(false, simpleComputer.getIsMyTurn());
	}

}
