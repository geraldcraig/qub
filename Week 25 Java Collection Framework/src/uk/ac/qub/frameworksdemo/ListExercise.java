package uk.ac.qub.frameworksdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListExercise {

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.add(5);
		arrList.add(52);
		arrList.add(65);
		arrList.add(5);
		arrList.add(21);
		arrList.add(99);
		arrList.add(5);
		arrList.add(99);

		LinkedList<Integer> linkList = new LinkedList<Integer>();
		linkList.add(5);
		linkList.add(21);
		linkList.add(99);
		linkList.add(5);
		linkList.add(80);

		System.out.println("orig list: " + arrList.toString());
		System.out.println("remove list: " + linkList.toString());
		removeDuplicates(arrList, linkList);
		System.out.println("list after: " + arrList.toString());

		System.out.println("end");

		Person toRemove = new Person("Gerald", "Craig");
		
		ArrayList<Person> removals = new ArrayList<Person>();
		removals.add(toRemove);
		

		ArrayList<Person> census = new ArrayList<Person>();
		census.add(new Person("Gerald", "Craig"));
		census.add(new Person("Gerald", "Craig"));
		census.add(new Person("Alison", "Craig"));
		census.add(new Person("Gerald", "Craig"));
		census.add(new Person("Shannon", "Craig"));
		census.add(new Person("Gerald", "Craig"));
		census.add(toRemove);

		System.out.println(census.toString());
		System.out.println(census.size());
		
		System.out.println("unsorted: " + census.toString());
		Collections.sort(census);
		System.out.println("sorted: " + census.toString());

		//Person toRemove = new Person("Gerald", "Craig");
		
		//census.remove(toRemove);
		census.removeAll(removals); 
		System.out.println("after remove");
		System.out.println(census.toString());
		System.out.println(census.size());

	}

	public static void removeDuplicates(List<Integer> origList, List<Integer> toRemove) {
		for (Integer value : toRemove) {
			origList.remove(value);
		}
		origList.removeAll(toRemove);
	}

}
