package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import levelPieces.*;
import gameEngine.*;

class TestInteractions {
	
	Drawable[] gameBoard;
	
	/**
	 * Tests that the expected interaction occurs between pieces occurs
	 */
	InteractionResult GeneralTestInteract(Drawable[] gameBoard, InteractionResult ExpectedInteractResult, GamePiece Piece, int index) {
		return Piece.interact(gameBoard, index);
	}

	/**
	 * Here, we set up all of the variables we use for testing.
	 * Note, JUnit5 Uses BeforeEach, not Before
	 */
	@BeforeEach
	public void setUp() {
		gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		gameBoard[0] = new Sheep('O', "Sheep", 0);
		gameBoard[1] = new Skeleton('S', "Skeleton", 1);
		gameBoard[2] = new Win('W', "Win", 2);
		gameBoard[3] = new Sheep('S', "Sheep", 3);
		gameBoard[4] = new Villager('V', "Villager", 4);
		gameBoard[5] = new Creeper('C', "Creeper", 5);
		gameBoard[6] = new Zombie('Z', "Zombie", 6);
	}	
	
	
	//Tests Zombie's interaction with player is as expected
	@Test
	public void testZombieInteract() {	
		InteractionResult expected = InteractionResult.KILL;
		InteractionResult actual = GeneralTestInteract(gameBoard, expected, (GamePiece) gameBoard[6], 6);
		assertEquals(expected, actual);
	}
	
	//Tests Sheep's interaction with player is as expected
	@Test
	public void testSheepInteract() {
		InteractionResult expected = InteractionResult.NONE;
		InteractionResult actual = GeneralTestInteract(gameBoard, expected, (GamePiece) gameBoard[0], 0);
		assertEquals(expected, actual);
	}
	
	//Tests Skeleton's interaction with player is as expected
	@Test
	public void testSkeletonInteract() {
		InteractionResult expected = InteractionResult.HIT;
		InteractionResult actual = GeneralTestInteract(gameBoard, expected, (GamePiece) gameBoard[1], 1);
		System.out.flush();
		assertEquals(expected, actual);
	}
	
	//Tests Win's interaction with player is as expected
	@Test
	public void testWinInteract() {
		InteractionResult expected = InteractionResult.GET_POINT;
		InteractionResult actual = GeneralTestInteract(gameBoard, expected, (GamePiece) gameBoard[2], 2);
		assertEquals(expected, actual);
	}
	
	//Tests Villager's interaction with player is as expected
	@Test
	public void testVillagerInteract() {
		InteractionResult expected = InteractionResult.ADVANCE;
		InteractionResult actual = GeneralTestInteract(gameBoard, expected, (GamePiece) gameBoard[4], 4);
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests Creeper's interaction with player is as expected, 
	 * must wear down Creepers timer before calling
	 * GeneralTestInteract
	 */
	@Test
	public void testCreeperInteract() {
		InteractionResult expected = InteractionResult.HIT;
		InteractionResult actual = InteractionResult.NONE;
		
		do {
			((GamePiece) gameBoard[5]).interact(gameBoard, 5);
		} while(Creeper.TIME_TO_BLOW != 0);
		
		actual = GeneralTestInteract(gameBoard, expected, (GamePiece) gameBoard[5], 5);
		assertEquals(expected, actual);
	}

}
