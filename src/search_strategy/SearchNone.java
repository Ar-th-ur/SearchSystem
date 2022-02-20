package search_strategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Search results in all terms that don`t match words entered in search query
 **/
public class SearchNone implements SearchEngine {
	@Override
	public HashSet<String> find(List<String> data, String toFind) {
		return data.stream()
			.filter(line -> Arrays.stream(line.split(" "))
				.noneMatch(word -> toFind.toLowerCase().contains(word.toLowerCase())))
			.collect(Collectors.toCollection(HashSet::new));
	}
}
