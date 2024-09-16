package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Sheep extends GamePiece {
	
	
	public Sheep(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
			return InteractionResult.NONE;
	}
	
	
}
