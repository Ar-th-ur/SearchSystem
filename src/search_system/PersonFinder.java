package search_system;

import search_strategy.SearchEngine;

import java.util.HashSet;
import java.util.List;

/**
 * Class for performing a search by the selected strategy
 */
public class PersonFinder {
	private SearchEngine strategy;

	public void setStrategy(SearchEngine strategy) {
		this.strategy = strategy;
	}

	public void find(List<String> data, String toFind) {
		HashSet<String> founded = strategy.find(data, toFind);
		if (founded.isEmpty()) {
			System.out.println("No matching people found.");
			return;
		}

		System.out.printf("%s person%s found:\n", founded.size(), founded.size() == 1 ? "" : "s");
		founded.forEach(System.out::println);
	}
}
