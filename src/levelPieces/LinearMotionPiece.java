package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public abstract class LinearMotionPiece extends GamePiece implements Moveable {

	private static boolean MOVELEFT = false;
	
	public LinearMotionPiece(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	
	public void move(Drawable[] gameBoard, int playerLocation) {
		//reset the old position
		gameBoard[this.getLocation()] = null;
		moveHelper();
		
		//if we encounter another piece, move again
		//There should always be an empty location on the board
		while (gameBoard[this.getLocation()] != null) {
			moveHelper();
		}
		
		gameBoard[this.getLocation()] = this;
	}
	
	//moves pieces linearly
	private void moveHelper() {
		if (this.getLocation() >= 0 && this.getLocation() < GameEngine.BOARD_SIZE && !MOVELEFT) {
			
			this.setLocation(this.getLocation() + 1);
			
			if(this.getLocation() == GameEngine.BOARD_SIZE - 1) {
				MOVELEFT = true;
			}
			
		} else if (MOVELEFT) {
			
			if(this.getLocation() == 0) {
				MOVELEFT = false;
			}
			
			this.setLocation(this.getLocation() - 1);
		}
	}
}
