package gameEngine;
import java.util.ArrayList;
import levelPieces.GamePiece;
import levelPieces.Sheep;
import levelPieces.Skeleton;
import levelPieces.Sniffer;
import levelPieces.Villager;
import levelPieces.Win;
import levelPieces.Zombie;

public class LevelSetup {
	
	private Drawable[] gameBoard;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	
	private int PlayerStartingLocation;
	private Zombie Zombie;
	private GamePiece villager;
	private Sheep Sheep;
	private Skeleton Skeleton;
	private GamePiece winner;
	
	public LevelSetup() {
		gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
		PlayerStartingLocation = 8;
		Zombie = new Zombie('Z', "Zombie", 4);
		villager = new Villager('V', "Villager", 12);
		Sheep = new Sheep('O', "Sheep", 20);
		Skeleton = new Skeleton('S', "Skeleton", 16);
		winner = new Win('W', "Win", 0);
	}
	
	public int getPlayerStartLoc() {
		return PlayerStartingLocation;

	}
	
	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}
	
	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}
	
	public Drawable[] getBoard() {
		return gameBoard;
	}

	public void createLevel(int levelNum) {
		//Adding moving pieces
		movingPieces.add(Zombie);
		movingPieces.add(Skeleton);
		movingPieces.add(Sheep);
		
		//Adding interacting pieces
		interactingPieces.add(Zombie);
		interactingPieces.add(Skeleton);
		interactingPieces.add(Sheep);
		interactingPieces.add(villager);
		interactingPieces.add(winner);
		
		//Adding gameboard pieces
		gameBoard[villager.getLocation()] = villager;
		gameBoard[winner.getLocation()] = winner;
		gameBoard[Zombie.getLocation()] = Zombie;
		gameBoard[Skeleton.getLocation()] = Skeleton;
		gameBoard[Sheep.getLocation()] = Sheep;
		gameBoard[15] = new Sniffer();
	}
	
}
