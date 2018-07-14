import java.util.*;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Lambdas extends Application {
	public static void main(String[] args) {
		Comparator<String> comp = (String first, String second) -> Integer.compare(first.length(), second.length());
		sort(comp);
		
		comp = (String first, String second) -> {
			if (first.length() < second.length())
				return -1;
			else if (first.length() > second.length())
				return 1;
			else
				return 0;
		};
		sort(comp);

		Runnable runner = () -> {
			for (int i = 0; i < 5; i++)
				doWork();
		};
		new Thread(runner).start();

		comp = (first, second) // Same as (String first, String second)
		-> Integer.compare(first.length(), second.length());
		sort(comp);

		launch(args);

	}

	public static void doWork() {
		System.out.println("Doing work...");
		try {
			Thread.sleep(100);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	private static void sort(Comparator<String> comp) {
		String[] strings = "Mary had a little lamb".split(" ");
		Arrays.sort(strings, comp);
		System.out.println(Arrays.toString(strings));
	}
	
	public void start(Stage stage) {
		EventHandler<ActionEvent> listener = e -> System.out.println(e.getTarget());
		// Instead of (e) -> or (ActionEvent e) ->

		Button button = new Button("Click me!");
		button.setOnAction(listener);

		stage.setScene(new Scene(button));
		stage.show();
	}

}
