
public class Professor extends User {
	
	public Professor(String name, String role) {
		super(name, role);
	}
	
	public void viewSchedule() {
		Schedule s = new Schedule();
		System.out.println(s.viewSchedule());
	}
	
	public void viewSchedule(String dayOfWeek) {
		Schedule s = new Schedule();
		System.out.println(s.viewSchedule(dayOfWeek));
	}
}
