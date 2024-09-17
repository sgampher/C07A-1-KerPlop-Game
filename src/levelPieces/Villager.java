package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Villager extends GamePiece {
		
	public Villager(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	public InteractionResult interact(Drawable[] board, int playerLocation) {
		
		if (playerLocation == this.getLocation()) {
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE;
	}
}
