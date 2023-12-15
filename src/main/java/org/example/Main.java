package org.example;

import org.example.util.Dashboard;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\nWitaj w aplikacji do tworzenia renowacji!");
			System.out.println("1. Dodaj obiekt");
			System.out.println("2. Znajdź po ID");
			System.out.println("3. Wyświetl identyfikatory z bazy");
			System.out.println("4. Wyjdź");
			choice = scanner.nextInt();
			scanner.nextLine();
			Dashboard.printDashboard(choice);
		} while (choice != 4);
	}
}