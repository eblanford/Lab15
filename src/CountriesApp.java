import java.util.Scanner;

public class CountriesApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Countries Maintenance Application!");
		boolean exit = false;

		while (exit != true) {
			int option = userSelection(scan);
			System.out.println();

			switch (option) {
			case 1:
				CountriesTextFile.readFromFile();
				break;
			case 2:
				System.out.print("Enter country: ");
				String country = scan.nextLine();
				CountriesTextFile.writeToFile(country);
				break;
			case 3:
				exit = true;
				break;
			}

			System.out.println();

		}

	}

	public static int userSelection(Scanner sc) {
		System.out.println("1 - See the list of countries");
		System.out.println("2 - Add a country");
		System.out.println("3 - Exit");

		System.out.println();
		return Validator.getInt(sc, "Enter menu number: ", 1, 3);
	}
}
