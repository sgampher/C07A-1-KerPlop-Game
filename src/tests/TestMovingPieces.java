package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import levelPieces.*;
import gameEngine.*;

class TestMovingPieces {
	
	/**
	 * Tests weather skeleton and sheep collide with one another
	 * We create a board of size twenty, then insert a skeleton and sheep at every index 
	 * If the amount of sheep/skeleton remain the same as before/after calling move, success,
	 * fail otherwise.
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
	    //fail if null value or some other value found (seperated to better identify issue). 
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
	    
	    assertEquals(countSkeletonBefore, skeletonCountAfter);
	    assertEquals(countSheepBefore, sheepCountAfter);
	}

	
	@Test
	void TestLinearMovement() {
		fail("Not yet implemented");
	}

}
