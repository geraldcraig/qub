package uk.ac.qub.ac.exercise1.solution;

public class RecursionExample {

	public static void main(String[] args) {
		callMe(1);
	}

	public static void callMe(int callNumber) {
		System.out.println("Call me please " + callNumber);
		
		callMe(++callNumber); // recursive call !!!!	
	}

}
