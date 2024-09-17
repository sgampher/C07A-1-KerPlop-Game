package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Zombie extends RandomMotionPiece {
	
	public Zombie(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	public InteractionResult interact(Drawable[] board, int playerLocation) {
		if (playerLocation >= this.getLocation() - 1 || playerLocation <= this.getLocation() + 1) {
			return InteractionResult.KILL;
		} else {
			return InteractionResult.NONE;
		}
	}
}
