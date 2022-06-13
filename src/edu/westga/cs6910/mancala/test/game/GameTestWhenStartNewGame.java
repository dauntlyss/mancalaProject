package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;

/**
 * Test to confirm the game class is working as expected.
 * 
 * @author Alyssa Harris
 * @version Jun 13, 2022
 */
public class GameTestWhenStartNewGame {
	
	/**
	 * Test method for Game classes startNewGame() method with ComputerPlayer having the first turn.
	 */
	@Test
	public void testStartNewGameWillStartNewGameWithComputerFirst() {
		Game newGame = new Game();
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer);
		assertEquals(simpleComputer, newGame.getCurrentPlayer());
		
	}
	
	/**
	 * Test method for Game classes startNewGame() method with HumanPlayer having the first turn.
	 */
	@Test
	public void testStartNewGameWillStartNewGameWithHumanFirst() {
		Game newGame = new Game();
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa", newGame);
		newGame.startNewGame(realHumanPlayer);
		assertEquals(realHumanPlayer, newGame.getCurrentPlayer());
		
	}
	
	/**
	 * Test method for Game classes startNewGame() method, tests that at the start of the game each pit has one stone each.
	 */
	@Test
	public void testStartNewGameWillStartNewGameWithAllPitsHavingOneStoneEach() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer);
		
		for (int pitNumber = 0; pitNumber < 7; pitNumber++) {
			if (pitNumber != 3) {
				assertEquals(1, newGame.getStones(pitNumber));
			}
		}
	}
	
	/**
	 * Test method for Game classes startNewGame() method, test that at the start of each game each store is empty.
	 */
	@Test
	public void testStartNewGameWillStartNewGameWithAllStoresHavingZeroStonesEach() {
		Game newGame = new Game();
		
		ComputerPlayer simpleComputer = new ComputerPlayer(newGame);
		newGame.startNewGame(simpleComputer);
		
		for (int pitNumber = 0; pitNumber <= 7; pitNumber++) {
			if (pitNumber == 3 || pitNumber == 7) {
				assertEquals(0, newGame.getStones(pitNumber));
			}
		}
	}

}
