package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Win extends GamePiece {
	
	
	public Win(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) {
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}
}
