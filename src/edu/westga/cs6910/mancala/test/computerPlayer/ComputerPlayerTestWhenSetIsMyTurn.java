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
public class ComputerPlayerTestWhenSetIsMyTurn {

	@Test
	public void testSetIsMyTurnWhenCalledForComputerSetsComputersTurnToTrue() {
		Game newGame = new Game();
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		simpleComputer.setIsMyTurn(true);
		
		assertEquals(true, simpleComputer.getIsMyTurn());
	}
	
	@Test
	public void testSetIsMyTurnWhenCalledForHumanSetsComputersTurnToFalse() {
		Game newGame = new Game();
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.getHumanPlayer().setIsMyTurn(true);
		
		assertEquals(false, simpleComputer.getIsMyTurn());
	}
	
	

}
