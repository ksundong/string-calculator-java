package dev.idion.stringcalc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("This is String Calculator...");
		System.out.println("The operator not a sign, use string. e.g.) plus, minus, multiply, divide");
		System.out.println("The separator is space.");
		System.out.println("The expression ending is '='");
		
		String expression = scanner.nextLine();
		if (expression.contains("=")) {
			expression = expression.substring(0, expression.indexOf("="));
		}
		
		String[] expressionArray = expression.split(" ");
		
		List<Integer> numberList = new ArrayList<>();
		List<String> operatorList = new ArrayList<>();
		
		for (int i = 0; i < expressionArray.length; i++) {
			if (expressionArray[i].matches("(^[0-9]*$)")) {
				numberList.add(Integer.parseInt(expressionArray[i]));
			} else {
				operatorList.add(expressionArray[i]);
			}
		}
		
		if (numberList.size() - operatorList.size() == 1) {
			int result = 0;
			for (int i = 0; i < operatorList.size(); i++) {
				String operator = operatorList.get(i);
				if (result != 0) {
					int j = i + 1;
					switch (operator) {
						case "plus":
							result += numberList.get(j);
							break;
						case "minus":
							result -= numberList.get(j);
							break;
						case "multiply":
							result *= numberList.get(j);
							break;
						case "divide":
							result /= numberList.get(j);
							break;
					}
				} else {
					switch (operator) {
						case "plus":
							result = numberList.get(i) + numberList.get(i + 1);
							break;
						case "minus":
							result = numberList.get(i) - numberList.get(i + 1);
							break;
						case "multiply":
							result = numberList.get(i) * numberList.get(i + 1);
							break;
						case "divide":
							result = numberList.get(i) / numberList.get(i + 1);
							break;
					}
				}
			}
			System.out.print("Your suggested expression's result is .... ");
			System.out.println(result);
		} else {
			System.out.println("The suggested expression is wrong.");
			System.out.print("Your expression is .... ");
			System.out.println(expression);
		}
		
		scanner.close();
	}
}
