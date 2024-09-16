package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import java.util.Random;


public class Skeleton extends RandomMotionPiece {	
	
	public Skeleton(char symbol, String label, int location) {
		super('S', "Skeleton", 5);
	}

	//kills player within 3 blocks, but if special move is true, kills player within 5 blocks
	public InteractionResult interact(Drawable[] board, int playerLocation) {
		Random rand = new Random();
		boolean SpecialMove = rand.nextBoolean();
		System.out.println("SPECIAL SKELETON MOVE ACTIVE!");
		
		if ( (playerLocation >= this.getLocation() - 3 || playerLocation <= this.getLocation() + 3) || (SpecialMove && (playerLocation >= this.getLocation() - 5 || playerLocation <= this.getLocation() + 5))) {
			return InteractionResult.KILL;
		} else {
			return InteractionResult.NONE;
		}
	}		
}



