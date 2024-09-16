package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public abstract class RandomMotionPiece extends GamePiece implements Moveable {

	private Drawable randomPiece;
	
	public RandomMotionPiece(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	public void move(Drawable[] gameBoard, int playerLocation) {
		Random rand = new Random();
		int newLocation = rand.nextInt(GameEngine.BOARD_SIZE);
		
		//Randomly probe locations on the board until an empty one is found,
		//there should always be an empty spot on board
		while (gameBoard[newLocation] != null) {			
			newLocation = rand.nextInt(GameEngine.BOARD_SIZE);
		}
		
		gameBoard[newLocation] = randomPiece;
		this.setLocation(newLocation);
	}
}
