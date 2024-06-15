import javax.swing.JOptionPane;

public class Chatbot {
	
	public void reply(String message) {
		System.out.println("Chatbot--> " + message);
	}
	
	public Chatbot() {
		System.out.println("Welcome to University Chatbot Application!");
		System.out.println("==========================================");
		Utility.showMessageDialog("Welcome to University Chatbot Application!");
		Admin ad = new Admin();
		String[] userList = ad.getUserList();
		Object selectedUser;
		do {
			selectedUser = Utility.showInputDialog("Select a user to login", userList, "");
			if(selectedUser == null) {
				reply("Bye!");
			}
			else {
				reply("You successfully logged-in with user: " + selectedUser);
				User user = ad.getByName(selectedUser.toString());
				
				switch(user.getRole().toLowerCase()) {
					case "student":
						reply("Would you like to view the course schedule?");
						int studentChoice = Utility.showOptionDialog("Would you like to view the course schedule?");

						if(studentChoice == JOptionPane.OK_OPTION)
						{
							Student stu = new Student(user.getName(), user.getRole());
							stu.viewSchedule();
						}
						else {
							System.out.println(user.getName() + "--> Cancelled");
						}
						break;
					case "professor":
						reply("Please select a below option to view the course scheudle?");
						String[] scheduleType = {"All", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
						Object selectedScheduleType = Utility.showInputDialog("Please select a below option to view the course scheudle?", scheduleType, "All");
						Professor prof = new Professor(user.getName(), user.getRole());
						
						if(selectedScheduleType == null) {
							System.out.println(user.getName() + "--> Cancelled");
						}
						else if(selectedScheduleType.toString().equalsIgnoreCase("All")) {
							prof.viewSchedule();
						}
						else {
							prof.viewSchedule(selectedScheduleType.toString());
						}
						
						break;
					case "admin":
						reply("No available function for User Interact Yet.");
						break;
					default:
						String email;
						do {
							reply("Please enter your email to receive the registration information:");
							email = Utility.showInputDialog("Please enter your email to receive the registration information:");
							
							if(email == null) {
								System.out.println(user.getName() + "--> Cancelled");
								break;
							}
							else if(!email.trim().equals("")) {
								reply("The registration information was already sent to your email address.");
							}
							else {
								reply("Sorry your email is invalid.");
							}
						}while(email.trim().equals(""));
						
						break;
				}
			}
		}while(selectedUser != null);
		
	}
}
