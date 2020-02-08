
public class Pokemon implements Comparable<Pokemon> {

	// ID of the Pokemon
	public int ID;

	// Name of the Pokemon
	public String Name;

	// Stats of the Pokemon (HP, Atk, Def, spAtk, spDef, Speed)
	public int HP;
	public int Atk;
	public int Def;
	public int spAtk;
	public int spDef;
	public int Speed;

	// Type of the Pokemon (e.g. Fire, Water)
	public String pType;
	public String sType;

	public Pokemon(int ID, String Name, int HP, int Atk, int Def, int spAtk, int spDef, int Speed, String pType,
			String sType) {
		this.ID = ID;
		this.Name = Name;

		this.HP = HP;
		this.Atk = Atk;
		this.Def = Def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.Speed = Speed;

		this.pType = pType;
		this.sType = sType;
	}

	// Getter methods for the variables
	public int getID() {
		return this.ID;
	}

	public String getName() {
		return this.Name;
	}

	public int getHP() {
		return this.HP;
	}

	public int getAtk() {
		return this.Atk;
	}

	public int getDef() {
		return this.Def;
	}

	public int getspAtk() {
		return this.spAtk;
	}

	public int getspDef() {
		return this.spDef;
	}

	public int getSpeed() {
		return this.Speed;
	}

	public String getpType() {
		return this.pType;
	}

	public String getsType() {
		return this.sType;
	}

	/*
	 * Builds a string depending on whether the pokemon has a secondary type or not.
	 */
	public String toString() {
		if (this.sType != "None") {
			return "Pokemon #" + ID + ": " + Name + " is a " + pType + " and " + sType + " type, and has " + HP
					+ " HP, " + Atk + " Atk, " + Def + " Def, " + spAtk + " Special Atk, " + spDef
					+ " Special Def, and " + Speed + " Speed.";

		} else {
			return "Pokemon #" + ID + ": " + Name + " is a " + pType + " type, and has " + HP + " HP, " + Atk + " Atk, "
					+ Def + " Def, " + spAtk + " Special Atk, " + spDef + " Special Def, and " + Speed + " Speed.";
		}
	}

	// Natural order for sorting Pokemon objects (by their ID #)
	public int compareTo(Pokemon p) {
		if (this.ID < p.ID) {
			return -1;
		} else if (this.ID > p.ID) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {

		Pokemon test = new Pokemon(1, "Bulbasaur", 45, 49, 49, 65, 65, 45, "Grass", "Poison");
		System.out.print(test);

	}

}
