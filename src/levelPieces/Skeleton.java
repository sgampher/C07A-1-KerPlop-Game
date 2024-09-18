package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import java.util.Random;


public class Skeleton extends RandomMotionPiece {	
	
	public Skeleton(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	//kills player within 2 blocks, but if special move is true, kills player within 3 blocks
	public InteractionResult interact(Drawable[] board, int playerLocation) {
		Random rand = new Random();
		boolean SpecialMove = rand.nextBoolean();
		
		if (SpecialMove) System.out.println("SPECIAL SKELETON MOVE ACTIVE!");
		
		if (((Math.abs(playerLocation - this.getLocation()) <= 2) && !SpecialMove) || ((Math.abs(playerLocation - this.getLocation()) <= 3) && SpecialMove)) {
			return InteractionResult.HIT;
		} else {
			return InteractionResult.NONE;
		}
	}		
}



