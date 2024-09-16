package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class Win extends LinearMotionPiece {
	
	private int winLocation = (GameEngine.BOARD_SIZE / 2 + 1);
	
	public Win(char symbol, String label, int location) {
		super(symbol, label, location);
		symbol = 'W';
		label = "Win";
		location = winLocation;
	}

	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) {
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}
}
