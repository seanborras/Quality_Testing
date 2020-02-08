import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		PokedexV2 allPkm = new PokedexV2("pokemon.txt", "pokemon_stats.txt", "pokemon_type.txt", "type.txt");
		typeMap allTypes = new typeMap(allPkm.getPkmList());
		teamBuilder allTeam = new teamBuilder();

		Scanner userInp = new Scanner(System.in);
		boolean exit = false;

		System.out.println("Pokedex Version 1.0.");

		while (!exit) {
			System.out.println("Would you like to: view Pokemon (q), " + "view/create a Pokemon team (w), "
					+ "compare Pokemon (e), or exit (x)?");
			String choice = userInp.next();

			if (choice.equals("x")) {
				System.out.println("Thank you for using the app!");
				exit = true;

			} else if (choice.equals("w")) {

				boolean stop = false;

				while (!stop) {

					System.out.println("Would you view ALL teams (q), create a team (w), view a team (e), "
							+ "delete a team (r), add Pokemon to a team (t), remove Pokemon from a team (y), or exit (x)?");
					String option = userInp.next();

					if (option.equals("x")) {
						System.out.println("Return to main menu!");
						stop = true;

					} else if (option.equals("q")) {
						System.out.println("These are all the current teams: ");
						ArrayList<String> teams = allTeam.viewAll();
						for (String s : teams) {
							System.out.println(s);
						}

					} else if (option.equals("w")) {
						System.out.println("What would you name this team?");
						String name = userInp.next();

						if (allTeam.addTeam(name) == true) {
							allTeam.addTeam(name);
							System.out.println("Team - " + name + " has been created!");
						} else {
							System.out.println("Team - " + name + " already exists!");
						}

					} else if (option.equals("e")) {
						System.out.println("Which team would you like to view?");
						String name = userInp.next();

						ArrayList<Pokemon> result = allTeam.viewTeam(name);
						if (result != null) {
							if (result.size() > 0) {
								System.out.println("Team - " + name + " has the following Pokemon: ");
								for (Pokemon p : result) {
									System.out.println(p);
								}
							} else {
								System.out.println("Team - " + name + " is empty!");
							}
						} else {
							System.out.println("That team doesn't exist!");
						}

					} else if (option.equals("r")) {
						System.out.println("Which team would you like to remove?");
						String name = userInp.next();

						if (allTeam.removeTeam(name) == true) {
							allTeam.removeTeam(name);
							System.out.println("Team - " + name + " has been removed!");
						} else {
							System.out.println("Team - " + name + " does not exist!");
						}

					} else if (option.equals("t")) {
						System.out.println("Which team would you like to add a Pokmeon to?");
						String name = userInp.next();

						if (allTeam.getMap().containsKey(name) == true) {

							System.out.println("Which pokemon would you like to add?");
							String pkm = userInp.next();

							if (allPkm.getPokemon(pkm) != null) {
								Pokemon newPkm = allPkm.getPokemon(pkm);

								if (allTeam.addPkm(name, newPkm) == true) {
									System.out.println(newPkm.getName() + " Has been added to Team - " + name);
								} else {
									System.out.println("Team already has 6 Pokemon!");
								}

							} else {
								System.out.println("Pokemon does not exist!");
							}

						} else {
							System.out.println("Team - " + name + " does not exist!");
						}

					} else if (option.equals("y")) {
						System.out.println("Which team would you like to remove a Pokmeon from?");
						String name = userInp.next();

						if (allTeam.getMap().containsKey(name) == true) {

							System.out.println("Which pokemon would you like to remove?");
							String pkm = userInp.next();

							if (allPkm.getPokemon(pkm) != null) {
								Pokemon newPkm = allPkm.getPokemon(pkm);

								if (allTeam.removePkm(name, newPkm) == true) {
									System.out.println(newPkm.getName() + " Has been added to Team - " + name);
								} else {
									System.out.println("Team already has 6 Pokemon!");
								}

							} else {
								System.out.println("Pokemon does not exist!");
							}

						} else {
							System.out.println("Team - " + name + " does not exist!");
						}

					} else {
						System.out.println("Invalid Input!");
					}

				}

			} else if (choice.equals("q")) {

				boolean stop = false;

				while (!stop) {

					System.out.println("Would you view ALL pokemon (q), view Pokemon by name(w), "
							+ "view Pokemon by type (e), or exit (x)?");
					String option = userInp.next();

					if (option.equals("x")) {
						System.out.println("Returning to main menu!");
						stop = true;

					} else if (option.equals("q")) {
						System.out.println("These are all the Pokemon! ");
						System.out.println(allPkm);

					} else if (option.equals("w")) {
						System.out.println("Ascending (a) or Descending (d)?");
						String select = userInp.next();

						if (select.equals("a")) {
							ArrayList<Pokemon> nameSort = allPkm.sortNameAsc();
							for (Pokemon p : nameSort) {
								System.out.println(p);
							}
							System.out.println("\n");
						} else if (select.equals("d")) {
							ArrayList<Pokemon> nameSort = allPkm.sortNameDesc();
							for (Pokemon p : nameSort) {
								System.out.println(p);
							}
							System.out.println("\n");
						} else {
							System.out.println("Invalid Input!");
							System.out.println("\n");
						}

					} else if (option.equals("e")) {
						System.out.println("Sort Pokemon by type (q), view all types (w), view Pokemon by type (e)");
						String select = userInp.next();

						if (select.equals("q")) {
							ArrayList<Pokemon> typeSort = allPkm.sortType();
							for (Pokemon p : typeSort) {
								System.out.println(p);
							}
							System.out.println("\n");
						} else if (select.equals("w")) {
							ArrayList<String> types = allTypes.getAllTypes();
							for (String s : types) {
								System.out.println(s);
							}
							System.out.println("\n");
						} else if (select.equals("e")) {
							System.out.println("Which type of pokemon would you like to view?");
							String type = userInp.next();

							HashMap<String, ArrayList<Pokemon>> check = allTypes.getTypeMap();
							if (check.containsKey(type)) {
								System.out.println(allTypes.toString(type));
							} else {
								System.out.println(type + " doesn't exist!");
							}

						} else {
							System.out.println("Invalid Input!");
							System.out.println("\n");
						}

					} else {
						System.out.println("Invalid Input!");
						System.out.println("\n");
					}

				}

			} else if (choice.equals("e")) {
				System.out.println("Enter Pokemon 1");
				String name1 = userInp.next();

				if (allPkm.getPokemon(name1) != null) {
					Pokemon pkm1 = allPkm.getPokemon(name1);
					System.out.println("Enter Pokemon 2");
					String name2 = userInp.next();

					if (allPkm.getPokemon(name1) != null) {
						Pokemon pkm2 = allPkm.getPokemon(name2);

						allPkm.comparePkm(pkm1, pkm2);

					} else {
						System.out.println("Pokemon does not exist!");
						System.out.println("\n");
					}

				} else {
					System.out.println("Pokemon does not exist!");
					System.out.println("\n");
				}

			} else {
				System.out.println("Invalid Input!");
				System.out.println("\n");
			}

		}

	}

}
