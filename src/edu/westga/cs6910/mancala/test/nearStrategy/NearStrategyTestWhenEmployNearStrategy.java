package edu.westga.cs6910.mancala.test.nearStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.strategies.NearStrategy;

/**
 * Tests to confirm the Near Strategy subclass is working correctly.
 *
 * @author Alyssa Harris
 * @version Jun 17, 2022
 */
public class NearStrategyTestWhenEmployNearStrategy {

	/**
	 * Test method for selectPit(int[]).
	 */
	@Test
	public void testSelectPitMethodWillReturn6ForNewGame() {
		Game theGame = new Game();
		NearStrategy nearStrategy = new NearStrategy();
		ComputerPlayer computerPlayer = new ComputerPlayer(theGame);
		theGame.startNewGame(computerPlayer, 1);

		assertEquals(6, nearStrategy.selectPit(theGame.getGameBoard()));
	}
	
	/**
	 * Test method for selectPit(int[]).
	 */
	@Test
	public void testSelectPitMethodWillReturn5If6IsEmpty() {
		Game theGame = new Game();
		NearStrategy nearStrategy = new NearStrategy();
		ComputerPlayer computerPlayer = new ComputerPlayer(theGame);
		theGame.startNewGame(computerPlayer, 1);
		computerPlayer.takeTurn(6);

		assertEquals(5, nearStrategy.selectPit(theGame.getGameBoard()));
	}
	
	/**
	 * Test method for selectPit(int[]).
	 */
	@Test
	public void testSelectPitMethodWillReturn4If5And6AreEmpty() {
		Game theGame = new Game();
		NearStrategy nearStrategy = new NearStrategy();
		ComputerPlayer computerPlayer = new ComputerPlayer(theGame);
		theGame.startNewGame(computerPlayer, 1);
		computerPlayer.takeTurn(6);
		computerPlayer.takeTurn(5);
		computerPlayer.takeTurn(6);

		assertEquals(4, nearStrategy.selectPit(theGame.getGameBoard()));
	}

}
