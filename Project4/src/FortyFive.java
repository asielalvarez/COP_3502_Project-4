
public class FortyFive extends Record {

	public FortyFive(String artist, String albumTitle, int year) {
		super(artist, albumTitle, year);
	}

	public String toString() {
		return "45: " + super.toString();
	}

}
