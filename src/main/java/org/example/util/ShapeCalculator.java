package org.example.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShapeCalculator {
	public static double shapeCalculator(String value, boolean isValue) {
		String regex = "\\d+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);

		int value1 = 0;
		int value2 = 0;
		int value3 = 0;

		int index = 0;
		while (matcher.find() && index < 3) {
			int currentValue = Integer.parseInt(matcher.group());
			switch (index) {
				case 0:
					value1 = currentValue;
					break;
				case 1:
					value2 = currentValue;
					break;
				case 2:
					value3 = currentValue;
					break;
			}
			index++;
		}

		if(isValue) {
			return value1 * value2 * value3;
		}

		return 2 * (value1 * value2 + value2 * value3 + value3 * value1);
	}
}
