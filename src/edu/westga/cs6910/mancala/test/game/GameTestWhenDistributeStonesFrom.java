package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;

/**
 * Test to confirm the game class is working as expected.
 *
 * @author Alyssa Harris
 * @version Jun 13, 2022
 */
public class GameTestWhenDistributeStonesFrom {

	/**
	 * Test method for distributeStonesFrom(int) method.
	 */
	@Test
	public void testDistributeStonesFromDistributesStonesFromPit0ToPit1() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer);
		
		newGame.distributeStonesFrom(0);
		assertEquals(2, newGame.getStones(1));
		
	}
	
	/**
	 * Test method for distributeStonesFrom(int) method.
	 */
	@Test
	public void testDistributeStonesFromDistributesStonesFromPit2ToStore() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer);
		
		newGame.distributeStonesFrom(2);
		assertEquals(1, newGame.getStones(3));
		
	}
	
	/**
	 * Test method for distributeStonesFrom(int) method.
	 */
	@Test
	public void testDistributeStonesFromDistributesStonesFromPit2ToStorse() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer);
		
		newGame.distributeStonesFrom(2);
		assertEquals(1, newGame.getStones(3));
		
	}

}
