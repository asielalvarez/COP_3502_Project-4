
public class Record {
	private String artist, title;
	private int year;

	public Record(String artist, String albumTitle, int year) {
		this.artist = artist;
		title = albumTitle;
		this.year = year;		
	}

	public String getArtist() {
		return artist;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}
	public String toString(){
		return title + " by " + artist + ", " + year;
	}

}
