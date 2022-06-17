package edu.westga.cs6910.mancala.model.strategies;

/**
 * Implements the game-play strategy that always selects the nearest
 * pit that has stones.
 *
 * @author Alyssa Harris
 * @version Jun 17, 2022
 */
public class NearStrategy implements SelectStrategy {
	
	@Override
	public int selectPit(int[] gameBoard) {
		int pitChoice = gameBoard.length - 2;
		
		while (gameBoard[pitChoice] == 0) {
			pitChoice--;
		}
		
		return pitChoice;
	}
}
