package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import levelPieces.*;
import gameEngine.*;

class TestMovingPieces {
	
	/**
	 * Tests weather skeleton and sheep collide with one another
	 * We create a board of size twenty, then insert a skeleton and sheep at every index 
	 * If the amount of both sheep/skeleton remain the same as before/after calling move,
	 * no null spaces are detected, and some other object isn't occupying any indeces, success,
	 * fail otherwise. This can also serve the purpose of testing all spaces on the board are occupied
	 * by random mmovement.
	 */
	@Test
	void TestRandomMovement() {
		
	    Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
	    int countSkeletonBefore=0;
	    int countSheepBefore=0;
	    int skeletonCountAfter = 0;
	    int sheepCountAfter = 0;
	    
	    // Create either skeleton or sheep at every index	    
	    for (int i=0; i<GameEngine.BOARD_SIZE; i += 2) {
	        gameBoard[i] = new Skeleton('S', "Skeleton ", i);
	        countSkeletonBefore++;
	        if (i+1<GameEngine.BOARD_SIZE) {
	            gameBoard[i + 1] = new Sheep('O', "Sheep", i + 1);
	            countSheepBefore++;
	        }
	    }
	    
	    // Move every skeleton and sheep
	    for (int i=0; i <gameBoard.length; i++) {
	          ((Moveable) gameBoard[i]).move(gameBoard, 1);
	      
	    }
	    
	    //iterate the count of skeleton and sheep
	    //fail if null value or some other value found. 
	    for (int i=0; i<gameBoard.length; i++) {
	        if (gameBoard[i] instanceof Skeleton) {
	        	skeletonCountAfter++;
	        } else if (gameBoard[i] instanceof Sheep) {
	        	sheepCountAfter++;
	        } else if(gameBoard[i] == null) {
	        	fail("Found an empty space");
	        } else {	        	
	        	fail("Some other object found");
	        }
	        
	    }
	    
	    //tests if the skeleton/sheep count before calling move is equal to the skeleton/sheep count after calling move
	    assertEquals(countSkeletonBefore, skeletonCountAfter);
	    assertEquals(countSheepBefore, sheepCountAfter);
	}

	/**
	 * Tests linear movement by again, ensuring the pieces do not collide when.
	 * We create an empty board, and then insert a Creeper and Zombie at every index
	 * If the amount of both Creepers and Zombies remain the same before and after calling move,
	 * no null spaces are detected, and some other objects aren't occupying any indeces, success, 
	 * fail otherwise. This can all serve the purpose of ensuring all spaces on the board can be occupies
	 * by linear movement
	 */
	@Test
	void TestLinearMovement() {
		
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
	    int countCreeperBefore=0;
	    int countZombieBefore=0;
	    int countZombieAfter = 0;
	    int countCreeperAfter = 0;
	    
	    // Create either skeleton or sheep at every index	    
	    for (int i=0; i<GameEngine.BOARD_SIZE; i += 2) {
	        gameBoard[i] = new Creeper('C', "Creeper ", i);
	        countCreeperBefore++;
	        if (i+1<GameEngine.BOARD_SIZE) {
	            gameBoard[i + 1] = new Zombie('Z', "Zombie", i + 1);
	            countZombieBefore++;
	        }
	    }
	    
	    // Move every zombie and creeper
	    for (int i=0; i <gameBoard.length; i++) {
	          ((Moveable) gameBoard[i]).move(gameBoard, 1);
	      
	    }
	    
	    //iterate the count of zombie and creeper
	    //fail if null value or some other value found. 
	    for (int i=0; i<gameBoard.length; i++) {
	        if (gameBoard[i] instanceof Zombie) {
	        	countZombieAfter++;
	        } else if (gameBoard[i] instanceof Creeper) {
	        	countCreeperAfter++;
	        } else if(gameBoard[i] == null) {
	        	fail("Found an empty space");
	        } else {	        	
	        	fail("Some other object found");
	        }
	        
	    }
	    
	    //tests if the creeper/zombie count before calling move is equal to the creeper/zombie count after calling move
	    assertEquals(countCreeperBefore, countCreeperAfter);
	    assertEquals(countZombieBefore, countZombieAfter);
		
	}

}
