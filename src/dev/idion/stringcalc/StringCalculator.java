package dev.idion.stringcalc;

import java.util.*;

public class StringCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringCalculator stringCalculator = new StringCalculator();
		
		System.out.println("This is String Calculator...");
		System.out.println("The operator not a sign, use string. e.g.) plus, minus, multiply, divide");
		System.out.println("The separator is space.");
		System.out.println("The expression ending is '='");
		
		String expression = scanner.nextLine();
		
		try {
			stringCalculator.stringCalc(expression);
		} catch (Exception e) {
			System.out.println("Wrong Expression Exception");
		} finally {
			scanner.close();
		}
	}
	
	// expression split.
	private Map<String, List> expressionSplit(String expression) {
		Map<String, List> listMap = new HashMap<>();
		
		String[] expressionArray = expression.split(" ");
		
		List<Integer> numberList = new ArrayList<>();
		List<String> operatorList = new ArrayList<>();
		operatorList.add("");
		
		for (int i = 0; i < expressionArray.length; i++) {
			if (i % 2 == 0 && expressionArray[i].matches("(^[0-9]*$)")) {
				numberList.add(Integer.parseInt(expressionArray[i]));
			} else if (i % 2 == 1) {
				operatorList.add(expressionArray[i]);
			}
		}
		
		listMap.put("numberList", numberList);
		listMap.put("operatorList", operatorList);
		
		return listMap;
	}
	
	private int calculator(List numberList, List operatorList) {
		int result = 0;
		
		for (int i = 0; i < operatorList.size(); i++) {
			if (result == 0) {
				result = (int) numberList.get(i);
			} else {
				String operator = (String) operatorList.get(i);
				if ("plus".equals(operator)) {
					result += ((int) numberList.get(i));
				} else if ("minus".equals(operator)) {
					result -= ((int) numberList.get(i));
				} else if ("multiply".equals(operator)) {
					result *= ((int) numberList.get(i));
				} else if ("divide".equals(operator)) {
					result /= ((int) numberList.get(i));
				}
			}
		}
		
		System.out.print("Your suggested expression's result is .... ");
		System.out.println(result);
		return result;
	}
	
	public Integer stringCalc(String expression) {
		if (expression.contains("=")) {
			expression = expression.substring(0, expression.indexOf("="));
		}
		
		Map<String, List> listMap = expressionSplit(expression);
		List numberList = listMap.get("numberList");
		List operatorList = listMap.get("operatorList");
		
		Integer result = null;
		
		if (numberList.size() - operatorList.size() != 0) {
			System.out.println("The suggested expression is wrong.");
			System.out.print("Your expression is .... ");
			System.out.println(expression);
			return result;
		}
		return calculator(numberList, operatorList);
	}
	
}
