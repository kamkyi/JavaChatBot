import java.util.Arrays;

public class Admin {
	
	private User[] users;
	
	public Admin() {
		users = new User[3];
		users[0] = new User("Student01", "Student");
		users[1] = new User("Professor01", "Professor");
		users[2] = new User("Guest01", "Guest");
	}
	
	public void add(String name, String role) {
		users = Arrays.copyOf(users, users.length + 1);
		users[users.length-1] = new User(name, role);
	}
	
	public void update(String name, String role) {
		for(int i=0; i<users.length; i++) {
			if(name.equalsIgnoreCase(users[i].getName())) {
				users[i].setRole(role);
			}
		}
	}
	
	public void delete(String name) {
		User[] userHelpers = new User[users.length-1];
		int j=0;
		for(int i=0; i<users.length; i++) {
			if(!name.equalsIgnoreCase(users[i].getName())) {
				userHelpers[j] = users[i];
				j++;
			}
		}
		
		if(userHelpers != null) {
			users = userHelpers;
		}
	}
	
	public String[] getUserList() {
		String[] userList = new String[this.users.length];
		for(int i = 0; i<this.users.length; i++) {
			userList[i] = this.users[i].getName();
		}
		
		return userList;
	}
	
	public User getByName(String name) {
		for(int i=0; i<users.length; i++) {
			if(name.equalsIgnoreCase(users[i].getName())) {
				return users[i];
			}
		}
		
		// Return Guest
		return users[2];
	}
}
