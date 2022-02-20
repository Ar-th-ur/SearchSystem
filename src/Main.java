import search_system.SearchSystem;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
	public static void main(String[] args) throws IOException {
		new SearchSystem(Path.of(args[0])).run();
	}
}
