import java.util.Comparator;

public class compareType implements Comparator<Pokemon> {

	public int compare(Pokemon p1, Pokemon p2) {
		if (p1.getpType().compareTo(p2.getpType()) < 0) {
			return -1;
		} else if (p1.getpType().compareTo(p2.getpType()) > 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
