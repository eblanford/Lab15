import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesTextFile {

	public static void readFromFile() {
		Path readFile = Paths.get("src/countries.txt");

		File file = readFile.toFile();
		try {
			FileReader fr = new FileReader(file);
			// the benefits of using the buffer are to help us store memory that we can go
			// back to and read data from later -- this is more efficient than the Scanner

			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}

			reader.close();

		} catch (FileNotFoundException e) {
			createFile("countries.txt");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}

	public static void writeToFile(String country) {
		Path writeFile = Paths.get("src/countries.txt");

		File file = writeFile.toFile(); // the toFile() converts the path to a file object
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(file, true)); // the true parameter allows us to
			// append to the end of the file

			out.println(country);
			out.close();// will want to close stream
		} catch (FileNotFoundException e) {
			createFile("countries.txt");
			e.printStackTrace();
		}
		
		System.out.println("This country has been saved!");
	}

	public static void createFile(String fileString) {
		Path filePath = Paths.get("src", fileString);
		// if you don't include dirString, it will go into the parent directory

		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
			} catch (IOException e) {
				System.out.println("Hey, something went wrong with the file creation!");
				e.printStackTrace();
			}
		}
	}

}
