import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Demonstrates basic file operations using the legacy java.io package.
 * 
 * HOW TO RUN:
 * 1. Open terminal in this folder.
 * 2. Compile: javac BasicFileIO.java
 * 3. Run:     java BasicFileIO
 * 
 * Concepts covered:
 * 1. Creating a File object
 * 2. Creating a physical file
 * 3. Writing to a file using FileWriter
 * 4. Reading from a file using Scanner
 * 5. Deleting a file
 */
public class BasicFileIO {

    public static void main(String[] args) {
        // Define the file path (relative to the current working directory)
        String fileName = "example_basic.txt";
        File file = new File(fileName);

        System.out.println("--- Basic File I/O Example ---");

        try {
            // 1. Create a new file
            if (file.createNewFile()) {
                System.out.println("1. File created: " + file.getName());
            } else {
                System.out.println("1. File already exists: " + file.getName());
            }

            // 2. Write to the file
            // FileWriter(file, false) overwrites. Use true for append mode.
            // Always close streams! try-with-resources closes the writer automatically,
            // even if write() throws an exception.
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Hello, this is a basic file I/O example.\n");
                writer.write("Writing data using FileWriter is simple and effective.");
            }
            System.out.println("2. Successfully wrote to the file.");

            // 3. Read from the file
            System.out.println("3. Reading file content:");
            System.out.println("--------------------------");
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    System.out.println(data);
                }
            }
            System.out.println("--------------------------");

            // 4. Get file information
            System.out.println("4. File Information:");
            System.out.println("   Absolute Path: " + file.getAbsolutePath());
            System.out.println("   Size: " + file.length() + " bytes");

            // 5. Delete the file (optional cleanup)
            // Left commented out so you can open example_basic.txt after the run;
            // uncomment it to see File.delete() in action.
            // if (file.delete()) {
            //     System.out.println("5. Deleted the file: " + file.getName());
            // } else {
            //     System.out.println("5. Failed to delete the file.");
            // }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
