package main;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorMain {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		List<String> history = new ArrayList();
		int command = 0;
		Calculator calulator = new Calculator();
		while (true) {
			System.out.println("======CALCULATOR=======");
			System.out.println("1. History");
			System.out.println("2. Clear All");
			System.out.println("3. Calculator Mode");
			System.out.println("4. Exit");
			command = scanner.nextInt();
			switch (command) {
			case 1:
				calulator.showHistory(history);
				break;
			case 2:
				calulator.clearAll(history);
				break;

			case 3:
				System.out.println("======Calculator Mode=====");
				Scanner scanInput=new Scanner(System.in);
				String input = scanInput.nextLine().trim();
				Pattern pattern = Pattern.compile("[a-zA-z]");
				Matcher matcher = pattern.matcher(input);
				if (matcher.find()) {
					System.out.println("Invalid input");
					break;
				}
				calulator.calculate(history, input);
				break;
			case 4:
				System.exit(0);
			default:

				break;
			}
		}
	}

}
