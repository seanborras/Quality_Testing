import java.util.Comparator;

public class compareNameDesc implements Comparator<Pokemon> {

	public int compare(Pokemon p1, Pokemon p2) {
		if (p1.getName().compareTo(p2.getName()) < 0) {
			return 1;
		} else if (p1.getName().compareTo(p2.getName()) > 0) {
			return -1;
		} else {
			return 0;
		}
	}

}
