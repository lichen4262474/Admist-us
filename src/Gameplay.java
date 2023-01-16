
public class Gameplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
		BlueAstronaut health = new BlueAstronaut("Health", 30, 3, 21);
		BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
		BlueAstronaut angle = new BlueAstronaut("Angle", 0, 1, 0);

		RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
		RedAstronaut suspicousPerson = new RedAstronaut("SuspicousPerson", 100, "expert");

		// suspicousPerson.emergencyMeeting();
		// albert.emergencyMeeting();

		// test1
		System.out.println(bob);
		liam.sabotage(bob);
		System.out.println(bob);
		// test 2
		System.out.println(suspicousPerson);
		liam.freeze(suspicousPerson);
		System.out.println(suspicousPerson);
		// test 3
		System.out.println(liam);
		System.out.println(albert);
		liam.freeze(albert);
		System.out.println(liam);
		System.out.println(albert);
		// test 4
		albert.emergencyMeeting();
		// test 5
		suspicousPerson.emergencyMeeting();
		System.out.println(bob);
		System.out.println(health);
		// test 6
		bob.emergencyMeeting();
		System.out.println(suspicousPerson);
		// test 7
		health.completeTask();
		System.out.println(health);
		// test 8
		health.completeTask();
		System.out.println(health);
		// test 9
		health.completeTask();
		System.out.println(health);
		// test 10
		liam.freeze(angle);
		System.out.println(liam);
		System.out.println(angle);
		// test 10
		liam.sabotage(bob);
		liam.sabotage(bob);
		System.out.println(bob);
		// test 11
		liam.freeze(bob);
		System.out.println(bob);
		// test 12
		angle.emergencyMeeting();
		System.out.println(liam);
	}

}
