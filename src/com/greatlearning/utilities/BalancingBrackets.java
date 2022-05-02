package com.greatlearning.utilities;

import java.util.Stack;

public class BalancingBrackets {

	static boolean isStringBalanced(String closingBracketue) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < closingBracketue.length(); i++) {

			char x = closingBracketue.charAt(i);

			if (x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}

			if (stack.isEmpty())
				return false;

			char closingBracket;
			switch (x) {
			case ')':
				closingBracket = stack.pop();
				if (closingBracket == '{' || closingBracket == '[')
					return false;
				break;

			case '}':
				closingBracket = stack.pop();
				if (closingBracket == '(' || closingBracket == '[')
					return false;
				break;

			case ']':
				closingBracket = stack.pop();
				if (closingBracket == '(' || closingBracket == '{')
					return false;
				break;
			}
		}

		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		String value = "([[{}]])";

		if (isStringBalanced(value))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
	}

}
