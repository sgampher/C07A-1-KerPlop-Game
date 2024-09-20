package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.LevelSetup;

public class Creeper extends LinearMotionPiece {
	
	public static int TIME_TO_BLOW = 2;

	public Creeper(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	//kills player within 2 blocks, but if special move is true, kills player within 3 blocks
	public InteractionResult interact(Drawable[] board, int playerLocation) {
		
		//reset TIME_TO_BLOW on level2
		if (LevelSetup.level2) {
			TIME_TO_BLOW = 2;
			LevelSetup.level2 = false;
		}
		
		
		
		//handling blow logic
		boolean BLOW = false;
		if (TIME_TO_BLOW == 0) {
			BLOW = true;
			System.out.println("THE CREEPER BLOWS!");
			TIME_TO_BLOW = 2;
		} else {
			System.out.println("Creeper Blows In: " + TIME_TO_BLOW + " Move(s)");
			TIME_TO_BLOW--;
		}
		
		
		
		
		if (((Math.abs(playerLocation - this.getLocation()) <= 5) && BLOW)) {
			return InteractionResult.HIT;
		} else {
			return InteractionResult.NONE;
		}
	}
}
