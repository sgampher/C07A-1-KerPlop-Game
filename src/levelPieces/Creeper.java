package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Creeper extends LinearMotionPiece {
	
	private static int TIME_TO_BLOW = 3;

	public Creeper(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	//kills player within 2 blocks, but if special move is true, kills player within 3 blocks
	public InteractionResult interact(Drawable[] board, int playerLocation) {
		
		//handling blow logic
		boolean BLOW = false;
		if (TIME_TO_BLOW == 0) {
			BLOW = true;
			System.out.println("THE CREEPER BLOWS!");
			TIME_TO_BLOW = 3;
		} else {
			TIME_TO_BLOW--;
		}
		
		
		
		if (((Math.abs(playerLocation - this.getLocation()) <= 5) && BLOW)) {
			return InteractionResult.HIT;
		} else {
			return InteractionResult.NONE;
		}
	}		
}
