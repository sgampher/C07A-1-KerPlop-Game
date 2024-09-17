package gameEngine;
import java.util.ArrayList;
import levelPieces.GamePiece;
import levelPieces.LinearMotionPiece;
import levelPieces.RandomMotionPiece;

public class LevelSetup {
	
	private Drawable[] gameBoard;
	private ArrayList<GamePiece> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private int PlayerStartingLocation;
	
	public LevelSetup() {
		gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		PlayerStartingLocation = GameEngine.BOARD_SIZE / 2 + 1;		
	}
	
	public int getPlayerStartLoc() {
		return PlayerStartingLocation;
	}
	
	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}
	
	public ArrayList<GamePiece> getMovingPieces() {
		return movingPieces;
	}
	
	public Drawable[] getBoard() {
		return gameBoard;
	}

	public void createLevel(int levelNum) {
		if (levelNum == 1) {
			
		} else if (levelNum == 2) {
			
		} else {
			return;
		}
	}
	
}
