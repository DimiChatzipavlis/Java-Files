import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Demonstrates efficient file reading and writing using Buffering.
 * 
 * HOW TO RUN:
 * 1. Open terminal in this folder.
 * 2. Compile: javac BufferedIO.java
 * 3. Run:     java BufferedIO
 * 
 * Concepts covered:
 * 1. BufferedWriter for efficient writing
 * 2. BufferedReader for efficient reading
 * 3. Performance difference (conceptual)
 */
public class BufferedIO {

    public static void main(String[] args) {
        String fileName = "example_buffered.txt";
        File file = new File(fileName);

        System.out.println("--- Buffered I/O Example ---");

        // 1. Write using BufferedWriter
        // Wrapping FileWriter in BufferedWriter reduces the number of physical disk writes
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            System.out.println("1. Writing multiple lines to file...");
            writer.write("Line 1: Buffering improves performance.");
            writer.newLine(); // Platform-independent new line
            writer.write("Line 2: It stores data in memory before writing to disk.");
            writer.newLine();
            writer.write("Line 3: This is much faster for large files.");
            
            System.out.println("   Successfully wrote to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Read using BufferedReader
        // Wrapping FileReader in BufferedReader reduces the number of physical disk reads
        System.out.println("\n2. Reading file content efficiently:");
        System.out.println("--------------------------");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // readLine() returns null when end of file is reached
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------");
    }
}
