package edu.westga.cs6910.mancala.model.strategies;

/**
 * Implements the game-play strategy that has the player randomly
 * chose a pit to play from.
 *
 * @author Alyssa Harris
 * @version Jun 18, 2022
 */
public class RandomStrategy implements SelectStrategy {

	@Override
	public int selectPit(int[] gameBoard) {
		int min = gameBoard.length / 2;
		int max = gameBoard.length - 2;
		int range = max - min + 1;
		
		int pitChoice = (int) (Math.random() * range) + min;
		
		while (gameBoard[pitChoice] == 0) {
			pitChoice = (int) (Math.random() * range) + min;
		}
		
		return pitChoice;
	}

}
