/**
 * 
 */
package uk.ac.qub.week5;

/**
 * @author geraldcraig
 *
 */
public class Practical6d {
	
	public static final double Rate = 11.50;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int totalHours = 0;
		int [] hours = {8, 7, 9, 7, 4, 7};
		String [] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		for (int i = 0; i < hours.length; i++) {
			
			System.out.printf("%d hours worked on :  %s\n", hours[i], days[i]);
			totalHours = totalHours + hours[i];
		}
		System.out.println("Total hours worked was : " + totalHours);
		System.out.printf("Salary is : £%.2f ", (totalHours*Rate));

	}

}
