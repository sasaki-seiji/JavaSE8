import java.util.*;

public class Application {
	public static void main(String[] args) {

		// Path first = Paths.get("/usr/bin");
		// Uncomment to see error "variable first is already defined"
		// in the lambda expression below

		Comparator<String> comp = (first, second) -> Integer.compare(first.length(), second.length());
		// 2018.07.15 add
		sort(comp);
		
		Application app = new Application();
		app.doWork();
	}

	public void doWork() {
		Runnable runner = () -> {
			System.out.println(this.toString());
		};
		runner.run();
		// Prints Application@... since this refers to an Application object
	}

	// 2018.07.15 add
	private static void sort(Comparator<String> comp) {
		String[] strings = "Mary had a little lamb".split(" ");
		Arrays.sort(strings, comp);
		System.out.println(Arrays.toString(strings));
	}

}
