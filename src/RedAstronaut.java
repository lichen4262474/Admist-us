import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
	// variables;
	public String skill;

	// constructors;
	public RedAstronaut(String name, int susLevel, String skill) {
		super(name, susLevel);
		this.skill = skill;
	}

	public RedAstronaut(String name) {
		this(name, 15, "experienced");
	}

	// getters and setters;
	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	// methods;
	@Override
	public void emergencyMeeting() {
		if (!isFrozen()) {
			Player[] players = getPlayers();
			Player suspect = null;

			Arrays.sort(players);
			int index = 0;
			do {
				if (!players[index].equals(this) && !players[index].isFrozen()) {
					suspect = players[index];
					index++;
					break;
				}
				index++;
			} while (index < players.length);

			for (int i = index; i < players.length; i++) {
				if (!players[i].isFrozen() && players[i].getSusLevel() == suspect.getSusLevel()) {
					// call off
					suspect = null;
					break;
				}
			}

			if (suspect != null) {
				System.out.println(suspect);
				suspect.setFrozen(true);
			}

			this.gameOver();
		}
	}


	@Override
	public void freeze(Player p) {
		if (p instanceof BlueAstronaut && (!this.isFrozen())) {
			if (this.getSusLevel() < p.getSusLevel()) {
				p.setFrozen(true);
			} else {
				this.setSusLevel(getSusLevel() * 2);
			}
		}
		gameOver();
	}

	@Override
	public void sabotage(Player p) {
		if (p instanceof BlueAstronaut && (!this.isFrozen()) && (!p.isFrozen())) {
			if (this.getSusLevel() < 20) {
				p.setSusLevel((int) (p.getSusLevel() * 1.5));
			} else {
				p.setSusLevel((int) (p.getSusLevel() * 1.25));
			}
		}
		gameOver();
	}

	@Override
	public boolean equals(Object o) {
		if (super.equals(o) ) {
			if (this.getSkill().equals(((RedAstronaut) o).getSkill())) {
				return true;
			}
		}
		return false;

	}

	@Override
	public String toString() {
		String result = super.toString();
		result = result + "I am an " + this.getSkill() + " player!";
		if (this.getSusLevel()>15) {
			result = result.toUpperCase();
		}
		return result;

	}
}



