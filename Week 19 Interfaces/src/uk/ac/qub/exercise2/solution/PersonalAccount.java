/**
 * 
 */
package uk.ac.qub.exercise2.solution;

public class PersonalAccount extends BankAccount {
	
	private String firstName;
	private String lastName;
	
	public PersonalAccount() {
		
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 */
	public PersonalAccount(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public void displayAll() {
		super.displayAll();
		System.out.println("First name : " + this.firstName);
		System.out.println("Las name : " + this.lastName);
	}	

}
