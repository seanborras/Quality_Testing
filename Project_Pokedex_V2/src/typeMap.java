import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class typeMap {

	public HashMap<String, ArrayList<Pokemon>> pkmType;

	/*
	 * Creates an object with a HashMap where the key is the type, and value is an
	 * array list of pokemon with that type.
	 */
	public typeMap(ArrayList<Pokemon> pkm) {

		pkmType = new HashMap<String, ArrayList<Pokemon>>();

		for (Pokemon p : pkm) {
			if (pkmType.containsKey(p.getpType())) {
				ArrayList<Pokemon> result = pkmType.get(p.getpType());
				result.add(p);
			} else {
				ArrayList<Pokemon> result = new ArrayList<Pokemon>();
				result.add(p);
				pkmType.put(p.getpType(), result);
			}
		}

	}

	/*
	 * Getter method that return the HashMap
	 */
	public HashMap<String, ArrayList<Pokemon>> getTypeMap() {
		return this.pkmType;
	}

	/*
	 * Getter method that returns an ArrayList containing all the types, which are
	 * the keys to the HashMap.
	 */
	public ArrayList<String> getAllTypes() {
		ArrayList<String> allTypes = new ArrayList<String>(pkmType.keySet());
		return allTypes;
	}

	/*
	 * Prints lines of Pokemon, depending on the type given.
	 */
	public String toString(String type) {
		Collections.sort(pkmType.get(type));
		String ret = "";
		for (Pokemon s : pkmType.get(type)) {
			ret += s + "\n";
		}
		return ret;
	}

	public static void main(String[] args) {
		PokedexV2 test = new PokedexV2("pokemon.txt", "pokemon_stats.txt", "pokemon_type.txt", "type.txt");
		// PokedexV2 test = new PokedexV2("pokemon.txt", "pokemon_stats.txt");

		typeMap testTypes = new typeMap(test.getPkmList());
		System.out.println(testTypes.toString("fire"));

	}

}
