package uk.ac.qub.revision.p3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import uk.ac.qub.revision.p3.solution.Country;

/**
 * PUT YOUR NAME HERE AND YOUR STUDNT NUMBER
 * 
 *
 */
public class StartApp {

	public static List<Player> players = new ArrayList<Player>();
	
	
	public static void main(String[] args) {
		readData(); 
		showMenu();
		
	}

	public static void showMenu() {
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("Book reading ");
		do {
			System.out.println("1. Display all players");
			System.out.println("2. Display all players from Ireland");
			System.out.println("3. Display the highest point scorer ");
			System.out.println("4. Display all players by height and name");
			System.out.println("5. Display each club (in alphabetical order with the cumulative number of games played in the six nations (Total Matches) by each player from that club ");			
			System.out.println("6. Capitalise the Last name and export/write to a new file in a new thread in the format Lastname, first name and country ");
			System.out.println("7. Quit");
			System.out.println("Enter option ...");
			option = scanner.nextInt();

			switch (option) {
				
			case 1:
				System.out.println("All players");
				displayAll(players);
				break;
			case 2:
				System.out.println("All players from Ireland");
				displayIre(players);
				break;
			case 3:
				System.out.println("The highest point scorer");
				highestPoints(players);
				break;
			case 4:
				System.out.println("All players by height and name");
				displayByHeight(players);
				break;
			case 5:
				System.out.println("Clubs and total points");
				displayByClub(players);
				break;
			case 6:
				System.out.println("Exporting to file");
				exportToFile(players);
				break;
			case 7:
				System.out.println("Quitting");
				break;		
			default:
				System.out.println("Try options again...");
			}
		} while (option != 7);
		scanner.close();
	}

	/**
	 * Reads in the data from the csv and maps to the Player class 
	 */
	public static void readData() {

		File file = new File("playerstats.csv");
		
		try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr);) {

			String line = reader.readLine(); // discard header
			line = reader.readLine(); // read first line

			while (line != null) {

				// TODO Code to process current line
				String[] parts = line.split(",");
				
				int codeNum = Integer.parseInt(parts[0]);
				CountryCode country = CountryCode.IRE;
				switch (codeNum) {
				case 1:
					country = CountryCode.ENG;
					break;
				case 2:
					country = CountryCode.FRA;
					break;
				case 3:
					country = CountryCode.IRE;
					break;
				case 4:
					country = CountryCode.ITA;
					break;
				case 5:
					country = CountryCode.SCO;
					break;
				case 6:
					country = CountryCode.WAL;
					break;
				default:
					System.out.println("Error in country enum");
				}
				
				String fullName = parts[1];
				String[] names = fullName.split(" ", 2);

				String firstName = names[0];
				String surname = names[1];
				Position position = Position.valueOf(parts[2].toUpperCase());
				int totalMatches = Integer.parseInt(parts[3]);
				int points = Integer.parseInt(parts[4]);
				int won = Integer.parseInt(parts[5]);
				int lost = Integer.parseInt(parts[6]);
				int draw = Integer.parseInt(parts[7]);
				double height = Double.parseDouble(parts[8]);
				String club = parts[9];
				int influence = Integer.parseInt(parts[10]);
				
				Player player = new Player(country, firstName, surname, position, totalMatches, points, won, lost, draw, height, club, influence);
				// TODO and add to list
				players.add(player);

				line = reader.readLine();// attempt to read next line and loop again
			
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found error");
		} catch (IOException e) {
			System.out.println("IO Exception");
		} catch (Exception e) {
			System.out.println("Exception occured");
			System.out.println(players.size() + " lines read successfully");
			System.out.println(e.getMessage());
		}
		System.out.println(players.size() + " lines read successfully");

	}
	
	public static void displayAll(List<Player> players) {
		for (Player i : players) {
			System.out.println("Country \t:" + i.getCountry());
			System.out.println("First name \t:" + i.getFirstName());
			System.out.println();
		}
		
	}
	
	public static void displayIre(List<Player> players) {
		for (Player i : players) {
			if (i.getCountry().equals(CountryCode.IRE)) {
				System.out.println(i.getFirstName() + " " + i.getLastName());
			}
		}
		
	}
	
	public static void highestPoints(List<Player> players) {
		List<Player> player = new ArrayList<Player>();
		int highest = 0;
		for (Player i : players) {
			if (i.getPointsScored() > highest) {
				highest = i.getPointsScored();
				player.add(i);
			}
			
		}
		for (Player i : player) {
			System.out.println(i.getFirstName() + " " + i.getLastName() + " " + i.getCountry()
			+ " " + i.getPointsScored());
		}	
	}

	public static void displayByHeight(List<Player> players) {
		Collections.sort(players, new CompareByHeight());
		for (Player i : players) {
			System.out.println(i.getHeight() + " " + i.getFirstName());
		}
		
	}
	
	public static void displayByClub(List<Player> players) {
		
		Map<String, Integer> clubs = new TreeMap<String, Integer>();
		
		for (Player p : players) {
			
			if (clubs.containsKey(p.getClub())) {
				
				int count = clubs.get(p.getClub() + p.getTotalMatches());
				clubs.put(p.getClub(), count);
			} else {
				clubs.put(p.getClub(), p.getTotalMatches());
			}
			
		}
		for (String keys : clubs.keySet()) {
			System.out.println(keys + " " + clubs.get(keys));
		}	
		
	}
	
	public static void exportToFile(List<Player> players) {
		File file = new File("Teams.csv");
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Last name" + "," + "first name" + "," + "country" + "\n");
				for (Player p : players) {
					bw.write(p.getLastName().toUpperCase() + "," + p.getFirstName() + "," + p.getCountry() + "\n");
				}

				bw.close();
				fw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}		
	
}
