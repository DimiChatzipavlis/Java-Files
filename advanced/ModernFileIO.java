import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates modern file operations using java.nio.file (NIO.2).
 * 
 * HOW TO RUN:
 * 1. Open terminal in this folder.
 * 2. Compile: javac ModernFileIO.java
 * 3. Run:     java ModernFileIO
 * 
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

        System.out.println("--- Modern NIO.2 File I/O Example ---");

        try {
            // 1. Write content to file
            // Files.write handles opening and closing resources automatically
            // Encode as UTF-8 explicitly: getBytes() without a charset uses the platform default,
            // while Files.write(path, lines) and Files.readAllLines(path) always use UTF-8
            String content = "This is a modern way to write files using Java NIO.\n";
            Files.write(filePath, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            // Appending lines
            List<String> lines = Arrays.asList("Line 1: Advanced I/O", "Line 2: Efficient and clean");
            Files.write(filePath, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            
            System.out.println("1. File written successfully: " + filePath.toAbsolutePath());

            // 2. Read all lines
            System.out.println("\n2. Reading file content:");
            System.out.println("--------------------------");
            List<String> readLines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            readLines.forEach(System.out::println);
            System.out.println("--------------------------");

            // 3. Copy file
            // REPLACE_EXISTING allows overwriting if the target exists
            Files.copy(filePath, copyPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("\n3. File copied to: " + copyPath.getFileName());

            // 4. Check file attributes
            System.out.println("\n4. File Attributes:");
            System.out.println("   File exists: " + Files.exists(filePath));
            System.out.println("   Is writable: " + Files.isWritable(filePath));
            System.out.println("   File size: " + Files.size(filePath) + " bytes");

            // 5. Buffered writer/reader with NIO
            // Files.newBufferedWriter / newBufferedReader give the efficiency of buffering
            // (see BufferedIO.java) while working with Path objects
            try (BufferedWriter writer = Files.newBufferedWriter(copyPath, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
                writer.write("Line 3: Appended to the copy with a buffered writer");
                writer.newLine();
            }
            System.out.println("\n5. Reading the copy with a buffered reader:");
            System.out.println("--------------------------");
            try (BufferedReader reader = Files.newBufferedReader(copyPath, StandardCharsets.UTF_8)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            System.out.println("--------------------------");

            // Cleanup
            // Files.deleteIfExists(filePath);
            // Files.deleteIfExists(copyPath);

        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }
}
