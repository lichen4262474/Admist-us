import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
	// variables;
	private int numTasks;
	private int taskSpeed;

	// constructors;
	public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
		super(name, susLevel);
		this.numTasks = numTasks;
		this.taskSpeed = taskSpeed;
	}
	public BlueAstronaut(String name) {
		this(name, 15, 6, 10);
	}

	// getters and setters;
	public int getNumTasks() {
		return numTasks;
	}

	public void setNumTasks(int numTasks) {
		this.numTasks = numTasks;
	}

	public int getTaskSpeed() {
		return taskSpeed;
	}

	public void setTaskSpeed(int taskSpeed) {
		this.taskSpeed = taskSpeed;
	}

	// methods;

	@Override
	public void completeTask() {
		if (!this.isFrozen() && this.getNumTasks() > 0) {
			if (this.getTaskSpeed() > 20) {
				this.setNumTasks(getNumTasks() - 2);
			} else {
				this.setNumTasks(getNumTasks() - 1);
			}
			if (this.getNumTasks() < 0) {
				this.setNumTasks(0);
			}
			if (this.getNumTasks() == 0) {
				System.out.println("I have completed all my tasks");
				this.setSusLevel(getSusLevel() / 2);
			}



		}

	}


	@Override
	void emergencyMeeting() {
		// TODO Auto-generated method stub
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
				suspect.setFrozen(true);
			}

			this.gameOver();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (super.equals(o)) {
			if (this.getNumTasks() == ((BlueAstronaut) o).getNumTasks()
					&& this.getTaskSpeed() == ((BlueAstronaut) o).getTaskSpeed()) {
				return true;
			}
		}
		return false;

	}

	@Override
	public String toString() {
		String result = super.toString();
		result = result + "I have " + this.getNumTasks() + " left over.";
		if (this.getSusLevel() > 15) {
			result = result.toUpperCase();
		}
		return result;

	}

}
