package normal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Demonstrates basic file operations using the legacy java.io package.
 * Concepts covered:
 * 1. Creating a File object
 * 2. Creating a physical file
 * 3. Writing to a file using FileWriter
 * 4. Reading from a file using Scanner
 * 5. Deleting a file
 */
public class BasicFileIO {

    public static void main(String[] args) {
        // Define the file path (relative to the project root or absolute)
        String fileName = "example_basic.txt";
        File file = new File(fileName);

        try {
            // 1. Create a new file
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            // 2. Write to the file
            // FileWriter(file, false) overwrites. Use true for append mode.
            FileWriter writer = new FileWriter(file);
            writer.write("Hello, this is a basic file I/O example.\n");
            writer.write("Writing data using FileWriter is simple.");
            writer.close(); // Always close streams!
            System.out.println("Successfully wrote to the file.");

            // 3. Read from the file
            System.out.println("\nReading file content:");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();

            // 4. Get file information
            System.out.println("\nFile Information:");
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length() + " bytes");

            // 5. Delete the file (optional cleanup)
            // if (file.delete()) {
            //     System.out.println("Deleted the file: " + file.getName());
            // } else {
            //     System.out.println("Failed to delete the file.");
            // }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
