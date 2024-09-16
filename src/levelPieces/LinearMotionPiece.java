package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public abstract class LinearMotionPiece extends GamePiece implements Moveable {

	private static boolean MOVELEFT = false;
	private Drawable LinearMotionPiece;
	
	public LinearMotionPiece(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	//if we encounter another piece, move again
	public void move(Drawable[] gameBoard, int playerLocation) {
		moveHelper();
		while (gameBoard[this.getLocation()] != null) {
			moveHelper();
		}
		
		gameBoard[this.getLocation()] = LinearMotionPiece;
	}
	
	//moves pieces linearly
	private void moveHelper() {
		if (this.getLocation() > 0 && this.getLocation() < GameEngine.BOARD_SIZE && !MOVELEFT) {
			
			this.setLocation(this.getLocation() + 1);
			
			if(this.getLocation() == GameEngine.BOARD_SIZE) {
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
