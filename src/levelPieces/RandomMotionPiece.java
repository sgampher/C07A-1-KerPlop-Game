package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public abstract class RandomMotionPiece extends GamePiece implements Moveable {

	
	public RandomMotionPiece(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	public void move(Drawable[] gameBoard, int playerLocation) {
		//Reset the old position
		gameBoard[this.getLocation()] = null;
		
		//generate a new position
		Random rand = new Random();
		int newLocation = rand.nextInt(GameEngine.BOARD_SIZE);
		
		//Randomly probe locations on the board until an empty one is found,
		//there should always be an empty spot on board
		while (gameBoard[newLocation] != null) {			
			newLocation = rand.nextInt(GameEngine.BOARD_SIZE);
		}
		
		gameBoard[newLocation] = this;
		this.setLocation(newLocation);
	}
}
