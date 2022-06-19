package edu.westga.cs6910.mancala.test.farStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.strategies.FarStrategy;

/**
 * Tests to confirm the Far Strategy subclass is working correctly.
 *
 * @author Alyssa Harris
 * @version Jun 18, 2022
 */
public class FarStrategyTestWhenEmployFarStrategy {

	/**
	 * Test method for selectPit(int[]).
	 */
	@Test
	public void testSelectPitMethodWillReturn4ForNewGame() {
		Game theGame = new Game();
		FarStrategy farStrategy = new FarStrategy();
		ComputerPlayer computerPlayer = new ComputerPlayer(theGame);
		theGame.startNewGame(computerPlayer);

		assertEquals(4, farStrategy.selectPit(theGame.getGameBoard()));
	}
	
	/**
	 * Test method for selectPit(int[]).
	 */
	@Test
	public void testSelectPitMethodWillReturn5If4IsEmpty() {
		Game theGame = new Game();
		FarStrategy farStrategy = new FarStrategy();
		ComputerPlayer computerPlayer = new ComputerPlayer(theGame);
		theGame.startNewGame(computerPlayer);
		computerPlayer.takeTurn(4);

		assertEquals(5, farStrategy.selectPit(theGame.getGameBoard()));
	}
	
	/**
	 * Test method for selectPit(int[]).
	 */
	@Test
	public void testSelectPitMethodWillReturn6If4And5AreEmpty() {
		Game theGame = new Game();
		FarStrategy farStrategy = new FarStrategy();
		ComputerPlayer computerPlayer = new ComputerPlayer(theGame);
		theGame.startNewGame(computerPlayer);
		computerPlayer.takeTurn(4);
		computerPlayer.takeTurn(5);

		assertEquals(6, farStrategy.selectPit(theGame.getGameBoard()));
	}

}