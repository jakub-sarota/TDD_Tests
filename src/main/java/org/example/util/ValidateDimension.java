package org.example.util;

public class ValidateDimension {
	public static boolean validateDimension(String value) {
		if (!value.isBlank()) {
			return value.matches("\\d+");
		}

		return false;
	}
}
