import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Demonstrates advanced file system traversal using the Visitor pattern.
 * 
 * HOW TO RUN:
 * 1. Open terminal in this folder.
 * 2. Compile: javac FileTreeWalker.java
 * 3. Run:     java FileTreeWalker
 * 
 * Concepts covered:
 * 1. Files.walkFileTree
 * 2. SimpleFileVisitor
 * 3. Recursively processing directories
 * 4. Handling file attributes
 */
public class FileTreeWalker {

    public static void main(String[] args) {
        // Start walking from the current directory (or specify another path)
        Path startPath = Paths.get(".");

        System.out.println("--- Recursive File Tree Walker ---");
        System.out.println("Scanning directory tree starting at: " + startPath.toAbsolutePath());
        System.out.println("--------------------------------------------------");

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("[DIR]  " + dir);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("   [FILE] " + file.getFileName() + " (" + attrs.size() + " bytes)");
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("   [ERR]  Failed to access: " + file + " (" + exc.getMessage() + ")");
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------");
    }
}
