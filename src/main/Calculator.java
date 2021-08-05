package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public void calculate(List<String> history, String input) {

		System.out.println("Input: " + input);
		List<Object> numberList = new ArrayList();

		char ch = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			ch = input.charAt(i);
			if (Character.isDigit(ch)) {
				sb.append(ch);			
			} else {
				Long number = Long.valueOf(sb.toString());
				numberList.add(number);
				sb.setLength(0);
				numberList.add(ch);
			}
		}
		if (Character.isDigit(ch)) {
			numberList.add(ch);
		}
		System.out.println(numberList.toString());
		int totalOperations = Math.floorDiv(numberList.size(), 2);
		System.out.println(totalOperations);
		Long answer = Long.valueOf(numberList.get(0).toString());
		System.out.println(answer);
		for (int i = 1; i < numberList.size(); i = i + 2) {
			if (i % 2 != 0) {

				switch (String.valueOf(numberList.get(i))) {

				case "+":
					answer += Long.valueOf(numberList.get(i + 1).toString());
					break;
				case "-":
					answer -= Long.valueOf(numberList.get(i + 1).toString());
					break;
				case "*":
					answer = answer * Long.valueOf(numberList.get(i + 1).toString());
					break;
				case "/":
					answer = answer / Long.valueOf(numberList.get(i + 1).toString());
					break;

				}
			}
		}
		System.out.println(input + "=" + answer);
		history.add(input + "=" + answer);

	}

	public void showHistory(List<String> history) {
		if (history.size() == 0) {
			System.out.println("No history");
		} else {
			System.out.println("=====History=====");
			history.forEach(action -> {
				System.out.println(action);
			});
		}
	}

	public void clearAll(List<String> history) {
		history.clear();
		System.out.println("History cleared...");
	}
	
}
