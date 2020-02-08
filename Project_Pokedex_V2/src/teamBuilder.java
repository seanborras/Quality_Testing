import java.util.ArrayList;
import java.util.HashMap;

public class teamBuilder {

	public HashMap<String, ArrayList<Pokemon>> teams;

	/*
	 * Creates an object with an empty HashMap.
	 */
	public teamBuilder() {

		teams = new HashMap<String, ArrayList<Pokemon>>();

	}

	/*
	 * Getter method that return the HashMap
	 */
	public HashMap<String, ArrayList<Pokemon>> getMap() {
		return this.teams;
	}

	/*
	 * Getter method that return an ArrayList containing all the teams, which are
	 * keys to the HashMap
	 */
	public ArrayList<String> viewAll() {
		ArrayList<String> allTeams = new ArrayList<String>(teams.keySet());
		return allTeams;
	}

	/*
	 * Creates a team, and adds it as a key in the HashMap. Returns a boolean value,
	 * depending on whether the team has been added or not.
	 */
	public boolean addTeam(String Name) {
		if (!teams.containsKey(Name)) {
			ArrayList<Pokemon> pkm = new ArrayList<Pokemon>();
			teams.put(Name, pkm);
			return true;
		}

		return false;
	}

	/*
	 * Returns an ArrayList of Pokemon of the team that was called.
	 */
	public ArrayList<Pokemon> viewTeam(String Name) {
		if (teams.containsKey(Name)) {
			return teams.get(Name);
		}

		return null;
	}

	/*
	 * Removes a team, and removes it as a key in the HashMap. Returns a boolean
	 * value, depending on whether the team has been added or not.
	 */
	public boolean removeTeam(String Name) {
		if (teams.containsKey(Name)) {
			teams.remove(Name);
			return true;
		}

		return false;
	}

	/*
	 * Adds specific Pokemon to a certain team. Returns a boolean value depending on
	 * whether the pokemon has been added to the team or not.
	 */
	public boolean addPkm(String Name, Pokemon pkm) {
		if (teams.containsKey(Name)) {
			ArrayList<Pokemon> result = teams.get(Name);

			if (result.size() < 6) {
				result.add(pkm);
				teams.put(Name, result);
				return true;
			}

			return false;

		}

		return false;
	}

	/*
	 * Removes specific Pokemon to a certain team. Returns a boolean value depending
	 * on whether the pokemon has been removed from the team or not
	 */
	public boolean removePkm(String Name, Pokemon pkm) {
		if (teams.containsKey(Name)) {
			ArrayList<Pokemon> result = teams.get(Name);

			if (!result.isEmpty()) {
				result.remove(pkm);
				teams.put(Name, result);
				return true;
			}

			return false;

		}

		return false;
	}

	public static void main(String[] args) {
		PokedexV2 test = new PokedexV2("pokemon.txt", "pokemon_stats.txt", "pokemon_type.txt", "type.txt");

		Pokemon x = test.getPokemon(83);
		Pokemon y = test.getPokemon("charizard");

		teamBuilder testTeams = new teamBuilder();
		System.out.println(testTeams.addTeam("Dream Team"));
		testTeams.addPkm("Dream Team", x);
		testTeams.addPkm("Dream Team", y);

		ArrayList<Pokemon> pkms = testTeams.teams.get("Dream Team");
		for (Pokemon p : pkms) {
			System.out.println(p);
		}

	}

}
