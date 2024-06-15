import javax.swing.JOptionPane;

public class Utility {
	
	public static void showMessageDialog(String message) {
		JOptionPane.showMessageDialog(null, message, "University Chatbot Application", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static String showInputDialog(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
	public static int showOptionDialog(String message) {
		return JOptionPane.showOptionDialog(null, message, "University Chatbot Application", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
	}
	
	public static Object showInputDialog(String message, String[] listItem, String defaultSelectedValue) {
		return JOptionPane.showInputDialog(null, message, "University Chatbot Application", JOptionPane.QUESTION_MESSAGE, null, listItem, defaultSelectedValue);
	}
}
