package search_strategy;

import java.util.HashSet;
import java.util.List;

/**
 * Strategy Pattern implementing various search strategies selected by user
 **/
public interface SearchEngine {
	HashSet<String> find(List<String> data, String toFind);
}
