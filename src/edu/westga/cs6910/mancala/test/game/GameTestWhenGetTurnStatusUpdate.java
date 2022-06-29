package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.strategies.FarStrategy;

/**
 * Test to confirm the game class is working as expected.
 *
 * @author Alyssa Harris
 * @version Jun 28, 2022
 */
public class GameTestWhenGetTurnStatusUpdate {

	/**
	 * Test method for getTurnStatusUpdate() method, tests that proper turnStatus message is generated.
	 */
	@Test
	public void testPlayFromOccupiedPitToOccupiedPitGeneratesNoTurnStatusMessage() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer(), 3);
		
		newGame.play(0);
		assertEquals("", newGame.getTurnStatusUpdate());
	}
	
	/**
	 * Test method for getTurnStatusUpdate() method, tests that proper turnStatus message is generated.
	 */
	@Test
	public void testWhenHumanPlayLandsInStoreGeneratesExtraTurnForHumanStatusMessage() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer(), 1);
		
		newGame.play(2);
		assertEquals("Human gets a free turn for landing in the store!", newGame.getTurnStatusUpdate());
	}
	
	/**
	 * Test method for getTurnStatusUpdate() method, tests that proper turnStatus message is generated.
	 */
	@Test
	public void testWhenComputerPlayLandsInStoreGeneratesExtraTurnForComputerStatusMessage() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getComputerPlayer(), 1);
		
		newGame.play(6);
		assertEquals("Simple computer gets a free turn for landing in the store!", newGame.getTurnStatusUpdate());
	}
	
	/**
	 * Test method for getTurnStatusUpdate() method, tests that proper turnStatus message is generated.
	 */
	@Test
	public void testWhenComputerPlayLandsInEmptyPit6GeneratesCaptureMessageForComputerAtPit0() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getComputerPlayer(), 7);
		
		newGame.play(6);
		assertEquals("Simple computer captured all the stones in pit 0!", newGame.getTurnStatusUpdate());
	}
	
	/**
	 * Test method for getTurnStatusUpdate() method, tests that proper turnStatus message is generated.
	 */
	@Test
	public void testWhenComputerPlayLandsInEmptyPit4GeneratesCaptureMessageForComputerAtPit2() {
		Game newGame = new Game();

		newGame.startNewGame(newGame.getComputerPlayer(), 7);
		newGame.getComputerPlayer().setStrategy(new FarStrategy());
		newGame.play(4);
		assertEquals("Simple computer captured all the stones in pit 2!", newGame.getTurnStatusUpdate());
	}
	
	/**
	 * Test method for getTurnStatusUpdate() method, tests that proper turnStatus message is generated.
	 */
	@Test
	public void testWhenHumanPlayLandsInEmptyPit0GeneratesCaptureMessageForHumanAtPit6() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer(), 7);
		
		newGame.play(0);
		assertEquals("Human captured all the stones in pit 6!", newGame.getTurnStatusUpdate());
	}
	
	/**
	 * Test method for getTurnStatusUpdate() method, tests that proper turnStatus message is generated.
	 */
	@Test
	public void testWhenHumanPlayLandsInEmptyPit2GeneratesCaptureMessageForComputerAtPit4() {
		Game newGame = new Game();

		newGame.startNewGame(newGame.getHumanPlayer(), 7);
		newGame.play(2);
		assertEquals("Human captured all the stones in pit 4!", newGame.getTurnStatusUpdate());
	}

}
