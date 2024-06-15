import java.util.Random;

public class Schedule {
	
	private String[][] schoolTimeTable;
	private String[] daysOfWeek;
	private String[] times;
	private Course[] courses;
	
	public Schedule() {
		this.courses = new Course[5];
		this.courses[0] = new Course("Math", "M01");
		this.courses[1] = new Course("Chemistry", "C01");
		this.courses[2] = new Course("Physic", "P01");
		this.courses[3] = new Course("History", "H01");
		this.courses[4] = new Course("Art", "A01");
		
		
		this.schoolTimeTable = new String[5][5];
		
		// create instance of Random class
        Random rand = new Random();
		
		for(int i=0; i<this.schoolTimeTable.length; i++) {
			for(int j=0; j<this.schoolTimeTable[i].length; j++) {
				this.schoolTimeTable[i][j] = this.courses[rand.nextInt(courses.length)].getName();
			}
		}
		
		this.daysOfWeek = new String[5];
		this.daysOfWeek[0] = "MONDAY";
		this.daysOfWeek[1] = "TUESDAY";
		this.daysOfWeek[2] = "WEDNESDAY";
		this.daysOfWeek[3] = "THURSDAY";
		this.daysOfWeek[4] = "FRIDAY";
		
		this.times = new String[5];
		this.times[0] = "07:00-08:30";
		this.times[1] = "08:30-09:45";
		this.times[2] = "09:45-10:30";
		this.times[3] = "10:30-11:30";
		this.times[4] = "11:30-13:00";
	}
	
	public String viewSchedule() {
		String result = "\t      ";
		for(int i=0; i<this.daysOfWeek.length; i++) {
			result += this.daysOfWeek[i];
			if(i < (this.daysOfWeek.length - 1)){
				result += " | ";
			}
		}
		
		result += "\n";
		
		for(int i=0; i<this.schoolTimeTable.length; i++) {
			result += this.times[i] + " | ";
			for(int j=0; j<this.schoolTimeTable[i].length; j++) {
				result += this.schoolTimeTable[i][j];
				if(j < (this.schoolTimeTable[i].length - 1)) {
					result += " | ";
				}
			}
			result += "\n";
		}
		
		return result;
	}
	
	public String viewSchedule(String dayOfWeek) {
		String result = "\t      " + dayOfWeek.toUpperCase();
		int dayOfWeekIndex = -1;
		for(int i=0 ; i<this.daysOfWeek.length; i++) {
			if(dayOfWeek.equalsIgnoreCase(this.daysOfWeek[i])) {
				dayOfWeekIndex = i;
			}
		}
		result += "\n";
		
		for(int i=0; i<this.schoolTimeTable.length; i++) {
			result += this.times[i] + " | ";
			result += this.schoolTimeTable[i][dayOfWeekIndex];
			result += "\n";
		}
		
		return result;
	}
}
