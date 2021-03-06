package uk.ac.qub.music;

public class mp3 {

	public final static int LOWER_RATING = 0;
	
	private int ref;
	private String artist;
	private String songName;
	private int rating;
	private int songLength;

	public int getRef() {
		return ref;
	}

	/**
	 * If less than zero then throw exception
	 * 
	 * @param ref
	 */
	public void setRef(int ref) throws IllegalArgumentException {

		if (ref <= 0) {
			this.ref = ref;
		}
		throw new IllegalArgumentException("Ref less than 0");
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		if ((rating > 1) && (rating < 5)) {
			this.rating = rating;
		}

	}
	
	/**
	 * @return the songLength
	 */
	public int getSongLength() {
		return songLength;
	}

	/**
	 * @param songLength the songLength to set
	 */
	public void setSongLength(int songLength) {
		if (songLength < 1 || songLength > 2500) {
			System.err.println("Invalid song length");
		} else {
		this.songLength = songLength;
		}
	}

	public mp3(int ref, String artist, String songName, int rating) {
		this.ref = ref;
		this.artist = artist;
		this.songName = songName;
		this.rating = rating;
	}

}
