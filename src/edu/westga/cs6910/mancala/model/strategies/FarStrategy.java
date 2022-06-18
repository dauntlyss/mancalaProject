package edu.westga.cs6910.mancala.model.strategies;

/**
 * Implements the game-play strategy that has the player always chose
 * the non-empty pit farthest away from the store.
 *
 * @author Alyssa Harris
 * @version Jun 18, 2022
 */
public class FarStrategy implements SelectStrategy {

	@Override
	public int selectPit(int[] gameBoard) {
		int pitChoice = gameBoard.length / 2;
		
		while (gameBoard[pitChoice] == 0) {
			pitChoice++;
		}
		
		return pitChoice;
	}

}
