
public class Student extends User{
	
	public Student() {super();}
	
	public Student(String name, String role) {
		super(name, role);
	}
	
	public void viewSchedule() {
		Schedule s = new Schedule();
		System.out.println(s.viewSchedule());
	}
}
