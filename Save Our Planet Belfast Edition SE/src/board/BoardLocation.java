package board;

import saveOurPlanetBelfastEdition.Player;

public abstract class BoardLocation {

	// initialise variables
	protected int index;
	protected String areaName;

	// ==================================================
	// ===============::Board Location::=================
	// ==================================================
	/**
	 * constructor for BoardLoaction
	 * 
	 * @param index
	 * @param areaName
	 */
	public BoardLocation(int index, String areaName) {

		this.index = index;
		this.areaName = areaName;

	}

	// ==================================================
	// =======--========::Get Index::====================
	// ==================================================
	/**
	 * gets index and returns it
	 * 
	 * @return index
	 */
	public int getIndex() {
		return index;
	}

	// ==================================================
	// ================::Get Area Name::=================
	// ==================================================
	/**
	 * gets areaName and returns it
	 * 
	 * @return areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	// ==================================================
	// ===========::Player Lands On Location::===========
	// ==================================================
	/**
	 * if player lands on location it gets the player object
	 * 
	 * @param player
	 */
	public abstract void playerLandsOnLocation(Player player);

}
