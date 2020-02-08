import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class PokedexV2 {

	public ArrayList<Pokemon> allPkm;

	/*
	 * Creates an object with an array list full of pokemon (objects) with
	 * information based from these 4 files.
	 */
	public PokedexV2(String pokemon, String stats, String types, String typesID) {
		Scanner pkmFile = getFileScanner(pokemon);

		allPkm = new ArrayList<Pokemon>();

		/*
		 * Creates a hashmap of pokemon stats, where one key holds the stats of one
		 * pokemon.
		 */
		HashMap<Integer, ArrayList<Integer>> pkmStats = new HashMap<Integer, ArrayList<Integer>>();
		Scanner statsFile = getFileScanner(stats);
		while (statsFile.hasNextLine()) {
			String statLine = statsFile.nextLine();
			String[] statArr = statLine.split(",");

			if (pkmStats.containsKey(Integer.parseInt(statArr[0]))) {
				ArrayList<Integer> result = pkmStats.get(Integer.parseInt(statArr[0]));
				result.add(Integer.parseInt(statArr[2]));
			} else {
				ArrayList<Integer> result = new ArrayList<Integer>();
				result.add(Integer.parseInt(statArr[2]));
				pkmStats.put(Integer.parseInt(statArr[0]), result);
			}

		}

		/*
		 * Creates a hashmap of pokemon types, where one key holds that type (or types).
		 * These are later reffered to when creating the pkemon object of one pokemon.
		 */
		HashMap<Integer, ArrayList<String>> pkmType = new HashMap<Integer, ArrayList<String>>();
		Scanner typesFile = getFileScanner(types);
		while (typesFile.hasNextLine()) {
			String typeLine = typesFile.nextLine();
			String[] typeArr = typeLine.split(",");

			Scanner typesIDFile = getFileScanner(typesID);
			while (typesIDFile.hasNextLine()) {
				String typeIDLine = typesIDFile.nextLine();
				String[] typeIDArr = typeIDLine.split(",");

				if (Integer.parseInt(typeArr[1]) == Integer.parseInt(typeIDArr[0])) {

					if (pkmType.containsKey(Integer.parseInt(typeArr[0]))) {
						ArrayList<String> result = pkmType.get(Integer.parseInt(typeArr[0]));
						result.add(typeIDArr[1]);
					} else {
						ArrayList<String> result = new ArrayList<String>();
						result.add(typeIDArr[1]);
						pkmType.put(Integer.parseInt(typeArr[0]), result);
					}

				}

			}
		}

		/*
		 * Creating the pokemon object.
		 */
		while (pkmFile.hasNextLine()) {
			String pkmLine = pkmFile.nextLine();
			String[] pkmArr = pkmLine.split(",");

			if (pkmStats.containsKey(Integer.parseInt(pkmArr[0]))) {
				ArrayList<Integer> valStat = pkmStats.get(Integer.parseInt(pkmArr[0]));

				int ID = Integer.parseInt(pkmArr[2]);
				String Name = pkmArr[1];

				int HP = valStat.get(0);
				int Atk = valStat.get(1);
				int Def = valStat.get(2);
				int spAtk = valStat.get(3);
				int spDef = valStat.get(4);
				int Speed = valStat.get(5);

				if (pkmType.containsKey(Integer.parseInt(pkmArr[0]))) {
					ArrayList<String> valType = pkmType.get(Integer.parseInt(pkmArr[0]));

					if (valType.size() > 1) {
						String pType = valType.get(0);
						String sType = valType.get(1);

						Pokemon pkm = new Pokemon(ID, Name, HP, Atk, Def, spAtk, spDef, Speed, pType, sType);

						allPkm.add(pkm);
					} else {
						String pType = valType.get(0);

						Pokemon pkm = new Pokemon(ID, Name, HP, Atk, Def, spAtk, spDef, Speed, pType, "None");

						allPkm.add(pkm);

					}

				}

			}

		}

	}

	/*
	 * Getter method that return the list containing all the pokemon.
	 */
	public ArrayList<Pokemon> getPkmList() {
		return this.allPkm;
	}

	/*
	 * Getter method that returns a Pokemon by name
	 */
	public Pokemon getPokemon(String Name) {
		for (Pokemon p : allPkm) {
			if (p.getName().equals(Name)) {
				return p;
			}
		}
		return null;
	}

	/*
	 * Getter method that returns a Pokemon by ID
	 */
	public Pokemon getPokemon(int ID) {
		for (Pokemon p : allPkm) {
			if (p.getID() == ID) {
				return p;
			}
		}
		return null;
	}

	/*
	 * Compares Pokemon by their stats.
	 */
	public void comparePkm(Pokemon x, Pokemon y) {
		String xName = x.getName();
		String yName = y.getName();

		if (x.getHP() > y.getHP()) {
			System.out.println(xName + " has a higher HP, than " + yName);
		} else if (x.getHP() < y.getHP()) {
			System.out.println(yName + " has a higher HP, than " + xName);
		} else {
			System.out.println(yName + " and " + xName + " have equal HP");
		}

		if (x.getAtk() > y.getAtk()) {
			System.out.println(xName + " has a higher Atk, than " + yName);
		} else if (x.getAtk() < y.getAtk()) {
			System.out.println(yName + " has a higher Atk, than " + xName);
		} else {
			System.out.println(yName + " and " + xName + " have equal Atk");
		}

		if (x.getDef() > y.getDef()) {
			System.out.println(xName + " has a higher Def, than " + yName);
		} else if (x.getDef() < y.getDef()) {
			System.out.println(yName + " has a higher Def, than " + xName);
		} else {
			System.out.println(yName + " and " + xName + " have equal Def");
		}

		if (x.getspAtk() > y.getspAtk()) {
			System.out.println(xName + " has a higher spAtk, than " + yName);
		} else if (x.getspAtk() < y.getspAtk()) {
			System.out.println(yName + " has a higher spAtk, than " + xName);
		} else {
			System.out.println(yName + " and " + xName + " have equal spAtk");
		}

		if (x.getspDef() > y.getspDef()) {
			System.out.println(xName + " has a higher spDef, than " + yName);
		} else if (x.getspDef() < y.getspDef()) {
			System.out.println(yName + " has a higher spDef, than " + xName);
		} else {
			System.out.println(yName + " and " + xName + " have equal spDef");
		}

		if (x.getSpeed() > y.getSpeed()) {
			System.out.println(xName + " has a higher Speed, than " + yName);
		} else if (x.getSpeed() < y.getSpeed()) {
			System.out.println(yName + " has a higher Speed, than " + xName);
		} else {
			System.out.println(yName + " and " + xName + " have equal Speed");
		}

	}

	/*
	 * Sorts Pokemon by name in an ascending order
	 */
	public ArrayList<Pokemon> sortNameAsc() {
		compareNameAsc sort = new compareNameAsc();
		Collections.sort(allPkm, sort);
		return allPkm;
	}

	/*
	 * Sorts Pokemon by name in a descending order
	 */
	public ArrayList<Pokemon> sortNameDesc() {
		compareNameDesc sort = new compareNameDesc();
		Collections.sort(allPkm, sort);
		return allPkm;
	}

	/*
	 * Sorts Pokemon by their type
	 */
	public ArrayList<Pokemon> sortType() {
		compareType sort = new compareType();
		Collections.sort(allPkm, sort);
		return allPkm;
	}

	/*
	 * Helper method to open files for reading.
	 */
	public static Scanner getFileScanner(String filename) {
		Scanner myFile;
		try {
			myFile = new Scanner(new FileReader(filename));
		} catch (Exception e) {
			System.out.println("File not found: " + filename);
			return null;
		}
		return myFile;
	}

	/*
	 * Helper method to open files for writing.
	 */
	public static PrintWriter getFileWriter(String filename) {
		PrintWriter outFile;
		try {
			outFile = new PrintWriter(filename);
		} catch (Exception e) {
			System.out.println("Error opening file: " + filename);
			return null;
		}
		return outFile;
	}

	/*
	 * Sorts the pokemon in the list according to their natural order, and then
	 * prints them.
	 */
	public String toString() {
		Collections.sort(allPkm);
		String ret = "";
		for (Pokemon s : allPkm) {
			ret += s + "\n";
		}
		return ret;
	}

	public static void main(String[] args) {
		PokedexV2 test = new PokedexV2("pokemon.txt", "pokemon_stats.txt", "pokemon_type.txt", "type.txt");
		// PokedexV2 test = new PokedexV2("pokemon.txt", "pokemon_stats.txt");
		ArrayList<Pokemon> nameSort = test.sortType();
		for (Pokemon p : nameSort) {
			System.out.println(p);
		}

	}

}
