package org.example.util;

import org.example.renovation.service.RenovationService;
import org.example.rest.DTO.RenovationDTO;

import java.util.Scanner;

public class Dashboard {
	public static void printDashboard(int choice) {
		Scanner scanner = new Scanner(System.in);

		switch (choice) {
			case 1:
				String name;
				String width;
				String height;
				String length;

				System.out.println("Podaj nazwę:");
				do {
					name = scanner.nextLine();
				} while (name.isBlank());

				System.out.println("Podaj szerokość:");
				do {
					width = scanner.nextLine();
					if (validateDimension(width)) {
						System.err.println("Wartość musi zawierać same cyfry!");
					}
				} while (width.isBlank() || validateDimension(width));

				System.out.println("Podaj wysokość:");
				do {
					height = scanner.nextLine();
					if (validateDimension(height)) {
						System.err.println("Wartość musi zawierać same cyfry!");
					}
				} while (height.isBlank() || validateDimension(width));

				System.out.println("Podaj długość: ");
				do {
					length = scanner.nextLine();
					if (validateDimension(length)) {
						System.err.println("Wartość musi zawierać same cyfry!");
					}
				} while (length.isBlank() || validateDimension(width));

				RenovationDTO renovationDTO = new RenovationDTO.Builder()
						.setName(name)
						.setWidth(width)
						.setHeight(height)
						.setLength(length)
						.build();

				RenovationService.addRenovation(renovationDTO);
				break;

			case 2:
				String id;
				System.out.println("Podaj id:");
				do {
					id = scanner.nextLine();
					System.out.println(RenovationService.showRenovationData(Integer.parseInt(id)).toString());
				} while (id.isBlank());

				break;
			case 3:
				System.out.println("\nIdentyfikatory: ");
				RenovationService.showRenovationData();
				break;

			case 4:
				System.out.println("Wyjście z programu.");
				break;

			default:
				System.out.println("Nieprawidłowy wybór operacji.");
		}
	}

	private static boolean validateDimension(String value) {
		return !ValidateDimension.validateDimension(value);
	}
}
