package edu.westga.cs6910.mancala.model.strategies;

/**
 * SelectStrategy defines the interface for all the game-play algorithms 
 * for the computer Mancala player.
 *
 * @author Alyssa Harris
 * @version Jun 16, 2022
 */
public interface SelectStrategy {
	/**
	 * Used to select the play strategy. Returns the pit number selected
	 * @param gameBoard	An array of ints
	 * 
	 * @return the pit number selected
	 */
	int selectPit(int[] gameBoard);
}
