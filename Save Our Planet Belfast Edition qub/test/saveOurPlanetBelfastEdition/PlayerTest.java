package saveOurPlanetBelfastEdition;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import board.Areas;

class PlayerTest {
	
	    //Test Data
		String validName;
		int validBoardPosition;
		Player player;
		double fundsToAdd;
		double fundsToRemove;
		int areaIndex;
		

		@BeforeEach
		void setUp() throws Exception {
			
			validName = "Lee";
			validBoardPosition = 10;	
			player = new Player("Walter", Marker.SOLAR_PANEL);
			fundsToAdd = 50.50;
			fundsToRemove = 350;
			areaIndex = 3;
			player.addToOwnedAreas(areaIndex);
			
		}

		//Test case tests the instantiation of a player object
		@Test
		void testPlayerConstructor() {
			Player testPlayer = new Player(validName, Marker.WINDMILL);
			assertNotNull(testPlayer);
			assertEquals(validName, testPlayer.getPlayerName());
			assertEquals(Marker.WINDMILL, testPlayer.getMarker());
		}
		
		@Test
		void testPlayerBoardPosition() {
			Player testPlayer = new Player(validName, Marker.WINDMILL);
			testPlayer.setBoardPosition(validBoardPosition);
			assertEquals(validBoardPosition, testPlayer.getBoardPosition());
		}
		
		@Test
		void testGetAndSetPlayerFunds() {
			assertEquals(300, player.getPlayerFunds());
			double addition = 300+fundsToAdd;
			player.updatePlayerFundsAdd(fundsToAdd);
			assertEquals(addition, player.getPlayerFunds());
		}
		
		@Test
		void testRemovePlayerFunds() {
			
			double total = 300-fundsToRemove;
			player.updatePlayerFundsSubtract(fundsToRemove);;
			assertEquals(total, player.getPlayerFunds());
		}
		
		@Test
		void testAddToPlayerAreas() {
			
			assertTrue(player.getOwnedAreas().contains(areaIndex));
		}
		
		@Test
		void getRemoveFromPlayerAreas() {
			
			player.removeFromOwnedAreas(areaIndex);
			//assertEquals(0, player.getOwnedAreas().size());
			assertFalse(player.getOwnedAreas().contains(areaIndex));
		}
			
	}
