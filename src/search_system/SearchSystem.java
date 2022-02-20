package search_system;

import search_strategy.SearchAll;
import search_strategy.SearchAny;
import search_strategy.SearchNone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class SearchSystem {
	private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");
	private final List<String> data;
	private final PersonFinder finder;

	public SearchSystem(Path path) throws IOException {
		data   = Files.readAllLines(path);
		finder = new PersonFinder();
	}

	/**
	 * Start the program
	 */
	public void run() {
		while (true) {
			switch (getChosenOption()) {
				case "1":
					findPerson();
					continue;
				case "2":
					printAll();
					continue;
				case "0":
					System.out.println("Bye!");
					return;
				default:
					System.out.println("Incorrect option! Try again.");
			}
		}
	}

	/**
	 * Prints all found people
	 */
	private void findPerson() {
		// executed until the user chooses a strategy
		while (setStrategyFromUser() == false) ;

		finder.find(data, getDataToSearch());
	}

	/**
	 * Sets the strategy chosen by the user
	 * @return true if the strategy was chosen successfully, false otherwise
	 */
	private boolean setStrategyFromUser() {
		System.out.println("Select a matching strategy: ALL, ANY, NONE");
		switch (scanner.next()) {
			case "ANY":
				finder.setStrategy(new SearchAny());
				return true;
			case "ALL":
				finder.setStrategy(new SearchAll());
				return true;
			case "NONE":
				finder.setStrategy(new SearchNone());
				return true;
			default:
				System.out.println("Incorrect strategy! Try again");
				return false;
		}
	}

	/**
	 * Prints all the people the file contains
	 */
	private void printAll() {
		System.out.println("=== List of people ===");
		data.forEach(System.out::println);
	}

	/**
	 * Prints menu and returns the chosen option
	 */
	private String getChosenOption() {
		System.out.println("=== Menu ===");
		System.out.println("1. Find a person");
		System.out.println("2. Print all people");
		System.out.println("0. Exit");
		return scanner.next();
	}

	/**
	 * Asks the user to choose the data to search for
	 */
	private String getDataToSearch() {
		System.out.println("Enter a name or email to search all suitable people.");
		return scanner.next();
	}
}
