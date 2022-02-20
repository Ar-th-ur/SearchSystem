package search_strategy;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Search results in all terms that match all words entered in search query
 **/
public class SearchAll implements SearchEngine {

	@Override
	public HashSet<String> find(List<String> data, String toFind) {
		return data.stream()
			.filter(line -> line.toLowerCase().contains(toFind.toLowerCase()))
			.collect(Collectors.toCollection(HashSet::new));
	}
}
