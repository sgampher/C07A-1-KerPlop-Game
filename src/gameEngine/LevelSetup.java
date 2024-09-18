package gameEngine;
import java.util.ArrayList;
import java.util.Random;
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
		
		//Initializes game board, moving pieces, and interacting pieces
		gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
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

		if (levelNum == 1) {
			
			PlayerStartingLocation = 10;
			Zombie = new Zombie('Z', "Zombie", 0);
			villager = new Villager('V', "Villager", 14);
			Sheep = new Sheep('O', "Sheep", 18);
			Skeleton = new Skeleton('S', "Skeleton", 20);
			winner = new Win('W', "Win", 14);
			
			
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
			
			
		} else if (levelNum == 2) {
			
			PlayerStartingLocation = 10;
			Zombie = new Zombie('Z', "Zombie", 8);
			villager = new Villager('V', "Villager", 4);
			Sheep = new Sheep('O', "Sheep", 12);
			Skeleton = new Skeleton('S', "Skeleton", 18);
			winner = new Win('W', "Win", 16);
			
			
			//clear previous arraylist contents
			movingPieces.clear();
			interactingPieces.clear();
			
			for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
				gameBoard[i] = null;
			}
			
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
}
