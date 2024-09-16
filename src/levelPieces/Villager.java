package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Villager extends GamePiece {
	
	Drawable villager;
	
	public Villager(char symbol, String label, int location) {
		super('V', "Villager", 20);
	}

	public InteractionResult interact(Drawable[] board, int playerLocation) {
		
		if (playerLocation == this.getLocation()) {
			return InteractionResult.ADVANCE;
		}
		
		return InteractionResult.NONE;
	}
	
	public void move(Drawable[] board, int playerLocation) {
		board[20] = villager;
		this.setLocation(20);
	}
}
