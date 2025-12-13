package advanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates modern file operations using java.nio.file (NIO.2).
 * Concepts covered:
 * 1. Path and Paths
 * 2. Files class utility methods
 * 3. Writing lists of strings directly
 * 4. Reading all lines at once
 * 5. Buffered readers/writers with NIO
 */
public class ModernFileIO {

    public static void main(String[] args) {
        // Define paths using the Path interface
        Path filePath = Paths.get("example_nio.txt");
        Path copyPath = Paths.get("example_nio_copy.txt");

        try {
            // 1. Write content to file
            // Files.write handles opening and closing resources automatically
            String content = "This is a modern way to write files using Java NIO.\n";
            Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            
            // Appending lines
            List<String> lines = Arrays.asList("Line 1: Advanced I/O", "Line 2: Efficient and clean");
            Files.write(filePath, lines, StandardOpenOption.APPEND);
            
            System.out.println("File written successfully: " + filePath.toAbsolutePath());

            // 2. Read all lines
            System.out.println("\nReading file content:");
            List<String> readLines = Files.readAllLines(filePath);
            readLines.forEach(System.out::println);

            // 3. Copy file
            // REPLACE_EXISTING allows overwriting if the target exists
            Files.copy(filePath, copyPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("\nFile copied to: " + copyPath.getFileName());

            // 4. Check file attributes
            System.out.println("File exists: " + Files.exists(filePath));
            System.out.println("Is writable: " + Files.isWritable(filePath));
            System.out.println("File size: " + Files.size(filePath) + " bytes");

            // Cleanup
            // Files.deleteIfExists(filePath);
            // Files.deleteIfExists(copyPath);

        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }
}
